package leilao;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class LeilaoMatcher extends TypeSafeMatcher {
    private Lance lance;

    public LeilaoMatcher(Lance lance){
        this.lance = lance;
    }

    public static Matcher<Leilao> temUmLance(Lance lance) {
        return new LeilaoMatcher(lance);
    }


    @Override
    public void describeTo(Description description) {
        description.appendText("leilao com lance " + lance.getValor());
    }

    @Override
    protected boolean matchesSafely(Object o) {
        Leilao leilao = (Leilao)o;
        return leilao.getLances().contains(lance);
    }

}
