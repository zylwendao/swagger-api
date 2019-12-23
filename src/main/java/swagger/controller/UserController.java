package swagger.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swagger.util.MakeSwaggerUtil;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "用户信息查询", description = "用户基本信息操作API", tags = "UserController", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
//
//    @ApiOperation(value = "/getUser", notes = "根据姓名查询用户信息")
//    @RequestMapping(value = "getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public User getUser(@RequestParam("name") String name){
//        User user = new User();
//        user.setId("123");
//        user.setName(name);
//        user.setAge(25);
//        return user;
//    }
//    @ApiOperation(value = "/addUser", notes = "添加一个用户")
//    @RequestMapping(value = "addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public User addUser(@RequestBody User user){
//        return user;
//    }

//    @Autowired
//    MakeSwaggerUtil makeSwaggerUtil;
//
//    @RequestMapping(value = "demo")
//    @ResponseBody
//    public String run() {
//        return makeSwaggerUtil.makeAPI();
//    }


}
