package swagger.config;

//@Configuration
public class Swagger2Config {
    //可以在这里配置 swagger,也可以在 application.yml 文件里面配置,看你喜欢
//    @Bean
//    public Docket buildDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(buildApiInf()) //将api的元信息设置为包含在json resourcelisting响应中
//                //.host("127.0.0.1:8080") //设置ip和端口，或者域名
//                .select()  //启动用于api选择的生成器
//                //.apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("com.zyl.code.controller"))//指定controller路径
//                .paths(PathSelectors.any()).build();
//    }
//
//    private ApiInfo buildApiInf() {
//
//        Contact contact=new Contact("朝雾轻寒","https://www.zwqh.top/","zwqh@clover1314.com");
//        return new ApiInfoBuilder()
//                .title("Swagger Demo Restful API Docs")//文档标题
//                .description("Swagger 示例 Restful Api 文档")//文档描述
//                .contact(contact)//联系人
//                .version("1.0")//版本号
//                //.license("")//更新此API的许可证信息
//                //.licenseUrl("")//更新此API的许可证Url
//                //.termsOfServiceUrl("")//更新服务条款URL
//                .build();
//
//    }
}
