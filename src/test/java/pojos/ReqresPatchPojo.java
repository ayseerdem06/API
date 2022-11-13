package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqresPatchPojo {

    private String name;

    public ReqresPatchPojo(String name) {
        this.name = name;
    }

    public ReqresPatchPojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReqresPatchPojo{" +
                "name='" + name + '\'' +
                '}';
    }
}
