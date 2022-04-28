package design.builder;

public class BuilderExample {

    public static void main(String[] args) {

        WindowsOS windowsOS = WindowsOS.builder()
                .name("Windows OS")
                .version("10")
                .manufacturer("Microsoft")
                .model("UX430UAR")
                .processor("Intel")
                .build();

        System.out.println(windowsOS.getName());

        WindowsOS os2 = WindowsOS.builder()
                .manufacturer("Windows 8")
                .processor("Intel")
                .build();

        System.out.println(os2.getName());

    }
}
