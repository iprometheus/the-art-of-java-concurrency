public class A_ContextSwithTest {

    private static long count=100000000;

    public static void main(String[] args) throws Exception {
        System.out.println("1亿次");
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
                long a = 0;
                for (long i= 0; i < count; i++) {
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

        long time = System.currentTimeMillis()-startTime;
        System.out.println("concurrency:" + time+",b"+b);
    }

    private static void serial() throws Exception {
        long startTime = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b =0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - startTime;
        System.out.println("serial:" + time+",a"+a+",b"+b);

    }



}
