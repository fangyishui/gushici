//package org.gushi.gushici;
//
//import org.gushi.gushici.dao.BaseMongoDao;
//import org.gushi.gushici.dao.MongoTestDao;
//import org.gushi.gushici.entity.MongoTest;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class GushiciApplicationTests {
//
//    @Autowired
//    private MongoTestDao mtdao;
//
//    @Autowired
//    private BaseMongoDao baseMongoDao;
//
//    @Test
//    void contextLoads() {
//        System.out.println("start。。。");
//    }
//
//    @Test
//    public void saveTest() throws Exception {
//        MongoTest mgtest=new MongoTest();
//        mgtest.setId(1121);
//        mgtest.setAge(33);
//        mgtest.setName("ceshi");
////        mtdao.saveTest(mgtest);
//
//        baseMongoDao.save(mgtest);
//    }
//
//    @Test
//    public void findTestByName(){
//        MongoTest mgtest= mtdao.findTestByName("ceshi");
//        System.out.println("mgtest is "+mgtest);
////        return mgtest;
//    }
//
//    @Test
//    public void updateTest(){
//        MongoTest mgtest=new MongoTest();
//        mgtest.setId(11);
//        mgtest.setAge(44);
//        mgtest.setName("ceshi2");
//        mtdao.updateTest(mgtest);
//    }
//
//    @Test
//    public void deleteTestById(){
//        mtdao.deleteTestById(11);
//    }
//
//}
