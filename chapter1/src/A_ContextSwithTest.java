public class A_ContextSwithTest {

    private static int count=100000000;

    public static void main(String[] args) throws Exception {
        System.out.println("10000次(1万次)");
//        concurrency(10000);
//        serial(10000);
//
//        System.out.println("100000次(10万次)");
//        concurrency(100000);
//        serial(100000);
//
//        System.out.println("1000000次(100万次)");
//        concurrency(1000000);
//        serial(1000000);
//
//        System.out.println("10000000次(1000万次)");
//        concurrency(10000000);
//        serial(10000000);

        System.out.println("100000000次(1亿次)");
        concurrency();
        serial();
    }

    /**
     * 并行执行
     *
     * @throws Exception
     */
    private static void concurrency() throws Exception {
        long startTime = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });

        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();

        long end = System.currentTimeMillis();
        System.out.println("concurrency:" + (end - startTime)+",b"+b);
    }

    private static void serial() throws Exception {
        long startTime = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 10;
        }
        int b =10;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long end = System.currentTimeMillis();
        System.out.println("start:"+startTime);
        System.out.println("end:"+end);
        System.out.println("serial:" + (end - startTime)+",a"+a+",b"+b);

    }

}
