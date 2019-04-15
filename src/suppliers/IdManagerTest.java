package suppliers;

import org.junit.Test;

public class IdManagerTest {

    private static final String TEST_ID = "SUPPLIED-TEST-ID";
    private static final String USERNAME = "test";

    @Test
    public void test_isIdSupplied(){
        IdManager idManager = new IdManager(new TestIDSupplier());

        idManager.addUser(USERNAME);

        assert(idManager.getUser(USERNAME).name==USERNAME);
        assert(idManager.getUser(USERNAME).id==TEST_ID);
    }

    private class TestIDSupplier implements Supplier<String>{

        @Override
        public String get() {
            return TEST_ID;
        }
    }
}