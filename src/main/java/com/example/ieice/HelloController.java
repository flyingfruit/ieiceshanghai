package com.example.ieice;

import com.example.ieice.Bean.Art;
import com.example.ieice.Bean.Article;
import com.example.ieice.service.SearchArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class HelloController {
    @Autowired
    private SearchArticle searchArticle;


    @RequestMapping("/hello")
    public String hello(){
        return "/orginazition.html";
    }

    @RequestMapping(value = {"/","/index"})
    public String index(Model model) {
        model.addAttribute("homeMenuSelect", true);
        model.addAttribute("ariid", "shanghaihead");
        model.addAttribute("title", "IEICE Shanghai Section Website");
        model.addAttribute("buttom", "buttom");
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

    @RequestMapping("/activities")
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

    @RequestMapping(value = {"/search"})
    public String search(Model model, HttpServletRequest request) {
//        model.addAttribute("homeMenuSelect", true);
        model.addAttribute("ariid", "search");
        model.addAttribute("title", "search - IEICE Shanghai Section Website");
        Map<Integer, String> idmap = new HashMap<Integer, String>();
        String m=request.getParameter("s");
        {
            idmap.put(0, "aboutUs");
            idmap.put(1,"activities");
            idmap.put(2,"Meetings");
            idmap.put(3,"Publications");
            idmap.put(4,"Conferences");
            idmap.put(5,"gallery");
            idmap.put(6,"Membership");
            idmap.put(7,"MembershipDues");
            idmap.put(8,"bMembership");
        }
        List<Article> articles=searchArticle.searchArticle(m);
        ArrayList<Art> articlelist=new ArrayList<Art>();
        if(articles.isEmpty()){
//            model.addAttribute("", "search");
            return "head";
        }
        for(Article article:articles){
            String Context=article.getContext();
//            Context+="<a href=\\\"https://ieicemalaysia.org/?page_id=117\\\" class=\\\"more-link\\\">...continue reading<span class=\\\"screen-reader-text\\\"> \\\"Organization\\\"</span></a></p>";
            boolean overlength=Context.length()>301?true:false;
//            boolean overlength=true;
            articlelist.add(new Art(Long.toString(article.getId()),article.getTitle(),overlength?Context.substring(0,300)+"...":Context+"...",idmap.get(article.getId().intValue()),overlength));
        }
//        articlelist.add(new Art("post-214","this2","ications of Membership - IE2","head"));
        model.addAttribute("articlelist",articlelist);
        model.addAttribute("search",m);
        return "reseach";
    }

    @RequestMapping("/Newpublications")
    public String newpublications(Model model){
        model.addAttribute("title", "New publications of Membership - IEICE Shanghai Section Website");
        model.addAttribute("ariid","Newpublications");
        return "head";
    }

    @ExceptionHandler(Exception.class) // 所有的异常都是Exception子类
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) { // 出现异常之后会跳转到此方法
        ModelAndView mav = new ModelAndView("error"); // 设置跳转路径
        return mav;
    }

}
