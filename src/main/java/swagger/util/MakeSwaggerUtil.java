package swagger.util;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.nio.file.Paths;

@Component
public class MakeSwaggerUtil {


    @Autowired
    HttpServletRequest request;
    //获取当前项目域名地址
    public String getUrlStr(){
        try {
            int start = request.getRequestURL().toString().indexOf("//");
            String httpStr = request.getRequestURL().toString().substring(0, start + 2);
            String hostStr = request.getHeader("host");
            String urlStr = httpStr+hostStr;
            return urlStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //生成文档
    public String makeAPI(){
        //    输出Ascii格式
        try {
            Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                    .withMarkupLanguage(MarkupLanguage.ASCIIDOC) //设置生成格式
                    .withOutputLanguage(Language.ZH)  //设置语言中文还是其他语言
                    .withPathsGroupedBy(GroupBy.TAGS)
                    .withGeneratedExamples()
                    .withoutInlineSchema()
                    .build();

            Swagger2MarkupConverter.from(new URL(getUrlStr()+"/v2/api-docs"))
                    .withConfig(config)
                    .build()
                    .toFile(Paths.get("src/main/resources/docs/asciidoc"));


//            Thread.sleep(3000);
            Swagger2MarkupConfig config2 = new Swagger2MarkupConfigBuilder()
                    .withMarkupLanguage(MarkupLanguage.MARKDOWN) //设置生成格式
                    .withOutputLanguage(Language.ZH)  //设置语言中文还是其他语言
                    .withPathsGroupedBy(GroupBy.TAGS)
                    .withGeneratedExamples()
                    .withoutInlineSchema()
                    .build();

            Swagger2MarkupConverter.from(new URL(getUrlStr()+"/v2/api-docs"))
                    .withConfig(config2)
                    .build()
                    .toFile(Paths.get("src/main/resources/docs/asciidoc"));
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
