# swagger-api
三步完成 API 文档导出!
1. 下载 : 下载或 clone 此项目,运行 maven 的 install 命令将本项目安装到 maven 库
2. 配置 : 你的项目不用添加任何 swagger 的依赖,只需要将此项目的 maven 坐标引入你项目的 pom 依赖,并且在你的项目的启动类上加入扫描地址 "swagger"
    2.1 maven 坐标:
          <dependency>
            <groupId>org.example</groupId>
            <artifactId>swagger-api</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    2.2 SpringBoot 启动类注解(添加下面这 2 个就够了):
          @EnableSwagger2Doc
          @ComponentScan(basePackages={"com.xxx你的项目扫描地址","swagger"})
3. 运行 : 
      生成 markdown 类型文件 : 新建一个 Controller ,运行工具类,你就可以在你的 Resourses 文件夹下面看到新生产的 doc 文件夹,如果看不见就鼠标右键点击 resoueces 文件夹
                             选择 - Reload from disk - 功能刷新一下;
                             
              @Controller
              public class MakeApi {
                  @Autowired
                  MakeSwaggerApiUtil makeSwaggerApiUtil;

                  @RequestMapping("make")
                  @ResponseBody
                  public String run(){
                      return makeSwaggerApiUtil.makeAPI();
                  }
              }
              
              访问地址 : http://localhost:8080(注意修改成你的端口)/make
                             
      生成   html   类型文件 : 在你的 pom 的 <build> 标签的<plugins> 里面加入下面的打包工具,然后在你 IDEA 的 maven 的 plugins 里面找到 asciidoctor -> asciidoctor:process-asciidoc , 
                             找到以后鼠标右键选择 Run Maven Build ,搞定! resources 里面就会生成 docs 文件夹,这里面就会有 html 接口文件,没有就刷新一下,如何刷新,如上. 
            <plugin>
                <groupId>org.asciidoctor</groupId>
                <artifactId>asciidoctor-maven-plugin</artifactId>
                <version>1.5.6</version>
                <configuration>
                    <!--asciidoc文件目录-->
                    <sourceDirectory>src/main/resources/docs</sourceDirectory>
                    <!---生成html的路径-->
                    <outputDirectory>src/main/resources/html</outputDirectory>
                    <backend>html</backend>
                    <sourceHighlighter>coderay</sourceHighlighter>
                    <attributes>
                        <!--导航栏在左-->
                        <toc>left</toc>
                        <!--显示层级数-->
                        <!--<toclevels>3</toclevels>-->
                        <!--自动打数字序号-->
                        <sectnums>true</sectnums>
                    </attributes>
                </configuration>
            </plugin>
            
 备注: 
 swagger 想要配置文档信息的话,可以在你项目的 application.yml 文件里面加入配置,这里只举例一个 title,其他的可以自行百度.
 swagger:
  enabled: true
  title: "我是 title"
  
 出现异常 : java.lang.NumberFormatException: For input string: "",这个不用管,是 swagger 的数字转换异常,是 swagger 插件的 bug,不影响程            序运行.
 
 冲突:
    下面这两个 pom 依赖需要暂时注释掉 ( 如果你的项目有用到的话 ) ,不然会报异常,导致不能正常运行 swagger
    	<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.9.9.1</version>
			<exclusions>
				<exclusion>
					<artifactId>jackson-annotations</artifactId>
					<groupId>com.fasterxml.jackson.core</groupId>
				</exclusion>
			</exclusions>
		</dependency>
        
        <dependency>
			<groupId>org.owasp.esapi</groupId>
			<artifactId>esapi</artifactId>
			<version>2.1.0</version>
		</dependency>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
