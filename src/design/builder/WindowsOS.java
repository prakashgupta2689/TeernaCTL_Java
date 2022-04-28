package design.builder;

public class WindowsOS {

    private final String name;
    private final String version;
    private final String manufacturer;
    private final String model;
    private final String processor;

    private WindowsOS(String name, String version, String manufacturer, String model, String processor) {
        this.name = name;
        this.version = version;
        this.manufacturer = manufacturer;
        this.model = model;
        this.processor = processor;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getProcessor() {
        return processor;
    }

    public static WindowsOSBuilder builder(){
        return new WindowsOSBuilder();
    }

    public static class WindowsOSBuilder{

        private String name;
        private String version;
        private String manufacturer;
        private String model;
        private String processor;

        public WindowsOSBuilder() {
        }

        public WindowsOSBuilder name(String name){
            this.name = name;
            return this;
        }

        public WindowsOSBuilder version(String version){

            this.version = version;
            return this;
        }

        public WindowsOSBuilder manufacturer(String manufacturer){

            this.manufacturer = manufacturer;
            return this;
        }

        public WindowsOSBuilder model(String model){

            this.model = model;
            return this;
        }

        public WindowsOSBuilder processor(String processor){

            this.processor = processor;
            return this;
        }

        public WindowsOS build(){

            return new WindowsOS(this.name, this.version, this.manufacturer, this.model, this.processor);
        }

    }
}
