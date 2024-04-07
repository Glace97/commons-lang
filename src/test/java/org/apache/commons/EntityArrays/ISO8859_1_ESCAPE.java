import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ISO8859_1_ESCAPETest {
  
  private EntityArrays entityArrays;
  
  @BeforeAll
  public void setUp() {
    entityArrays = new EntityArrays();
  }
  
  @Test
  public void testISO8859_1_ESCAPE() {
    String[][] expectedEscape = entityArrays.ISO8859_1_ESCAPE();
    String[][] actualEscape = EntityArrays.ISO8859_1_ESCAPE;
    assertEquals(expectedEscape.length, actualEscape.length);
    for (int i = 0; i < expectedEscape.length; i++) {
      assertEquals(expectedEscape[i][0], actualEscape[i][0]);
      assertEquals(expectedEscape[i][1], actualEscape[i][1]);
    }
  }
  
  @ParameterizedTest
  @CsvSource({
    "\u00A0, &nbsp;",
    "\u00A1, &iexcl;",
    "\u00A2, &cent;",
    "\u00A3, &pound;",
    "\u00A4, &curren;",
    "\u00A5, &yen;",
    "\u00A6, &brvbar;",
    "\u00A7, &sect;",
    "\u00A8, &uml;",
    "\u00A9, &copy;",
    "\u00AA, &ordf;",
    "\u00AB, &laquo;",
    "\u00AC, &not;",
    "\u00AD, &shy;",
    "\u00AE, &reg;",
    "\u00AF, &macr;",
    "\u00B0, &deg;",
    "\u00B1, &plusmn;",
    "\u00B2, &sup2;",
    "\u00B3, &sup3;",
    "\u00B4, &acute;",
    "\u00B5, &micro;",
    "\u00B6, &para;",
    "\u00B7, &middot;",
    "\u00B8, &cedil;",
    "\u00B9, &sup1;",
    "\u00BA, &ordm;",
    "\u00BB, &raquo;",
    "\u00BC, &frac14;",
    "\u00BD, &frac12;",
    "\u00BE, &frac34;",
    "\u00BF, &iquest;",
    "\u00C0, &Agrave;",
    "\u00C1, &Aacute;",
    "\u00C2, &Acirc;",
    "\u00C3, &Atilde;",
    "\u00C4, &Auml;",
    "\u00C5, &Aring;",
    "\u00C6, &AElig;",
    "\u00C7, &Ccedil;",
    "\u00C8, &Egrave;",
    "\u00C9, &Eacute;",
    "\u00CA, &Ecirc;",
    "\u00CB, &Euml;",
    "\u00CC, &Igrave;",
    "\u00CD, &Iacute;",
    "\u00CE, &Icirc;",
    "\u00CF, &Iuml;",
    "\u00D0, &ETH;",
    "\u00D1, &Ntilde;",
    "\u00D2, &Ograve;",
    "\u00D3, &Oacute;",
    "\u00D4, &Ocirc;",
    "\u00D5, &Otilde;",
    "\u00D6, &Ouml;",
    "\u00D7, &times;",
    "\u00D8, &Oslash;",
    "\u00D9, &Ugrave;",
    "\u00DA, &Uacute;",
    "\u00DB, &Ucirc;",
    "\u00DC, &Uuml;",
    "\u00DD, &Yacute;",
    "\u00DE, &THORN;",
    "\u00DF, &szlig;",
    "\u00E0, &agrave;",
    "\u00E1, &aacute;",
    "\u00E2, &acirc;",
    "\u00E3, &atilde;",
    "\u00E4, &auml;",
    "\u00E5, &aring;",
    "\u00E6, &aelig;",
    "\u00E7, &ccedil;",
    "\u00E8, &egrave;",
    "\u00E9, &eacute;",
    "\u00EA, &ecirc;",
    "\u00EB, &euml;",
    "\u00EC, &igrave;",
    "\u00ED, &iacute;",
    "\u00EE, &icirc;",
    "\u00EF, &iuml;",
    "\u00F0, &eth;",
    "\u00F1, &ntilde;",
    "\u00F2, &ograve;",
    "\u00F3, &oacute;",
    "\u00F4, &ocirc;",
    "\u00F5, &otilde;",
    "\u00F6, &ouml;",
    "\u00F7, &divide;",
    "\u00F8, &oslash;",
    "\u00F9, &ugrave;",
    "\u00FA, &uacute;",
    "\u00FB, &ucirc;",
    "\u00FC, &uuml;",
    "\u00FD, &yacute;",
    "\u00FE, &thorn;",
    "\u00FF, &yuml;"
  })
  public void testISO8859_1_ESCAPE(String input, String expectedOutput) {
    String actualOutput = StringUtil.escapeISO8859_1(input);
    assertEquals(expectedOutput, actualOutput);
  }

}