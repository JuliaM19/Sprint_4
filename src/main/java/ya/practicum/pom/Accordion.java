package ya.practicum.pom;

public class Accordion {

    private final String accordionHeader;
    private final String accordionText;

    public Accordion(String accordionHeader, String accordionText) {
        this.accordionHeader = accordionHeader;
        this.accordionText = accordionText;
    }

    public String getAccordionHeader() {
        return accordionHeader;
    }

    public String getAccordionText() {
        return accordionText;
    }
}
