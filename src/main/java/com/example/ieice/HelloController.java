package com.example.ieice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "/orginazition.html";
    }

    @RequestMapping(value = {"/","/index"})
    public String index(Model model) {
        model.addAttribute("homeMenuSelect", true);
        model.addAttribute("ariid", "shanghaihead");
        model.addAttribute("title", "index - IEICE Shanghai Section Website");
        return "head";
    }

    @RequestMapping("/aboutUs")
    public String aboutUs(Model model){
        model.addAttribute("title", "IEICE Shanghai Section Website");
        model.addAttribute("aboutMenuSelect",true);
        model.addAttribute("ariid","aboutus");
        return "head";
    }

    @RequestMapping("/head")
    public String head(Model model){
        model.addAttribute("title","about");
        model.addAttribute("title", "Organization - IEICE Shanghai Section Website");
        model.addAttribute("aboutMenuSelect",true);
        return "head";
    }

    @RequestMapping("/aboutUs2")
    public String aboutUS2(Model model){
        model.addAttribute("title","haha");
//        model.addAttribute("homeMenuSelect","current-menu-item");
//        model.addAttribute("homeMenuSelect",true);
        model.addAttribute("ariid","shanghaihead");
        return "head";
    }

    @RequestMapping("/organization")
    public String organization(Model model){
        model.addAttribute("title", "Organization - IEICE Shanghai Section Website");
        model.addAttribute("aboutMenuSelect",true);
        model.addAttribute("organizationSelect", true);
        model.addAttribute("ariid","originage");
        return "head";
    }

    @RequestMapping("/activate")
    public String activate(Model model){
        model.addAttribute("title", "Activities - IEICE Shanghai Section Website");
        model.addAttribute("activateMenuSelect",true);
        model.addAttribute("ariid","activate");
        return "head";
    }

    @RequestMapping("/Meetings")
    public String meetings(Model model){
        model.addAttribute("title", "Meetings - IEICE Shanghai Section Website");
        model.addAttribute("activateMenuSelect",true);
        model.addAttribute("allSelect",true);
        model.addAttribute("ariid","meetings");
        return "head";
    }

    @RequestMapping("/Publications")
    public String publications(Model model){
        model.addAttribute("title", "Publications - IEICE Shanghai Section Website");
        model.addAttribute("activateMenuSelect",true);
        model.addAttribute("pubSelect",true);
        model.addAttribute("ariid","publications");
        return "head";
    }

    @RequestMapping("/Conferences")
    public String conferences(Model model){
        model.addAttribute("title", "Conferences - IEICE Shanghai Section Website");
        model.addAttribute("activateMenuSelect",true);
        model.addAttribute("cSelect",true);
        model.addAttribute("ariid","conferences");
        return "head";
    }

    @RequestMapping("/gallery")
    public String gallery(Model model){
        model.addAttribute("title", "Gallery - IEICE Shanghai Section Website");
        model.addAttribute("activateMenuSelect",true);
        model.addAttribute("gSelect",true);
        model.addAttribute("ariid","gallery");
        return "head";
    }

    @RequestMapping("/newUpdata")
    public String newUpdata(Model model){
        model.addAttribute("title", "newUpdata - IEICE Shanghai Section Website");
        model.addAttribute("newUpdataMenuSelect",true);
        model.addAttribute("ariid","newUpdata");
        return "head";
    }

    @RequestMapping("/Membership")
    public String membership(Model model){
        model.addAttribute("title", "Membership - IEICE Shanghai Section Website");
        model.addAttribute("mMenuSelect",true);
        model.addAttribute("ariid","Membership");
        return "head";
    }

    @RequestMapping("/MembershipDues")
    public String MembershipDues(Model model){
        model.addAttribute("title", "MembershipDues - IEICE Shanghai Section Website");
        model.addAttribute("mMenuSelect",true);
        model.addAttribute("mdSelect",true);
        model.addAttribute("ariid","mdMembership");
        return "head";
    }

    @RequestMapping("/bMembership")
    public String bMembership(Model model){
        model.addAttribute("title", "Benefits of Membership - IEICE Shanghai Section Website");
        model.addAttribute("mMenuSelect",true);
        model.addAttribute("bSelect",true);
        model.addAttribute("ariid","bMembership");
        return "head";
    }

    @RequestMapping("/Newpublications")
    public String newpublications(Model model){
        model.addAttribute("title", "New publications of Membership - IEICE Shanghai Section Website");
        model.addAttribute("ariid","Newpublications");
        return "head";
    }
}
