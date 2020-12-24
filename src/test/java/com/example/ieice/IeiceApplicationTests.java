package com.example.ieice;

import com.example.ieice.Bean.Article;
import com.example.ieice.Dao.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.*;

@SpringBootTest
class IeiceApplicationTests {
    @Autowired
    ArticleRepository itemRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    void SpringEsTest() {
////        Article article1=new Article((long) 1,"title","context");
////        itemRepository.save(article1);
//        Iterable<Article> list= itemRepository.findAll();
//        for (Article article:list){
//            System.out.println(article.getId()+article.getTitle()/*+article.getContext()*/);
//        }
//    }
//
//    @Test
//    void SpringESadd(){
//        Article article1=new Article((long) 3,"title and baby","context and this");
//        itemRepository.save(article1);
////        Iterable<Article> list= itemRepository.findByContextContain("title");
////        for (Article article:list){
////            System.out.println(article.getId()+article.getTitle()+article.getContext());
////        }
//    }
//
//    @Test
//    void SpringESaddArticle(){
//        Map<String,String> articleMap=new LinkedHashMap<String, String>();
//        {
//            articleMap.put("About us", "The Institute of Electronics, Information and Communication Engineers (IEICE) is an academic society with mainly consisted of researchers and engineers.\n" +
//                    "\n" +
//                    "Towards 100 years of growth\n" +
//                    "\n" +
//                    "IEICE is a Japan's largest international academic society in the fields of electronics, information, and communications.\n" +
//                    "\n" +
//                    "IEICE was officially launched as the Telegraph and Telephone Society in May 1917. In May 2017, we celebrated our 100th anniversary.\n" +
//                    "\n" +
//                    "As an international academic society in electronic information communication and related fields, the Society aim to contribute to the formation of a healthy communication society and the maintenance and improvement of a rich global environment by promoting academic development, industrial development and human resource development.\n" +
//                    "\n" +
//                    "The IEICE will contribute working on activities of combining cross-cutting elements from multiple technological fields and establish new technological fields, to pioneer new fields and cultivate new human resource development which creates a paradigm shift.\n" +
//                    "\n" +
//                    "IEICE Malaysian Sections activities (April 2017 ~ March 2019)\n" +
//                    "\n" +
//                    "Conference/Symposium/Workshop\n" +
//                    "• The inaugural IEICE Workshop on Cryptography and Information Security has been conducted successfully on 15 December 2017 at Multimedia University, Melaka. The workshop was jointly organized by IEICE Malaysia Section and Multimedia University. This workshop featured 6 invited talks focusing on the state-of-the-art and current research trend in Cryptography and Information Security, in particular the sharing on recent research topics such as cryptocurrency/bitcoin/blockchain technology, GPGPU, and searchable encryption.\n" +
//                    "• The Invited Speakers:\n" +
//                    "1. Dr. Muhammad Reza Z’aba, Researcher, Malaysian Institute of Microelectronic Systems (MIMOS)\n" +
//                    "2. Dr. Geong Sen Poh, Researcher, Malaysian Institute of Microelectronic Systems (MIMOS)\n" +
//                    "3. Dr. Jiqiang Lu, Scientist, Institute for Infocomm Research (I2R), Singapore\n" +
//                    "4. Dr. Raphael Phan, Professor, Multimedia University (Cyberjaya)\n" +
//                    "5. Dr. Wei-Chuen Yau, Associate Professor, Xiamen University Malaysia\n" +
//                    "6. Mr. Wai Kong Lee, Universiti Tunku Abdul Rahman, Malaysia\n" +
//                    "• The workshop received overwhelming response from a few institutions and organizations and was attended by about 40 researchers working in information security related areas. The main participations are from Malaysian Institute of Microelectronic Systems (MIMOS), CyberSecurity Malaysia, Universiti Putra Malaysia (UPM), Universiti Teknikal Malaysia (UTeM), International Islamic University Malaysia (IIUM), and Multimedia University (MMU).\n" +
//                    "• Prof. Heng also briefed the participants on the establishment of IEICE Malaysia Section and shared the benefits of IEICE membership.");
//
//            articleMap.put("Activity", "Current Research Scope and Technology Focus\n" +
//                    "\n" +
//                    "The current research scope and technology focus cover but they are not limited to the following issues:\n" +
//                    "\n" +
//                    "Optical Wireless Technology\n" +
//                    "Intelligent Autonomous Control\n" +
//                    "Artificial Transportation Systems\n" +
//                    "Biology Information Systems\n" +
//                    "Renewable Energy Research\n" +
//                    "Wireless Convergence\n" +
//                    "New Generation Networks\n" +
//                    "Internet of Things\n" +
//                    "Cloud Computing\n" +
//                    "Big Data Processing\n" +
//                    "Information Security\n" +
//                    "With the above selected scope and focus, we look forward to possible collaborations with all relevant IEICE Societies/Group including the recently established Nonlinear Theory and Its Applications Society (NOLTA).");
//
//            articleMap.put("IEICE Sections Meetings", "IEICE Sections Meetings\n" +
//                    "Here is a list of Sections Meetings IEICE General Conference:\n" +
//                    "\n" +
//                    "All Sections Meeting 2015 IEICE General Conference\n" +
//                    "All Sections Meeting 2016 IEICE General Conference\n" +
//                    "All Sections Meeting 2017 IEICE General Conference\n" +
//                    "All Sections Meeting 2019 IEICE General Conference");
//
//            articleMap.put("Publications", "The Journal of the IEICE\n" +
//                    "\n" +
//                    "A cutting-edge world to know from each special issues ~ You will See the Future you do not Know~. The journal is published 23,000 copies every month. We publish a special issue every month and delivered to members in an easy-to-read articles centering on the field of electronic information communications.\n" +
//                    "\n" +
//                    "With the 100th anniversary of our foundation, we have completely digitized all of the journals since the first issue (the number of contents is about 20,000) and currently providing an online version. We have provided a journal application in order to support smartphones since December 2013. You can also browse through a trial browsing site. We hope you will enjoy our journal.\n" +
//                    "\n" +
//                    "The IEICE Transactions\n" +
//                    "\n" +
//                    "~ Knowing the cutting-edge technologies~\n" +
//                    "\n" +
//                    "IEICE publishes four Japanese journals and seven English journals, of which five English journals have impact factors. Each journal has independent contents and contains papers that have been rigorously reviewed by prominent researchers. Papers are submitted from all over the world and 70% of submissions are from overseas. The annual publications in eleven journals is about 13,000 in FY2018. We introduced an Open Access Option System for English journals. Authors are allowed to publish free access paper for an additional fee from the January 2019 issue. We are looking forward to your submission.\n" +
//                    "\n" +
//                    "Contents archive system\n" +
//                    "\n" +
//                    "Know what shall be, Consider what has been\n" +
//                    "\n" +
//                    "~From the past to the future, for the next 100 years~\n" +
//                    "\n" +
//                    "The IEICE is promoting the digitization of IEICE journals, Japanese transactions, English transactions, IEICE Technical Report, conference proceedings, International conference proceedings, etc. In addition, the IEICE operate an archive system that is intended to be used as a new research resource for researchers in the field of electronic information communications.\n" +
//                    "\n" +
//                    "The contents archive system has been preserved from the journal published in 1917, and currently contains about 400,000 contents.\n" +
//                    "\n" +
//                    "Challenge and Creation\n" +
//                    "\n" +
//                    "Research Society\n" +
//                    "\n" +
//                    "A place where people and technology meet\n" +
//                    "\n" +
//                    "-A world tide is born-\n" +
//                    "\n" +
//                    "The research society is a unique activity of the IEICE. Under five societies and one group, many researchers gather in each specialized field, and the number of research societies exceeds 500 per year and the number of presentations reaches 10,000. Active discussions are held on the theme of cutting-edge technology to encourage the emergence of new research. IEICE Technical Reports as research societies materials will be digitized from conventional booklets and will be fully digitized in FY2020. In addition, we support activities from presentation to submission through our original Research Society application system. We hope to your participate in the research society as a place to interact with researchers.\n" +
//                    "\n" +
//                    "Challenge and Creation\n" +
//                    "\n" +
//                    "Interact with researchers\n" +
//                    "\n" +
//                    "Researchers and engineers with diverse values gather and create new values n a place of communication\n" +
//                    "\n" +
//                    "Conference -A place to stimulate intellectual curiosity-\n" +
//                    "\n" +
//                    "IEICE holds conferences every spring and autumn, where students, engineers and researchers from companies and universities gathers to discuss.\n" +
//                    "\n" +
//                    "The conference hold thousands of general lectures and symposiums, as well as special lectures by prominent researchers. In addition, we hold an event with cutting-edge themes.\n" +
//                    "\n" +
//                    "In the poster session, you can get a lot of advice from senior researchers. Career consultation meeting which is popular among students allows to interact with various companies. There is also a company exhibition as a place for creating industry-government-academia exchanges and technology trends and services, and holding presentations.\n" +
//                    "\n" +
//                    "The conference hosted by the IEICE is one of the leading events in Japan, with approximately 5,000 participants in the Spring General Conference and approximately 3,000 participants in the Fall Society Conference. FIT hold jointly with the IPSJ. The FIT participants is approximately 1000.\n" +
//                    "\n" +
//                    "We will start using the conference app from 2020 General Conference to improve the convenience of participants and make it easier to refer to the conference program.");
//
//            articleMap.put("IEICE Global Conferences", "Society's Conferences\n" +
//                    "\n" +
//                    "IEICE Society Conference 2017\n" +
//                    "IEICE General Conference 2017\n" +
//                    "International Conferences\n" +
//                    "\n" +
//                    "Engineering Sciences Society(ESS)\n" +
//                    "Communications Society(CS)\n" +
//                    "Electronics Society(E\n" +
//                    "Information and System Society(ISS)\n" +
//                    "Human Communication Group(HCG)\n" +
//                    "others\n" +
//                    "\n" +
//                    "Technical Committee Conferences\n" +
//                    "International Conferences\n" +
//                    "I-Scover Park\n" +
//                    "I-Scover Park (Japanese)");
//
//            articleMap.put("Gallery", "2015 IEICE All Sections Meeting,2016 IEICE All Sections Meeting");
//
//            articleMap.put("Membership", "Membership benefits\n" +
//                    "\n" +
//                    "Subscription to the official magazine “Journal of the Institute of Electronics, Information and Communication Engineers”\n" +
//                    "\n" +
//                    "Submission and presentation to journals and research societies\n" +
//                    "\n" +
//                    "Submission and presentation at the conference\n" +
//                    "\n" +
//                    "Special price purchase of books published by the Society\n" +
//                    "\n" +
//                    "Preferential fees for conferences, workshops, research societies, tours, etc.\n" +
//                    "\n" +
//                    "Interaction with people\n" +
//                    "\n" +
//                    "Participation in conferences and workshops\n" +
//                    "\n" +
//                    "Planning and operation of research societies and international conferences\n" +
//                    "\n" +
//                    "Submit your paper to Transactions\n" +
//                    "\n" +
//                    "Management of the Society as an officer\n" +
//                    "\n" +
//                    "Editing and planning of Transactions and journals\n" +
//                    "\n" +
//                    "Peer review\n" +
//                    "\n" +
//                    "Attendance at workshops and conferences\n" +
//                    "\n" +
//                    "Participation in academic events (lectures. etc.)\n" +
//                    "\n" +
//                    "Presentation of papers at workshops and conferences\n" +
//                    "\n" +
//                    "Participation in a variety of activities\n" +
//                    "\n" +
//                    "Read papers\n" +
//                    "\n" +
//                    "Subscription of journals and magazine articles\n" +
//                    "\n" +
//                    "Contents Publishing System Archive Search\n" +
//                    "\n" +
//                    "(common search)\n" +
//                    "\n" +
//                    "E-Learning\n" +
//                    "\n" +
//                    "Various awards\n" +
//                    "\n" +
//                    "Grant of Fellow title\n" +
//                    "\n" +
//                    "Membership Information\n" +
//                    "\n" +
//                    "We accept applications for membership at any time. When you join, you can get the latest information on electronic information and communication fields. For details, please refer to our website.\n" +
//                    "\n" +
//                    " \n" +
//                    "\n" +
//                    "The IEICE support your research and development.\n" +
//                    "\n" +
//                    "Membership in IEICE comes with a lot of benefits. Apart from being able to access members only resources on the our website, members can also participate in conferences and publish papers with IEICE . Please follow the links below for membership related matters:" +
//                    "Joining IEICE (Overseas Membership)\n" +
//                    "Joining IEICE (Japanese Residents only)\n" +
//                    "Click here for Membership Application Credit Card Form\n" +
//                    "Request form for mailing and Journal Options");
//
//            articleMap.put("Membership Dues", "IEICE Membership Dues\n" +
//                    "*IEICE Membership dues :All IEICE Members can access online transactions(English/Japanese) of registered Society [unit : JPY]\n" +
//                    "-\tMEMBER\tSTUDENT\tMEMBER\n" +
//                    "(OMDP)\tSTUDENT\n" +
//                    "(OMDP)\n" +
//                    "Annual fee\t7,000\t2,000\t5,000\t1,000\n" +
//                    "Additional Society\n" +
//                    "(/1Society)\t3,500\t2,000\t3,000\t1,500\n" +
//                    "Reduced\n" +
//                    "membership fee\t5,000\t-\t4,000\t-\n" +
//                    "*IEICE membership year runs from 1 April through 31 March.\n" +
//                    "*OMDP is for candidates from countries/areas in Asia (except Republic of Korea,Taiwan,China and Singapore),Africa, Central America and South America, etc.\n" +
//                    "*When your classification is changed from a Student Member to a Member,your membership dues is reduced to half for the first two years (Except postdoctoral).\n" +
//                    "[ Option ]\n" +
//                    "*Journal(Japanese) is available at 6,000 JPY per year.\n" +
//                    "Surface mail charge is included in membership fee. If you want rapid mailing service, please refer the following chart.\n" +
//                    "Zone\tAreas\tAir mail\tSAL mail\n" +
//                    "1st\tAsia; Guam; Midway islands\t5,600\t3,200\n" +
//                    "2st\tOceania; Near & Middle East; North & Central America; Europe\t7,800\t4,400\n" +
//                    "3st\tAfrica; South America\t11,000\t5,600\n" +
//                    "(per year)\n" +
//                    "\n" +
//                    "Click here for Membership Application Credit Card Form\n" +
//                    "\n" +
//                    "Request form for mailing and Journal Options");
//
//            articleMap.put("Benefits of Membership", "New useful function of our web page\n" +
//                    "\n" +
//                    "The necessary procedures can be conducted on the Internet.\n" +
//                    "membership fee payment\n" +
//                    "change your address\n" +
//                    "change / add your Society\n" +
//                    "change membership classification. \n" +
//                    "You can participate in various events:\n" +
//                    "\n" +
//                    "You can submit your papers for publication in the appropriate Transactions\n" +
//                    "You can participate in international conferences co-sponsored by the IEICE and major engineering societies of other countries.\n" +
//                    "You can register with one or more Societies and participate in Society-sponsored events.\n" +
//                    "You can participate in local events and student events of the IEICE.\n" +
//                    "You are entitled to apply to participate in voluntary-training courses sponsored by the Japan Accreditation Board for Engineering Education (JABEE) as a member. Furthermore, you can become a JABEE reviewer by participating in its reviews.\n" +
//                    "You can receive IEICE Publications:\n" +
//                    "\n" +
//                    "You can read papers in the Transactions of your Society in electronic form.\n" +
//                    "You receive News Letters from your Society. \n" +
//                    "You can also benefit from miscellaneous member services.\n" +
//                    "\n" +
//                    "You are eligible for various IEICE awards.\n" +
//                    "You can buy various IEICE publications (books, textbooks, handbooks, etc.) at member discount rates.\n" +
//                    "You can get information about papers presented in Technical Group meetings and General Conferences in the past. If you wish to make a copy of paper, you can do so by visiting the IEICE office or related facilities\n" +
//                    "I-Scover (IEICE Knowledge Discovery) is available free of charge for anyone. But,for a person who has an IEICE membership, login is recommended to utilize some of its privileges.\n" +
//                    "You can use the email forwarding service with up to two forwarding addresses, and including a virus scan feature.\n" +
//                    "You can receive benefits under the shared benefit plan with other engineering societies (IEEE, the Institute of Electrical Engineers of Japan, the Information Processing Society of Japan, etc.)\n" +
//                    "You can benefit from a discounted membership subscription if you are 60 or more years old, and can get free membership if the sum of your age(70 years old or old), and years of your membership exceeds 100.\n" +
//                    "You can get member discount rates for hotels, car hire and other travel expenditure(In Japan) .");
//        }
//        ArrayList<Article> articles=new ArrayList<Article>();
//        Iterator<Map.Entry<String,String>> iterator = articleMap.entrySet().iterator();
//        int i=0;
//        while (iterator.hasNext()){
//            Map.Entry entry=iterator.next();
//            articles.add(new Article((long) i,(String) entry.getKey(),(String) entry.getValue()));
//            i++;
//        }
//        for(Article article:articles){
//            System.out.println(article.getId()+article.getTitle()+article.getContext());
//        }
//        itemRepository.saveAll(articles);
//    }
//
//    @Test
//    void SpringESfindO(){
//    }
//    @Test
//    void SpringESFind(){
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//        queryBuilder.withQuery(QueryBuilders.matchQuery("title baby", "title this"));
//    }
//    @Test
//    void SpringESFindbyALL(){
////        ArrayList<String> arrayList1=new ArrayList<String>();
////        arrayList1.add("title");
////        arrayList1.add("baby");
////        ArrayList<String> arrayList2=new ArrayList<String>();
////        arrayList2.add("Scover");
////        arrayList2.add("aida");
//
//        List<Article> list= itemRepository.findByTitleInOrContextIn(Arrays.asList("assdas "),Arrays.asList("Grant","Fellow","title"));
//        for (Article article:list){
//            System.out.println(/*article.getId()+*/article.getTitle()/*+article.getContext()*/);
//        }
//    }
}
