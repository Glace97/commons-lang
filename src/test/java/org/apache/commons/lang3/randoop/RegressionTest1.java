import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest1 {

    public static boolean debug = false;

    @Test
    public void test0501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0501");
        java.lang.reflect.Field[] fieldArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_FIELD_ARRAY;
        org.junit.Assert.assertNotNull(fieldArray0);
    }

    @Test
    public void test0502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0502");
        java.lang.String str1 = org.apache.commons.lang3.CharUtils.unicodeEscaped((java.lang.Character) '$');
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "\\u0024" + "'", str1, "\\u0024");
    }

    @Test
    public void test0503() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0503");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_12;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0504() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0504");
        java.lang.String str1 = org.apache.commons.lang3.text.WordUtils.swapCase("UTF-16");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "utf-16" + "'", str1, "utf-16");
    }

    @Test
    public void test0505() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0505");
        org.apache.commons.lang3.function.FailableLongFunction<org.apache.commons.lang3.stream.IntStreams, org.apache.commons.lang3.concurrent.UncheckedExecutionException> intStreamsFailableLongFunction0 = org.apache.commons.lang3.function.FailableLongFunction.nop();
        org.junit.Assert.assertNotNull(intStreamsFailableLongFunction0);
    }

    @Test
    public void test0506() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0506");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaVmInfo();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "mixed mode, sharing" + "'", str0, "mixed mode, sharing");
    }

    @Test
    public void test0507() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0507");
        java.util.Calendar calendar0 = null;
        java.util.Calendar calendar1 = null;
        // The following exception was thrown during execution in test generation
        try {
            int int3 = org.apache.commons.lang3.time.DateUtils.truncatedCompareTo(calendar0, calendar1, (-5));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0508() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0508");
        org.apache.commons.lang3.text.StrMatcher strMatcher0 = org.apache.commons.lang3.text.StrMatcher.noneMatcher();
        org.junit.Assert.assertNotNull(strMatcher0);
    }

    @Test
    public void test0509() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0509");
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException7 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException3);
        java.lang.Throwable throwable8 = org.apache.commons.lang3.exception.ExceptionUtils.getRootCause((java.lang.Throwable) uncheckedExecutionException3);
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertNotNull(throwable8);
        org.junit.Assert.assertNull("throwable8.getLocalizedMessage() == null", throwable8.getLocalizedMessage());
        org.junit.Assert.assertNull("throwable8.getMessage() == null", throwable8.getMessage());
        org.junit.Assert.assertEquals(throwable8.toString(), "org.apache.commons.lang3.concurrent.UncheckedExecutionException");
    }

    @Test
    public void test0510() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0510");
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate0 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        boolean boolean2 = throwableFailableLongPredicate0.test((long) (byte) 100);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate3 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate4 = throwableFailableLongPredicate0.or(throwableFailableLongPredicate3);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate5 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate6 = throwableFailableLongPredicate0.and(throwableFailableLongPredicate5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate3);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate4);
    }

    @Test
    public void test0511() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0511");
        double[] doubleArray5 = new double[] { 1.0d, 2147483647L, 100.0d, 10, 32.0f };
        double[] doubleArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(doubleArray5, 1.0d);
        double[] doubleArray12 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray16 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean18 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray16, (double) '4');
        boolean boolean19 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray12, doubleArray16);
        int int23 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray12, (-1.0d), (int) '\n', (double) 100);
        boolean boolean24 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray7, doubleArray12);
        org.apache.commons.lang3.ArrayUtils.shuffle(doubleArray7);
        int int29 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray7, (double) 100, 100, (double) 2);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[1.0, 2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray7);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray7), "[32.0, 2.147483647E9, 10.0, 100.0]");
        org.junit.Assert.assertNotNull(doubleArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray12), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray16), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertTrue("'" + int29 + "' != '" + (-1) + "'", int29 == (-1));
    }

    @Test
    public void test0512() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0512");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        char[] charArray13 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray16 = org.apache.commons.lang3.ArrayUtils.subarray(charArray13, (int) (short) 1, (-1));
        char[] charArray17 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray4, charArray13);
        char[] charArray19 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(charArray4, '#');
        org.apache.commons.lang3.ArrayUtils.reverse(charArray4);
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray2), "[ , #]");
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[ ]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[#]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray13);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray13), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray13), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray13), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray16);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray16), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray16), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray16), "[]");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray17), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray17), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray17), "[]");
        org.junit.Assert.assertNotNull(charArray19);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray19), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray19), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray19), "[ ]");
    }

    @Test
    public void test0513() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0513");
        char[] charArray0 = null;
        org.apache.commons.lang3.text.StrMatcher strMatcher2 = org.apache.commons.lang3.text.StrMatcher.charMatcher('a');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer(charArray0, strMatcher2);
        char[] charArray7 = new char[] { ' ', '#' };
        char[] charArray9 = new char[] { ' ' };
        char[] charArray10 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray7, charArray9);
        char[] charArray13 = org.apache.commons.lang3.ArrayUtils.add(charArray9, (int) (short) 0, ' ');
        java.lang.String str14 = org.apache.commons.lang3.text.WordUtils.initials(" ", charArray13);
        org.apache.commons.lang3.text.StrTokenizer strTokenizer15 = strTokenizer3.reset(charArray13);
        org.junit.Assert.assertNotNull(strMatcher2);
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray7), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray7), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray7), "[ , #]");
        org.junit.Assert.assertNotNull(charArray9);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray9), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray9), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray9), "[ ]");
        org.junit.Assert.assertNotNull(charArray10);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray10), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray10), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray10), "[#]");
        org.junit.Assert.assertNotNull(charArray13);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray13), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray13), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray13), "[ ,  ]");
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "" + "'", str14, "");
        org.junit.Assert.assertNotNull(strTokenizer15);
    }

    @Test
    public void test0514() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0514");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer9 = org.apache.commons.lang3.text.StrTokenizer.getTSVInstance(charArray8);
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.contains(charArray8, '#');
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray2), "[ , #]");
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[ ]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[#]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ ,  ]");
        org.junit.Assert.assertNotNull(strTokenizer9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test0515() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0515");
        // The following exception was thrown during execution in test generation
        try {
            int int1 = org.apache.commons.lang3.CharUtils.toIntValue('o');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The character o is not in the range '0' - '9'");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0516() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0516");
        org.apache.commons.lang3.mutable.MutableLong mutableLong1 = new org.apache.commons.lang3.mutable.MutableLong((java.lang.Number) 97);
    }

    @Test
    public void test0517() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0517");
        short short1 = org.apache.commons.lang3.ObjectUtils.CONST_SHORT(0);
        org.junit.Assert.assertTrue("'" + short1 + "' != '" + (short) 0 + "'", short1 == (short) 0);
    }

    @Test
    public void test0518() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0518");
        java.util.stream.IntStream intStream1 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream3 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle4 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle5 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str6 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle4, toStringStyle5);
        java.lang.StringBuffer stringBuffer7 = null;
        java.lang.Object obj8 = null;
        standardToStringStyle4.appendStart(stringBuffer7, obj8);
        java.lang.String str10 = standardToStringStyle4.getNullText();
        standardToStringStyle4.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder14 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream1, (java.lang.AutoCloseable) intStream3, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle4, true);
        long[] longArray17 = new long[] { 3 };
        long[] longArray18 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray17);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray17);
        long[] longArray21 = new long[] { '4' };
        long[] longArray27 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet30 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray27, (long) '\n', 100);
        boolean boolean31 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray27);
        long[] longArray33 = org.apache.commons.lang3.ArrayUtils.add(longArray27, (long) (short) 101);
        boolean boolean34 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray21, longArray33);
        long[] longArray36 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray33, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder37 = autoCloseableDiffBuilder14.append("java.awt.headless", longArray17, longArray36);
        org.apache.commons.lang3.builder.DiffResult<java.lang.AutoCloseable> autoCloseableDiffResult39 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder40 = autoCloseableDiffBuilder37.append("java.specification.vendor", autoCloseableDiffResult39);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: diffResult");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intStream1);
        org.junit.Assert.assertNotNull(intStream3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
        org.junit.Assert.assertNotNull(longArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray17), "[3]");
        org.junit.Assert.assertNotNull(longArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray18), "[3]");
        org.junit.Assert.assertNotNull(longArray21);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray21), "[52]");
        org.junit.Assert.assertNotNull(longArray27);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray27), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet30);
        org.junit.Assert.assertEquals(bitSet30.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNotNull(longArray33);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray33), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(longArray36);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray36), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder37);
    }

    @Test
    public void test0519() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0519");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaAwtFonts();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0520() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0520");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_VM_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "OpenJDK 64-Bit Server VM" + "'", str0, "OpenJDK 64-Bit Server VM");
    }

    @Test
    public void test0521() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0521");
        float[] floatArray5 = new float[] { (short) 1, (-1.0f), (byte) 0, 3, 0L };
        java.lang.String str9 = org.apache.commons.lang3.StringUtils.join(floatArray5, '\000', (int) (short) 101, (-1));
        org.junit.Assert.assertNotNull(floatArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray5), "[1.0, -1.0, 0.0, 3.0, 0.0]");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "" + "'", str9, "");
    }

    @Test
    public void test0522() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0522");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_2008;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0523() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0523");
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate0 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate1 = uncheckedExecutionExceptionFailableDoublePredicate0.negate();
        boolean boolean3 = uncheckedExecutionExceptionFailableDoublePredicate0.test((double) 60000L);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate0);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate1);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test0524() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0524");
        java.lang.String str1 = org.apache.commons.lang3.text.WordUtils.uncapitalize("os.version");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "os.version" + "'", str1, "os.version");
    }

    @Test
    public void test0525() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0525");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.removeElement(byteArray3, (byte) 100);
        // The following exception was thrown during execution in test generation
        try {
            long long10 = org.apache.commons.lang3.Conversion.byteArrayToLong(byteArray5, (int) (short) 10, (long) '4', (-27), 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nBytes-1)*8+dstPos is greater or equal to than 64");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[0, -1]");
    }

    @Test
    public void test0526() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0526");
        float[] floatArray3 = new float[] { 100.0f, 0.0f, 100L };
        org.apache.commons.lang3.ArrayUtils.shift(floatArray3, (int) (short) 100);
        float[] floatArray6 = org.apache.commons.lang3.ArraySorter.sort(floatArray3);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date8 = org.apache.commons.lang3.time.DateUtils.round((java.lang.Object) floatArray6, (-5));
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: Could not round [F@78bb497a");
        } catch (java.lang.ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[0.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray6), "[0.0, 100.0, 100.0]");
    }

    @Test
    public void test0527() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0527");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat((float) (short) -1);
        mutableFloat1.increment();
        float float3 = mutableFloat1.incrementAndGet();
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + 1.0f + "'", float3 == 1.0f);
    }

    @Test
    public void test0528() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0528");
        java.lang.String str2 = org.apache.commons.lang3.RandomStringUtils.randomPrint((int) (short) 1, (int) '\n');
// flaky:         org.junit.Assert.assertEquals("'" + str2 + "' != '" + ")<+WncT" + "'", str2, ")<+WncT");
    }

    @Test
    public void test0529() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0529");
        long long1 = org.apache.commons.lang3.math.NumberUtils.toLong(";ClT9Ss'St<Q");
        org.junit.Assert.assertTrue("'" + long1 + "' != '" + 0L + "'", long1 == 0L);
    }

    @Test
    public void test0530() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0530");
        int int2 = org.apache.commons.lang3.math.NumberUtils.compare((int) 'o', (int) (short) 1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 1 + "'", int2 == 1);
    }

    @Test
    public void test0531() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0531");
        java.util.TimeZone timeZone1 = org.apache.commons.lang3.time.FastTimeZone.getGmtTimeZone("\\u0061");
        org.junit.Assert.assertNull(timeZone1);
    }

    @Test
    public void test0532() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0532");
        boolean boolean2 = org.apache.commons.lang3.StringUtils.contains((java.lang.CharSequence) "/var/folders/hh/thrdkjsj7yn83kx4xl6753y40000gn/T/", (java.lang.CharSequence) "UTF-16BE");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0533() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0533");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = strTokenizer3.reset("");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer7 = strTokenizer5.setDelimiterString("java.awt.headless");
        java.lang.String str8 = strTokenizer7.nextToken();
        org.junit.Assert.assertNotNull(strTokenizer5);
        org.junit.Assert.assertNotNull(strTokenizer7);
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test0534() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0534");
        java.util.function.Predicate<java.lang.ThreadGroup> threadGroupPredicate0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Collection<java.lang.ThreadGroup> threadGroupCollection1 = org.apache.commons.lang3.ThreadUtils.findThreadGroups(threadGroupPredicate0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: predicate");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0535() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0535");
        java.lang.reflect.Type[] typeArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_TYPE_ARRAY;
        org.apache.commons.lang3.ArrayUtils.swap((java.lang.Object[]) typeArray0, (int) '4', (int) ' ');
        org.junit.Assert.assertNotNull(typeArray0);
    }

    @Test
    public void test0536() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0536");
        org.apache.commons.lang3.reflect.InheritanceUtils inheritanceUtils0 = new org.apache.commons.lang3.reflect.InheritanceUtils();
        org.apache.commons.lang3.reflect.InheritanceUtils inheritanceUtils1 = org.apache.commons.lang3.exception.ExceptionUtils.throwUnchecked(inheritanceUtils0);
        org.junit.Assert.assertNotNull(inheritanceUtils1);
    }

    @Test
    public void test0537() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0537");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange2 = org.apache.commons.lang3.Range.of(javaVersion0, javaVersion1);
        char[] charArray5 = new char[] { ' ', '#' };
        char[] charArray7 = new char[] { ' ' };
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray5, charArray7);
        boolean boolean9 = javaVersionRange2.equals((java.lang.Object) charArray8);
        org.apache.commons.lang3.JavaVersion javaVersion10 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion11 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange12 = org.apache.commons.lang3.Range.of(javaVersion10, javaVersion11);
        boolean boolean13 = javaVersionRange2.isEndedBy(javaVersion11);
        java.util.function.Function<java.lang.Object, java.lang.String> objFunction17 = null;
        java.util.stream.Collector<java.lang.Object, ?, java.lang.String> objCollector18 = org.apache.commons.lang3.stream.LangCollectors.joining((java.lang.CharSequence) " ", (java.lang.CharSequence) "StrTokenizer[not tokenized yet]", (java.lang.CharSequence) "100", objFunction17);
        boolean boolean19 = javaVersionRange2.equals((java.lang.Object) objFunction17);
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange2);
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[ , #]");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray7), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray7), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray7), "[ ]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[#]");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + javaVersion10 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion10.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion11 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion11.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNotNull(objCollector18);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test0538() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0538");
        char[] charArray3 = new char[] { ' ', '#' };
        char[] charArray5 = new char[] { ' ' };
        char[] charArray6 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray3, charArray5);
        java.util.Random random7 = null;
        org.apache.commons.lang3.ArrayUtils.shuffle(charArray6, random7);
        int int9 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) "no", charArray6);
        org.apache.commons.lang3.text.StrTokenizer strTokenizer11 = new org.apache.commons.lang3.text.StrTokenizer(charArray6, ",");
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray3), "[ , #]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[ ]");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray6), "[#]");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
    }

    @Test
    public void test0539() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0539");
        org.apache.commons.lang3.text.translate.JavaUnicodeEscaper javaUnicodeEscaper2 = org.apache.commons.lang3.text.translate.JavaUnicodeEscaper.outsideOf((int) (byte) 100, (int) (byte) 0);
        org.junit.Assert.assertNotNull(javaUnicodeEscaper2);
    }

    @Test
    public void test0540() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0540");
        short[] shortArray2 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray2, (int) (byte) -1, 1, (int) (byte) 10);
        org.apache.commons.lang3.ArrayUtils.shuffle(shortArray2);
        int int9 = org.apache.commons.lang3.ArrayUtils.indexOf(shortArray2, (short) (byte) 10);
        org.junit.Assert.assertNotNull(shortArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray2), "[100, 100]");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
    }

    @Test
    public void test0541() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0541");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.time.DateUtils.getFragmentInHours(calendar0, (int) '\000');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: calendar");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0542() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0542");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_PANTHER;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0543() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0543");
        java.util.Collection<java.util.Locale> localeCollection0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream1 = org.apache.commons.lang3.Streams.stream(localeCollection0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Collection.stream()\" because \"stream\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0544() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0544");
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException7 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException3);
        org.apache.commons.lang3.exception.CloneFailedException cloneFailedException8 = new org.apache.commons.lang3.exception.CloneFailedException((java.lang.Throwable) notImplementedException7);
        org.junit.Assert.assertNotNull(throwableArray4);
    }

    @Test
    public void test0545() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0545");
        char[] charArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_CHAR_ARRAY;
        org.junit.Assert.assertNotNull(charArray0);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray0), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray0), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray0), "[]");
    }

    @Test
    public void test0546() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0546");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.addFirst(byteArray2, (byte) -1);
        byte[] byteArray6 = org.apache.commons.lang3.ArrayUtils.clone(byteArray2);
        byte[] byteArray9 = org.apache.commons.lang3.ArrayUtils.subarray(byteArray2, (int) (short) 101, (int) (short) 0);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[-1, 0, -1]");
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray6), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray9), "[]");
    }

    @Test
    public void test0547() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0547");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray13 = org.apache.commons.lang3.ArrayUtils.remove(booleanArray5, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 52, Length: 5");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet9);
        org.junit.Assert.assertEquals(bitSet9.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(booleanArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray11), "[false, true, false, true, false, true]");
    }

    @Test
    public void test0548() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0548");
        double[] doubleArray5 = new double[] { (byte) 100, (byte) -1, (byte) 100, (-1L), 0.0d };
        org.apache.commons.lang3.ArrayUtils.reverse(doubleArray5);
        java.lang.reflect.Type type7 = null;
        boolean boolean8 = org.apache.commons.lang3.reflect.TypeUtils.isInstance((java.lang.Object) doubleArray5, type7);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[0.0, -1.0, 100.0, -1.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test0549() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0549");
        int int2 = org.apache.commons.lang3.math.NumberUtils.compare((long) 0, (long) (-1));
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 1 + "'", int2 == 1);
    }

    @Test
    public void test0550() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0550");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_MOUNTAIN_LION;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0551() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0551");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair1 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray2 = charSequenceArrayImmutablePair1.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair3 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair1);
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle4 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle5 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str6 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle4, toStringStyle5);
        java.lang.StringBuffer stringBuffer7 = null;
        java.lang.Object obj8 = null;
        standardToStringStyle4.appendStart(stringBuffer7, obj8);
        java.lang.String str10 = standardToStringStyle4.getNullText();
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayImmutablePairReflectionDiffBuilder11 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>>(charSequenceArrayImmutablePair0, charSequenceArrayImmutablePair1, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle4);
        java.lang.String str12 = standardToStringStyle4.getSummaryObjectStartText();
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair1);
        org.junit.Assert.assertNull(charSequenceArray2);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "<" + "'", str12, "<");
    }

    @Test
    public void test0552() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0552");
        float float2 = org.apache.commons.lang3.RandomUtils.nextFloat(0.6f, (float) '4');
// flaky:         org.junit.Assert.assertTrue("'" + float2 + "' != '" + 22.874115f + "'", float2 == 22.874115f);
    }

    @Test
    public void test0553() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0553");
        int int1 = org.apache.commons.lang3.StringUtils.length((java.lang.CharSequence) "long");
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 4 + "'", int1 == 4);
    }

    @Test
    public void test0554() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0554");
        short short1 = org.apache.commons.lang3.ObjectUtils.CONST((short) 0);
        org.junit.Assert.assertTrue("'" + short1 + "' != '" + (short) 0 + "'", short1 == (short) 0);
    }

    @Test
    public void test0555() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0555");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = strTokenizer3.reset("");
        java.lang.String str6 = strTokenizer3.previousToken();
        org.junit.Assert.assertNotNull(strTokenizer5);
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test0556() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0556");
        org.apache.commons.lang3.exception.ContextedException contextedException0 = new org.apache.commons.lang3.exception.ContextedException();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle4 = null;
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder5 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle4);
        org.apache.commons.lang3.exception.ContextedException contextedException6 = contextedException0.setContextValue("yes", (java.lang.Object) 0);
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator7 = org.apache.commons.lang3.StringEscapeUtils.UNESCAPE_HTML4;
        boolean boolean8 = org.apache.commons.lang3.ObjectUtils.equals((java.lang.Object) contextedException0, (java.lang.Object) charSequenceTranslator7);
        org.apache.commons.lang3.exception.ContextedException contextedException11 = contextedException0.setContextValue("os.name", (java.lang.Object) "OpenJDK Runtime Environment");
        java.util.List<org.apache.commons.lang3.tuple.Pair<java.lang.String, java.lang.Object>> strPairList12 = contextedException11.getContextEntries();
        org.apache.commons.lang3.function.FailableBiConsumer<java.io.File, org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.RuntimeException> fileFailableBiConsumer14 = org.apache.commons.lang3.function.FailableBiConsumer.nop();
        java.util.function.BiConsumer<java.io.File, org.apache.commons.lang3.builder.RecursiveToStringStyle> fileBiConsumer15 = org.apache.commons.lang3.function.Failable.asBiConsumer(fileFailableBiConsumer14);
        org.apache.commons.lang3.exception.ContextedException contextedException16 = contextedException11.addContextValue("", (java.lang.Object) fileBiConsumer15);
        org.junit.Assert.assertNotNull(contextedException6);
        org.junit.Assert.assertNotNull(charSequenceTranslator7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(contextedException11);
        org.junit.Assert.assertNotNull(strPairList12);
        org.junit.Assert.assertNotNull(fileFailableBiConsumer14);
        org.junit.Assert.assertNotNull(fileBiConsumer15);
        org.junit.Assert.assertNotNull(contextedException16);
    }

    @Test
    public void test0557() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0557");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setNullText("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        standardToStringStyle0.setFieldSeparatorAtStart(true);
        java.lang.StringBuffer stringBuffer5 = null;
        // The following exception was thrown during execution in test generation
        try {
            standardToStringStyle0.append(stringBuffer5, "/Users/glacierali/randoop-4.3.2", (int) '\n');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0558() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0558");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = strTokenizer3.reset("");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer7 = strTokenizer5.setDelimiterString("java.awt.headless");
        boolean boolean8 = strTokenizer7.hasNext();
        org.junit.Assert.assertNotNull(strTokenizer5);
        org.junit.Assert.assertNotNull(strTokenizer7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test0559() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0559");
        java.lang.Number number0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat(number0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.Number.floatValue()\" because \"value\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0560() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0560");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_NT;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0561() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0561");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.unwrap("\\u0061", 'a');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "\\u0061" + "'", str2, "\\u0061");
    }

    @Test
    public void test0562() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0562");
        java.util.Formatter formatter1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Formatter formatter6 = org.apache.commons.lang3.text.FormattableUtils.append((java.lang.CharSequence) "long", formatter1, (int) 'o', (int) (short) 1, (int) (byte) 1, 'o');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Formatter.format(String, Object[])\" because \"formatter\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0563() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0563");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat((float) (short) -1);
        int int2 = mutableFloat1.intValue();
        float float4 = mutableFloat1.addAndGet((float) 1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertTrue("'" + float4 + "' != '" + 0.0f + "'", float4 == 0.0f);
    }

    @Test
    public void test0564() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0564");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        org.apache.commons.lang3.ArrayUtils.swap(booleanArray5, (-27), (int) (byte) 1);
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray12 = org.apache.commons.lang3.ArrayUtils.remove(booleanArray5, (int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 10, Length: 5");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[true, false, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
    }

    @Test
    public void test0565() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0565");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean1 = new org.apache.commons.lang3.mutable.MutableBoolean((java.lang.Boolean) true);
        boolean boolean3 = mutableBoolean1.equals((java.lang.Object) 0.0f);
        boolean boolean4 = mutableBoolean1.isTrue();
        boolean boolean5 = mutableBoolean1.isFalse();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0566() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0566");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        boolean boolean12 = org.apache.commons.lang3.BooleanUtils.and(booleanArray5);
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet9);
        org.junit.Assert.assertEquals(bitSet9.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(booleanArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray11), "[false, true, false, true, false, true]");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test0567() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0567");
        org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper2 = org.apache.commons.lang3.text.translate.NumericEntityEscaper.between(0, 0);
        org.junit.Assert.assertNotNull(numericEntityEscaper2);
    }

    @Test
    public void test0568() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0568");
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException1 = new org.apache.commons.lang3.exception.ContextedRuntimeException("mixed mode, sharing");
        float[] floatArray2 = new float[] {};
        java.util.BitSet bitSet4 = org.apache.commons.lang3.ArrayUtils.indexesOf(floatArray2, 0.0f);
        org.apache.commons.lang3.tuple.ImmutablePair<org.apache.commons.lang3.exception.ContextedRuntimeException, java.util.BitSet> contextedRuntimeExceptionImmutablePair5 = new org.apache.commons.lang3.tuple.ImmutablePair<org.apache.commons.lang3.exception.ContextedRuntimeException, java.util.BitSet>(contextedRuntimeException1, bitSet4);
        org.junit.Assert.assertNotNull(floatArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray2), "[]");
        org.junit.Assert.assertNotNull(bitSet4);
        org.junit.Assert.assertEquals(bitSet4.toString(), "{}");
    }

    @Test
    public void test0569() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0569");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = strTokenizer3.reset("");
        int int6 = strTokenizer3.size();
        org.junit.Assert.assertNotNull(strTokenizer5);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test0570() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0570");
        double double3 = org.apache.commons.lang3.math.NumberUtils.min((double) (byte) 1, (double) '\000', (double) (short) 101);
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 0.0d + "'", double3 == 0.0d);
    }

    @Test
    public void test0571() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0571");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        boolean boolean2 = fastDateFormat0.equals((java.lang.Object) (short) -1);
        java.lang.StringBuffer stringBuffer4 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.StringBuffer stringBuffer5 = fastDateFormat0.format((long) (short) 100, stringBuffer4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.Appendable.append(char)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0572() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0572");
        java.util.Locale locale1 = null;
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.FastDateFormat.getInstance("", locale1);
        java.text.ParsePosition parsePosition4 = null;
        java.lang.Object obj5 = fastDateFormat2.parseObject("open", parsePosition4);
        java.util.Date date6 = null;
        java.lang.StringBuffer stringBuffer7 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.StringBuffer stringBuffer8 = fastDateFormat2.format(date6, stringBuffer7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat2);
        org.junit.Assert.assertNotNull(obj5);
        org.junit.Assert.assertEquals(obj5.toString(), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj5), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj5), "Thu Jan 01 00:00:00 CET 1970");
    }

    @Test
    public void test0573() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0573");
        org.apache.commons.lang3.mutable.MutableInt mutableInt1 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        mutableInt1.increment();
    }

    @Test
    public void test0574() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0574");
        java.lang.String str2 = org.apache.commons.lang3.ObjectUtils.toString((java.lang.Object) "581cd446", ";ClT9Ss'St<Q");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "581cd446" + "'", str2, "581cd446");
    }

    @Test
    public void test0575() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0575");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.USER_LANGUAGE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "en" + "'", str0, "en");
    }

    @Test
    public void test0576() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0576");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.setYears(date0, (int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0577() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0577");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.builder.HashCodeBuilder hashCodeBuilder2 = new org.apache.commons.lang3.builder.HashCodeBuilder(100, (int) 'o');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: HashCodeBuilder requires an odd initial value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0578() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0578");
        org.apache.commons.lang3.text.translate.UnicodeEscaper unicodeEscaper2 = org.apache.commons.lang3.text.translate.UnicodeEscaper.between(4, 0);
        org.junit.Assert.assertNotNull(unicodeEscaper2);
    }

    @Test
    public void test0579() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0579");
        short[] shortArray2 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray2, (int) (byte) -1, 1, (int) (byte) 10);
        org.apache.commons.lang3.ArrayUtils.shuffle(shortArray2);
        int int10 = org.apache.commons.lang3.ArrayUtils.indexOf(shortArray2, (short) (byte) -1, 100);
        int int13 = org.apache.commons.lang3.ArrayUtils.lastIndexOf(shortArray2, (short) -1, 0);
        org.junit.Assert.assertNotNull(shortArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray2), "[100, 100]");
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + (-1) + "'", int13 == (-1));
    }

    @Test
    public void test0580() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0580");
        java.util.List<java.util.Locale> localeList0 = org.apache.commons.lang3.LocaleUtils.availableLocaleList();
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream1 = org.apache.commons.lang3.Streams.stream((java.util.Collection<java.util.Locale>) localeList0);
        java.util.stream.Stream<java.util.Locale> localeStream2 = org.apache.commons.lang3.stream.Streams.of((java.util.Collection<java.util.Locale>) localeList0);
        org.junit.Assert.assertNotNull(localeList0);
        org.junit.Assert.assertNotNull(localeFailableStream1);
        org.junit.Assert.assertNotNull(localeStream2);
    }

    @Test
    public void test0581() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0581");
        java.lang.CharSequence charSequence1 = null;
        boolean boolean2 = org.apache.commons.lang3.StringUtils.equalsIgnoreCase((java.lang.CharSequence) "mixed mode, sharing", charSequence1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0582() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0582");
        org.apache.commons.lang3.SerializationException serializationException0 = new org.apache.commons.lang3.SerializationException();
    }

    @Test
    public void test0583() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0583");
        java.util.Locale locale0 = null;
        java.util.Locale locale1 = null;
        java.util.List<java.util.Locale> localeList2 = org.apache.commons.lang3.LocaleUtils.localeLookupList(locale0, locale1);
        // The following exception was thrown during execution in test generation
        try {
            int int4 = org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode((java.lang.Object) locale0, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: object");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(localeList2);
    }

    @Test
    public void test0584() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0584");
        java.util.stream.IntStream intStream1 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream3 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle4 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle5 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str6 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle4, toStringStyle5);
        java.lang.StringBuffer stringBuffer7 = null;
        java.lang.Object obj8 = null;
        standardToStringStyle4.appendStart(stringBuffer7, obj8);
        java.lang.String str10 = standardToStringStyle4.getNullText();
        standardToStringStyle4.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder14 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream1, (java.lang.AutoCloseable) intStream3, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle4, true);
        long[] longArray17 = new long[] { 3 };
        long[] longArray18 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray17);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray17);
        long[] longArray21 = new long[] { '4' };
        long[] longArray27 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet30 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray27, (long) '\n', 100);
        boolean boolean31 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray27);
        long[] longArray33 = org.apache.commons.lang3.ArrayUtils.add(longArray27, (long) (short) 101);
        boolean boolean34 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray21, longArray33);
        long[] longArray36 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray33, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder37 = autoCloseableDiffBuilder14.append("java.awt.headless", longArray17, longArray36);
        char[] charArray41 = new char[] { ' ', '#' };
        char[] charArray43 = new char[] { ' ' };
        char[] charArray44 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray41, charArray43);
        org.apache.commons.lang3.ArrayUtils.swap(charArray41, (int) (short) 1, (int) (short) 101, 0);
        int[] intArray50 = new int[] { '\n' };
        java.util.BitSet bitSet53 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray50, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray50);
        boolean boolean56 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) (short) 101, (java.lang.Object) intArray50, true);
        int[] intArray58 = new int[] { '\n' };
        java.util.BitSet bitSet61 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray58, (int) (byte) -1, (int) (short) -1);
        java.lang.String str65 = org.apache.commons.lang3.StringUtils.join(intArray58, '\000', (int) '4', 1);
        int[] intArray67 = org.apache.commons.lang3.ArrayUtils.addFirst(intArray58, (int) (byte) 10);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder68 = autoCloseableDiffBuilder37.append(" ", intArray50, intArray67);
        int[] intArray70 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(intArray67, (int) '\000');
        org.junit.Assert.assertNotNull(intStream1);
        org.junit.Assert.assertNotNull(intStream3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
        org.junit.Assert.assertNotNull(longArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray17), "[3]");
        org.junit.Assert.assertNotNull(longArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray18), "[3]");
        org.junit.Assert.assertNotNull(longArray21);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray21), "[52]");
        org.junit.Assert.assertNotNull(longArray27);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray27), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet30);
        org.junit.Assert.assertEquals(bitSet30.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNotNull(longArray33);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray33), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(longArray36);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray36), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder37);
        org.junit.Assert.assertNotNull(charArray41);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray41), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray41), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray41), "[ , #]");
        org.junit.Assert.assertNotNull(charArray43);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray43), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray43), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray43), "[ ]");
        org.junit.Assert.assertNotNull(charArray44);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray44), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray44), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray44), "[#]");
        org.junit.Assert.assertNotNull(intArray50);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray50), "[10]");
        org.junit.Assert.assertNotNull(bitSet53);
        org.junit.Assert.assertEquals(bitSet53.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertNotNull(intArray58);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray58), "[10]");
        org.junit.Assert.assertNotNull(bitSet61);
        org.junit.Assert.assertEquals(bitSet61.toString(), "{}");
        org.junit.Assert.assertEquals("'" + str65 + "' != '" + "" + "'", str65, "");
        org.junit.Assert.assertNotNull(intArray67);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray67), "[10, 10]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder68);
        org.junit.Assert.assertNotNull(intArray70);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray70), "[10, 10]");
    }

    @Test
    public void test0585() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0585");
        java.lang.String[] strArray2 = org.apache.commons.lang3.StringUtils.split("Long", 'o');
        org.junit.Assert.assertNotNull(strArray2);
    }

    @Test
    public void test0586() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0586");
        java.util.stream.IntStream intStream1 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream3 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle4 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle5 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str6 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle4, toStringStyle5);
        java.lang.StringBuffer stringBuffer7 = null;
        java.lang.Object obj8 = null;
        standardToStringStyle4.appendStart(stringBuffer7, obj8);
        java.lang.String str10 = standardToStringStyle4.getNullText();
        standardToStringStyle4.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder14 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream1, (java.lang.AutoCloseable) intStream3, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle4, true);
        long[] longArray17 = new long[] { 3 };
        long[] longArray18 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray17);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray17);
        long[] longArray21 = new long[] { '4' };
        long[] longArray27 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet30 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray27, (long) '\n', 100);
        boolean boolean31 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray27);
        long[] longArray33 = org.apache.commons.lang3.ArrayUtils.add(longArray27, (long) (short) 101);
        boolean boolean34 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray21, longArray33);
        long[] longArray36 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray33, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder37 = autoCloseableDiffBuilder14.append("java.awt.headless", longArray17, longArray36);
        char[] charArray41 = new char[] { ' ', '#' };
        char[] charArray43 = new char[] { ' ' };
        char[] charArray44 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray41, charArray43);
        org.apache.commons.lang3.ArrayUtils.swap(charArray41, (int) (short) 1, (int) (short) 101, 0);
        int[] intArray50 = new int[] { '\n' };
        java.util.BitSet bitSet53 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray50, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray50);
        boolean boolean56 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) (short) 101, (java.lang.Object) intArray50, true);
        int[] intArray58 = new int[] { '\n' };
        java.util.BitSet bitSet61 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray58, (int) (byte) -1, (int) (short) -1);
        java.lang.String str65 = org.apache.commons.lang3.StringUtils.join(intArray58, '\000', (int) '4', 1);
        int[] intArray67 = org.apache.commons.lang3.ArrayUtils.addFirst(intArray58, (int) (byte) 10);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder68 = autoCloseableDiffBuilder37.append(" ", intArray50, intArray67);
        java.lang.String str70 = org.apache.commons.lang3.StringUtils.join(intArray67, 'a');
        org.junit.Assert.assertNotNull(intStream1);
        org.junit.Assert.assertNotNull(intStream3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
        org.junit.Assert.assertNotNull(longArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray17), "[3]");
        org.junit.Assert.assertNotNull(longArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray18), "[3]");
        org.junit.Assert.assertNotNull(longArray21);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray21), "[52]");
        org.junit.Assert.assertNotNull(longArray27);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray27), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet30);
        org.junit.Assert.assertEquals(bitSet30.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNotNull(longArray33);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray33), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(longArray36);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray36), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder37);
        org.junit.Assert.assertNotNull(charArray41);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray41), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray41), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray41), "[ , #]");
        org.junit.Assert.assertNotNull(charArray43);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray43), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray43), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray43), "[ ]");
        org.junit.Assert.assertNotNull(charArray44);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray44), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray44), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray44), "[#]");
        org.junit.Assert.assertNotNull(intArray50);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray50), "[10]");
        org.junit.Assert.assertNotNull(bitSet53);
        org.junit.Assert.assertEquals(bitSet53.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + false + "'", boolean56 == false);
        org.junit.Assert.assertNotNull(intArray58);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray58), "[10]");
        org.junit.Assert.assertNotNull(bitSet61);
        org.junit.Assert.assertEquals(bitSet61.toString(), "{}");
        org.junit.Assert.assertEquals("'" + str65 + "' != '" + "" + "'", str65, "");
        org.junit.Assert.assertNotNull(intArray67);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray67), "[10, 10]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder68);
        org.junit.Assert.assertEquals("'" + str70 + "' != '" + "10a10" + "'", str70, "10a10");
    }

    @Test
    public void test0587() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0587");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.substringAfter("UTF-16BE", "long");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test0588() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0588");
        java.lang.reflect.Field field0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.reflect.FieldUtils.removeFinalModifier(field0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: field");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0589() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0589");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.exclusiveBetween((double) (short) 0, (double) 0.0f, 0.0d, "user.name");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: user.name");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0590() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0590");
        java.lang.String[] strArray0 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray2 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray0, (java.lang.CharSequence) "Integer");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.firstNonBlank(strArray0);
        org.apache.commons.lang3.ArrayUtils.swap((java.lang.Object[]) strArray0, (int) ' ', (int) (short) 101, (int) ' ');
        org.junit.Assert.assertNotNull(strArray0);
        org.junit.Assert.assertNotNull(charSequenceArray2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Integer" + "'", str3, "Integer");
    }

    @Test
    public void test0591() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0591");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaVmSpecificationVendor();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Oracle Corporation" + "'", str0, "Oracle Corporation");
    }

    @Test
    public void test0592() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0592");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.FILE_SEPARATOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "file.separator" + "'", str0, "file.separator");
    }

    @Test
    public void test0593() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0593");
        float[] floatArray3 = new float[] { 100.0f, 0.0f, 100L };
        org.apache.commons.lang3.ArrayUtils.shift(floatArray3, (int) (short) 100);
        float[] floatArray6 = org.apache.commons.lang3.ArraySorter.sort(floatArray3);
        org.apache.commons.lang3.ArrayUtils.shift(floatArray6, 17);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[100.0, 100.0, 0.0]");
        org.junit.Assert.assertNotNull(floatArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray6), "[100.0, 100.0, 0.0]");
    }

    @Test
    public void test0594() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0594");
        double[] doubleArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double1 = org.apache.commons.lang3.math.NumberUtils.min(doubleArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: array");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0595() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0595");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer0 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService1 = multiBackgroundInitializer0.getExternalExecutor();
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer3 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService4 = multiBackgroundInitializer3.getExternalExecutor();
        multiBackgroundInitializer0.addInitializer("60.0", (org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>) multiBackgroundInitializer3);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults multiBackgroundInitializerResults6 = multiBackgroundInitializer0.get();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: start() must be called first!");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(executorService1);
        org.junit.Assert.assertNull(executorService4);
    }

    @Test
    public void test0596() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0596");
        char char0 = org.apache.commons.lang3.CharUtils.CR;
        org.junit.Assert.assertTrue("'" + char0 + "' != '" + '\r' + "'", char0 == '\r');
    }

    @Test
    public void test0597() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0597");
        org.apache.commons.lang3.function.FailableObjIntConsumer<java.io.File, org.apache.commons.lang3.exception.ContextedRuntimeException> fileFailableObjIntConsumer0 = org.apache.commons.lang3.function.FailableObjIntConsumer.nop();
        org.junit.Assert.assertNotNull(fileFailableObjIntConsumer0);
    }

    @Test
    public void test0598() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0598");
        org.apache.commons.lang3.exception.ContextedException contextedException0 = new org.apache.commons.lang3.exception.ContextedException();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle4 = null;
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder5 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle4);
        org.apache.commons.lang3.exception.ContextedException contextedException6 = contextedException0.setContextValue("yes", (java.lang.Object) 0);
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator7 = org.apache.commons.lang3.StringEscapeUtils.UNESCAPE_HTML4;
        boolean boolean8 = org.apache.commons.lang3.ObjectUtils.equals((java.lang.Object) contextedException0, (java.lang.Object) charSequenceTranslator7);
        java.util.function.Consumer<java.lang.Throwable> throwableConsumer9 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.exception.ExceptionUtils.forEach((java.lang.Throwable) contextedException0, throwableConsumer9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(contextedException6);
        org.junit.Assert.assertNotNull(charSequenceTranslator7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test0599() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0599");
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle0 = org.apache.commons.lang3.builder.ToStringStyle.NO_CLASS_NAME_STYLE;
        java.lang.StringBuffer stringBuffer1 = null;
        short[] shortArray5 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray5, (int) (byte) -1, 1, (int) (byte) 10);
        short[] shortArray13 = new short[] { (short) 1, (short) -1, (byte) 10 };
        boolean boolean14 = org.apache.commons.lang3.ArrayUtils.isSorted(shortArray13);
        boolean boolean15 = org.apache.commons.lang3.ArrayUtils.isSameLength(shortArray5, shortArray13);
        // The following exception was thrown during execution in test generation
        try {
            toStringStyle0.append(stringBuffer1, "hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!a16.0.1+9ahi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!h", shortArray13, (java.lang.Boolean) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(toStringStyle0);
        org.junit.Assert.assertNotNull(shortArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray5), "[100, 100]");
        org.junit.Assert.assertNotNull(shortArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray13), "[1, -1, 10]");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test0600() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0600");
        org.apache.commons.lang3.arch.Processor.Type type0 = org.apache.commons.lang3.arch.Processor.Type.X86;
        org.junit.Assert.assertTrue("'" + type0 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.X86 + "'", type0.equals(org.apache.commons.lang3.arch.Processor.Type.X86));
    }

    @Test
    public void test0601() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0601");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.ONE_FIFTH;
        org.junit.Assert.assertNotNull(fraction0);
    }

    @Test
    public void test0602() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0602");
        char char1 = org.apache.commons.lang3.CharUtils.toChar((java.lang.Character) ' ');
        org.junit.Assert.assertTrue("'" + char1 + "' != '" + ' ' + "'", char1 == ' ');
    }

    @Test
    public void test0603() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0603");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort1.setValue((java.lang.Number) (short) 100);
        org.apache.commons.lang3.mutable.MutableShort mutableShort5 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        short short6 = mutableShort5.incrementAndGet();
        org.apache.commons.lang3.mutable.MutableLong mutableLong8 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        mutableLong8.add((long) 0);
        mutableShort5.setValue((java.lang.Number) 0);
        org.apache.commons.lang3.mutable.MutableShort mutableShort12 = org.apache.commons.lang3.compare.ComparableUtils.min(mutableShort1, mutableShort5);
        org.apache.commons.lang3.mutable.MutableShort mutableShort14 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        double double15 = mutableShort14.doubleValue();
        mutableShort12.add((java.lang.Number) mutableShort14);
        org.junit.Assert.assertTrue("'" + short6 + "' != '" + (short) 101 + "'", short6 == (short) 101);
        org.junit.Assert.assertNotNull(mutableShort12);
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 100.0d + "'", double15 == 100.0d);
    }

    @Test
    public void test0604() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0604");
        org.apache.commons.lang3.reflect.FieldUtils fieldUtils0 = new org.apache.commons.lang3.reflect.FieldUtils();
    }

    @Test
    public void test0605() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0605");
        double[] doubleArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_DOUBLE_ARRAY;
        double[] doubleArray1 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(doubleArray0);
        java.util.BitSet bitSet5 = org.apache.commons.lang3.ArrayUtils.indexesOf(doubleArray1, (double) (short) -1, (int) (short) 99, (double) (byte) 1);
        org.apache.commons.lang3.ArrayUtils.reverse(doubleArray1);
        org.junit.Assert.assertNotNull(doubleArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray0), "[]");
        org.junit.Assert.assertNotNull(doubleArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray1), "[]");
        org.junit.Assert.assertNotNull(bitSet5);
        org.junit.Assert.assertEquals(bitSet5.toString(), "{}");
    }

    @Test
    public void test0606() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0606");
        java.lang.reflect.Method[] methodArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_METHOD_ARRAY;
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) methodArray0, 'a');
        org.junit.Assert.assertNotNull(methodArray0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test0607() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0607");
        char[] charArray3 = new char[] { ' ', '#' };
        char[] charArray5 = new char[] { ' ' };
        char[] charArray6 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray3, charArray5);
        char[] charArray9 = org.apache.commons.lang3.ArrayUtils.add(charArray5, (int) (short) 0, ' ');
        char[] charArray14 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray17 = org.apache.commons.lang3.ArrayUtils.subarray(charArray14, (int) (short) 1, (-1));
        char[] charArray18 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray5, charArray14);
        char[] charArray21 = new char[] { ' ', '#' };
        char[] charArray23 = new char[] { ' ' };
        char[] charArray24 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray21, charArray23);
        char[] charArray27 = org.apache.commons.lang3.ArrayUtils.add(charArray23, (int) (short) 0, ' ');
        char[] charArray32 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray35 = org.apache.commons.lang3.ArrayUtils.subarray(charArray32, (int) (short) 1, (-1));
        char[] charArray36 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray23, charArray32);
        char[] charArray37 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray14, charArray36);
        char[] charArray40 = new char[] { ' ', '#' };
        char[] charArray42 = new char[] { ' ' };
        char[] charArray43 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray40, charArray42);
        char[] charArray46 = org.apache.commons.lang3.ArrayUtils.add(charArray42, (int) (short) 0, ' ');
        char[] charArray51 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray54 = org.apache.commons.lang3.ArrayUtils.subarray(charArray51, (int) (short) 1, (-1));
        char[] charArray55 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray42, charArray51);
        char[] charArray58 = new char[] { ' ', '#' };
        char[] charArray60 = new char[] { ' ' };
        char[] charArray61 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray58, charArray60);
        char[] charArray64 = org.apache.commons.lang3.ArrayUtils.add(charArray60, (int) (short) 0, ' ');
        char[] charArray69 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray72 = org.apache.commons.lang3.ArrayUtils.subarray(charArray69, (int) (short) 1, (-1));
        char[] charArray73 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray60, charArray69);
        char[] charArray74 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray51, charArray73);
        char[] charArray75 = org.apache.commons.lang3.ArrayUtils.insert(3, charArray36, charArray73);
        char[] charArray76 = org.apache.commons.lang3.ArraySorter.sort(charArray36);
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray3), "[ , #]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[ ]");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray6), "[#]");
        org.junit.Assert.assertNotNull(charArray9);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray9), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray9), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray9), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray14);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray14), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray14), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray14), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray17), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray17), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray17), "[]");
        org.junit.Assert.assertNotNull(charArray18);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray18), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray18), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray18), "[]");
        org.junit.Assert.assertNotNull(charArray21);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray21), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray21), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray21), "[ , #]");
        org.junit.Assert.assertNotNull(charArray23);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray23), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray23), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray23), "[ ]");
        org.junit.Assert.assertNotNull(charArray24);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray24), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray24), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray24), "[#]");
        org.junit.Assert.assertNotNull(charArray27);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray27), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray27), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray27), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray32);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray32), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray32), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray32), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray35);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray35), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray35), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray35), "[]");
        org.junit.Assert.assertNotNull(charArray36);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray36), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray36), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray36), "[]");
        org.junit.Assert.assertNotNull(charArray37);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray37), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray37), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray37), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray40);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray40), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray40), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray40), "[ , #]");
        org.junit.Assert.assertNotNull(charArray42);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray42), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray42), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray42), "[ ]");
        org.junit.Assert.assertNotNull(charArray43);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray43), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray43), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray43), "[#]");
        org.junit.Assert.assertNotNull(charArray46);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray46), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray46), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray46), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray51);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray51), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray51), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray51), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray54);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray54), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray54), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray54), "[]");
        org.junit.Assert.assertNotNull(charArray55);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray55), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray55), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray55), "[]");
        org.junit.Assert.assertNotNull(charArray58);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray58), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray58), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray58), "[ , #]");
        org.junit.Assert.assertNotNull(charArray60);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray60), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray60), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray60), "[ ]");
        org.junit.Assert.assertNotNull(charArray61);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray61), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray61), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray61), "[#]");
        org.junit.Assert.assertNotNull(charArray64);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray64), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray64), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray64), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray69);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray69), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray69), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray69), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray72);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray72), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray72), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray72), "[]");
        org.junit.Assert.assertNotNull(charArray73);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray73), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray73), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray73), "[]");
        org.junit.Assert.assertNotNull(charArray74);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray74), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray74), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray74), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray75);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray75), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray75), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray75), "[]");
        org.junit.Assert.assertNotNull(charArray76);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray76), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray76), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray76), "[]");
    }

    @Test
    public void test0608() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0608");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.addMilliseconds(date0, (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0609() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0609");
        org.apache.commons.lang3.tuple.ImmutableTriple<org.apache.commons.lang3.function.FailableIntUnaryOperator, java.util.List<java.util.Locale>, org.apache.commons.lang3.function.FailableFunction> failableIntUnaryOperatorImmutableTriple0 = org.apache.commons.lang3.tuple.ImmutableTriple.nullTriple();
        org.junit.Assert.assertNotNull(failableIntUnaryOperatorImmutableTriple0);
    }

    @Test
    public void test0610() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0610");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4("");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "" + "'", str1, "");
    }

    @Test
    public void test0611() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0611");
        org.apache.commons.lang3.BitField bitField1 = new org.apache.commons.lang3.BitField((int) (byte) 10);
        boolean boolean3 = bitField1.isSet(4);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test0612() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0612");
        org.apache.commons.lang3.CharSet charSet0 = org.apache.commons.lang3.CharSet.ASCII_ALPHA;
        boolean boolean2 = charSet0.contains('\000');
        org.junit.Assert.assertNotNull(charSet0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0613() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0613");
        java.lang.String[] strArray2 = org.apache.commons.lang3.StringUtils.split("UTF-16", '4');
        org.junit.Assert.assertNotNull(strArray2);
    }

    @Test
    public void test0614() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0614");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_SPECIFICATION_VENDOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Oracle Corporation" + "'", str0, "Oracle Corporation");
    }

    @Test
    public void test0615() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0615");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.ONE_QUARTER;
        org.apache.commons.lang3.math.Fraction fraction1 = org.apache.commons.lang3.math.Fraction.ONE_QUARTER;
        java.util.function.Predicate<org.apache.commons.lang3.math.Fraction> fractionPredicate2 = org.apache.commons.lang3.compare.ComparableUtils.lt(fraction1);
        java.util.Comparator<org.apache.commons.lang3.math.Fraction> fractionComparator3 = null;
        org.apache.commons.lang3.NumberRange<org.apache.commons.lang3.math.Fraction> fractionNumberRange4 = new org.apache.commons.lang3.NumberRange<org.apache.commons.lang3.math.Fraction>(fraction0, fraction1, fractionComparator3);
        org.junit.Assert.assertNotNull(fraction0);
        org.junit.Assert.assertNotNull(fraction1);
        org.junit.Assert.assertNotNull(fractionPredicate2);
    }

    @Test
    public void test0616() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0616");
        org.apache.commons.lang3.BitField bitField1 = new org.apache.commons.lang3.BitField((int) (byte) 10);
        byte byte3 = bitField1.clearByte((byte) -1);
        boolean boolean5 = bitField1.isAllSet(17);
        int int7 = bitField1.getValue((int) (byte) 100);
        org.junit.Assert.assertTrue("'" + byte3 + "' != '" + (byte) -11 + "'", byte3 == (byte) -11);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 0 + "'", int7 == 0);
    }

    @Test
    public void test0617() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0617");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.substringBefore("org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on", "https://adoptopenjdk.net/");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on" + "'", str2, "org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on");
    }

    @Test
    public void test0618() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0618");
        double double3 = org.apache.commons.lang3.math.IEEE754rUtils.min(100.0d, (double) 1, (double) 1.0f);
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 1.0d + "'", double3 == 1.0d);
    }

    @Test
    public void test0619() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0619");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.USER_COUNTRY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "SE" + "'", str0, "SE");
    }

    @Test
    public void test0620() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0620");
        java.lang.String str4 = org.apache.commons.lang3.BooleanUtils.toString((java.lang.Boolean) true, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false", "\\u0024", "java.vm.vendor");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str4, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
    }

    @Test
    public void test0621() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0621");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer10 = new org.apache.commons.lang3.text.StrTokenizer(charArray4, 'a');
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray2), "[ , #]");
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[ ]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[#]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ ,  ]");
    }

    @Test
    public void test0622() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0622");
        short[] shortArray2 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray2, (int) (byte) -1, 1, (int) (byte) 10);
        short[] shortArray7 = org.apache.commons.lang3.ArraySorter.sort(shortArray2);
        java.lang.String str11 = org.apache.commons.lang3.StringUtils.join(shortArray7, '$', (int) (short) 0, (int) (byte) -1);
        org.apache.commons.lang3.ArrayUtils.swap(shortArray7, (int) (short) 100, (int) ' ');
        org.junit.Assert.assertNotNull(shortArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray2), "[100, 100]");
        org.junit.Assert.assertNotNull(shortArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray7), "[100, 100]");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "" + "'", str11, "");
    }

    @Test
    public void test0623() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0623");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setSizeStartText("\000\000");
        java.lang.StringBuffer stringBuffer3 = null;
        boolean[] booleanArray10 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray12 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray10, false);
        boolean boolean13 = org.apache.commons.lang3.ArrayUtils.isNotEmpty(booleanArray10);
        // The following exception was thrown during execution in test generation
        try {
            standardToStringStyle0.append(stringBuffer3, "10a10", booleanArray10, (java.lang.Boolean) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray10), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray12), "[true, true]");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test0624() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0624");
        org.apache.commons.lang3.text.translate.UnicodeEscaper unicodeEscaper1 = org.apache.commons.lang3.text.translate.UnicodeEscaper.below((int) (byte) 10);
        org.junit.Assert.assertNotNull(unicodeEscaper1);
    }

    @Test
    public void test0625() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0625");
        java.util.function.Function<org.apache.commons.lang3.function.FailablePredicate, org.apache.commons.lang3.CharUtils> failablePredicateFunction0 = null;
        org.apache.commons.lang3.concurrent.Memoizer<org.apache.commons.lang3.function.FailablePredicate, org.apache.commons.lang3.CharUtils> failablePredicateMemoizer2 = new org.apache.commons.lang3.concurrent.Memoizer<org.apache.commons.lang3.function.FailablePredicate, org.apache.commons.lang3.CharUtils>(failablePredicateFunction0, false);
    }

    @Test
    public void test0626() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0626");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.lowerCase("Oracle Corporation");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "oracle corporation" + "'", str1, "oracle corporation");
    }

    @Test
    public void test0627() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0627");
        java.util.concurrent.TimeUnit timeUnit2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.EventCountCircuitBreaker eventCountCircuitBreaker3 = new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker((int) (short) 0, (long) 2, timeUnit2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.TimeUnit.toNanos(long)\" because \"openingUnit\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0628() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0628");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setSizeStartText("\000\000");
        standardToStringStyle0.setArraySeparator("OpenJDK 64-Bit Server VM");
    }

    @Test
    public void test0629() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0629");
        org.apache.commons.lang3.mutable.MutableLong mutableLong0 = null;
        org.apache.commons.lang3.mutable.MutableLong mutableLong2 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        org.apache.commons.lang3.mutable.MutableLong mutableLong3 = org.apache.commons.lang3.compare.ComparableUtils.min(mutableLong0, mutableLong2);
        java.util.function.Supplier<org.apache.commons.lang3.text.StrMatcher> strMatcherSupplier4 = org.apache.commons.lang3.function.Suppliers.nul();
        org.apache.commons.lang3.text.StrMatcher strMatcher5 = org.apache.commons.lang3.function.Suppliers.get(strMatcherSupplier4);
        boolean boolean6 = mutableLong2.equals((java.lang.Object) strMatcher5);
        org.junit.Assert.assertNotNull(mutableLong3);
        org.junit.Assert.assertNotNull(strMatcherSupplier4);
        org.junit.Assert.assertNull(strMatcher5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test0630() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0630");
        int int3 = org.apache.commons.lang3.StringUtils.ordinalIndexOf((java.lang.CharSequence) "6f51daee", (java.lang.CharSequence) "OpenJDK Runtime Environment", (-5));
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test0631() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0631");
        double[] doubleArray5 = new double[] { 1.0d, 2147483647L, 100.0d, 10, 32.0f };
        double[] doubleArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(doubleArray5, 1.0d);
        double[] doubleArray12 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray16 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean18 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray16, (double) '4');
        boolean boolean19 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray12, doubleArray16);
        int int23 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray12, (-1.0d), (int) '\n', (double) 100);
        boolean boolean24 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray7, doubleArray12);
        org.apache.commons.lang3.ArrayUtils.shuffle(doubleArray7);
        double[] doubleArray27 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(doubleArray7, (double) 100.0f);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[1.0, 2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray7);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray7), "[100.0, 2.147483647E9, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray12), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray16), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(doubleArray27);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray27), "[2.147483647E9, 10.0, 32.0]");
    }

    @Test
    public void test0632() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0632");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT;
        java.util.Date date1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str2 = fastDateFormat0.format(date1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
    }

    @Test
    public void test0633() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0633");
        long long0 = org.apache.commons.lang3.time.DateUtils.MILLIS_PER_HOUR;
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + 3600000L + "'", long0 == 3600000L);
    }

    @Test
    public void test0634() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0634");
        java.lang.Class<java.util.BitSet> bitSetClass0 = null;
        org.apache.commons.lang3.Streams.ArrayCollector<java.util.BitSet> bitSetArrayCollector1 = new org.apache.commons.lang3.Streams.ArrayCollector<java.util.BitSet>(bitSetClass0);
        java.util.Set<java.util.stream.Collector.Characteristics> characteristicsSet2 = bitSetArrayCollector1.characteristics();
        java.util.function.Supplier<java.util.List<java.util.BitSet>> bitSetListSupplier3 = bitSetArrayCollector1.supplier();
        org.junit.Assert.assertNotNull(characteristicsSet2);
        org.junit.Assert.assertNotNull(bitSetListSupplier3);
    }

    @Test
    public void test0635() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0635");
        java.lang.Class<?>[] wildcardClassArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_CLASS_ARRAY;
        java.lang.reflect.Type[] typeArray1 = org.apache.commons.lang3.reflect.TypeUtils.normalizeUpperBounds((java.lang.reflect.Type[]) wildcardClassArray0);
        org.junit.Assert.assertNotNull(wildcardClassArray0);
        org.junit.Assert.assertNotNull(typeArray1);
    }

    @Test
    public void test0636() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0636");
        org.apache.commons.lang3.ClassUtils classUtils0 = new org.apache.commons.lang3.ClassUtils();
    }

    @Test
    public void test0637() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0637");
        org.apache.commons.lang3.function.FailableDoubleToIntFunction<java.lang.UnsupportedOperationException> unsupportedOperationExceptionFailableDoubleToIntFunction0 = org.apache.commons.lang3.function.FailableDoubleToIntFunction.nop();
        org.junit.Assert.assertNotNull(unsupportedOperationExceptionFailableDoubleToIntFunction0);
    }

    @Test
    public void test0638() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0638");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_LION;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0639() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0639");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean1 = new org.apache.commons.lang3.mutable.MutableBoolean((java.lang.Boolean) true);
        boolean boolean3 = mutableBoolean1.equals((java.lang.Object) 0.0f);
        boolean boolean4 = mutableBoolean1.isFalse();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0640() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0640");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        java.lang.String str1 = fastDateFormat0.toString();
        java.lang.String[] strArray2 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray4 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray2, (java.lang.CharSequence) "Integer");
        boolean boolean5 = fastDateFormat0.equals((java.lang.Object) charSequenceArray4);
        boolean boolean6 = org.apache.commons.lang3.StringUtils.isAllEmpty(charSequenceArray4);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Map<java.lang.Object, java.lang.Object> objMap7 = org.apache.commons.lang3.ArrayUtils.toMap((java.lang.Object[]) charSequenceArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Array element 0, 'Integer', is neither of type Map.Entry nor an Array");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]" + "'", str1, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertNotNull(charSequenceArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test0641() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0641");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.DateFormatUtils.ISO_TIME_FORMAT;
        java.util.TimeZone timeZone3 = fastDateFormat2.getTimeZone();
        java.util.Locale locale4 = null;
        java.util.Locale locale5 = org.apache.commons.lang3.LocaleUtils.toLocale(locale4);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str6 = org.apache.commons.lang3.time.DateFormatUtils.format((long) 10, "UTF-16", timeZone3, locale4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: U");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat2);
        org.junit.Assert.assertNotNull(timeZone3);
        org.junit.Assert.assertEquals(timeZone3.getDisplayName(), "Central European Standard Time");
        org.junit.Assert.assertNotNull(locale5);
        org.junit.Assert.assertEquals(locale5.toString(), "en_SE");
    }

    @Test
    public void test0642() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0642");
        java.lang.String str1 = org.apache.commons.lang3.text.translate.CharSequenceTranslator.hex((int) (short) 101);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "65" + "'", str1, "65");
    }

    @Test
    public void test0643() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0643");
        org.apache.commons.lang3.function.FailableToDoubleBiFunction failableToDoubleBiFunction0 = org.apache.commons.lang3.function.FailableToDoubleBiFunction.NOP;
        org.junit.Assert.assertNotNull(failableToDoubleBiFunction0);
    }

    @Test
    public void test0644() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0644");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_VENDOR_URL;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.vendor.url" + "'", str0, "java.vendor.url");
    }

    @Test
    public void test0645() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0645");
        org.apache.commons.lang3.function.FailableLongUnaryOperator<java.lang.RuntimeException> runtimeExceptionFailableLongUnaryOperator0 = org.apache.commons.lang3.function.FailableLongUnaryOperator.identity();
        org.junit.Assert.assertNotNull(runtimeExceptionFailableLongUnaryOperator0);
    }

    @Test
    public void test0646() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0646");
        java.lang.Float[] floatArray6 = new java.lang.Float[] { 32.0f, 10.0f, 1.0f, (-1.0f), 35.0f, 2.3398232E38f };
        float[] floatArray7 = org.apache.commons.lang3.ArrayUtils.toPrimitive(floatArray6);
        org.apache.commons.lang3.function.FailableIntFunction failableIntFunction8 = org.apache.commons.lang3.function.FailableIntFunction.NOP;
        int int9 = org.apache.commons.lang3.ArrayUtils.indexOf((java.lang.Object[]) floatArray6, (java.lang.Object) failableIntFunction8);
        org.junit.Assert.assertNotNull(floatArray6);
        org.junit.Assert.assertNotNull(floatArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray7), "[32.0, 10.0, 1.0, -1.0, 35.0, 2.3398232E38]");
        org.junit.Assert.assertNotNull(failableIntFunction8);
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
    }

    @Test
    public void test0647() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0647");
        double double3 = org.apache.commons.lang3.math.NumberUtils.max((double) 60000L, (double) 35.0f, (double) ' ');
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 60000.0d + "'", double3 == 60000.0d);
    }

    @Test
    public void test0648() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0648");
        byte[] byteArray3 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray4 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray3);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.EMPTY_BYTE_ARRAY;
        byte[] byteArray6 = org.apache.commons.lang3.ArrayUtils.insert((int) (short) 10, byteArray3, byteArray5);
        int int9 = org.apache.commons.lang3.ArrayUtils.indexOf(byteArray3, (byte) 0, 3);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray4), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[]");
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray6), "[0, -1]");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
    }

    @Test
    public void test0649() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0649");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.SMTP_DATETIME_FORMAT;
        java.lang.String str1 = fastDateFormat0.getPattern();
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "EEE, dd MMM yyyy HH:mm:ss Z" + "'", str1, "EEE, dd MMM yyyy HH:mm:ss Z");
    }

    @Test
    public void test0650() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0650");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaAwtGraphicsenv();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0651() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0651");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = org.apache.commons.lang3.StringUtils.abbreviate("org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on", "java.vm.specification.name", 1, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Minimum abbreviation width is 27");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0652() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0652");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        boolean[] booleanArray9 = org.apache.commons.lang3.ArrayUtils.removeElement(booleanArray5, true);
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.isNotEmpty(booleanArray9);
        org.apache.commons.lang3.ArrayUtils.reverse(booleanArray9);
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(booleanArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray9), "[false, true, false, false]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test0653() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0653");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getUserTimezone();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Europe/Stockholm" + "'", str0, "Europe/Stockholm");
    }

    @Test
    public void test0654() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0654");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort("AdoptOpenJDK");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"AdoptOpenJDK\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0655() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0655");
        long[] longArray0 = null;
        boolean boolean1 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0656() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0656");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.OS_ARCH;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "x86_64" + "'", str0, "x86_64");
    }

    @Test
    public void test0657() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0657");
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces0 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces1 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces2 = org.apache.commons.lang3.compare.ComparableUtils.min(interfaces0, interfaces1);
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces3 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces4 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces5 = org.apache.commons.lang3.compare.ComparableUtils.min(interfaces3, interfaces4);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.ClassUtils.Interfaces> interfacesRange6 = org.apache.commons.lang3.Range.of(interfaces2, interfaces4);
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces7 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Range<org.apache.commons.lang3.ClassUtils.Interfaces> interfacesRange8 = org.apache.commons.lang3.Range.between(interfaces4, interfaces7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: element2");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + interfaces0 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces0.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces1 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces1.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces2 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces2.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces3 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces3.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces4 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces4.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces5 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces5.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertNotNull(interfacesRange6);
    }

    @Test
    public void test0658() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0658");
        char[] charArray5 = null;
        java.util.Random random6 = null;
        java.lang.String str7 = org.apache.commons.lang3.RandomStringUtils.random(0, 99, (int) (byte) 10, true, true, charArray5, random6);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "" + "'", str7, "");
    }

    @Test
    public void test0659() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0659");
        org.apache.commons.lang3.function.FailableObjIntConsumer<java.net.URL[], org.apache.commons.lang3.SerializationException> uRLArrayFailableObjIntConsumer0 = org.apache.commons.lang3.function.FailableObjIntConsumer.nop();
        org.junit.Assert.assertNotNull(uRLArrayFailableObjIntConsumer0);
    }

    @Test
    public void test0660() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0660");
        org.apache.commons.lang3.function.FailableToLongBiFunction<int[], java.lang.UnsupportedOperationException[], org.apache.commons.lang3.exception.ContextedException> intArrayFailableToLongBiFunction0 = org.apache.commons.lang3.function.FailableToLongBiFunction.nop();
        org.junit.Assert.assertNotNull(intArrayFailableToLongBiFunction0);
    }

    @Test
    public void test0661() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0661");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.math.Fraction fraction2 = org.apache.commons.lang3.math.Fraction.getFraction((int) (short) 10, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArithmeticException; message: The denominator must not be zero");
        } catch (java.lang.ArithmeticException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0662() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0662");
        java.net.URL[] uRLArray0 = org.apache.commons.lang3.ClassLoaderUtils.getSystemURLs();
        org.junit.Assert.assertNotNull(uRLArray0);
    }

    @Test
    public void test0663() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0663");
        org.apache.commons.lang3.function.FailableDoubleConsumer<org.apache.commons.lang3.concurrent.CircuitBreakingException> circuitBreakingExceptionFailableDoubleConsumer0 = org.apache.commons.lang3.function.FailableDoubleConsumer.nop();
        org.junit.Assert.assertNotNull(circuitBreakingExceptionFailableDoubleConsumer0);
    }

    @Test
    public void test0664() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0664");
        java.util.Date date0 = null;
        java.util.TimeZone timeZone3 = org.apache.commons.lang3.time.FastTimeZone.getTimeZone("yes");
        java.util.Locale locale4 = null;
        java.util.Locale locale5 = org.apache.commons.lang3.LocaleUtils.toLocale(locale4);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str6 = org.apache.commons.lang3.time.DateFormatUtils.format(date0, "10a10", timeZone3, locale5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(timeZone3);
        org.junit.Assert.assertEquals(timeZone3.getDisplayName(), "Greenwich Mean Time");
        org.junit.Assert.assertNotNull(locale5);
        org.junit.Assert.assertEquals(locale5.toString(), "en_SE");
    }

    @Test
    public void test0665() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0665");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.center("\000\000", (int) (byte) 1, ":");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "\000\000" + "'", str3, "\000\000");
    }

    @Test
    public void test0666() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0666");
        java.util.Comparator<java.lang.Class<?>> wildcardClassComparator0 = org.apache.commons.lang3.ClassUtils.comparator();
        org.junit.Assert.assertNotNull(wildcardClassComparator0);
    }

    @Test
    public void test0667() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0667");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaVendor();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "AdoptOpenJDK" + "'", str0, "AdoptOpenJDK");
    }

    @Test
    public void test0668() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0668");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.inclusiveBetween((long) (-5), (long) 8, (long) 'o');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The value 111 is not in the specified inclusive range of -5 to 8");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0669() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0669");
        org.apache.commons.lang3.mutable.MutableByte mutableByte0 = new org.apache.commons.lang3.mutable.MutableByte();
        org.apache.commons.lang3.mutable.MutableByte mutableByte1 = new org.apache.commons.lang3.mutable.MutableByte();
        int int2 = mutableByte0.compareTo(mutableByte1);
        java.lang.Object obj3 = null;
        boolean boolean4 = mutableByte1.equals(obj3);
        java.lang.String str5 = mutableByte1.toString();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "0" + "'", str5, "0");
    }

    @Test
    public void test0670() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0670");
        long[] longArray1 = new long[] { '4' };
        long[] longArray7 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet10 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray7, (long) '\n', 100);
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray7);
        long[] longArray13 = org.apache.commons.lang3.ArrayUtils.add(longArray7, (long) (short) 101);
        boolean boolean14 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray1, longArray13);
        long[] longArray16 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray13, 60000L);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str20 = org.apache.commons.lang3.StringUtils.join(longArray13, 'a', (int) (byte) -1, (int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Index -1 out of bounds for length 6");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray1), "[52]");
        org.junit.Assert.assertNotNull(longArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray7), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet10);
        org.junit.Assert.assertEquals(bitSet10.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(longArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray13), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNotNull(longArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray16), "[60000, 10, 100, 100, 97, 52, 101]");
    }

    @Test
    public void test0671() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0671");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_TIME_FORMAT;
        java.util.TimeZone timeZone1 = fastDateFormat0.getTimeZone();
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date3 = fastDateFormat0.parse("user.name");
            org.junit.Assert.fail("Expected exception of type java.text.ParseException; message: Unparseable date: user.name");
        } catch (java.text.ParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertNotNull(timeZone1);
        org.junit.Assert.assertEquals(timeZone1.getDisplayName(), "Central European Standard Time");
    }

    @Test
    public void test0672() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0672");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_ENDORSED_DIRS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.endorsed.dirs" + "'", str0, "java.endorsed.dirs");
    }

    @Test
    public void test0673() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0673");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer0 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults multiBackgroundInitializerResults1 = multiBackgroundInitializer0.get();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: start() must be called first!");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0674() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0674");
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate0 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate1 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate2 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate3 = uncheckedExecutionExceptionFailableDoublePredicate2.negate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate4 = uncheckedExecutionExceptionFailableDoublePredicate1.or(uncheckedExecutionExceptionFailableDoublePredicate2);
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate5 = uncheckedExecutionExceptionFailableDoublePredicate0.and(uncheckedExecutionExceptionFailableDoublePredicate1);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate0);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate1);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate2);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate3);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate4);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate5);
    }

    @Test
    public void test0675() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0675");
        java.lang.Boolean boolean4 = org.apache.commons.lang3.BooleanUtils.toBooleanObject((int) (short) -1, (-1), (-27), (int) (short) 101);
        org.junit.Assert.assertEquals("'" + boolean4 + "' != '" + true + "'", boolean4, true);
    }

    @Test
    public void test0676() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0676");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.lang.Integer[] intArray9 = org.apache.commons.lang3.ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
        java.lang.Class[] classArray11 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray12 = (java.lang.Class<?>[]) classArray11;
        java.lang.Class<?> wildcardClass13 = null;
        java.lang.Class[] classArray15 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray16 = (java.lang.Class<?>[]) classArray15;
        wildcardClassArray16[0] = wildcardClass13;
        boolean boolean19 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray11, wildcardClassArray16);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj20 = org.apache.commons.lang3.reflect.MethodUtils.invokeExactMethod((java.lang.Object) booleanArray5, "pen", (java.lang.Object[]) intArray9, wildcardClassArray16);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: pen() on object: [Z");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertNotNull(classArray11);
        org.junit.Assert.assertNotNull(wildcardClassArray12);
        org.junit.Assert.assertNotNull(classArray15);
        org.junit.Assert.assertNotNull(wildcardClassArray16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test0677() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0677");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer9 = org.apache.commons.lang3.text.StrTokenizer.getTSVInstance(charArray8);
        org.apache.commons.lang3.text.StrTokenizer strTokenizer11 = strTokenizer9.reset("line.separator");
        int int12 = strTokenizer9.nextIndex();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer14 = strTokenizer9.reset("os.nam");
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray2), "[ , #]");
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[ ]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[#]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ ,  ]");
        org.junit.Assert.assertNotNull(strTokenizer9);
        org.junit.Assert.assertNotNull(strTokenizer11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertNotNull(strTokenizer14);
    }

    @Test
    public void test0678() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0678");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.time.FastDateFormat fastDateFormat1 = org.apache.commons.lang3.time.FastDateFormat.getInstance("/Users/glacierali");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: U");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0679() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0679");
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException7 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException3);
        org.apache.commons.lang3.SerializationException serializationException8 = new org.apache.commons.lang3.SerializationException((java.lang.Throwable) notImplementedException7);
        org.apache.commons.lang3.SerializationException serializationException9 = new org.apache.commons.lang3.SerializationException((java.lang.Throwable) notImplementedException7);
        org.junit.Assert.assertNotNull(throwableArray4);
    }

    @Test
    public void test0680() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0680");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        float[] floatArray12 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(floatArray10);
        float[] floatArray14 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(floatArray10, 101.0f);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(floatArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray12), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray14);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray14), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
    }

    @Test
    public void test0681() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0681");
        java.util.function.Supplier[] supplierArray1 = new java.util.function.Supplier[0];
        @SuppressWarnings("unchecked")
        java.util.function.Supplier<double[]>[] doubleArraySupplierArray2 = (java.util.function.Supplier<double[]>[]) supplierArray1;
        double[] doubleArray3 = org.apache.commons.lang3.ObjectUtils.getFirstNonNull((java.util.function.Supplier<double[]>[]) supplierArray1);
        org.junit.Assert.assertNotNull(supplierArray1);
        org.junit.Assert.assertNotNull(doubleArraySupplierArray2);
        org.junit.Assert.assertNull(doubleArray3);
    }

    @Test
    public void test0682() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0682");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.setMonths(date0, (int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0683() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0683");
        byte[] byteArray3 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray4 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray3);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.EMPTY_BYTE_ARRAY;
        byte[] byteArray6 = org.apache.commons.lang3.ArrayUtils.insert((int) (short) 10, byteArray3, byteArray5);
        // The following exception was thrown during execution in test generation
        try {
            long long11 = org.apache.commons.lang3.Conversion.byteArrayToLong(byteArray3, (int) (byte) -1, (long) (byte) -11, (int) (short) 0, 4);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Index -1 out of bounds for length 2");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray4), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[]");
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray6), "[0, -1]");
    }

    @Test
    public void test0684() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0684");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.stream.BaseStream<java.lang.Integer, java.util.stream.IntStream> intBaseStream1 = org.apache.commons.lang3.SerializationUtils.deserialize(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: inputStream");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0685() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0685");
        double[] doubleArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_DOUBLE_ARRAY;
        java.util.Random random1 = null;
        org.apache.commons.lang3.ArrayUtils.shuffle(doubleArray0, random1);
        org.junit.Assert.assertNotNull(doubleArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray0), "[]");
    }

    @Test
    public void test0686() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0686");
        int int2 = org.apache.commons.lang3.BooleanUtils.compare(true, true);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test0687() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0687");
        org.apache.commons.lang3.function.FailableSupplier failableSupplier0 = org.apache.commons.lang3.function.FailableSupplier.NUL;
        org.junit.Assert.assertNotNull(failableSupplier0);
    }

    @Test
    public void test0688() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0688");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.remove("oracle corporation", "Mac OS X");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "oracle corporation" + "'", str2, "oracle corporation");
    }

    @Test
    public void test0689() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0689");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_YOSEMITE;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0690() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0690");
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces0 = org.apache.commons.lang3.ClassUtils.Interfaces.INCLUDE;
        org.junit.Assert.assertTrue("'" + interfaces0 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.INCLUDE + "'", interfaces0.equals(org.apache.commons.lang3.ClassUtils.Interfaces.INCLUDE));
    }

    @Test
    public void test0691() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0691");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.ONE;
        org.junit.Assert.assertNotNull(fraction0);
    }

    @Test
    public void test0692() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0692");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.lowerCase("java.library.path");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "java.library.path" + "'", str1, "java.library.path");
    }

    @Test
    public void test0693() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0693");
        boolean boolean1 = org.apache.commons.lang3.CharUtils.isAsciiAlpha(' ');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0694() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0694");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.escapeXml("utf-16");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "utf-16" + "'", str1, "utf-16");
    }

    @Test
    public void test0695() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0695");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        java.util.stream.IntStream intStream10 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream12 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle13 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle14 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str15 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle13, toStringStyle14);
        java.lang.StringBuffer stringBuffer16 = null;
        java.lang.Object obj17 = null;
        standardToStringStyle13.appendStart(stringBuffer16, obj17);
        java.lang.String str19 = standardToStringStyle13.getNullText();
        standardToStringStyle13.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder23 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream10, (java.lang.AutoCloseable) intStream12, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle13, true);
        boolean boolean24 = org.apache.commons.lang3.ArrayUtils.isSameType((java.lang.Object) ' ', (java.lang.Object) intStream10);
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray2), "[ , #]");
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[ ]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[#]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ ,  ]");
        org.junit.Assert.assertNotNull(intStream10);
        org.junit.Assert.assertNotNull(intStream12);
        org.junit.Assert.assertNotNull(toStringStyle14);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str15, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "<null>" + "'", str19, "<null>");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test0696() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0696");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaUtilPrefsPreferencesFactory();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0697() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0697");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.substringAfter("java.vm.vendor", "/Users/glacierali/randoop-4.3.2");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test0698() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0698");
        org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper1 = org.apache.commons.lang3.text.translate.NumericEntityEscaper.above((int) (short) 0);
        org.junit.Assert.assertNotNull(numericEntityEscaper1);
    }

    @Test
    public void test0699() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0699");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        java.lang.Object obj4 = null;
        standardToStringStyle0.appendStart(stringBuffer3, obj4);
        java.lang.String str6 = standardToStringStyle0.getNullText();
        boolean boolean7 = standardToStringStyle0.isUseClassName();
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "<null>" + "'", str6, "<null>");
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
    }

    @Test
    public void test0700() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0700");
        java.lang.Thread thread2 = org.apache.commons.lang3.ThreadUtils.findThreadById((long) 'o', "false\000true\000false\000true\000false");
        org.junit.Assert.assertNull(thread2);
    }

    @Test
    public void test0701() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0701");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.mid("java.specification.name", 1, (int) (byte) 10);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "ava.specif" + "'", str3, "ava.specif");
    }

    @Test
    public void test0702() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0702");
        long[] longArray5 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray5, (long) '\n', 100);
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray5);
        long[] longArray11 = org.apache.commons.lang3.ArrayUtils.add(longArray5, (long) (short) 101);
        long[] longArray18 = new long[] { (short) 10, 1L, 'a', 100L, ' ', 100 };
        long[] longArray20 = org.apache.commons.lang3.ArrayUtils.remove(longArray18, 3);
        boolean boolean21 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray5, longArray18);
        java.lang.Long[] longArray29 = new java.lang.Long[] { 10L, 0L, (-1L), (-1L), 10L, 1L };
        java.lang.Long[] longArray30 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray29);
        java.net.URL[] uRLArray31 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        boolean boolean32 = org.apache.commons.lang3.ArrayUtils.isSameLength((java.lang.Object[]) longArray29, (java.lang.Object[]) uRLArray31);
        java.lang.constant.ConstantDesc[] constantDescArray34 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences((java.lang.constant.ConstantDesc[]) longArray29, (java.lang.constant.ConstantDesc) (-1.0d));
        java.lang.Class<?>[] wildcardClassArray35 = org.apache.commons.lang3.ArrayUtils.EMPTY_CLASS_ARRAY;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj36 = org.apache.commons.lang3.reflect.MethodUtils.invokeExactMethod((java.lang.Object) longArray18, "user.dir", (java.lang.Object[]) longArray29, wildcardClassArray35);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: user.dir() on object: [J");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray5), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(longArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray11), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(longArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray18), "[10, 1, 97, 100, 32, 100]");
        org.junit.Assert.assertNotNull(longArray20);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray20), "[10, 1, 97, 32, 100]");
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(longArray29);
        org.junit.Assert.assertNotNull(longArray30);
        org.junit.Assert.assertNotNull(uRLArray31);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(constantDescArray34);
        org.junit.Assert.assertNotNull(wildcardClassArray35);
    }

    @Test
    public void test0703() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0703");
        java.lang.Short[] shortArray5 = new java.lang.Short[] { (short) 100, (short) 1, (short) 1, (short) 10, (short) 1 };
        java.lang.Short[] shortArray6 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(shortArray5);
        short[] shortArray8 = org.apache.commons.lang3.ArrayUtils.toPrimitive(shortArray6, (short) 99);
        org.apache.commons.lang3.ArrayUtils.reverse(shortArray8);
        org.junit.Assert.assertNotNull(shortArray5);
        org.junit.Assert.assertNotNull(shortArray6);
        org.junit.Assert.assertNotNull(shortArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray8), "[1, 10, 1, 1, 100]");
    }

    @Test
    public void test0704() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0704");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.USER_LANGUAGE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "user.language" + "'", str0, "user.language");
    }

    @Test
    public void test0705() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0705");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.util.concurrent.Future<org.apache.commons.lang3.builder.StandardToStringStyle> standardToStringStyleFuture3 = org.apache.commons.lang3.concurrent.ConcurrentUtils.constantFuture(standardToStringStyle0);
        standardToStringStyle0.setFieldSeparatorAtStart(true);
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertNotNull(standardToStringStyleFuture3);
    }

    @Test
    public void test0706() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0706");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.repeat('\000', 1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "\000" + "'", str2, "\000");
    }

    @Test
    public void test0707() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0707");
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException1 = new org.apache.commons.lang3.exception.ContextedRuntimeException("mixed mode, sharing");
        java.lang.String str3 = contextedRuntimeException1.getFormattedExceptionMessage("mixed mode, sharing");
        java.lang.String str4 = contextedRuntimeException1.toString();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "mixed mode, sharing" + "'", str3, "mixed mode, sharing");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "org.apache.commons.lang3.exception.ContextedRuntimeException: mixed mode, sharing" + "'", str4, "org.apache.commons.lang3.exception.ContextedRuntimeException: mixed mode, sharing");
    }

    @Test
    public void test0708() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0708");
        int int3 = org.apache.commons.lang3.StringUtils.getLevenshteinDistance((java.lang.CharSequence) "org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on", (java.lang.CharSequence) "ava.specif", (int) (byte) 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test0709() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0709");
        char[] charArray3 = new char[] { ' ', '#' };
        char[] charArray5 = new char[] { ' ' };
        char[] charArray6 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray3, charArray5);
        char[] charArray9 = org.apache.commons.lang3.ArrayUtils.add(charArray5, (int) (short) 0, ' ');
        char[] charArray14 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray17 = org.apache.commons.lang3.ArrayUtils.subarray(charArray14, (int) (short) 1, (-1));
        char[] charArray18 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray5, charArray14);
        char[] charArray20 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(charArray5, '#');
        int int21 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) "65", charArray20);
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray3), "[ , #]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[ ]");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray6), "[#]");
        org.junit.Assert.assertNotNull(charArray9);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray9), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray9), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray9), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray14);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray14), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray14), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray14), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray17), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray17), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray17), "[]");
        org.junit.Assert.assertNotNull(charArray18);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray18), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray18), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray18), "[]");
        org.junit.Assert.assertNotNull(charArray20);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray20), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray20), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray20), "[ ]");
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + (-1) + "'", int21 == (-1));
    }

    @Test
    public void test0710() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0710");
        org.apache.commons.lang3.function.FailableDoubleToLongFunction<org.apache.commons.lang3.exception.ContextedRuntimeException> contextedRuntimeExceptionFailableDoubleToLongFunction0 = org.apache.commons.lang3.function.FailableDoubleToLongFunction.nop();
        org.junit.Assert.assertNotNull(contextedRuntimeExceptionFailableDoubleToLongFunction0);
    }

    @Test
    public void test0711() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0711");
        java.lang.reflect.Field[] fieldArray0 = null;
        java.lang.ThreadGroup threadGroup1 = org.apache.commons.lang3.ThreadUtils.getSystemThreadGroup();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.tuple.ImmutablePair<java.lang.reflect.Field[], java.lang.ThreadGroup> fieldArrayImmutablePair2 = org.apache.commons.lang3.tuple.ImmutablePair.ofNonNull(fieldArray0, threadGroup1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: left");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(threadGroup1);
        org.junit.Assert.assertEquals(threadGroup1.toString(), "java.lang.ThreadGroup[name=system,maxpri=10]");
    }

    @Test
    public void test0712() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0712");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore3 = new org.apache.commons.lang3.concurrent.TimedSemaphore((long) (short) 1, timeUnit1, (int) (byte) -1);
        int int4 = timedSemaphore3.getAcquireCount();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test0713() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0713");
        double[] doubleArray5 = new double[] { 0.0f, 'a', 1L, (-1.0f), ' ' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(doubleArray5, (double) 100, (double) (-1.0f));
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[0.0, 97.0, 1.0, -1.0, 32.0]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
    }

    @Test
    public void test0714() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0714");
        org.apache.commons.lang3.ClassUtils classUtils0 = new org.apache.commons.lang3.ClassUtils();
        org.apache.commons.lang3.ClassUtils classUtils1 = new org.apache.commons.lang3.ClassUtils();
        org.apache.commons.lang3.ClassUtils classUtils2 = new org.apache.commons.lang3.ClassUtils();
        org.apache.commons.lang3.ClassUtils classUtils3 = new org.apache.commons.lang3.ClassUtils();
        org.apache.commons.lang3.ClassUtils classUtils4 = new org.apache.commons.lang3.ClassUtils();
        org.apache.commons.lang3.ClassUtils[] classUtilsArray5 = new org.apache.commons.lang3.ClassUtils[] { classUtils0, classUtils1, classUtils2, classUtils3, classUtils4 };
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ClassUtils[] classUtilsArray6 = org.apache.commons.lang3.ArraySorter.sort(classUtilsArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: class org.apache.commons.lang3.ClassUtils cannot be cast to class java.lang.Comparable (org.apache.commons.lang3.ClassUtils is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')");
        } catch (java.lang.ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(classUtilsArray5);
    }

    @Test
    public void test0715() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0715");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("\\u0024", '#', 'o');
    }

    @Test
    public void test0716() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0716");
        org.apache.commons.lang3.text.StrMatcher strMatcher0 = org.apache.commons.lang3.text.StrMatcher.doubleQuoteMatcher();
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = org.apache.commons.lang3.text.StrMatcher.doubleQuoteMatcher();
        org.apache.commons.lang3.text.StrMatcher strMatcher2 = org.apache.commons.lang3.text.StrMatcher.doubleQuoteMatcher();
        org.apache.commons.lang3.text.StrMatcher[] strMatcherArray3 = new org.apache.commons.lang3.text.StrMatcher[] { strMatcher0, strMatcher1, strMatcher2 };
        org.apache.commons.lang3.text.StrMatcher[] strMatcherArray4 = new org.apache.commons.lang3.text.StrMatcher[] {};
        org.apache.commons.lang3.text.StrMatcher[] strMatcherArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(strMatcherArray3, strMatcherArray4);
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat6 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT;
        java.util.BitSet bitSet7 = org.apache.commons.lang3.ArrayUtils.indexesOf((java.lang.Object[]) strMatcherArray3, (java.lang.Object) fastDateFormat6);
        org.junit.Assert.assertNotNull(strMatcher0);
        org.junit.Assert.assertNotNull(strMatcher1);
        org.junit.Assert.assertNotNull(strMatcher2);
        org.junit.Assert.assertNotNull(strMatcherArray3);
        org.junit.Assert.assertNotNull(strMatcherArray4);
        org.junit.Assert.assertNotNull(strMatcherArray5);
        org.junit.Assert.assertNotNull(fastDateFormat6);
        org.junit.Assert.assertNotNull(bitSet7);
        org.junit.Assert.assertEquals(bitSet7.toString(), "{}");
    }

    @Test
    public void test0717() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0717");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        char[] charArray13 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray16 = org.apache.commons.lang3.ArrayUtils.subarray(charArray13, (int) (short) 1, (-1));
        char[] charArray17 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray4, charArray13);
        char[] charArray19 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(charArray4, '#');
        int int21 = org.apache.commons.lang3.ArrayUtils.indexOf(charArray4, '$');
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray2), "[ , #]");
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[ ]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[#]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray13);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray13), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray13), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray13), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray16);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray16), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray16), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray16), "[]");
        org.junit.Assert.assertNotNull(charArray17);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray17), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray17), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray17), "[]");
        org.junit.Assert.assertNotNull(charArray19);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray19), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray19), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray19), "[ ]");
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + (-1) + "'", int21 == (-1));
    }

    @Test
    public void test0718() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0718");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_1_5;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0719() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0719");
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException7 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException3);
        java.lang.String str8 = org.apache.commons.lang3.exception.ExceptionUtils.getRootCauseMessage((java.lang.Throwable) uncheckedExecutionException3);
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "UncheckedExecutionException: " + "'", str8, "UncheckedExecutionException: ");
    }

    @Test
    public void test0720() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0720");
        int[] intArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(intArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read the array length because \"array\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0721() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0721");
        java.util.regex.Pattern pattern1 = null;
        java.lang.String str2 = org.apache.commons.lang3.RegExUtils.removeFirst("OpenJDK 64-Bit Server VM", pattern1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "OpenJDK 64-Bit Server VM" + "'", str2, "OpenJDK 64-Bit Server VM");
    }

    @Test
    public void test0722() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0722");
        char char1 = org.apache.commons.lang3.CharUtils.toChar((java.lang.Character) 'a');
        org.junit.Assert.assertTrue("'" + char1 + "' != '" + 'a' + "'", char1 == 'a');
    }

    @Test
    public void test0723() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0723");
        int int2 = org.apache.commons.lang3.StringUtils.lastIndexOf((java.lang.CharSequence) "oracle corporation", (java.lang.CharSequence) "https://adoptopenjdk.net/");
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test0724() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0724");
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer.Builder<org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>, org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializerBuilder0 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer.Builder<org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>, org.apache.commons.lang3.builder.ToStringStyle>();
    }

    @Test
    public void test0725() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0725");
        org.apache.commons.lang3.function.FailablePredicate<org.apache.commons.lang3.concurrent.TimedSemaphore, org.apache.commons.lang3.NotImplementedException> timedSemaphoreFailablePredicate0 = org.apache.commons.lang3.function.FailablePredicate.falsePredicate();
        org.junit.Assert.assertNotNull(timedSemaphoreFailablePredicate0);
    }

    @Test
    public void test0726() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0726");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.PATH_SEPARATOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "path.separator" + "'", str0, "path.separator");
    }

    @Test
    public void test0727() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0727");
        java.time.temporal.Temporal temporal0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.time.Duration duration1 = org.apache.commons.lang3.time.DurationUtils.since(temporal0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.temporal.Temporal.until(java.time.temporal.Temporal, java.time.temporal.TemporalUnit)\" because \"startInclusive\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0728() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0728");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.reflect.Method[] methodArray1 = org.apache.commons.lang3.SerializationUtils.deserialize(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: inputStream");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0729() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0729");
        // The following exception was thrown during execution in test generation
        try {
            java.util.Locale locale1 = org.apache.commons.lang3.LocaleUtils.toLocale("6f51daee");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid locale format: 6f51daee");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0730() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0730");
        java.util.Formattable formattable0 = null;
        java.lang.String str1 = org.apache.commons.lang3.text.FormattableUtils.toString(formattable0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "null" + "'", str1, "null");
    }

    @Test
    public void test0731() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0731");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaRuntimeName();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "OpenJDK Runtime Environment" + "'", str0, "OpenJDK Runtime Environment");
    }

    @Test
    public void test0732() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0732");
        java.lang.String[] strArray0 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray2 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray0, (java.lang.CharSequence) "Integer");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair3 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray4 = charSequenceArrayImmutablePair3.getLeft();
        int int5 = org.apache.commons.lang3.ArrayUtils.lastIndexOf((java.lang.Object[]) strArray0, (java.lang.Object) charSequenceArrayImmutablePair3);
        org.junit.Assert.assertNotNull(strArray0);
        org.junit.Assert.assertNotNull(charSequenceArray2);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair3);
        org.junit.Assert.assertNull(charSequenceArray4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
    }

    @Test
    public void test0733() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0733");
        double[][] doubleArray0 = new double[][] {};
        double[][] doubleArray1 = org.apache.commons.lang3.Validate.noNullElements(doubleArray0);
        double[] doubleArray2 = org.apache.commons.lang3.ObjectUtils.firstNonNull(doubleArray1);
        org.junit.Assert.assertNotNull(doubleArray0);
        org.junit.Assert.assertNotNull(doubleArray1);
        org.junit.Assert.assertNull(doubleArray2);
    }

    @Test
    public void test0734() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0734");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange2 = org.apache.commons.lang3.Range.of(javaVersion0, javaVersion1);
        org.apache.commons.lang3.JavaVersion javaVersion3 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion4 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange5 = org.apache.commons.lang3.Range.of(javaVersion3, javaVersion4);
        char[] charArray8 = new char[] { ' ', '#' };
        char[] charArray10 = new char[] { ' ' };
        char[] charArray11 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray8, charArray10);
        boolean boolean12 = javaVersionRange5.equals((java.lang.Object) charArray11);
        boolean boolean13 = javaVersionRange2.isAfterRange(javaVersionRange5);
        org.apache.commons.lang3.JavaVersion javaVersion14 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion15 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange16 = org.apache.commons.lang3.Range.of(javaVersion14, javaVersion15);
        org.apache.commons.lang3.Range[] rangeArray18 = new org.apache.commons.lang3.Range[2];
        @SuppressWarnings("unchecked")
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion>[] javaVersionRangeArray19 = (org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion>[]) rangeArray18;
        javaVersionRangeArray19[0] = javaVersionRange2;
        javaVersionRangeArray19[1] = javaVersionRange16;
        java.lang.Long[] longArray32 = new java.lang.Long[] { 10L, 0L, (-1L), (-1L), 10L, 1L };
        java.lang.Long[] longArray33 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray32);
        java.net.URL[] uRLArray34 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        boolean boolean35 = org.apache.commons.lang3.ArrayUtils.isSameLength((java.lang.Object[]) longArray32, (java.lang.Object[]) uRLArray34);
        java.lang.Long[] longArray36 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray32);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion>[] javaVersionRangeArray37 = org.apache.commons.lang3.Validate.validIndex(javaVersionRangeArray19, (int) '4', "Oracle Corporation", (java.lang.Object[]) longArray36);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Oracle Corporation");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange2);
        org.junit.Assert.assertTrue("'" + javaVersion3 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion3.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion4 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion4.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange5);
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ , #]");
        org.junit.Assert.assertNotNull(charArray10);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray10), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray10), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray10), "[ ]");
        org.junit.Assert.assertNotNull(charArray11);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray11), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray11), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray11), "[#]");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + javaVersion14 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion14.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion15 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion15.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange16);
        org.junit.Assert.assertNotNull(rangeArray18);
        org.junit.Assert.assertNotNull(javaVersionRangeArray19);
        org.junit.Assert.assertNotNull(longArray32);
        org.junit.Assert.assertNotNull(longArray33);
        org.junit.Assert.assertNotNull(uRLArray34);
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(longArray36);
    }

    @Test
    public void test0735() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0735");
        java.lang.String[][] strArray0 = org.apache.commons.lang3.text.translate.EntityArrays.HTML40_EXTENDED_ESCAPE();
        org.junit.Assert.assertNotNull(strArray0);
    }

    @Test
    public void test0736() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0736");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaRuntimeVersion();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "16.0.1+9" + "'", str0, "16.0.1+9");
    }

    @Test
    public void test0737() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0737");
        double[] doubleArray6 = new double[] { (byte) 100, (byte) -1, (byte) 100, (-1L), 0.0d };
        org.apache.commons.lang3.ArrayUtils.reverse(doubleArray6);
        double[] doubleArray12 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray16 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean18 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray16, (double) '4');
        boolean boolean19 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray12, doubleArray16);
        org.apache.commons.lang3.ArrayUtils.reverse(doubleArray12);
        // The following exception was thrown during execution in test generation
        try {
            double[] doubleArray21 = org.apache.commons.lang3.ArrayUtils.insert((int) '\n', doubleArray6, doubleArray12);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 10, Length: 5");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(doubleArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray6), "[0.0, -1.0, 100.0, -1.0, 100.0]");
        org.junit.Assert.assertNotNull(doubleArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray12), "[1.0, -1.0, 52.0, 97.0]");
        org.junit.Assert.assertNotNull(doubleArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray16), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
    }

    @Test
    public void test0738() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0738");
        org.apache.commons.lang3.arch.Processor.Arch arch0 = null;
        org.apache.commons.lang3.arch.Processor.Type type1 = org.apache.commons.lang3.arch.Processor.Type.PPC;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.arch.Processor.Type> typeRange2 = org.apache.commons.lang3.Range.is(type1);
        org.apache.commons.lang3.arch.Processor processor3 = new org.apache.commons.lang3.arch.Processor(arch0, type1);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = processor3.toString();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"org.apache.commons.lang3.arch.Processor$Arch.getLabel()\" because \"this.arch\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + type1 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type1.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNotNull(typeRange2);
    }

    @Test
    public void test0739() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0739");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        // The following exception was thrown during execution in test generation
        try {
            toStringStyle1.append(stringBuffer3, "https://adoptopenjdk.net/", (short) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(int)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
    }

    @Test
    public void test0740() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0740");
        java.io.File file0 = org.apache.commons.lang3.SystemUtils.getUserHome();
        org.junit.Assert.assertNotNull(file0);
        org.junit.Assert.assertEquals(file0.getParent(), "/Users");
        org.junit.Assert.assertEquals(file0.toString(), "/Users/glacierali");
    }

    @Test
    public void test0741() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0741");
        org.apache.commons.lang3.mutable.MutableLong mutableLong0 = null;
        org.apache.commons.lang3.mutable.MutableLong mutableLong2 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        org.apache.commons.lang3.mutable.MutableLong mutableLong3 = org.apache.commons.lang3.compare.ComparableUtils.min(mutableLong0, mutableLong2);
        double double4 = mutableLong2.doubleValue();
        org.junit.Assert.assertNotNull(mutableLong3);
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 1.0d + "'", double4 == 1.0d);
    }

    @Test
    public void test0742() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0742");
        java.lang.String str3 = org.apache.commons.lang3.BooleanUtils.toString(false, ";ClT9Ss'St<Q", "org.apache.commons.lang3.builder.StandardToStringStyle");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "org.apache.commons.lang3.builder.StandardToStringStyle" + "'", str3, "org.apache.commons.lang3.builder.StandardToStringStyle");
    }

    @Test
    public void test0743() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0743");
        org.apache.commons.lang3.BitField bitField1 = new org.apache.commons.lang3.BitField((int) '\r');
    }

    @Test
    public void test0744() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0744");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isAlphanumeric((java.lang.CharSequence) "java.awt.headless");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0745() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0745");
        java.util.TimeZone timeZone1 = org.apache.commons.lang3.time.FastTimeZone.getGmtTimeZone("java.specification.vendor");
        org.junit.Assert.assertNull(timeZone1);
    }

    @Test
    public void test0746() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0746");
        long[] longArray6 = new long[] { (short) 10, 1L, 'a', 100L, ' ', 100 };
        long[] longArray8 = org.apache.commons.lang3.ArrayUtils.remove(longArray6, 3);
        org.apache.commons.lang3.ArrayUtils.swap(longArray8, (int) (short) 1, (int) (short) 99);
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray6), "[10, 1, 97, 100, 32, 100]");
        org.junit.Assert.assertNotNull(longArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray8), "[10, 1, 97, 32, 100]");
    }

    @Test
    public void test0747() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0747");
        int int1 = org.apache.commons.lang3.StringUtils.length((java.lang.CharSequence) "os.nam");
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 6 + "'", int1 == 6);
    }

    @Test
    public void test0748() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0748");
        short[] shortArray0 = null;
        boolean boolean1 = org.apache.commons.lang3.ArrayUtils.isEmpty(shortArray0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0749() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0749");
        java.lang.reflect.Method method0 = null;
        java.lang.reflect.Method method1 = org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethod(method0);
        org.junit.Assert.assertNull(method1);
    }

    @Test
    public void test0750() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0750");
        java.lang.String str1 = org.apache.commons.lang3.time.DurationFormatUtils.formatDurationISO(1L);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "P0Y0M0DT0H0M0.001S" + "'", str1, "P0Y0M0DT0H0M0.001S");
    }

    @Test
    public void test0751() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0751");
        java.lang.Object[] objArray0 = null;
        org.apache.commons.lang3.ArrayUtils.swap(objArray0, (int) (byte) -11, (int) (short) 99);
    }

    @Test
    public void test0752() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0752");
        int[] intArray1 = new int[] { '\n' };
        java.util.BitSet bitSet4 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray1, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray1);
        int[] intArray6 = org.apache.commons.lang3.ArraySorter.sort(intArray1);
        int[] intArray7 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(intArray6);
        int[] intArray9 = new int[] { '\n' };
        java.util.BitSet bitSet12 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray9, (int) (byte) -1, (int) (short) -1);
        java.lang.String str16 = org.apache.commons.lang3.StringUtils.join(intArray9, '\000', (int) '4', 1);
        int[] intArray17 = org.apache.commons.lang3.ArrayUtils.removeElements(intArray6, intArray9);
        org.junit.Assert.assertNotNull(intArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray1), "[10]");
        org.junit.Assert.assertNotNull(bitSet4);
        org.junit.Assert.assertEquals(bitSet4.toString(), "{}");
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray6), "[10]");
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray7), "[10]");
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray9), "[10]");
        org.junit.Assert.assertNotNull(bitSet12);
        org.junit.Assert.assertEquals(bitSet12.toString(), "{}");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
        org.junit.Assert.assertNotNull(intArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray17), "[]");
    }

    @Test
    public void test0753() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0753");
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException2, "Integer");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer6 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService7 = multiBackgroundInitializer6.getExternalExecutor();
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer9 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService10 = multiBackgroundInitializer9.getExternalExecutor();
        multiBackgroundInitializer6.addInitializer("60.0", (org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>) multiBackgroundInitializer9);
        org.apache.commons.lang3.tuple.MutablePair<org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.concurrent.MultiBackgroundInitializer> notImplementedExceptionMutablePair12 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull(notImplementedException5, multiBackgroundInitializer9);
        java.lang.Class<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierClass13 = org.apache.commons.lang3.ObjectUtils.getClass((org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>) multiBackgroundInitializer9);
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces14 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces15 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces16 = org.apache.commons.lang3.compare.ComparableUtils.min(interfaces14, interfaces15);
        java.lang.Iterable<java.lang.Class<?>> wildcardClassIterable17 = org.apache.commons.lang3.ClassUtils.hierarchy(multiBackgroundInitializerResultsFailableSupplierClass13, interfaces14);
        java.lang.reflect.ParameterizedType parameterizedType18 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> wildcardTypeVariableMap19 = org.apache.commons.lang3.reflect.TypeUtils.determineTypeArguments(multiBackgroundInitializerResultsFailableSupplierClass13, parameterizedType18);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: superParameterizedType");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertTrue("'" + interfaces14 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces14.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces15 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces15.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces16 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces16.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertNotNull(wildcardClassIterable17);
    }

    @Test
    public void test0754() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0754");
        char[] charArray5 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.subarray(charArray5, (int) (short) 1, (-1));
        int int9 = org.apache.commons.lang3.StringUtils.indexOfAnyBut((java.lang.CharSequence) "os.version", charArray8);
        // The following exception was thrown during execution in test generation
        try {
            char[] charArray12 = org.apache.commons.lang3.ArrayUtils.add(charArray8, (int) ' ', 'o');
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 32, Length: 0");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[]");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
    }

    @Test
    public void test0755() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0755");
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException1 = new org.apache.commons.lang3.exception.ContextedRuntimeException("mixed mode, sharing");
        java.lang.String str3 = contextedRuntimeException1.getFormattedExceptionMessage("mixed mode, sharing");
        java.lang.String str4 = org.apache.commons.lang3.ArrayUtils.toString((java.lang.Object) "mixed mode, sharing");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "mixed mode, sharing" + "'", str3, "mixed mode, sharing");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "mixed mode, sharing" + "'", str4, "mixed mode, sharing");
    }

    @Test
    public void test0756() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0756");
        java.math.BigDecimal bigDecimal1 = org.apache.commons.lang3.math.NumberUtils.toScaledBigDecimal((java.lang.Double) (-1.0d));
        org.junit.Assert.assertNotNull(bigDecimal1);
    }

    @Test
    public void test0757() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0757");
        short[] shortArray2 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray2, (int) (byte) -1, 1, (int) (byte) 10);
        org.apache.commons.lang3.ArrayUtils.shuffle(shortArray2);
        short[] shortArray10 = org.apache.commons.lang3.ArrayUtils.subarray(shortArray2, 2, 3);
        org.apache.commons.lang3.ArrayUtils.shift(shortArray10, (-1));
        short[] shortArray13 = org.apache.commons.lang3.ArraySorter.sort(shortArray10);
        org.junit.Assert.assertNotNull(shortArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray2), "[100, 100]");
        org.junit.Assert.assertNotNull(shortArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray10), "[]");
        org.junit.Assert.assertNotNull(shortArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray13), "[]");
    }

    @Test
    public void test0758() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0758");
        java.util.stream.Stream[] streamArray1 = new java.util.stream.Stream[0];
        @SuppressWarnings("unchecked")
        java.util.stream.Stream<java.util.Locale>[] localeStreamArray2 = (java.util.stream.Stream<java.util.Locale>[]) streamArray1;
        int[] intArray3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.stream.Stream<java.util.Locale>[] localeStreamArray4 = org.apache.commons.lang3.ArrayUtils.removeAll(localeStreamArray2, intArray3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read the array length because \"a\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(streamArray1);
        org.junit.Assert.assertNotNull(localeStreamArray2);
    }

    @Test
    public void test0759() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0759");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_AWT_FONTS;
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0760() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0760");
        java.lang.String str2 = org.apache.commons.lang3.RegExUtils.removePattern("java.ext.dirs", "6f51daee");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "java.ext.dirs" + "'", str2, "java.ext.dirs");
    }

    @Test
    public void test0761() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0761");
        org.apache.commons.lang3.tuple.ImmutableTriple<java.lang.String, java.lang.constant.ConstantDesc, java.lang.constant.Constable> strImmutableTriple0 = org.apache.commons.lang3.tuple.ImmutableTriple.nullTriple();
        org.apache.commons.lang3.function.FailableObjIntConsumer failableObjIntConsumer1 = org.apache.commons.lang3.function.FailableObjIntConsumer.NOP;
        boolean boolean2 = strImmutableTriple0.equals((java.lang.Object) failableObjIntConsumer1);
        java.lang.constant.ConstantDesc constantDesc3 = strImmutableTriple0.middle;
        org.junit.Assert.assertNotNull(strImmutableTriple0);
        org.junit.Assert.assertNotNull(failableObjIntConsumer1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNull(constantDesc3);
    }

    @Test
    public void test0762() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0762");
        org.apache.commons.lang3.concurrent.LazyInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleLazyInitializer0 = new org.apache.commons.lang3.concurrent.LazyInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = toStringStyleLazyInitializer0.get();
        boolean boolean2 = toStringStyleLazyInitializer0.isInitialized();
        org.junit.Assert.assertNull(toStringStyle1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test0763() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0763");
        java.util.List<java.lang.Boolean> booleanList0 = org.apache.commons.lang3.BooleanUtils.values();
        org.junit.Assert.assertNotNull(booleanList0);
    }

    @Test
    public void test0764() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0764");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isNotBlank((java.lang.CharSequence) "org.apache.commons.lang3.function");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0765() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0765");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getAwtToolkit();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0766() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0766");
        // The following exception was thrown during execution in test generation
        try {
            short short5 = org.apache.commons.lang3.Conversion.hexToShort("oracle corporation", (int) '\n', (short) (byte) 10, 100, 8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nHexs-1)*4+dstPos is greater or equal to than 16");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0767() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0767");
        java.lang.String[] strArray0 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray2 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray0, (java.lang.CharSequence) "Integer");
        org.apache.commons.lang3.ArrayUtils.shift((java.lang.Object[]) charSequenceArray2, (int) (byte) -11, 4, (int) (short) 100);
        org.junit.Assert.assertNotNull(strArray0);
        org.junit.Assert.assertNotNull(charSequenceArray2);
    }

    @Test
    public void test0768() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0768");
        java.util.List<java.util.Locale> localeList0 = org.apache.commons.lang3.LocaleUtils.availableLocaleList();
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream1 = org.apache.commons.lang3.stream.Streams.stream((java.util.Collection<java.util.Locale>) localeList0);
        org.junit.Assert.assertNotNull(localeList0);
        org.junit.Assert.assertNotNull(localeFailableStream1);
    }

    @Test
    public void test0769() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0769");
        java.util.stream.IntStream intStream1 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream3 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle4 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle5 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str6 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle4, toStringStyle5);
        java.lang.StringBuffer stringBuffer7 = null;
        java.lang.Object obj8 = null;
        standardToStringStyle4.appendStart(stringBuffer7, obj8);
        java.lang.String str10 = standardToStringStyle4.getNullText();
        standardToStringStyle4.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder14 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream1, (java.lang.AutoCloseable) intStream3, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle4, true);
        java.lang.StringBuffer stringBuffer15 = null;
        long[] longArray22 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet25 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray22, (long) '\n', 100);
        // The following exception was thrown during execution in test generation
        try {
            standardToStringStyle4.append(stringBuffer15, "\n", longArray22, (java.lang.Boolean) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intStream1);
        org.junit.Assert.assertNotNull(intStream3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
        org.junit.Assert.assertNotNull(longArray22);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray22), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet25);
        org.junit.Assert.assertEquals(bitSet25.toString(), "{}");
    }

    @Test
    public void test0770() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0770");
        java.util.List<java.util.Locale> localeList0 = org.apache.commons.lang3.LocaleUtils.availableLocaleList();
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream1 = org.apache.commons.lang3.Streams.stream((java.util.Collection<java.util.Locale>) localeList0);
        java.util.stream.Stream<java.util.Locale> localeStream2 = org.apache.commons.lang3.stream.Streams.of((java.lang.Iterable<java.util.Locale>) localeList0);
        java.util.stream.Stream<java.util.Locale> localeStream3 = org.apache.commons.lang3.stream.Streams.nonNull(localeStream2);
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream4 = org.apache.commons.lang3.Functions.stream(localeStream3);
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream5 = org.apache.commons.lang3.Streams.stream(localeStream3);
        org.junit.Assert.assertNotNull(localeList0);
        org.junit.Assert.assertNotNull(localeFailableStream1);
        org.junit.Assert.assertNotNull(localeStream2);
        org.junit.Assert.assertNotNull(localeStream3);
        org.junit.Assert.assertNotNull(localeFailableStream4);
        org.junit.Assert.assertNotNull(localeFailableStream5);
    }

    @Test
    public void test0771() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0771");
        byte[] byteArray5 = new byte[] { (byte) -11, (byte) -1, (byte) 1, (byte) 0, (byte) 10 };
        java.nio.charset.Charset charset6 = null;
        java.lang.String str7 = org.apache.commons.lang3.StringUtils.toEncodedString(byteArray5, charset6);
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[-11, -1, 1, 0, 10]");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "\ufffd\ufffd\001\000\n" + "'", str7, "\ufffd\ufffd\001\000\n");
    }

    @Test
    public void test0772() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0772");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle2 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer6 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray7 = strTokenizer6.getTokenArray();
        java.lang.String str8 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle2, strArray7);
        java.lang.String str12 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray7, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int13 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray7);
        boolean boolean14 = org.apache.commons.lang3.StringUtils.equalsAnyIgnoreCase((java.lang.CharSequence) "\\u0024", (java.lang.CharSequence[]) strArray7);
        org.junit.Assert.assertNotNull(strArray7);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "" + "'", str12, "");
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + (-1) + "'", int13 == (-1));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test0773() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0773");
        long[] longArray5 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray5, (long) '\n', 100);
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray5);
        long[] longArray11 = org.apache.commons.lang3.ArrayUtils.add(longArray5, (long) (short) 101);
        long[] longArray18 = new long[] { (short) 10, 1L, 'a', 100L, ' ', 100 };
        long[] longArray20 = org.apache.commons.lang3.ArrayUtils.remove(longArray18, 3);
        boolean boolean21 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray5, longArray18);
        long[] longArray22 = null;
        long[] longArray23 = org.apache.commons.lang3.ArrayUtils.removeElements(longArray5, longArray22);
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray5), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(longArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray11), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(longArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray18), "[10, 1, 97, 100, 32, 100]");
        org.junit.Assert.assertNotNull(longArray20);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray20), "[10, 1, 97, 32, 100]");
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(longArray23);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray23), "[10, 100, 100, 97, 52]");
    }

    @Test
    public void test0774() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0774");
        // The following exception was thrown during execution in test generation
        try {
            int int1 = org.apache.commons.lang3.Conversion.hexDigitToInt('\000');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot interpret '?' as a hexadecimal digit");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0775() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0775");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setNullText("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        standardToStringStyle0.setFieldSeparatorAtStart(true);
        java.lang.StringBuffer stringBuffer5 = null;
        char[] charArray9 = new char[] { ' ', '#' };
        char[] charArray11 = new char[] { ' ' };
        char[] charArray12 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray9, charArray11);
        char[] charArray15 = org.apache.commons.lang3.ArrayUtils.add(charArray11, (int) (short) 0, ' ');
        // The following exception was thrown during execution in test generation
        try {
            standardToStringStyle0.append(stringBuffer5, ")<+WncT", (java.lang.Object) (short) 0, (java.lang.Boolean) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray9);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray9), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray9), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray9), "[ , #]");
        org.junit.Assert.assertNotNull(charArray11);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray11), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray11), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray11), "[ ]");
        org.junit.Assert.assertNotNull(charArray12);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray12), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray12), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray12), "[#]");
        org.junit.Assert.assertNotNull(charArray15);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray15), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray15), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray15), "[ ,  ]");
    }

    @Test
    public void test0776() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0776");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.toRootUpperCase("Double");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "DOUBLE" + "'", str1, "DOUBLE");
    }

    @Test
    public void test0777() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0777");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        boolean[] booleanArray9 = org.apache.commons.lang3.ArrayUtils.removeElement(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.remove(booleanArray9, 2);
        java.util.Random random12 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(booleanArray11, random12);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(booleanArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray9), "[false, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray11), "[false, false, false]");
    }

    @Test
    public void test0778() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0778");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.removeAll("true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false", "                                                                                                  100");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
    }

    @Test
    public void test0779() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0779");
        org.apache.commons.lang3.math.Fraction fraction2 = org.apache.commons.lang3.math.Fraction.getReducedFraction((-27), 3);
        java.lang.String str3 = fraction2.toProperString();
        org.junit.Assert.assertNotNull(fraction2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "-9" + "'", str3, "-9");
    }

    @Test
    public void test0780() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0780");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.escapeJson("QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc" + "'", str1, "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc");
    }

    @Test
    public void test0781() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0781");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer0 = new org.apache.commons.lang3.text.StrTokenizer();
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat3 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        java.lang.String str4 = fastDateFormat3.toString();
        java.lang.String[] strArray5 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray7 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray5, (java.lang.CharSequence) "Integer");
        boolean boolean8 = fastDateFormat3.equals((java.lang.Object) charSequenceArray7);
        boolean boolean9 = org.apache.commons.lang3.StringUtils.isAllEmpty(charSequenceArray7);
        java.lang.Class[] classArray11 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray12 = (java.lang.Class<?>[]) classArray11;
        java.lang.Class<?> wildcardClass13 = null;
        java.lang.Class[] classArray15 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray16 = (java.lang.Class<?>[]) classArray15;
        wildcardClassArray16[0] = wildcardClass13;
        boolean boolean19 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray11, wildcardClassArray16);
        java.lang.Class[] classArray21 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray22 = (java.lang.Class<?>[]) classArray21;
        java.lang.Class<?> wildcardClass23 = null;
        java.lang.Class[] classArray25 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray26 = (java.lang.Class<?>[]) classArray25;
        wildcardClassArray26[0] = wildcardClass23;
        boolean boolean29 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray21, wildcardClassArray26);
        boolean boolean31 = org.apache.commons.lang3.ClassUtils.isAssignable(wildcardClassArray16, (java.lang.Class<?>[]) classArray21, false);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj32 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) strTokenizer0, true, "\n", (java.lang.Object[]) charSequenceArray7, (java.lang.Class<?>[]) classArray21);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such method: ?() on object: org.apache.commons.lang3.text.StrTokenizer");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]" + "'", str4, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertNotNull(charSequenceArray7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(classArray11);
        org.junit.Assert.assertNotNull(wildcardClassArray12);
        org.junit.Assert.assertNotNull(classArray15);
        org.junit.Assert.assertNotNull(wildcardClassArray16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(classArray21);
        org.junit.Assert.assertNotNull(wildcardClassArray22);
        org.junit.Assert.assertNotNull(classArray25);
        org.junit.Assert.assertNotNull(wildcardClassArray26);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
    }

    @Test
    public void test0782() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0782");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setNullText("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        standardToStringStyle0.setFieldSeparatorAtStart(true);
        java.lang.StringBuffer stringBuffer5 = null;
        org.apache.commons.lang3.function.FailableBiPredicate<int[][], java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.concurrent.CircuitBreakingException> intArrayFailableBiPredicate6 = org.apache.commons.lang3.function.FailableBiPredicate.falsePredicate();
        // The following exception was thrown during execution in test generation
        try {
            standardToStringStyle0.appendStart(stringBuffer5, (java.lang.Object) intArrayFailableBiPredicate6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArrayFailableBiPredicate6);
    }

    @Test
    public void test0783() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0783");
        double[] doubleArray4 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray8 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray8, (double) '4');
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray4, doubleArray8);
        int int15 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray4, (-1.0d), (int) '\n', (double) 100);
        int int18 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray4, (double) 8, (int) (short) 10);
        boolean boolean20 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray4, (-1.0d));
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray4), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray8), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + (-1) + "'", int15 == (-1));
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + (-1) + "'", int18 == (-1));
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + true + "'", boolean20 == true);
    }

    @Test
    public void test0784() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0784");
        java.lang.annotation.Annotation annotation0 = null;
        java.lang.annotation.Annotation annotation1 = null;
        boolean boolean2 = org.apache.commons.lang3.AnnotationUtils.equals(annotation0, annotation1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test0785() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0785");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray1 = charSequenceArrayImmutablePair0.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair2 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0);
        java.lang.String[] strArray3 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray5 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray3, (java.lang.CharSequence) "Integer");
        java.lang.String str6 = org.apache.commons.lang3.StringUtils.firstNonBlank(strArray3);
        charSequenceArrayMutablePair2.left = strArray3;
        java.util.stream.IntStream intStream9 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream11 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle12 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle13 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str14 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle12, toStringStyle13);
        java.lang.StringBuffer stringBuffer15 = null;
        java.lang.Object obj16 = null;
        standardToStringStyle12.appendStart(stringBuffer15, obj16);
        java.lang.String str18 = standardToStringStyle12.getNullText();
        standardToStringStyle12.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder22 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream9, (java.lang.AutoCloseable) intStream11, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle12, true);
        long[] longArray25 = new long[] { 3 };
        long[] longArray26 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray25);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray25);
        long[] longArray29 = new long[] { '4' };
        long[] longArray35 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet38 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray35, (long) '\n', 100);
        boolean boolean39 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray35);
        long[] longArray41 = org.apache.commons.lang3.ArrayUtils.add(longArray35, (long) (short) 101);
        boolean boolean42 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray29, longArray41);
        long[] longArray44 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray41, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder45 = autoCloseableDiffBuilder22.append("java.awt.headless", longArray25, longArray44);
        char[] charArray49 = new char[] { ' ', '#' };
        char[] charArray51 = new char[] { ' ' };
        char[] charArray52 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray49, charArray51);
        org.apache.commons.lang3.ArrayUtils.swap(charArray49, (int) (short) 1, (int) (short) 101, 0);
        int[] intArray58 = new int[] { '\n' };
        java.util.BitSet bitSet61 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray58, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray58);
        boolean boolean64 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) (short) 101, (java.lang.Object) intArray58, true);
        int[] intArray66 = new int[] { '\n' };
        java.util.BitSet bitSet69 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray66, (int) (byte) -1, (int) (short) -1);
        java.lang.String str73 = org.apache.commons.lang3.StringUtils.join(intArray66, '\000', (int) '4', 1);
        int[] intArray75 = org.apache.commons.lang3.ArrayUtils.addFirst(intArray66, (int) (byte) 10);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder76 = autoCloseableDiffBuilder45.append(" ", intArray58, intArray75);
        org.apache.commons.lang3.compare.ObjectToStringComparator objectToStringComparator77 = new org.apache.commons.lang3.compare.ObjectToStringComparator();
        org.apache.commons.lang3.Range<java.lang.Object> objRange78 = org.apache.commons.lang3.Range.of((java.lang.Object) strArray3, (java.lang.Object) " ", (java.util.Comparator<java.lang.Object>) objectToStringComparator77);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(charSequenceArray1);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair2);
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertNotNull(charSequenceArray5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "Integer" + "'", str6, "Integer");
        org.junit.Assert.assertNotNull(intStream9);
        org.junit.Assert.assertNotNull(intStream11);
        org.junit.Assert.assertNotNull(toStringStyle13);
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str14, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "<null>" + "'", str18, "<null>");
        org.junit.Assert.assertNotNull(longArray25);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray25), "[3]");
        org.junit.Assert.assertNotNull(longArray26);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray26), "[3]");
        org.junit.Assert.assertNotNull(longArray29);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray29), "[52]");
        org.junit.Assert.assertNotNull(longArray35);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray35), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet38);
        org.junit.Assert.assertEquals(bitSet38.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNotNull(longArray41);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray41), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNotNull(longArray44);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray44), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder45);
        org.junit.Assert.assertNotNull(charArray49);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray49), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray49), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray49), "[ , #]");
        org.junit.Assert.assertNotNull(charArray51);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray51), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray51), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray51), "[ ]");
        org.junit.Assert.assertNotNull(charArray52);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray52), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray52), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray52), "[#]");
        org.junit.Assert.assertNotNull(intArray58);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray58), "[10]");
        org.junit.Assert.assertNotNull(bitSet61);
        org.junit.Assert.assertEquals(bitSet61.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
        org.junit.Assert.assertNotNull(intArray66);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray66), "[10]");
        org.junit.Assert.assertNotNull(bitSet69);
        org.junit.Assert.assertEquals(bitSet69.toString(), "{}");
        org.junit.Assert.assertEquals("'" + str73 + "' != '" + "" + "'", str73, "");
        org.junit.Assert.assertNotNull(intArray75);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray75), "[10, 10]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder76);
        org.junit.Assert.assertNotNull(objRange78);
    }

    @Test
    public void test0786() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0786");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_AWT_GRAPHICSENV;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.awt.graphicsenv" + "'", str0, "java.awt.graphicsenv");
    }

    @Test
    public void test0787() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0787");
        org.apache.commons.lang3.ObjectUtils.Null null0 = org.apache.commons.lang3.ObjectUtils.NULL;
        org.junit.Assert.assertNotNull(null0);
    }

    @Test
    public void test0788() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0788");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.FastDateFormat.getDateTimeInstance(0, 8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal time style 8");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0789() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0789");
        long long3 = org.apache.commons.lang3.math.NumberUtils.min((long) (byte) 10, 0L, 0L);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + 0L + "'", long3 == 0L);
    }

    @Test
    public void test0790() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0790");
        java.lang.Short[] shortArray5 = new java.lang.Short[] { (short) 100, (short) 1, (short) 1, (short) 10, (short) 1 };
        java.lang.Short[] shortArray6 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(shortArray5);
        short[] shortArray8 = org.apache.commons.lang3.ArrayUtils.toPrimitive(shortArray6, (short) 99);
        short[] shortArray11 = org.apache.commons.lang3.ArrayUtils.subarray(shortArray8, 100, (int) (byte) 100);
        org.junit.Assert.assertNotNull(shortArray5);
        org.junit.Assert.assertNotNull(shortArray6);
        org.junit.Assert.assertNotNull(shortArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray8), "[100, 1, 1, 10, 1]");
        org.junit.Assert.assertNotNull(shortArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray11), "[]");
    }

    @Test
    public void test0791() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0791");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.TWO_THIRDS;
        org.apache.commons.lang3.math.Fraction fraction3 = org.apache.commons.lang3.math.Fraction.getFraction((int) (short) 1, (int) (short) 1);
        int int4 = fraction0.compareTo(fraction3);
        java.lang.String str5 = fraction3.toString();
        org.junit.Assert.assertNotNull(fraction0);
        org.junit.Assert.assertNotNull(fraction3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + (-1) + "'", int4 == (-1));
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "1/1" + "'", str5, "1/1");
    }

    @Test
    public void test0792() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0792");
        java.lang.Class<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierClass0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.List<java.lang.reflect.Field> fieldList1 = org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList(multiBackgroundInitializerResultsFailableSupplierClass0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: cls");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0793() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0793");
        org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException> strItorMutableTriple0 = new org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException>();
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException1 = strItorMutableTriple0.getRight();
        org.junit.Assert.assertNull(contextedRuntimeException1);
    }

    @Test
    public void test0794() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0794");
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder1 = new org.apache.commons.lang3.builder.EqualsBuilder();
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder4 = equalsBuilder1.append(false, false);
        java.lang.Object obj5 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer6 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService7 = multiBackgroundInitializer6.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle10 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer14 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray15 = strTokenizer14.getTokenArray();
        java.lang.String str16 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle10, strArray15);
        java.lang.String str20 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray15, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int21 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray15);
        boolean boolean22 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray15);
        boolean boolean23 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj5, (java.lang.Object) executorService7, strArray15);
        java.lang.Object[] objArray24 = org.apache.commons.lang3.ArrayUtils.nullToEmpty((java.lang.Object[]) strArray15);
        java.lang.Object obj25 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer26 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService27 = multiBackgroundInitializer26.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle30 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer34 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray35 = strTokenizer34.getTokenArray();
        java.lang.String str36 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle30, strArray35);
        java.lang.String str40 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray35, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int41 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray35);
        boolean boolean42 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray35);
        boolean boolean43 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj25, (java.lang.Object) executorService27, strArray35);
        java.lang.Object[] objArray44 = org.apache.commons.lang3.ArrayUtils.nullToEmpty((java.lang.Object[]) strArray35);
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder45 = equalsBuilder1.append((java.lang.Object[]) strArray15, objArray44);
        // The following exception was thrown during execution in test generation
        try {
            int int46 = org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode((java.lang.Object) "/Users/glacierali", strArray15);
            org.junit.Assert.fail("Expected exception of type java.lang.reflect.InaccessibleObjectException; message: Unable to make field static final boolean java.lang.String.COMPACT_STRINGS accessible: module java.base does not \"opens java.lang\" to unnamed module @654b5005");
        } catch (java.lang.reflect.InaccessibleObjectException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(equalsBuilder4);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNotNull(strArray15);
        org.junit.Assert.assertEquals("'" + str20 + "' != '" + "" + "'", str20, "");
        org.junit.Assert.assertTrue("'" + int21 + "' != '" + (-1) + "'", int21 == (-1));
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(objArray24);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray24), "[581cd446]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray24), "[581cd446]");
        org.junit.Assert.assertNull(executorService27);
        org.junit.Assert.assertNotNull(strArray35);
        org.junit.Assert.assertEquals("'" + str40 + "' != '" + "" + "'", str40, "");
        org.junit.Assert.assertTrue("'" + int41 + "' != '" + (-1) + "'", int41 == (-1));
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        org.junit.Assert.assertNotNull(objArray44);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray44), "[581cd446]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray44), "[581cd446]");
        org.junit.Assert.assertNotNull(equalsBuilder45);
    }

    @Test
    public void test0795() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0795");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        float[] floatArray12 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(floatArray10);
        org.apache.commons.lang3.ArrayUtils.reverse(floatArray12);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[100.0, 0.0, 10.0, 10.0, 100.0, 32.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(floatArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray12), "[100.0, 0.0, 10.0, 10.0, 100.0, 32.0]");
    }

    @Test
    public void test0796() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0796");
        java.io.File file0 = org.apache.commons.lang3.SystemUtils.getJavaIoTmpDir();
        org.junit.Assert.assertNotNull(file0);
        org.junit.Assert.assertEquals(file0.getParent(), "/var/folders/hh/thrdkjsj7yn83kx4xl6753y40000gn");
        org.junit.Assert.assertEquals(file0.toString(), "/var/folders/hh/thrdkjsj7yn83kx4xl6753y40000gn/T");
    }

    @Test
    public void test0797() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0797");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.getHostName();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0798() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0798");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort1.setValue((java.lang.Number) (short) 100);
        long long4 = mutableShort1.longValue();
        org.apache.commons.lang3.mutable.MutableLong mutableLong5 = new org.apache.commons.lang3.mutable.MutableLong();
        short short6 = mutableShort1.getAndAdd((java.lang.Number) mutableLong5);
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 100L + "'", long4 == 100L);
        org.junit.Assert.assertTrue("'" + short6 + "' != '" + (short) 100 + "'", short6 == (short) 100);
    }

    @Test
    public void test0799() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0799");
        int[] intArray1 = new int[] { '\n' };
        java.util.BitSet bitSet4 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray1, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray1);
        int[] intArray6 = org.apache.commons.lang3.ArraySorter.sort(intArray1);
        int[] intArray7 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(intArray6);
        java.util.BitSet bitSet10 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray6, (-5), 17);
        org.junit.Assert.assertNotNull(intArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray1), "[10]");
        org.junit.Assert.assertNotNull(bitSet4);
        org.junit.Assert.assertEquals(bitSet4.toString(), "{}");
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray6), "[10]");
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray7), "[10]");
        org.junit.Assert.assertNotNull(bitSet10);
        org.junit.Assert.assertEquals(bitSet10.toString(), "{}");
    }

    @Test
    public void test0800() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0800");
        org.apache.commons.lang3.function.FailableIntToLongFunction<java.lang.Throwable> throwableFailableIntToLongFunction0 = org.apache.commons.lang3.function.FailableIntToLongFunction.nop();
        long long2 = throwableFailableIntToLongFunction0.applyAsLong((int) '4');
        org.junit.Assert.assertNotNull(throwableFailableIntToLongFunction0);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
    }

    @Test
    public void test0801() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0801");
        int int0 = org.apache.commons.lang3.time.FastDateFormat.MEDIUM;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test0802() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0802");
        java.lang.String str1 = org.apache.commons.lang3.ClassUtils.getShortClassName(";ClT9Ss'St<Q");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + ";ClT9Ss'St<Q" + "'", str1, ";ClT9Ss'St<Q");
    }

    @Test
    public void test0803() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0803");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.FILE_ENCODING;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "file.encoding" + "'", str0, "file.encoding");
    }

    @Test
    public void test0804() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0804");
        java.lang.String str5 = org.apache.commons.lang3.Conversion.byteToHex((byte) 1, 0, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]", (int) '$', (-27));
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]" + "'", str5, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
    }

    @Test
    public void test0805() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0805");
        java.util.stream.IntStream intStream6 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream8 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle9 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle10 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str11 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle9, toStringStyle10);
        java.lang.StringBuffer stringBuffer12 = null;
        java.lang.Object obj13 = null;
        standardToStringStyle9.appendStart(stringBuffer12, obj13);
        java.lang.String str15 = standardToStringStyle9.getNullText();
        standardToStringStyle9.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder19 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream6, (java.lang.AutoCloseable) intStream8, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle9, true);
        long[] longArray22 = new long[] { 3 };
        long[] longArray23 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray22);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray22);
        long[] longArray26 = new long[] { '4' };
        long[] longArray32 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet35 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray32, (long) '\n', 100);
        boolean boolean36 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray32);
        long[] longArray38 = org.apache.commons.lang3.ArrayUtils.add(longArray32, (long) (short) 101);
        boolean boolean39 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray26, longArray38);
        long[] longArray41 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray38, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder42 = autoCloseableDiffBuilder19.append("java.awt.headless", longArray22, longArray41);
        char[] charArray46 = new char[] { ' ', '#' };
        char[] charArray48 = new char[] { ' ' };
        char[] charArray49 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray46, charArray48);
        char[] charArray52 = org.apache.commons.lang3.ArrayUtils.add(charArray48, (int) (short) 0, ' ');
        char[] charArray55 = new char[] { ' ', '#' };
        char[] charArray57 = new char[] { ' ' };
        char[] charArray58 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray55, charArray57);
        char[] charArray61 = org.apache.commons.lang3.ArrayUtils.add(charArray57, (int) (short) 0, ' ');
        char[] charArray66 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray69 = org.apache.commons.lang3.ArrayUtils.subarray(charArray66, (int) (short) 1, (-1));
        char[] charArray70 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray57, charArray66);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder71 = autoCloseableDiffBuilder19.append("user.name", charArray52, charArray70);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str72 = org.apache.commons.lang3.RandomStringUtils.random(2, 6, 99, true, true, charArray52);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Index 61 out of bounds for length 2");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intStream6);
        org.junit.Assert.assertNotNull(intStream8);
        org.junit.Assert.assertNotNull(toStringStyle10);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str11, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "<null>" + "'", str15, "<null>");
        org.junit.Assert.assertNotNull(longArray22);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray22), "[3]");
        org.junit.Assert.assertNotNull(longArray23);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray23), "[3]");
        org.junit.Assert.assertNotNull(longArray26);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray26), "[52]");
        org.junit.Assert.assertNotNull(longArray32);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray32), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet35);
        org.junit.Assert.assertEquals(bitSet35.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(longArray38);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray38), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean39 + "' != '" + false + "'", boolean39 == false);
        org.junit.Assert.assertNotNull(longArray41);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray41), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder42);
        org.junit.Assert.assertNotNull(charArray46);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray46), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray46), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray46), "[ , #]");
        org.junit.Assert.assertNotNull(charArray48);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray48), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray48), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray48), "[ ]");
        org.junit.Assert.assertNotNull(charArray49);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray49), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray49), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray49), "[#]");
        org.junit.Assert.assertNotNull(charArray52);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray52), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray52), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray52), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray55);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray55), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray55), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray55), "[ , #]");
        org.junit.Assert.assertNotNull(charArray57);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray57), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray57), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray57), "[ ]");
        org.junit.Assert.assertNotNull(charArray58);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray58), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray58), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray58), "[#]");
        org.junit.Assert.assertNotNull(charArray61);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray61), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray61), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray61), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray66);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray66), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray66), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray66), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray69);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray69), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray69), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray69), "[]");
        org.junit.Assert.assertNotNull(charArray70);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray70), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray70), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray70), "[]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder71);
    }

    @Test
    public void test0806() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0806");
        java.lang.Byte[] byteArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
        org.junit.Assert.assertNotNull(byteArray0);
    }

    @Test
    public void test0807() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0807");
        org.apache.commons.lang3.text.StrMatcher strMatcher0 = org.apache.commons.lang3.text.StrMatcher.commaMatcher();
        org.junit.Assert.assertNotNull(strMatcher0);
    }

    @Test
    public void test0808() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0808");
        double[] doubleArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_DOUBLE_ARRAY;
        java.lang.Integer[] intArray4 = new java.lang.Integer[] { (-1), 1, 0 };
        int[] intArray6 = org.apache.commons.lang3.ArrayUtils.toPrimitive(intArray4, (int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            double[] doubleArray7 = org.apache.commons.lang3.ArrayUtils.removeAll(doubleArray0, intArray6);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 1, Length: 0");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(doubleArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray0), "[]");
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray6), "[-1, 1, 0]");
    }

    @Test
    public void test0809() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0809");
        java.lang.Object obj0 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer1 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService2 = multiBackgroundInitializer1.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle5 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer9 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray10 = strTokenizer9.getTokenArray();
        java.lang.String str11 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle5, strArray10);
        java.lang.String str15 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray10, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int16 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray10);
        boolean boolean17 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray10);
        boolean boolean18 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj0, (java.lang.Object) executorService2, strArray10);
        java.lang.Object[] objArray19 = org.apache.commons.lang3.ArrayUtils.nullToEmpty((java.lang.Object[]) strArray10);
        boolean boolean20 = org.apache.commons.lang3.ArrayUtils.isEmpty(objArray19);
        java.lang.Object obj21 = org.apache.commons.lang3.ArrayUtils.toPrimitive((java.lang.Object) objArray19);
        org.junit.Assert.assertNull(executorService2);
        org.junit.Assert.assertNotNull(strArray10);
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "" + "'", str15, "");
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertNotNull(objArray19);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray19), "[581cd446]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray19), "[581cd446]");
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertNotNull(obj21);
    }

    @Test
    public void test0810() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0810");
        java.lang.Iterable[] iterableArray1 = new java.lang.Iterable[0];
        @SuppressWarnings("unchecked")
        java.lang.Iterable<java.util.Locale>[] localeIterableArray2 = (java.lang.Iterable<java.util.Locale>[]) iterableArray1;
        java.util.Locale[] localeArray3 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList4 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean5 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList4, localeArray3);
        java.net.URL[] uRLArray7 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection8 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList4, "Integer", (java.lang.Object[]) uRLArray7);
        java.lang.Iterable<java.util.Locale>[] localeIterableArray9 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences((java.lang.Iterable<java.util.Locale>[]) iterableArray1, (java.lang.Iterable<java.util.Locale>) localeList4);
        org.junit.Assert.assertNotNull(iterableArray1);
        org.junit.Assert.assertNotNull(localeIterableArray2);
        org.junit.Assert.assertNotNull(localeArray3);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(uRLArray7);
        org.junit.Assert.assertNotNull(localeCollection8);
        org.junit.Assert.assertNotNull(localeIterableArray9);
    }

    @Test
    public void test0811() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0811");
        int int3 = org.apache.commons.lang3.StringUtils.lastIndexOfIgnoreCase((java.lang.CharSequence) "581cd446", (java.lang.CharSequence) ".]Wr1`~U#8P1RR^y~QA|^cKs1{%\\1T?5lK0:E`Sb.&C>Ti|7U`_rdX-~ezvoa,]'Y`!G4\"%H.wF)`\",%`~,Oq)sru73.75Tg2", 3);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test0812() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0812");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        java.lang.String str12 = org.apache.commons.lang3.StringUtils.join(charArray8, '\n', 17, (int) (byte) 1);
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray2), "[ , #]");
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[ ]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[#]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ ,  ]");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "" + "'", str12, "");
    }

    @Test
    public void test0813() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0813");
        java.util.function.Predicate<java.lang.Thread> threadPredicate0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Collection<java.lang.Thread> threadCollection1 = org.apache.commons.lang3.ThreadUtils.findThreads(threadPredicate0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: The predicate must not be null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0814() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0814");
        org.apache.commons.lang3.Validate.notNaN((double) (-1L));
    }

    @Test
    public void test0815() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0815");
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator2 = org.apache.commons.lang3.StringEscapeUtils.ESCAPE_HTML3;
        // The following exception was thrown during execution in test generation
        try {
            int int3 = org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode((int) (byte) -1, 2, (java.lang.Object) charSequenceTranslator2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: HashCodeBuilder requires an odd multiplier");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charSequenceTranslator2);
    }

    @Test
    public void test0816() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0816");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper0 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper1 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper2 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper3 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper4 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper5 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper6 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray7 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper1, unicodeUnescaper2, unicodeUnescaper3, unicodeUnescaper4, unicodeUnescaper5, unicodeUnescaper6 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator8 = unicodeUnescaper0.with(charSequenceTranslatorArray7);
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper9 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper10 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper11 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper12 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper13 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper14 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper15 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray16 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper10, unicodeUnescaper11, unicodeUnescaper12, unicodeUnescaper13, unicodeUnescaper14, unicodeUnescaper15 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator17 = unicodeUnescaper9.with(charSequenceTranslatorArray16);
        java.lang.String str19 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) charSequenceTranslatorArray16, ' ');
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator20 = charSequenceTranslator8.with(charSequenceTranslatorArray16);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray7);
        org.junit.Assert.assertNotNull(charSequenceTranslator8);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray16);
        org.junit.Assert.assertNotNull(charSequenceTranslator17);
        org.junit.Assert.assertNotNull(charSequenceTranslator20);
    }

    @Test
    public void test0817() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0817");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getUserDir();
// flaky:         org.junit.Assert.assertEquals("'" + str0 + "' != '" + "/Users/glacierali/randoop-4.3.2" + "'", str0, "/Users/glacierali/randoop-4.3.2");
    }

    @Test
    public void test0818() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0818");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.TWO_THIRDS;
        int int1 = fraction0.getNumerator();
        org.junit.Assert.assertNotNull(fraction0);
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 2 + "'", int1 == 2);
    }

    @Test
    public void test0819() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0819");
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.exception.ContextedException contextedException2 = new org.apache.commons.lang3.exception.ContextedException("java.vm.version", throwable1);
    }

    @Test
    public void test0820() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0820");
        java.lang.Long[] longArray6 = new java.lang.Long[] { 10L, 0L, (-1L), (-1L), 10L, 1L };
        java.lang.Long[] longArray7 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray6);
        java.net.URL[] uRLArray8 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.isSameLength((java.lang.Object[]) longArray6, (java.lang.Object[]) uRLArray8);
        java.lang.Long[] longArray10 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray6);
        boolean boolean11 = org.apache.commons.lang3.ObjectUtils.allNotNull((java.lang.Object[]) longArray6);
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertNotNull(longArray7);
        org.junit.Assert.assertNotNull(uRLArray8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(longArray10);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test0821() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0821");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper0 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper1 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper2 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper3 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper4 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper5 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper6 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray7 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper1, unicodeUnescaper2, unicodeUnescaper3, unicodeUnescaper4, unicodeUnescaper5, unicodeUnescaper6 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator8 = unicodeUnescaper0.with(charSequenceTranslatorArray7);
        java.io.Writer writer10 = null;
        // The following exception was thrown during execution in test generation
        try {
            unicodeUnescaper0.translate((java.lang.CharSequence) "UnicodeUnescaper", writer10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: writer");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray7);
        org.junit.Assert.assertNotNull(charSequenceTranslator8);
    }

    @Test
    public void test0822() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0822");
        java.lang.Class<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierClass0 = null;
        boolean boolean1 = org.apache.commons.lang3.AnnotationUtils.isValidAnnotationMemberType(multiBackgroundInitializerResultsFailableSupplierClass0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0823() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0823");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaCompiler();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0824() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0824");
        java.lang.reflect.Field field0 = null;
        short[] shortArray3 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray3, (int) (byte) -1, 1, (int) (byte) 10);
        short[] shortArray8 = org.apache.commons.lang3.ArraySorter.sort(shortArray3);
        java.lang.String str12 = org.apache.commons.lang3.StringUtils.join(shortArray8, '$', (int) (short) 0, (int) (byte) -1);
        java.lang.Object obj13 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.reflect.FieldUtils.writeField(field0, (java.lang.Object) shortArray8, obj13, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: field");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(shortArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray3), "[100, 100]");
        org.junit.Assert.assertNotNull(shortArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray8), "[100, 100]");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "" + "'", str12, "");
    }

    @Test
    public void test0825() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0825");
        double[] doubleArray4 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray8 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray8, (double) '4');
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray4, doubleArray8);
        double[] doubleArray12 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(doubleArray8);
        double[] doubleArray13 = org.apache.commons.lang3.ArrayUtils.clone(doubleArray12);
        boolean boolean16 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray13, (double) (byte) 100, (double) (byte) 100);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray4), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray8), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(doubleArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray12), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertNotNull(doubleArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray13), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test0826() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0826");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper0 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper1 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper2 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper3 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper4 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper5 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper6 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray7 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper1, unicodeUnescaper2, unicodeUnescaper3, unicodeUnescaper4, unicodeUnescaper5, unicodeUnescaper6 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator8 = unicodeUnescaper0.with(charSequenceTranslatorArray7);
        java.lang.String str10 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) charSequenceTranslatorArray7, ' ');
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper12 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper13 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper14 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper15 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper16 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper17 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper18 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray19 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper13, unicodeUnescaper14, unicodeUnescaper15, unicodeUnescaper16, unicodeUnescaper17, unicodeUnescaper18 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator20 = unicodeUnescaper12.with(charSequenceTranslatorArray19);
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray21 = org.apache.commons.lang3.ArrayUtils.add(charSequenceTranslatorArray7, 2, (org.apache.commons.lang3.text.translate.CharSequenceTranslator) unicodeUnescaper12);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray7);
        org.junit.Assert.assertNotNull(charSequenceTranslator8);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray19);
        org.junit.Assert.assertNotNull(charSequenceTranslator20);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray21);
    }

    @Test
    public void test0827() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0827");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.trimToEmpty("}");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "}" + "'", str1, "}");
    }

    @Test
    public void test0828() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0828");
        int int3 = org.apache.commons.lang3.StringUtils.lastIndexOfIgnoreCase((java.lang.CharSequence) "Integer", (java.lang.CharSequence) "on", 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test0829() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0829");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.TWO_THIRDS;
        org.apache.commons.lang3.math.Fraction fraction3 = org.apache.commons.lang3.math.Fraction.getFraction((int) (short) 1, (int) (short) 1);
        int int4 = fraction0.compareTo(fraction3);
        org.apache.commons.lang3.math.Fraction fraction7 = org.apache.commons.lang3.math.Fraction.getFraction((int) (short) 1, (int) (short) 1);
        java.util.Comparator<org.apache.commons.lang3.math.Fraction> fractionComparator8 = null;
        org.apache.commons.lang3.NumberRange<org.apache.commons.lang3.math.Fraction> fractionNumberRange9 = new org.apache.commons.lang3.NumberRange<org.apache.commons.lang3.math.Fraction>(fraction0, fraction7, fractionComparator8);
        org.apache.commons.lang3.math.Fraction fraction10 = fraction0.negate();
        org.junit.Assert.assertNotNull(fraction0);
        org.junit.Assert.assertNotNull(fraction3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + (-1) + "'", int4 == (-1));
        org.junit.Assert.assertNotNull(fraction7);
        org.junit.Assert.assertNotNull(fraction10);
    }

    @Test
    public void test0830() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0830");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = org.apache.commons.lang3.RandomStringUtils.random((int) (short) 99, 6, 4, true, true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Parameter end (4) must be greater than start (6)");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0831() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0831");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isAsciiPrintable((java.lang.CharSequence) "Europe/Stockholm");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0832() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0832");
        byte[] byteArray0 = new byte[] {};
        org.apache.commons.lang3.ArrayUtils.shift(byteArray0, (int) (short) 101);
        org.junit.Assert.assertNotNull(byteArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray0), "[]");
    }

    @Test
    public void test0833() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0833");
        boolean boolean1 = org.apache.commons.lang3.BooleanUtils.toBoolean((int) (byte) 1);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0834() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0834");
        java.util.stream.IntStream intStream1 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream3 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle4 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle5 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str6 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle4, toStringStyle5);
        java.lang.StringBuffer stringBuffer7 = null;
        java.lang.Object obj8 = null;
        standardToStringStyle4.appendStart(stringBuffer7, obj8);
        java.lang.String str10 = standardToStringStyle4.getNullText();
        standardToStringStyle4.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder14 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream1, (java.lang.AutoCloseable) intStream3, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle4, true);
        long[] longArray17 = new long[] { 3 };
        long[] longArray18 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray17);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray17);
        long[] longArray21 = new long[] { '4' };
        long[] longArray27 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet30 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray27, (long) '\n', 100);
        boolean boolean31 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray27);
        long[] longArray33 = org.apache.commons.lang3.ArrayUtils.add(longArray27, (long) (short) 101);
        boolean boolean34 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray21, longArray33);
        long[] longArray36 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray33, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder37 = autoCloseableDiffBuilder14.append("java.awt.headless", longArray17, longArray36);
        long[] longArray39 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray17, 0L);
        org.junit.Assert.assertNotNull(intStream1);
        org.junit.Assert.assertNotNull(intStream3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
        org.junit.Assert.assertNotNull(longArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray17), "[3]");
        org.junit.Assert.assertNotNull(longArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray18), "[3]");
        org.junit.Assert.assertNotNull(longArray21);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray21), "[52]");
        org.junit.Assert.assertNotNull(longArray27);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray27), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet30);
        org.junit.Assert.assertEquals(bitSet30.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
        org.junit.Assert.assertNotNull(longArray33);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray33), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(longArray36);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray36), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder37);
        org.junit.Assert.assertNotNull(longArray39);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray39), "[0, 3]");
    }

    @Test
    public void test0835() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0835");
        org.apache.commons.lang3.stream.Streams streams0 = new org.apache.commons.lang3.stream.Streams();
    }

    @Test
    public void test0836() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0836");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        org.apache.commons.lang3.ArrayUtils.shift(floatArray10, (int) (byte) -1);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[100.0, 10.0, 10.0, 0.0, 100.0, 32.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test0837() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0837");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer0 = org.apache.commons.lang3.text.StrTokenizer.getTSVInstance();
        org.junit.Assert.assertNotNull(strTokenizer0);
    }

    @Test
    public void test0838() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0838");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.time.Duration duration2 = org.apache.commons.lang3.time.DurationUtils.toDuration((long) 0, timeUnit1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0839() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0839");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_DATE_FORMAT;
        java.lang.String str1 = fastDateFormat0.toString();
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "FastDateFormat[yyyy-MM-dd,en_SE,Europe/Stockholm]" + "'", str1, "FastDateFormat[yyyy-MM-dd,en_SE,Europe/Stockholm]");
    }

    @Test
    public void test0840() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0840");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray1 = charSequenceArrayImmutablePair0.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair2 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0);
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair3 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray4 = charSequenceArrayImmutablePair3.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair5 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair3);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayMutablePairRange6 = org.apache.commons.lang3.Range.between(charSequenceArrayMutablePair2, charSequenceArrayMutablePair5);
        java.lang.CharSequence[] charSequenceArray7 = charSequenceArrayMutablePair2.left;
        java.util.Locale[] localeArray8 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList9 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean10 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList9, localeArray8);
        java.net.URL[] uRLArray12 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection13 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList9, "Integer", (java.lang.Object[]) uRLArray12);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream14 = org.apache.commons.lang3.stream.Streams.failableStream((java.util.Collection<java.util.Locale>) localeList9);
        java.util.Locale[] localeArray15 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList16 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean17 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList16, localeArray15);
        java.net.URL[] uRLArray19 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection20 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList16, "Integer", (java.lang.Object[]) uRLArray19);
        java.util.Locale[] localeArray21 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList22 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean23 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList22, localeArray21);
        java.net.URL[] uRLArray25 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection26 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList22, "Integer", (java.lang.Object[]) uRLArray25);
        java.util.Locale[] localeArray27 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList28 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean29 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList28, localeArray27);
        java.net.URL[] uRLArray31 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection32 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList28, "Integer", (java.lang.Object[]) uRLArray31);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream33 = org.apache.commons.lang3.stream.Streams.failableStream((java.util.Collection<java.util.Locale>) localeList28);
        java.util.RandomAccess[] randomAccessArray34 = new java.util.RandomAccess[] { localeList9, localeList16, localeList22, localeList28 };
        java.util.Locale[] localeArray35 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList36 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean37 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList36, localeArray35);
        java.net.URL[] uRLArray39 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection40 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList36, "Integer", (java.lang.Object[]) uRLArray39);
        java.util.RandomAccess[] randomAccessArray41 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(randomAccessArray34, (java.util.RandomAccess) localeList36);
        charSequenceArrayMutablePair2.setRight((java.util.AbstractCollection<java.util.Locale>) localeList36);
        java.util.Locale[] localeArray43 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList44 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean45 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList44, localeArray43);
        java.net.URL[] uRLArray47 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection48 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList44, "Integer", (java.lang.Object[]) uRLArray47);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream49 = org.apache.commons.lang3.stream.Streams.failableStream((java.util.Collection<java.util.Locale>) localeList44);
        java.util.Locale[] localeArray50 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList51 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean52 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList51, localeArray50);
        java.net.URL[] uRLArray54 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection55 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList51, "Integer", (java.lang.Object[]) uRLArray54);
        java.util.AbstractList[] abstractListArray57 = new java.util.AbstractList[3];
        @SuppressWarnings("unchecked")
        java.util.AbstractList<java.util.Locale>[] localeListArray58 = (java.util.AbstractList<java.util.Locale>[]) abstractListArray57;
        localeListArray58[0] = localeList36;
        localeListArray58[1] = localeList44;
        localeListArray58[2] = localeList51;
        java.util.AbstractList<java.util.Locale>[] localeListArray65 = org.apache.commons.lang3.ArrayUtils.toArray(localeListArray58);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(charSequenceArray1);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair2);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair3);
        org.junit.Assert.assertNull(charSequenceArray4);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair5);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePairRange6);
        org.junit.Assert.assertNull(charSequenceArray7);
        org.junit.Assert.assertNotNull(localeArray8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(uRLArray12);
        org.junit.Assert.assertNotNull(localeCollection13);
        org.junit.Assert.assertNotNull(localeFailableStream14);
        org.junit.Assert.assertNotNull(localeArray15);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(uRLArray19);
        org.junit.Assert.assertNotNull(localeCollection20);
        org.junit.Assert.assertNotNull(localeArray21);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(uRLArray25);
        org.junit.Assert.assertNotNull(localeCollection26);
        org.junit.Assert.assertNotNull(localeArray27);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + false + "'", boolean29 == false);
        org.junit.Assert.assertNotNull(uRLArray31);
        org.junit.Assert.assertNotNull(localeCollection32);
        org.junit.Assert.assertNotNull(localeFailableStream33);
        org.junit.Assert.assertNotNull(randomAccessArray34);
        org.junit.Assert.assertNotNull(localeArray35);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(uRLArray39);
        org.junit.Assert.assertNotNull(localeCollection40);
        org.junit.Assert.assertNotNull(randomAccessArray41);
        org.junit.Assert.assertNotNull(localeArray43);
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + false + "'", boolean45 == false);
        org.junit.Assert.assertNotNull(uRLArray47);
        org.junit.Assert.assertNotNull(localeCollection48);
        org.junit.Assert.assertNotNull(localeFailableStream49);
        org.junit.Assert.assertNotNull(localeArray50);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertNotNull(uRLArray54);
        org.junit.Assert.assertNotNull(localeCollection55);
        org.junit.Assert.assertNotNull(abstractListArray57);
        org.junit.Assert.assertNotNull(localeListArray58);
        org.junit.Assert.assertNotNull(localeListArray65);
    }

    @Test
    public void test0841() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0841");
        long[] longArray5 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray5, (long) '\n', 100);
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray5);
        long[] longArray11 = org.apache.commons.lang3.ArrayUtils.add(longArray5, (long) (short) 101);
        java.lang.String str13 = org.apache.commons.lang3.StringUtils.join(longArray5, '$');
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray5), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(longArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray11), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "10$100$100$97$52" + "'", str13, "10$100$100$97$52");
    }

    @Test
    public void test0842() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0842");
        boolean boolean1 = org.apache.commons.lang3.BooleanUtils.toBoolean("java.specification.version");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0843() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0843");
        org.apache.commons.lang3.function.FailableToDoubleFunction failableToDoubleFunction0 = org.apache.commons.lang3.function.FailableToDoubleFunction.NOP;
        org.junit.Assert.assertNotNull(failableToDoubleFunction0);
    }

    @Test
    public void test0844() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0844");
        java.util.TimeZone timeZone1 = org.apache.commons.lang3.time.FastTimeZone.getGmtTimeZone();
        java.util.Locale locale2 = null;
        java.util.Locale locale3 = org.apache.commons.lang3.LocaleUtils.toLocale(locale2);
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat4 = org.apache.commons.lang3.time.FastDateFormat.getTimeInstance(0, timeZone1, locale2);
        java.util.Locale locale6 = null;
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat7 = org.apache.commons.lang3.time.FastDateFormat.getInstance("", locale6);
        java.text.ParsePosition parsePosition9 = null;
        java.lang.Object obj10 = fastDateFormat7.parseObject("open", parsePosition9);
        java.lang.String str11 = fastDateFormat7.toString();
        java.lang.String str12 = fastDateFormat7.getPattern();
        org.apache.commons.lang3.text.CompositeFormat compositeFormat13 = new org.apache.commons.lang3.text.CompositeFormat((java.text.Format) fastDateFormat4, (java.text.Format) fastDateFormat7);
        java.lang.String str15 = fastDateFormat4.format((long) ' ');
        org.junit.Assert.assertNotNull(timeZone1);
        org.junit.Assert.assertEquals(timeZone1.getDisplayName(), "GMT+00:00");
        org.junit.Assert.assertNotNull(locale3);
        org.junit.Assert.assertEquals(locale3.toString(), "en_SE");
        org.junit.Assert.assertNotNull(fastDateFormat4);
        org.junit.Assert.assertNotNull(fastDateFormat7);
        org.junit.Assert.assertNotNull(obj10);
        org.junit.Assert.assertEquals(obj10.toString(), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj10), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj10), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "FastDateFormat[,en_SE,Europe/Stockholm]" + "'", str11, "FastDateFormat[,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "" + "'", str12, "");
        org.junit.Assert.assertEquals("'" + str15 + "' != '" + "00:00:00 GMT+00:00" + "'", str15, "00:00:00 GMT+00:00");
    }

    @Test
    public void test0845() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0845");
        short[] shortArray2 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray2, (int) (byte) -1, 1, (int) (byte) 10);
        short[] shortArray10 = new short[] { (short) 1, (short) -1, (byte) 10 };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSorted(shortArray10);
        boolean boolean12 = org.apache.commons.lang3.ArrayUtils.isSameLength(shortArray2, shortArray10);
        // The following exception was thrown during execution in test generation
        try {
            short[] shortArray15 = org.apache.commons.lang3.ArrayUtils.add(shortArray10, 99, (short) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 99, Length: 3");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(shortArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray2), "[100, 100]");
        org.junit.Assert.assertNotNull(shortArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray10), "[1, -1, 10]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test0846() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0846");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        float[] floatArray13 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(floatArray10, (-1.0f));
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj16 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) floatArray10, false, "java.specification.version");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: java.specification.version() on object: [F");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(floatArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray13), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
    }

    @Test
    public void test0847() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0847");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray4 = strTokenizer3.getTokenArray();
        boolean boolean5 = strTokenizer3.isEmptyTokenAsNull();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer7 = strTokenizer3.setIgnoredChar('\n');
        org.apache.commons.lang3.text.StrMatcher strMatcher8 = org.apache.commons.lang3.text.StrSubstitutor.DEFAULT_PREFIX;
        org.apache.commons.lang3.text.StrTokenizer strTokenizer9 = strTokenizer3.setTrimmerMatcher(strMatcher8);
        java.lang.String str10 = strTokenizer3.toString();
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(strTokenizer7);
        org.junit.Assert.assertNotNull(strMatcher8);
        org.junit.Assert.assertNotNull(strTokenizer9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "StrTokenizer[581cd446]" + "'", str10, "StrTokenizer[581cd446]");
    }

    @Test
    public void test0848() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0848");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer9 = org.apache.commons.lang3.text.StrTokenizer.getTSVInstance(charArray8);
        org.apache.commons.lang3.text.StrTokenizer strTokenizer11 = strTokenizer9.reset("line.separator");
        int int12 = strTokenizer9.nextIndex();
        java.lang.String str13 = strTokenizer9.getContent();
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray2), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray2), "[ , #]");
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[ ]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[#]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ ,  ]");
        org.junit.Assert.assertNotNull(strTokenizer9);
        org.junit.Assert.assertNotNull(strTokenizer11);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "line.separator" + "'", str13, "line.separator");
    }

    @Test
    public void test0849() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0849");
        org.apache.commons.lang3.math.Fraction fraction2 = org.apache.commons.lang3.math.Fraction.getFraction((int) (short) 10, (int) '4');
        org.junit.Assert.assertNotNull(fraction2);
    }

    @Test
    public void test0850() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0850");
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion2 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange3 = org.apache.commons.lang3.Range.of(javaVersion1, javaVersion2);
        boolean boolean4 = javaVersionRange3.isNaturalOrdering();
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat5 = org.apache.commons.lang3.time.DateFormatUtils.SMTP_DATETIME_FORMAT;
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate6 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        boolean boolean8 = throwableFailableLongPredicate6.test((long) (byte) 100);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate9 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate10 = throwableFailableLongPredicate6.or(throwableFailableLongPredicate9);
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces11 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces12 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces13 = org.apache.commons.lang3.compare.ComparableUtils.min(interfaces11, interfaces12);
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces14 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces15 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces16 = org.apache.commons.lang3.compare.ComparableUtils.min(interfaces14, interfaces15);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.ClassUtils.Interfaces> interfacesRange17 = org.apache.commons.lang3.Range.of(interfaces13, interfaces14);
        org.apache.commons.lang3.compare.ObjectToStringComparator objectToStringComparator18 = new org.apache.commons.lang3.compare.ObjectToStringComparator();
        org.apache.commons.lang3.Range<java.lang.Object> objRange19 = org.apache.commons.lang3.Range.of((java.lang.Object) throwableFailableLongPredicate6, (java.lang.Object) interfacesRange17, (java.util.Comparator<java.lang.Object>) objectToStringComparator18);
        org.apache.commons.lang3.Range<java.lang.Object> objRange20 = org.apache.commons.lang3.Range.is((java.lang.Object) fastDateFormat5, (java.util.Comparator<java.lang.Object>) objectToStringComparator18);
        org.apache.commons.lang3.Range<java.lang.Object> objRange21 = org.apache.commons.lang3.Range.of((java.lang.Object) "16.0.1", (java.lang.Object) boolean4, (java.util.Comparator<java.lang.Object>) objectToStringComparator18);
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion2 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion2.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(fastDateFormat5);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate6);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate9);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate10);
        org.junit.Assert.assertTrue("'" + interfaces11 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces11.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces12 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces12.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces13 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces13.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces14 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces14.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces15 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces15.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces16 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces16.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertNotNull(interfacesRange17);
        org.junit.Assert.assertNotNull(objRange19);
        org.junit.Assert.assertNotNull(objRange20);
        org.junit.Assert.assertNotNull(objRange21);
    }

    @Test
    public void test0851() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0851");
        java.util.List<java.util.Locale> localeList0 = org.apache.commons.lang3.LocaleUtils.availableLocaleList();
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream1 = org.apache.commons.lang3.Streams.stream((java.util.Collection<java.util.Locale>) localeList0);
        java.util.stream.Stream<java.util.Locale> localeStream2 = org.apache.commons.lang3.stream.Streams.of((java.lang.Iterable<java.util.Locale>) localeList0);
        java.util.stream.Stream<java.util.Locale> localeStream3 = org.apache.commons.lang3.stream.Streams.nonNull(localeStream2);
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream4 = org.apache.commons.lang3.Functions.stream(localeStream3);
        org.apache.commons.lang3.function.FailableLongFunction<org.apache.commons.lang3.time.FastDateFormat, java.lang.Throwable> fastDateFormatFailableLongFunction5 = org.apache.commons.lang3.function.FailableLongFunction.nop();
        java.lang.String[] strArray12 = new java.lang.String[] { "java.lang", "                                                                                                open", "60.0", "16.0.1", ":", "Integer" };
        org.apache.commons.lang3.CharSet charSet13 = org.apache.commons.lang3.CharSet.getInstance(strArray12);
        org.apache.commons.lang3.tuple.Triple<java.lang.AutoCloseable, org.apache.commons.lang3.function.FailableLongFunction<org.apache.commons.lang3.time.FastDateFormat, java.lang.Throwable>, java.lang.String[]> autoCloseableTriple14 = org.apache.commons.lang3.tuple.Triple.ofNonNull((java.lang.AutoCloseable) localeStream3, fastDateFormatFailableLongFunction5, strArray12);
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat16 = fastDateFormatFailableLongFunction5.apply((long) 97);
        org.junit.Assert.assertNotNull(localeList0);
        org.junit.Assert.assertNotNull(localeFailableStream1);
        org.junit.Assert.assertNotNull(localeStream2);
        org.junit.Assert.assertNotNull(localeStream3);
        org.junit.Assert.assertNotNull(localeFailableStream4);
        org.junit.Assert.assertNotNull(fastDateFormatFailableLongFunction5);
        org.junit.Assert.assertNotNull(strArray12);
        org.junit.Assert.assertNotNull(charSet13);
        org.junit.Assert.assertNotNull(autoCloseableTriple14);
        org.junit.Assert.assertNull(fastDateFormat16);
    }

    @Test
    public void test0852() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0852");
        org.apache.commons.lang3.function.FailablePredicate failablePredicate0 = org.apache.commons.lang3.function.FailablePredicate.TRUE;
        org.junit.Assert.assertNotNull(failablePredicate0);
    }

    @Test
    public void test0853() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0853");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayFill.fill(byteArray2, (byte) 0);
        int int7 = org.apache.commons.lang3.ArrayUtils.lastIndexOf(byteArray5, (byte) 100);
        org.apache.commons.lang3.ArrayUtils.swap(byteArray5, 97, (int) ' ', (int) (short) -1);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[0, 0]");
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
    }

    @Test
    public void test0854() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0854");
        java.lang.String str1 = org.apache.commons.lang3.CharUtils.toString('4');
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "4" + "'", str1, "4");
    }

    @Test
    public void test0855() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0855");
        java.time.Duration duration0 = null;
        int int1 = org.apache.commons.lang3.time.DurationUtils.getNanosOfMilli(duration0);
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test0856() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0856");
        long[] longArray1 = new long[] { 3 };
        long[] longArray2 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray1);
        long[] longArray4 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray1, (long) 10);
        long[] longArray6 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray1, (long) '4');
        org.junit.Assert.assertNotNull(longArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray1), "[3]");
        org.junit.Assert.assertNotNull(longArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray2), "[3]");
        org.junit.Assert.assertNotNull(longArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray4), "[10, 3]");
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray6), "[52, 3]");
    }

    @Test
    public void test0857() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0857");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_DATE_FORMAT;
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat1 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        java.lang.String str2 = fastDateFormat1.toString();
        int int3 = fastDateFormat1.getMaxLengthEstimate();
        org.apache.commons.lang3.text.CompositeFormat compositeFormat4 = new org.apache.commons.lang3.text.CompositeFormat((java.text.Format) fastDateFormat0, (java.text.Format) fastDateFormat1);
        java.util.TimeZone timeZone5 = fastDateFormat0.getTimeZone();
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertNotNull(fastDateFormat1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]" + "'", str2, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 8 + "'", int3 == 8);
        org.junit.Assert.assertNotNull(timeZone5);
        org.junit.Assert.assertEquals(timeZone5.getDisplayName(), "Central European Standard Time");
    }

    @Test
    public void test0858() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0858");
        java.lang.String str4 = org.apache.commons.lang3.StringUtils.abbreviate("", "/Users/glacierali", (int) (short) 10, (int) (byte) 10);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test0859() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0859");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.swapCase("00:00:00 GMT+00:00");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "00:00:00 gmt+00:00" + "'", str1, "00:00:00 gmt+00:00");
    }

    @Test
    public void test0860() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0860");
        java.lang.String str0 = org.apache.commons.lang3.BooleanUtils.ON;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "on" + "'", str0, "on");
    }

    @Test
    public void test0861() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0861");
        java.util.Calendar calendar0 = null;
        java.util.Calendar calendar1 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = org.apache.commons.lang3.time.DateUtils.truncatedEquals(calendar0, calendar1, (-5));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0862() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0862");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.substringAfterLast("6f51daee", 100);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "aee" + "'", str2, "aee");
    }

    @Test
    public void test0863() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0863");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        boolean[] booleanArray17 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray19 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray17, false);
        java.util.BitSet bitSet21 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray17, true);
        boolean[] booleanArray22 = org.apache.commons.lang3.ArrayUtils.removeElements(booleanArray11, booleanArray17);
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray25 = org.apache.commons.lang3.ArrayUtils.add(booleanArray22, (int) '#', false);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 35, Length: 1");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet9);
        org.junit.Assert.assertEquals(bitSet9.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(booleanArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray11), "[false, true, false, true, false, true]");
        org.junit.Assert.assertNotNull(booleanArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray17), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray19);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray19), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet21);
        org.junit.Assert.assertEquals(bitSet21.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(booleanArray22);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray22), "[true]");
    }

    @Test
    public void test0864() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0864");
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate0 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        boolean boolean2 = throwableFailableLongPredicate0.test((long) (byte) 100);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate3 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        boolean boolean5 = throwableFailableLongPredicate3.test((long) (byte) 100);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate6 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate7 = throwableFailableLongPredicate3.or(throwableFailableLongPredicate6);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate8 = throwableFailableLongPredicate0.or(throwableFailableLongPredicate6);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate3);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate6);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate7);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate8);
    }

    @Test
    public void test0865() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0865");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange2 = org.apache.commons.lang3.Range.of(javaVersion0, javaVersion1);
        char[] charArray5 = new char[] { ' ', '#' };
        char[] charArray7 = new char[] { ' ' };
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray5, charArray7);
        boolean boolean9 = javaVersionRange2.equals((java.lang.Object) charArray8);
        org.apache.commons.lang3.JavaVersion javaVersion10 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion11 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange12 = org.apache.commons.lang3.Range.of(javaVersion10, javaVersion11);
        boolean boolean13 = javaVersionRange2.isEndedBy(javaVersion11);
        org.apache.commons.lang3.JavaVersion javaVersion14 = org.apache.commons.lang3.JavaVersion.JAVA_1_1;
        boolean boolean15 = javaVersionRange2.contains(javaVersion14);
        org.apache.commons.lang3.JavaVersion javaVersion16 = org.apache.commons.lang3.JavaVersion.JAVA_10;
        boolean boolean17 = javaVersionRange2.contains(javaVersion16);
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange2);
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[ , #]");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray7), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray7), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray7), "[ ]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[#]");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + javaVersion10 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion10.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion11 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion11.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertTrue("'" + javaVersion14 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_1_1 + "'", javaVersion14.equals(org.apache.commons.lang3.JavaVersion.JAVA_1_1));
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + javaVersion16 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_10 + "'", javaVersion16.equals(org.apache.commons.lang3.JavaVersion.JAVA_10));
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test0866() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0866");
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext0 = new org.apache.commons.lang3.exception.DefaultExceptionContext();
        java.util.List<org.apache.commons.lang3.tuple.Pair<java.lang.String, java.lang.Object>> strPairList1 = defaultExceptionContext0.getContextEntries();
        java.util.List<org.apache.commons.lang3.tuple.Pair<java.lang.String, java.lang.Object>> strPairList2 = defaultExceptionContext0.getContextEntries();
        org.junit.Assert.assertNotNull(strPairList1);
        org.junit.Assert.assertNotNull(strPairList2);
    }

    @Test
    public void test0867() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0867");
        boolean boolean1 = org.apache.commons.lang3.math.NumberUtils.isParsable("java.vm.version");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0868() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0868");
        boolean boolean1 = org.apache.commons.lang3.CharUtils.isAsciiAlphanumeric('a');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0869() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0869");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getUserHome();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "/Users/glacierali" + "'", str0, "/Users/glacierali");
    }

    @Test
    public void test0870() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0870");
        java.lang.Byte[] byteArray2 = new java.lang.Byte[] {};
        byte[] byteArray4 = org.apache.commons.lang3.ArrayUtils.toPrimitive(byteArray2, (byte) 10);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.toPrimitive(byteArray2);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray8 = org.apache.commons.lang3.Conversion.shortToByteArray((short) 101, (int) '4', byteArray5, (int) '$', 4);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nBytes-1)*8+srcPos is greater or equal to than 16");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray4), "[]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[]");
    }

    @Test
    public void test0871() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0871");
        java.lang.Byte[] byteArray0 = new java.lang.Byte[] {};
        byte[] byteArray1 = org.apache.commons.lang3.ArrayUtils.toPrimitive(byteArray0);
        byte[] byteArray2 = org.apache.commons.lang3.ArraySorter.sort(byteArray1);
        // The following exception was thrown during execution in test generation
        try {
            int int7 = org.apache.commons.lang3.Conversion.byteArrayToInt(byteArray1, 100, (int) '\r', (int) (short) 99, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nBytes-1)*8+dstPos is greater or equal to than 32");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray0);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray1), "[]");
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[]");
    }

    @Test
    public void test0872() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0872");
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer1 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer2 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer3 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer4 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer5 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer6 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer[] atomicSafeInitializerArray8 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer[6];
        @SuppressWarnings("unchecked")
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>[] toStringStyleAtomicSafeInitializerArray9 = (org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>[]) atomicSafeInitializerArray8;
        toStringStyleAtomicSafeInitializerArray9[0] = toStringStyleAtomicSafeInitializer1;
        toStringStyleAtomicSafeInitializerArray9[1] = toStringStyleAtomicSafeInitializer2;
        toStringStyleAtomicSafeInitializerArray9[2] = toStringStyleAtomicSafeInitializer3;
        toStringStyleAtomicSafeInitializerArray9[3] = toStringStyleAtomicSafeInitializer4;
        toStringStyleAtomicSafeInitializerArray9[4] = toStringStyleAtomicSafeInitializer5;
        toStringStyleAtomicSafeInitializerArray9[5] = toStringStyleAtomicSafeInitializer6;
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer22 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer23 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer24 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer25 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer26 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer[] atomicSafeInitializerArray28 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer[5];
        @SuppressWarnings("unchecked")
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>[] toStringStyleAtomicSafeInitializerArray29 = (org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>[]) atomicSafeInitializerArray28;
        toStringStyleAtomicSafeInitializerArray29[0] = toStringStyleAtomicSafeInitializer22;
        toStringStyleAtomicSafeInitializerArray29[1] = toStringStyleAtomicSafeInitializer23;
        toStringStyleAtomicSafeInitializerArray29[2] = toStringStyleAtomicSafeInitializer24;
        toStringStyleAtomicSafeInitializerArray29[3] = toStringStyleAtomicSafeInitializer25;
        toStringStyleAtomicSafeInitializerArray29[4] = toStringStyleAtomicSafeInitializer26;
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>[] toStringStyleAtomicSafeInitializerArray40 = org.apache.commons.lang3.ArrayUtils.insert(3, toStringStyleAtomicSafeInitializerArray9, toStringStyleAtomicSafeInitializerArray29);
        org.junit.Assert.assertNotNull(atomicSafeInitializerArray8);
        org.junit.Assert.assertNotNull(toStringStyleAtomicSafeInitializerArray9);
        org.junit.Assert.assertNotNull(atomicSafeInitializerArray28);
        org.junit.Assert.assertNotNull(toStringStyleAtomicSafeInitializerArray29);
        org.junit.Assert.assertNotNull(toStringStyleAtomicSafeInitializerArray40);
    }

    @Test
    public void test0873() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0873");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.inclusiveBetween((long) ' ', 10L, (long) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The value 100 is not in the specified inclusive range of 32 to 10");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0874() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0874");
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext0 = new org.apache.commons.lang3.exception.DefaultExceptionContext();
        org.apache.commons.lang3.function.FailableBiConsumer<java.io.File, org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.RuntimeException> fileFailableBiConsumer2 = org.apache.commons.lang3.function.FailableBiConsumer.nop();
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext3 = defaultExceptionContext0.addContextValue("\n", (java.lang.Object) fileFailableBiConsumer2);
        float[] floatArray10 = new float[] { (byte) 100, 10.0f, (-1.0f), 0L, 100L };
        org.apache.commons.lang3.ArrayUtils.reverse(floatArray10, (int) (byte) 10, (int) 'a');
        float float14 = org.apache.commons.lang3.math.IEEE754rUtils.max(floatArray10);
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext15 = defaultExceptionContext0.setContextValue("java.endorsed.dirs", (java.lang.Object) float14);
        org.junit.Assert.assertNotNull(fileFailableBiConsumer2);
        org.junit.Assert.assertNotNull(defaultExceptionContext3);
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[100.0, 10.0, -1.0, 0.0, 100.0]");
        org.junit.Assert.assertTrue("'" + float14 + "' != '" + 100.0f + "'", float14 == 100.0f);
        org.junit.Assert.assertNotNull(defaultExceptionContext15);
    }

    @Test
    public void test0875() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0875");
        org.apache.commons.lang3.arch.Processor.Arch arch0 = null;
        org.apache.commons.lang3.arch.Processor.Type type1 = org.apache.commons.lang3.arch.Processor.Type.PPC;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.arch.Processor.Type> typeRange2 = org.apache.commons.lang3.Range.is(type1);
        org.apache.commons.lang3.arch.Processor processor3 = new org.apache.commons.lang3.arch.Processor(arch0, type1);
        boolean boolean4 = processor3.is32Bit();
        org.junit.Assert.assertTrue("'" + type1 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type1.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNotNull(typeRange2);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0876() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0876");
        org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle> toStringStyleAtomicSafeInitializer0 = new org.apache.commons.lang3.concurrent.AtomicSafeInitializer<org.apache.commons.lang3.builder.ToStringStyle>();
        boolean boolean1 = toStringStyleAtomicSafeInitializer0.isInitialized();
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0877() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0877");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Calendar calendar2 = org.apache.commons.lang3.time.DateUtils.ceiling(calendar0, 6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: calendar");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0878() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0878");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.exclusiveBetween(1.0d, (double) (-1.0f), (double) (-1), "java.lang");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.lang");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0879() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0879");
        org.apache.commons.lang3.mutable.MutableByte mutableByte0 = new org.apache.commons.lang3.mutable.MutableByte();
        org.apache.commons.lang3.mutable.MutableByte mutableByte1 = new org.apache.commons.lang3.mutable.MutableByte();
        int int2 = mutableByte0.compareTo(mutableByte1);
        byte byte4 = mutableByte0.addAndGet((byte) 0);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
        org.junit.Assert.assertTrue("'" + byte4 + "' != '" + (byte) 0 + "'", byte4 == (byte) 0);
    }

    @Test
    public void test0880() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0880");
        double[] doubleArray4 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray8 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray8, (double) '4');
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray4, doubleArray8);
        double[] doubleArray12 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(doubleArray8);
        double[] doubleArray13 = org.apache.commons.lang3.ArrayUtils.clone(doubleArray12);
        org.apache.commons.lang3.ArrayUtils.shuffle(doubleArray12);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray4), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray8);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray8), "[-1.0, -1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(doubleArray12);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray12), "[-1.0, -1.0, 52.0]");
        org.junit.Assert.assertNotNull(doubleArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray13), "[52.0, -1.0, -1.0]");
    }

    @Test
    public void test0881() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0881");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.center(":", 0, ' ');
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + ":" + "'", str3, ":");
    }

    @Test
    public void test0882() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0882");
        java.lang.Short[] shortArray5 = new java.lang.Short[] { (short) 100, (short) 1, (short) 1, (short) 10, (short) 1 };
        java.lang.Short[] shortArray6 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(shortArray5);
        short[] shortArray8 = org.apache.commons.lang3.ArrayUtils.toPrimitive(shortArray6, (short) 99);
        // The following exception was thrown during execution in test generation
        try {
            long long13 = org.apache.commons.lang3.Conversion.shortArrayToLong(shortArray8, 0, (long) 3, (int) (byte) 0, (int) 'o');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nShorts-1)*16+dstPos is greater or equal to than 64");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(shortArray5);
        org.junit.Assert.assertNotNull(shortArray6);
        org.junit.Assert.assertNotNull(shortArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray8), "[100, 1, 1, 10, 1]");
    }

    @Test
    public void test0883() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0883");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.removePattern("user.region", "<");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "user.region" + "'", str2, "user.region");
    }

    @Test
    public void test0884() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0884");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.exclusiveBetween("os.version", "                                                                                                open", (java.lang.Comparable<java.lang.String>) "x86_64");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The value x86_64 is not in the specified exclusive range of os.version to                                                                                                 open");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0885() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0885");
        java.lang.String str3 = org.apache.commons.lang3.BooleanUtils.toString(true, "Mac OS X", "UTF-16BE");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Mac OS X" + "'", str3, "Mac OS X");
    }

    @Test
    public void test0886() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0886");
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate0 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate1 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate2 = uncheckedExecutionExceptionFailableDoublePredicate1.negate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate3 = uncheckedExecutionExceptionFailableDoublePredicate0.or(uncheckedExecutionExceptionFailableDoublePredicate1);
        boolean boolean5 = uncheckedExecutionExceptionFailableDoublePredicate0.test((double) 5);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate0);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate1);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate2);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate3);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0887() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0887");
        java.util.Collection<java.lang.Thread> threadCollection2 = org.apache.commons.lang3.ThreadUtils.findThreadsByName("OpenJDK 64-Bit Server VM", "UTF-16BE");
        org.junit.Assert.assertNotNull(threadCollection2);
    }

    @Test
    public void test0888() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0888");
        char char2 = org.apache.commons.lang3.CharUtils.toChar("Mac OS X", '\000');
        org.junit.Assert.assertTrue("'" + char2 + "' != '" + 'M' + "'", char2 == 'M');
    }

    @Test
    public void test0889() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0889");
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder0 = new org.apache.commons.lang3.builder.EqualsBuilder();
        char[] charArray3 = new char[] { ' ', '#' };
        char[] charArray5 = new char[] { ' ' };
        char[] charArray6 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray3, charArray5);
        org.apache.commons.lang3.ArrayUtils.swap(charArray3, (int) (short) 1, (int) (short) 101, 0);
        int[] intArray12 = new int[] { '\n' };
        java.util.BitSet bitSet15 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray12, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray12);
        boolean boolean18 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) (short) 101, (java.lang.Object) intArray12, true);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray12);
        java.util.stream.IntStream intStream21 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream23 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle24 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle25 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str26 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle24, toStringStyle25);
        java.lang.StringBuffer stringBuffer27 = null;
        java.lang.Object obj28 = null;
        standardToStringStyle24.appendStart(stringBuffer27, obj28);
        java.lang.String str30 = standardToStringStyle24.getNullText();
        standardToStringStyle24.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder34 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream21, (java.lang.AutoCloseable) intStream23, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle24, true);
        long[] longArray37 = new long[] { 3 };
        long[] longArray38 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray37);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray37);
        long[] longArray41 = new long[] { '4' };
        long[] longArray47 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet50 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray47, (long) '\n', 100);
        boolean boolean51 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray47);
        long[] longArray53 = org.apache.commons.lang3.ArrayUtils.add(longArray47, (long) (short) 101);
        boolean boolean54 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray41, longArray53);
        long[] longArray56 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray53, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder57 = autoCloseableDiffBuilder34.append("java.awt.headless", longArray37, longArray56);
        char[] charArray61 = new char[] { ' ', '#' };
        char[] charArray63 = new char[] { ' ' };
        char[] charArray64 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray61, charArray63);
        org.apache.commons.lang3.ArrayUtils.swap(charArray61, (int) (short) 1, (int) (short) 101, 0);
        int[] intArray70 = new int[] { '\n' };
        java.util.BitSet bitSet73 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray70, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray70);
        boolean boolean76 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) (short) 101, (java.lang.Object) intArray70, true);
        int[] intArray78 = new int[] { '\n' };
        java.util.BitSet bitSet81 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray78, (int) (byte) -1, (int) (short) -1);
        java.lang.String str85 = org.apache.commons.lang3.StringUtils.join(intArray78, '\000', (int) '4', 1);
        int[] intArray87 = org.apache.commons.lang3.ArrayUtils.addFirst(intArray78, (int) (byte) 10);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder88 = autoCloseableDiffBuilder57.append(" ", intArray70, intArray87);
        int[] intArray90 = org.apache.commons.lang3.ArrayUtils.add(intArray70, (int) '\r');
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder91 = equalsBuilder0.append(intArray12, intArray70);
        java.util.BitSet bitSet93 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray12, 44);
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray3), "[ , #]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[ ]");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray6), "[#]");
        org.junit.Assert.assertNotNull(intArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray12), "[10]");
        org.junit.Assert.assertNotNull(bitSet15);
        org.junit.Assert.assertEquals(bitSet15.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(intStream21);
        org.junit.Assert.assertNotNull(intStream23);
        org.junit.Assert.assertNotNull(toStringStyle25);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str26, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "<null>" + "'", str30, "<null>");
        org.junit.Assert.assertNotNull(longArray37);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray37), "[3]");
        org.junit.Assert.assertNotNull(longArray38);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray38), "[3]");
        org.junit.Assert.assertNotNull(longArray41);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray41), "[52]");
        org.junit.Assert.assertNotNull(longArray47);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray47), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet50);
        org.junit.Assert.assertEquals(bitSet50.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
        org.junit.Assert.assertNotNull(longArray53);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray53), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNotNull(longArray56);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray56), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder57);
        org.junit.Assert.assertNotNull(charArray61);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray61), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray61), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray61), "[ , #]");
        org.junit.Assert.assertNotNull(charArray63);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray63), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray63), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray63), "[ ]");
        org.junit.Assert.assertNotNull(charArray64);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray64), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray64), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray64), "[#]");
        org.junit.Assert.assertNotNull(intArray70);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray70), "[10]");
        org.junit.Assert.assertNotNull(bitSet73);
        org.junit.Assert.assertEquals(bitSet73.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean76 + "' != '" + false + "'", boolean76 == false);
        org.junit.Assert.assertNotNull(intArray78);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray78), "[10]");
        org.junit.Assert.assertNotNull(bitSet81);
        org.junit.Assert.assertEquals(bitSet81.toString(), "{}");
        org.junit.Assert.assertEquals("'" + str85 + "' != '" + "" + "'", str85, "");
        org.junit.Assert.assertNotNull(intArray87);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray87), "[10, 10]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder88);
        org.junit.Assert.assertNotNull(intArray90);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray90), "[10, 13]");
        org.junit.Assert.assertNotNull(equalsBuilder91);
        org.junit.Assert.assertNotNull(bitSet93);
        org.junit.Assert.assertEquals(bitSet93.toString(), "{}");
    }

    @Test
    public void test0890() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0890");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_18;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_18 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_18));
    }

    @Test
    public void test0891() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0891");
        org.apache.commons.lang3.arch.Processor.Arch arch0 = org.apache.commons.lang3.arch.Processor.Arch.BIT_32;
        org.apache.commons.lang3.arch.Processor.Arch arch1 = org.apache.commons.lang3.arch.Processor.Arch.BIT_32;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.arch.Processor.Arch> archRange2 = org.apache.commons.lang3.Range.of(arch0, arch1);
        org.junit.Assert.assertTrue("'" + arch0 + "' != '" + org.apache.commons.lang3.arch.Processor.Arch.BIT_32 + "'", arch0.equals(org.apache.commons.lang3.arch.Processor.Arch.BIT_32));
        org.junit.Assert.assertTrue("'" + arch1 + "' != '" + org.apache.commons.lang3.arch.Processor.Arch.BIT_32 + "'", arch1.equals(org.apache.commons.lang3.arch.Processor.Arch.BIT_32));
        org.junit.Assert.assertNotNull(archRange2);
    }

    @Test
    public void test0892() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0892");
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext0 = new org.apache.commons.lang3.exception.DefaultExceptionContext();
        org.apache.commons.lang3.function.FailableBiConsumer<java.io.File, org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.RuntimeException> fileFailableBiConsumer2 = org.apache.commons.lang3.function.FailableBiConsumer.nop();
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext3 = defaultExceptionContext0.addContextValue("\n", (java.lang.Object) fileFailableBiConsumer2);
        java.util.Set<java.lang.String> strSet4 = defaultExceptionContext3.getContextLabels();
        org.junit.Assert.assertNotNull(fileFailableBiConsumer2);
        org.junit.Assert.assertNotNull(defaultExceptionContext3);
        org.junit.Assert.assertNotNull(strSet4);
    }

    @Test
    public void test0893() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0893");
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = org.apache.commons.lang3.text.StrMatcher.charSetMatcher("\\u0020");
        org.junit.Assert.assertNotNull(strMatcher1);
    }

    @Test
    public void test0894() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0894");
        java.lang.Boolean boolean1 = org.apache.commons.lang3.BooleanUtils.negate((java.lang.Boolean) false);
        org.junit.Assert.assertEquals("'" + boolean1 + "' != '" + true + "'", boolean1, true);
    }

    @Test
    public void test0895() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0895");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.substringBetween("UTF-16BE", "java.vm.specification.name", "                                                                                                open");
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test0896() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0896");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getUserCountry();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "SE" + "'", str0, "SE");
    }

    @Test
    public void test0897() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0897");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_RECENT;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_RECENT + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_RECENT));
    }

    @Test
    public void test0898() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0898");
        java.util.function.Function<org.apache.commons.lang3.text.StrTokenizer, org.apache.commons.lang3.CharSet> strTokenizerFunction0 = null;
        org.apache.commons.lang3.concurrent.Memoizer<org.apache.commons.lang3.text.StrTokenizer, org.apache.commons.lang3.CharSet> strTokenizerMemoizer2 = new org.apache.commons.lang3.concurrent.Memoizer<org.apache.commons.lang3.text.StrTokenizer, org.apache.commons.lang3.CharSet>(strTokenizerFunction0, false);
    }

    @Test
    public void test0899() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0899");
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder0 = new org.apache.commons.lang3.builder.EqualsBuilder();
        char[] charArray3 = new char[] { ' ', '#' };
        char[] charArray5 = new char[] { ' ' };
        char[] charArray6 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray3, charArray5);
        org.apache.commons.lang3.ArrayUtils.swap(charArray3, (int) (short) 1, (int) (short) 101, 0);
        int[] intArray12 = new int[] { '\n' };
        java.util.BitSet bitSet15 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray12, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray12);
        boolean boolean18 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) (short) 101, (java.lang.Object) intArray12, true);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray12);
        java.util.stream.IntStream intStream21 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream23 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle24 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle25 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str26 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle24, toStringStyle25);
        java.lang.StringBuffer stringBuffer27 = null;
        java.lang.Object obj28 = null;
        standardToStringStyle24.appendStart(stringBuffer27, obj28);
        java.lang.String str30 = standardToStringStyle24.getNullText();
        standardToStringStyle24.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder34 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream21, (java.lang.AutoCloseable) intStream23, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle24, true);
        long[] longArray37 = new long[] { 3 };
        long[] longArray38 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray37);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray37);
        long[] longArray41 = new long[] { '4' };
        long[] longArray47 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet50 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray47, (long) '\n', 100);
        boolean boolean51 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray47);
        long[] longArray53 = org.apache.commons.lang3.ArrayUtils.add(longArray47, (long) (short) 101);
        boolean boolean54 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray41, longArray53);
        long[] longArray56 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray53, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder57 = autoCloseableDiffBuilder34.append("java.awt.headless", longArray37, longArray56);
        char[] charArray61 = new char[] { ' ', '#' };
        char[] charArray63 = new char[] { ' ' };
        char[] charArray64 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray61, charArray63);
        org.apache.commons.lang3.ArrayUtils.swap(charArray61, (int) (short) 1, (int) (short) 101, 0);
        int[] intArray70 = new int[] { '\n' };
        java.util.BitSet bitSet73 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray70, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray70);
        boolean boolean76 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) (short) 101, (java.lang.Object) intArray70, true);
        int[] intArray78 = new int[] { '\n' };
        java.util.BitSet bitSet81 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray78, (int) (byte) -1, (int) (short) -1);
        java.lang.String str85 = org.apache.commons.lang3.StringUtils.join(intArray78, '\000', (int) '4', 1);
        int[] intArray87 = org.apache.commons.lang3.ArrayUtils.addFirst(intArray78, (int) (byte) 10);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder88 = autoCloseableDiffBuilder57.append(" ", intArray70, intArray87);
        int[] intArray90 = org.apache.commons.lang3.ArrayUtils.add(intArray70, (int) '\r');
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder91 = equalsBuilder0.append(intArray12, intArray70);
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder94 = equalsBuilder0.append(false, false);
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder97 = equalsBuilder94.append((short) (byte) 100, (short) 99);
        boolean boolean98 = equalsBuilder94.isEquals();
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray3), "[ , #]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[ ]");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray6), "[#]");
        org.junit.Assert.assertNotNull(intArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray12), "[10]");
        org.junit.Assert.assertNotNull(bitSet15);
        org.junit.Assert.assertEquals(bitSet15.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(intStream21);
        org.junit.Assert.assertNotNull(intStream23);
        org.junit.Assert.assertNotNull(toStringStyle25);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str26, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "<null>" + "'", str30, "<null>");
        org.junit.Assert.assertNotNull(longArray37);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray37), "[3]");
        org.junit.Assert.assertNotNull(longArray38);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray38), "[3]");
        org.junit.Assert.assertNotNull(longArray41);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray41), "[52]");
        org.junit.Assert.assertNotNull(longArray47);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray47), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet50);
        org.junit.Assert.assertEquals(bitSet50.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
        org.junit.Assert.assertNotNull(longArray53);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray53), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNotNull(longArray56);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray56), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder57);
        org.junit.Assert.assertNotNull(charArray61);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray61), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray61), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray61), "[ , #]");
        org.junit.Assert.assertNotNull(charArray63);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray63), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray63), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray63), "[ ]");
        org.junit.Assert.assertNotNull(charArray64);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray64), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray64), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray64), "[#]");
        org.junit.Assert.assertNotNull(intArray70);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray70), "[10]");
        org.junit.Assert.assertNotNull(bitSet73);
        org.junit.Assert.assertEquals(bitSet73.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean76 + "' != '" + false + "'", boolean76 == false);
        org.junit.Assert.assertNotNull(intArray78);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray78), "[10]");
        org.junit.Assert.assertNotNull(bitSet81);
        org.junit.Assert.assertEquals(bitSet81.toString(), "{}");
        org.junit.Assert.assertEquals("'" + str85 + "' != '" + "" + "'", str85, "");
        org.junit.Assert.assertNotNull(intArray87);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray87), "[10, 10]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder88);
        org.junit.Assert.assertNotNull(intArray90);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray90), "[10, 13]");
        org.junit.Assert.assertNotNull(equalsBuilder91);
        org.junit.Assert.assertNotNull(equalsBuilder94);
        org.junit.Assert.assertNotNull(equalsBuilder97);
        org.junit.Assert.assertTrue("'" + boolean98 + "' != '" + false + "'", boolean98 == false);
    }

    @Test
    public void test0900() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0900");
        short short2 = org.apache.commons.lang3.math.NumberUtils.toShort("Integer", (short) 99);
        org.junit.Assert.assertTrue("'" + short2 + "' != '" + (short) 99 + "'", short2 == (short) 99);
    }

    @Test
    public void test0901() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0901");
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate0 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate0);
    }

    @Test
    public void test0902() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0902");
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.RandomUtils.nextLong((long) '6', (long) 5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Start value must be smaller or equal to end value.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0903() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0903");
        org.apache.commons.lang3.tuple.ImmutableTriple<?, ?, ?>[] wildcardImmutableTripleArray0 = org.apache.commons.lang3.tuple.ImmutableTriple.EMPTY_ARRAY;
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair3 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.util.AbstractCollection<java.util.Locale> localeCollection4 = charSequenceArrayImmutablePair3.getRight();
        java.lang.String[] strArray11 = new java.lang.String[] { "java.lang", "                                                                                                open", "60.0", "16.0.1", ":", "Integer" };
        org.apache.commons.lang3.CharSet charSet12 = org.apache.commons.lang3.CharSet.getInstance(strArray11);
        boolean boolean13 = charSequenceArrayImmutablePair3.equals((java.lang.Object) strArray11);
        boolean boolean14 = org.apache.commons.lang3.CharSetUtils.containsAny("Integer", strArray11);
        java.lang.Class[] classArray16 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray17 = (java.lang.Class<?>[]) classArray16;
        java.lang.Class<?> wildcardClass18 = null;
        java.lang.Class[] classArray20 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray21 = (java.lang.Class<?>[]) classArray20;
        wildcardClassArray21[0] = wildcardClass18;
        boolean boolean24 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray16, wildcardClassArray21);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj25 = org.apache.commons.lang3.reflect.MethodUtils.invokeExactMethod((java.lang.Object) wildcardImmutableTripleArray0, "HH:mm:ss", (java.lang.Object[]) strArray11, (java.lang.Class<?>[]) classArray16);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: HH:mm:ss() on object: [Lorg.apache.commons.lang3.tuple.ImmutableTriple;");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(wildcardImmutableTripleArray0);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair3);
        org.junit.Assert.assertNull(localeCollection4);
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertNotNull(charSet12);
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + false + "'", boolean13 == false);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + true + "'", boolean14 == true);
        org.junit.Assert.assertNotNull(classArray16);
        org.junit.Assert.assertNotNull(wildcardClassArray17);
        org.junit.Assert.assertNotNull(classArray20);
        org.junit.Assert.assertNotNull(wildcardClassArray21);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
    }

    @Test
    public void test0904() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0904");
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate0 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate1 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate2 = uncheckedExecutionExceptionFailableDoublePredicate1.negate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate3 = uncheckedExecutionExceptionFailableDoublePredicate0.or(uncheckedExecutionExceptionFailableDoublePredicate1);
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate4 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate5 = uncheckedExecutionExceptionFailableDoublePredicate1.or(uncheckedExecutionExceptionFailableDoublePredicate4);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate0);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate1);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate2);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate3);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate4);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate5);
    }

    @Test
    public void test0905() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0905");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray1 = charSequenceArrayImmutablePair0.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair2 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0);
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair3 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray4 = charSequenceArrayImmutablePair3.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair5 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair3);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayMutablePairRange6 = org.apache.commons.lang3.Range.between(charSequenceArrayMutablePair2, charSequenceArrayMutablePair5);
        java.lang.CharSequence[] charSequenceArray7 = charSequenceArrayMutablePair2.left;
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair8 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray9 = charSequenceArrayImmutablePair8.left;
        int int10 = charSequenceArrayMutablePair2.compareTo((org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair8);
        java.util.AbstractCollection<java.util.Locale> localeCollection11 = charSequenceArrayImmutablePair8.right;
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(charSequenceArray1);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair2);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair3);
        org.junit.Assert.assertNull(charSequenceArray4);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair5);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePairRange6);
        org.junit.Assert.assertNull(charSequenceArray7);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair8);
        org.junit.Assert.assertNull(charSequenceArray9);
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
        org.junit.Assert.assertNull(localeCollection11);
    }

    @Test
    public void test0906() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0906");
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException1 = new org.apache.commons.lang3.exception.ContextedRuntimeException("mixed mode, sharing");
        java.util.stream.IntStream intStream4 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream6 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle7 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle8 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str9 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle7, toStringStyle8);
        java.lang.StringBuffer stringBuffer10 = null;
        java.lang.Object obj11 = null;
        standardToStringStyle7.appendStart(stringBuffer10, obj11);
        java.lang.String str13 = standardToStringStyle7.getNullText();
        standardToStringStyle7.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder17 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream4, (java.lang.AutoCloseable) intStream6, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle7, true);
        long[] longArray20 = new long[] { 3 };
        long[] longArray21 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray20);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray20);
        long[] longArray24 = new long[] { '4' };
        long[] longArray30 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet33 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray30, (long) '\n', 100);
        boolean boolean34 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray30);
        long[] longArray36 = org.apache.commons.lang3.ArrayUtils.add(longArray30, (long) (short) 101);
        boolean boolean37 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray24, longArray36);
        long[] longArray39 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray36, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder40 = autoCloseableDiffBuilder17.append("java.awt.headless", longArray20, longArray39);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException41 = contextedRuntimeException1.addContextValue(" ", (java.lang.Object) longArray20);
        java.util.List<java.lang.Object> objList43 = contextedRuntimeException1.getContextValues("60.0");
        java.util.List<java.lang.Object> objList45 = contextedRuntimeException1.getContextValues("no");
        java.util.function.Consumer<java.lang.Throwable> throwableConsumer46 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.exception.ExceptionUtils.forEach((java.lang.Throwable) contextedRuntimeException1, throwableConsumer46);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intStream4);
        org.junit.Assert.assertNotNull(intStream6);
        org.junit.Assert.assertNotNull(toStringStyle8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str9, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "<null>" + "'", str13, "<null>");
        org.junit.Assert.assertNotNull(longArray20);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray20), "[3]");
        org.junit.Assert.assertNotNull(longArray21);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray21), "[3]");
        org.junit.Assert.assertNotNull(longArray24);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray24), "[52]");
        org.junit.Assert.assertNotNull(longArray30);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray30), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet33);
        org.junit.Assert.assertEquals(bitSet33.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(longArray36);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray36), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(longArray39);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray39), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder40);
        org.junit.Assert.assertNotNull(contextedRuntimeException41);
        org.junit.Assert.assertNotNull(objList43);
        org.junit.Assert.assertNotNull(objList45);
    }

    @Test
    public void test0907() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0907");
        org.apache.commons.lang3.mutable.MutableByte mutableByte0 = new org.apache.commons.lang3.mutable.MutableByte();
        mutableByte0.setValue((byte) 10);
        byte byte4 = mutableByte0.getAndAdd((byte) 1);
        mutableByte0.decrement();
        org.junit.Assert.assertTrue("'" + byte4 + "' != '" + (byte) 10 + "'", byte4 == (byte) 10);
    }

    @Test
    public void test0908() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0908");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        java.lang.Object obj4 = null;
        standardToStringStyle0.appendStart(stringBuffer3, obj4);
        java.lang.String str6 = standardToStringStyle0.getNullText();
        java.lang.String str7 = standardToStringStyle0.getArraySeparator();
        java.lang.String str8 = standardToStringStyle0.getArrayEnd();
        standardToStringStyle0.setNullText("org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on");
        standardToStringStyle0.setArrayEnd("FastDateFormat[,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "<null>" + "'", str6, "<null>");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "," + "'", str7, ",");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "}" + "'", str8, "}");
    }

    @Test
    public void test0909() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0909");
        java.util.Calendar calendar0 = null;
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.DateFormatUtils.ISO_TIME_FORMAT;
        java.util.TimeZone timeZone3 = fastDateFormat2.getTimeZone();
        java.util.Locale locale5 = null;
        java.util.Locale locale6 = org.apache.commons.lang3.LocaleUtils.toLocale(locale5);
        java.lang.String str7 = org.apache.commons.lang3.StringUtils.lowerCase("user.name", locale6);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = org.apache.commons.lang3.time.DateFormatUtils.format(calendar0, "OpenJDK 64-Bit Server VM", timeZone3, locale6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: O");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat2);
        org.junit.Assert.assertNotNull(timeZone3);
        org.junit.Assert.assertEquals(timeZone3.getDisplayName(), "Central European Standard Time");
        org.junit.Assert.assertNotNull(locale6);
        org.junit.Assert.assertEquals(locale6.toString(), "en_SE");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "user.name" + "'", str7, "user.name");
    }

    @Test
    public void test0910() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0910");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isNumeric((java.lang.CharSequence) "1/1");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0911() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0911");
        org.apache.commons.lang3.tuple.MutableTriple<?, ?, ?>[] wildcardMutableTripleArray0 = org.apache.commons.lang3.tuple.MutableTriple.EMPTY_ARRAY;
        org.junit.Assert.assertNotNull(wildcardMutableTripleArray0);
    }

    @Test
    public void test0912() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0912");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_TIME_FORMAT;
        java.util.TimeZone timeZone1 = fastDateFormat0.getTimeZone();
        java.util.function.Consumer<org.apache.commons.lang3.Functions> functionsConsumer2 = org.apache.commons.lang3.function.Consumers.nop();
        boolean boolean3 = fastDateFormat0.equals((java.lang.Object) functionsConsumer2);
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertNotNull(timeZone1);
        org.junit.Assert.assertEquals(timeZone1.getDisplayName(), "Central European Standard Time");
        org.junit.Assert.assertNotNull(functionsConsumer2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test0913() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0913");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        boolean boolean12 = org.apache.commons.lang3.ArrayUtils.isEmpty(booleanArray5);
        // The following exception was thrown during execution in test generation
        try {
            char char14 = org.apache.commons.lang3.Conversion.binaryToHexDigitMsb0_4bits(booleanArray5, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Index -1 out of bounds for length 5");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet9);
        org.junit.Assert.assertEquals(bitSet9.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(booleanArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray11), "[false, true, false, true, false, true]");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test0914() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0914");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_1_5;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_1_5 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_1_5));
    }

    @Test
    public void test0915() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0915");
        org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover unicodeUnpairedSurrogateRemover0 = new org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover();
    }

    @Test
    public void test0916() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0916");
        java.lang.Short[] shortArray5 = new java.lang.Short[] { (short) 100, (short) 1, (short) 1, (short) 10, (short) 1 };
        java.lang.Short[] shortArray6 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(shortArray5);
        short[] shortArray8 = org.apache.commons.lang3.ArrayUtils.toPrimitive(shortArray6, (short) 99);
        org.apache.commons.lang3.ArrayUtils.swap(shortArray8, (int) 'M', (int) (short) -1);
        org.junit.Assert.assertNotNull(shortArray5);
        org.junit.Assert.assertNotNull(shortArray6);
        org.junit.Assert.assertNotNull(shortArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray8), "[100, 1, 1, 10, 1]");
    }

    @Test
    public void test0917() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0917");
        org.apache.commons.lang3.BitField bitField1 = new org.apache.commons.lang3.BitField((int) (byte) 10);
        byte byte3 = bitField1.clearByte((byte) -1);
        boolean boolean5 = bitField1.isAllSet(17);
        short short7 = bitField1.getShortValue((short) 101);
        org.junit.Assert.assertTrue("'" + byte3 + "' != '" + (byte) -11 + "'", byte3 == (byte) -11);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + short7 + "' != '" + (short) 0 + "'", short7 == (short) 0);
    }

    @Test
    public void test0918() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0918");
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException2, "Integer");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer6 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService7 = multiBackgroundInitializer6.getExternalExecutor();
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer9 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService10 = multiBackgroundInitializer9.getExternalExecutor();
        multiBackgroundInitializer6.addInitializer("60.0", (org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>) multiBackgroundInitializer9);
        org.apache.commons.lang3.tuple.MutablePair<org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.concurrent.MultiBackgroundInitializer> notImplementedExceptionMutablePair12 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull(notImplementedException5, multiBackgroundInitializer9);
        java.lang.Class<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierClass13 = org.apache.commons.lang3.ObjectUtils.getClass((org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>) multiBackgroundInitializer9);
        java.lang.Class[] classArray15 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray16 = (java.lang.Class<?>[]) classArray15;
        java.lang.Class<?> wildcardClass17 = null;
        java.lang.Class[] classArray19 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray20 = (java.lang.Class<?>[]) classArray19;
        wildcardClassArray20[0] = wildcardClass17;
        boolean boolean23 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray15, wildcardClassArray20);
        java.lang.reflect.Constructor<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierConstructor24 = org.apache.commons.lang3.reflect.ConstructorUtils.getMatchingAccessibleConstructor(multiBackgroundInitializerResultsFailableSupplierClass13, (java.lang.Class<?>[]) classArray15);
        java.lang.String str26 = org.apache.commons.lang3.ClassUtils.getName(multiBackgroundInitializerResultsFailableSupplierClass13, "java.specification.name");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle29 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer33 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray34 = strTokenizer33.getTokenArray();
        java.lang.String str35 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle29, strArray34);
        java.lang.String str39 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray34, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int40 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray34);
        boolean boolean41 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray34);
        boolean boolean42 = org.apache.commons.lang3.StringUtils.isAllBlank((java.lang.CharSequence[]) strArray34);
        java.lang.Throwable throwable44 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException45 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable44);
        java.lang.Throwable[] throwableArray46 = uncheckedExecutionException45.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException48 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException45, "Integer");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer49 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService50 = multiBackgroundInitializer49.getExternalExecutor();
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer52 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService53 = multiBackgroundInitializer52.getExternalExecutor();
        multiBackgroundInitializer49.addInitializer("60.0", (org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>) multiBackgroundInitializer52);
        org.apache.commons.lang3.tuple.MutablePair<org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.concurrent.MultiBackgroundInitializer> notImplementedExceptionMutablePair55 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull(notImplementedException48, multiBackgroundInitializer52);
        java.lang.Class<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierClass56 = org.apache.commons.lang3.ObjectUtils.getClass((org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>) multiBackgroundInitializer52);
        java.lang.Class[] classArray58 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray59 = (java.lang.Class<?>[]) classArray58;
        java.lang.Class<?> wildcardClass60 = null;
        java.lang.Class[] classArray62 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray63 = (java.lang.Class<?>[]) classArray62;
        wildcardClassArray63[0] = wildcardClass60;
        boolean boolean66 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray58, wildcardClassArray63);
        java.lang.reflect.Constructor<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierConstructor67 = org.apache.commons.lang3.reflect.ConstructorUtils.getMatchingAccessibleConstructor(multiBackgroundInitializerResultsFailableSupplierClass56, (java.lang.Class<?>[]) classArray58);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException> multiBackgroundInitializerResultsFailableSupplier68 = org.apache.commons.lang3.reflect.ConstructorUtils.invokeExactConstructor(multiBackgroundInitializerResultsFailableSupplierClass13, (java.lang.Object[]) strArray34, (java.lang.Class<?>[]) classArray58);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: wrong number of arguments");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertNotNull(classArray15);
        org.junit.Assert.assertNotNull(wildcardClassArray16);
        org.junit.Assert.assertNotNull(classArray19);
        org.junit.Assert.assertNotNull(wildcardClassArray20);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierConstructor24);
        org.junit.Assert.assertEquals("'" + str26 + "' != '" + "org.apache.commons.lang3.concurrent.MultiBackgroundInitializer" + "'", str26, "org.apache.commons.lang3.concurrent.MultiBackgroundInitializer");
        org.junit.Assert.assertNotNull(strArray34);
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "" + "'", str39, "");
        org.junit.Assert.assertTrue("'" + int40 + "' != '" + (-1) + "'", int40 == (-1));
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + false + "'", boolean42 == false);
        org.junit.Assert.assertNotNull(throwableArray46);
        org.junit.Assert.assertNull(executorService50);
        org.junit.Assert.assertNull(executorService53);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair55);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass56);
        org.junit.Assert.assertNotNull(classArray58);
        org.junit.Assert.assertNotNull(wildcardClassArray59);
        org.junit.Assert.assertNotNull(classArray62);
        org.junit.Assert.assertNotNull(wildcardClassArray63);
        org.junit.Assert.assertTrue("'" + boolean66 + "' != '" + false + "'", boolean66 == false);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierConstructor67);
    }

    @Test
    public void test0919() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0919");
        org.apache.commons.lang3.concurrent.BackgroundInitializer.Builder<org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.JavaVersion>, org.apache.commons.lang3.JavaVersion> javaVersionBackgroundInitializerBuilder0 = org.apache.commons.lang3.concurrent.BackgroundInitializer.builder();
        org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.JavaVersion> javaVersionBackgroundInitializer1 = javaVersionBackgroundInitializerBuilder0.get();
        org.junit.Assert.assertNotNull(javaVersionBackgroundInitializerBuilder0);
        org.junit.Assert.assertNotNull(javaVersionBackgroundInitializer1);
    }

    @Test
    public void test0920() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0920");
        double double0 = org.apache.commons.lang3.RandomUtils.nextDouble();
// flaky:         org.junit.Assert.assertTrue("'" + double0 + "' != '" + 1.191453755573606E308d + "'", double0 == 1.191453755573606E308d);
    }

    @Test
    public void test0921() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0921");
        org.apache.commons.lang3.event.EventUtils eventUtils0 = new org.apache.commons.lang3.event.EventUtils();
    }

    @Test
    public void test0922() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0922");
        java.lang.Float[] floatArray0 = new java.lang.Float[] {};
        float[] floatArray2 = org.apache.commons.lang3.ArrayUtils.toPrimitive(floatArray0, 10.0f);
        java.lang.Float[] floatArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(floatArray0);
        org.junit.Assert.assertNotNull(floatArray0);
        org.junit.Assert.assertNotNull(floatArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray2), "[]");
        org.junit.Assert.assertNotNull(floatArray3);
    }

    @Test
    public void test0923() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0923");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange2 = org.apache.commons.lang3.Range.of(javaVersion0, javaVersion1);
        char[] charArray5 = new char[] { ' ', '#' };
        char[] charArray7 = new char[] { ' ' };
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray5, charArray7);
        boolean boolean9 = javaVersionRange2.equals((java.lang.Object) charArray8);
        org.apache.commons.lang3.JavaVersion javaVersion10 = org.apache.commons.lang3.JavaVersion.JAVA_13;
        boolean boolean11 = javaVersionRange2.isStartedBy(javaVersion10);
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange2);
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[ , #]");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray7), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray7), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray7), "[ ]");
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[#]");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertTrue("'" + javaVersion10 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_13 + "'", javaVersion10.equals(org.apache.commons.lang3.JavaVersion.JAVA_13));
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test0924() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0924");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.USER_DIR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "user.dir" + "'", str0, "user.dir");
    }

    @Test
    public void test0925() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0925");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaAwtHeadless();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0926() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0926");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_1_2;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0927() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0927");
        org.apache.commons.lang3.function.FailableToLongFunction<java.lang.CharSequence[], org.apache.commons.lang3.NotImplementedException> charSequenceArrayFailableToLongFunction0 = org.apache.commons.lang3.function.FailableToLongFunction.nop();
        org.junit.Assert.assertNotNull(charSequenceArrayFailableToLongFunction0);
    }

    @Test
    public void test0928() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0928");
        int int0 = org.apache.commons.lang3.time.DateUtils.RANGE_MONTH_SUNDAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 5 + "'", int0 == 5);
    }

    @Test
    public void test0929() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0929");
        java.util.regex.Pattern pattern1 = null;
        java.lang.String str2 = org.apache.commons.lang3.RegExUtils.removeAll("P0Y0M0DT0H0M0.001S", pattern1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "P0Y0M0DT0H0M0.001S" + "'", str2, "P0Y0M0DT0H0M0.001S");
    }

    @Test
    public void test0930() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0930");
        boolean boolean1 = org.apache.commons.lang3.BooleanUtils.toBoolean((int) '\r');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0931() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0931");
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator0 = org.apache.commons.lang3.StringEscapeUtils.ESCAPE_JAVA;
        org.junit.Assert.assertNotNull(charSequenceTranslator0);
    }

    @Test
    public void test0932() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0932");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore3 = new org.apache.commons.lang3.concurrent.TimedSemaphore((long) (short) 1, timeUnit1, (int) (byte) -1);
        int int4 = timedSemaphore3.getLastAcquiresPerPeriod();
        int int5 = timedSemaphore3.getLastAcquiresPerPeriod();
        java.util.concurrent.TimeUnit timeUnit6 = timedSemaphore3.getUnit();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
        org.junit.Assert.assertNull(timeUnit6);
    }

    @Test
    public void test0933() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0933");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.TWO_FIFTHS;
        org.apache.commons.lang3.math.Fraction fraction1 = org.apache.commons.lang3.math.Fraction.TWO_THIRDS;
        org.apache.commons.lang3.math.Fraction fraction4 = org.apache.commons.lang3.math.Fraction.getFraction((int) (short) 1, (int) (short) 1);
        int int5 = fraction1.compareTo(fraction4);
        org.apache.commons.lang3.math.Fraction fraction6 = fraction0.multiplyBy(fraction4);
        org.junit.Assert.assertNotNull(fraction0);
        org.junit.Assert.assertNotNull(fraction1);
        org.junit.Assert.assertNotNull(fraction4);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
        org.junit.Assert.assertNotNull(fraction6);
    }

    @Test
    public void test0934() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0934");
        org.apache.commons.lang3.concurrent.locks.LockingVisitors lockingVisitors0 = new org.apache.commons.lang3.concurrent.locks.LockingVisitors();
    }

    @Test
    public void test0935() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0935");
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer7 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService8 = multiBackgroundInitializer7.getExternalExecutor();
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer10 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService11 = multiBackgroundInitializer10.getExternalExecutor();
        multiBackgroundInitializer7.addInitializer("60.0", (org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>) multiBackgroundInitializer10);
        org.apache.commons.lang3.tuple.MutablePair<org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.concurrent.MultiBackgroundInitializer> notImplementedExceptionMutablePair13 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull(notImplementedException6, multiBackgroundInitializer10);
        java.lang.Class<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierClass14 = org.apache.commons.lang3.ObjectUtils.getClass((org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>) multiBackgroundInitializer10);
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces15 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces16 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces17 = org.apache.commons.lang3.compare.ComparableUtils.min(interfaces15, interfaces16);
        java.lang.Iterable<java.lang.Class<?>> wildcardClassIterable18 = org.apache.commons.lang3.ClassUtils.hierarchy(multiBackgroundInitializerResultsFailableSupplierClass14, interfaces15);
        org.apache.commons.lang3.function.FailableSupplier failableSupplier19 = org.apache.commons.lang3.function.FailableSupplier.NUL;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.event.EventUtils.addEventListener((java.lang.Object) (byte) 0, multiBackgroundInitializerResultsFailableSupplierClass14, (org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>) failableSupplier19);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Class java.lang.Byte does not have a public addMultiBackgroundInitializer method which takes a parameter of type org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertNull(executorService8);
        org.junit.Assert.assertNull(executorService11);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair13);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass14);
        org.junit.Assert.assertTrue("'" + interfaces15 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces15.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces16 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces16.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces17 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces17.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertNotNull(wildcardClassIterable18);
        org.junit.Assert.assertNotNull(failableSupplier19);
    }

    @Test
    public void test0936() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0936");
        java.lang.Class<?> wildcardClass2 = org.apache.commons.lang3.ClassUtils.getClass("org.apache.commons.lang3.concurrent.MultiBackgroundInitializer", true);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test0937() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0937");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_1_8;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0938() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0938");
        boolean boolean1 = org.apache.commons.lang3.CharUtils.isAsciiAlphanumeric('o');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0939() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0939");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.addDays(date0, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0940() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0940");
        char[] charArray3 = new char[] { ' ', '#' };
        char[] charArray5 = new char[] { ' ' };
        char[] charArray6 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray3, charArray5);
        java.util.Random random7 = null;
        org.apache.commons.lang3.ArrayUtils.shuffle(charArray6, random7);
        int int9 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) "no", charArray6);
        org.apache.commons.lang3.math.Fraction fraction10 = org.apache.commons.lang3.math.Fraction.THREE_FIFTHS;
        float float11 = fraction10.floatValue();
        boolean boolean12 = org.apache.commons.lang3.ObjectUtils.equals((java.lang.Object) "no", (java.lang.Object) float11);
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray3), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray3), "[ , #]");
        org.junit.Assert.assertNotNull(charArray5);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray5), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray5), "[ ]");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray6), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray6), "[#]");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNotNull(fraction10);
        org.junit.Assert.assertTrue("'" + float11 + "' != '" + 0.6f + "'", float11 == 0.6f);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test0941() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0941");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.chomp("AdoptOpenJDK", "\000");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "AdoptOpenJDK" + "'", str2, "AdoptOpenJDK");
    }

    @Test
    public void test0942() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0942");
        int int3 = org.apache.commons.lang3.BooleanUtils.toInteger(false, (int) (byte) 0, (int) (short) 100);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 100 + "'", int3 == 100);
    }

    @Test
    public void test0943() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0943");
        org.apache.commons.lang3.mutable.MutableByte mutableByte0 = new org.apache.commons.lang3.mutable.MutableByte();
        mutableByte0.setValue((byte) 10);
        org.apache.commons.lang3.mutable.MutableByte mutableByte3 = new org.apache.commons.lang3.mutable.MutableByte();
        mutableByte3.setValue((byte) 10);
        int int6 = mutableByte0.compareTo(mutableByte3);
        boolean boolean7 = org.apache.commons.lang3.ObjectUtils.isArray((java.lang.Object) mutableByte0);
        float float8 = mutableByte0.floatValue();
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + float8 + "' != '" + 10.0f + "'", float8 == 10.0f);
    }

    @Test
    public void test0944() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0944");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate2 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion0, javaVersion1);
        org.apache.commons.lang3.JavaVersion javaVersion3 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion4 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange5 = org.apache.commons.lang3.Range.of(javaVersion3, javaVersion4);
        char[] charArray8 = new char[] { ' ', '#' };
        char[] charArray10 = new char[] { ' ' };
        char[] charArray11 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray8, charArray10);
        boolean boolean12 = javaVersionRange5.equals((java.lang.Object) charArray11);
        org.apache.commons.lang3.JavaVersion javaVersion13 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion14 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange15 = org.apache.commons.lang3.Range.of(javaVersion13, javaVersion14);
        boolean boolean16 = javaVersionRange5.isEndedBy(javaVersion14);
        org.apache.commons.lang3.JavaVersion javaVersion17 = org.apache.commons.lang3.JavaVersion.JAVA_1_1;
        boolean boolean18 = javaVersionRange5.contains(javaVersion17);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange19 = org.apache.commons.lang3.Range.of(javaVersion0, javaVersion17);
        org.apache.commons.lang3.JavaVersion javaVersion20 = org.apache.commons.lang3.JavaVersion.JAVA_1_1;
        org.apache.commons.lang3.JavaVersion javaVersion21 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion22 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange23 = org.apache.commons.lang3.Range.of(javaVersion21, javaVersion22);
        boolean boolean24 = org.apache.commons.lang3.SystemUtils.isJavaVersionAtLeast(javaVersion21);
        boolean boolean25 = javaVersion20.atMost(javaVersion21);
        boolean boolean26 = javaVersionRange19.isStartedBy(javaVersion20);
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate2);
        org.junit.Assert.assertTrue("'" + javaVersion3 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion3.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion4 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion4.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange5);
        org.junit.Assert.assertNotNull(charArray8);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray8), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray8), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray8), "[ , #]");
        org.junit.Assert.assertNotNull(charArray10);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray10), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray10), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray10), "[ ]");
        org.junit.Assert.assertNotNull(charArray11);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray11), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray11), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray11), "[#]");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + javaVersion13 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion13.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion14 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion14.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange15);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        org.junit.Assert.assertTrue("'" + javaVersion17 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_1_1 + "'", javaVersion17.equals(org.apache.commons.lang3.JavaVersion.JAVA_1_1));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertNotNull(javaVersionRange19);
        org.junit.Assert.assertTrue("'" + javaVersion20 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_1_1 + "'", javaVersion20.equals(org.apache.commons.lang3.JavaVersion.JAVA_1_1));
        org.junit.Assert.assertTrue("'" + javaVersion21 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion21.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion22 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion22.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
    }

    @Test
    public void test0945() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0945");
        org.apache.commons.lang3.mutable.MutableInt mutableInt1 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        mutableInt1.setValue((int) 'a');
        mutableInt1.subtract((int) '4');
        int int6 = mutableInt1.decrementAndGet();
        mutableInt1.add((-27));
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 44 + "'", int6 == 44);
    }

    @Test
    public void test0946() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0946");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.lang.String str8 = org.apache.commons.lang3.text.StrSubstitutor.replaceSystemProperties((java.lang.Object) booleanArray7);
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
    }

    @Test
    public void test0947() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0947");
        org.apache.commons.lang3.function.FailableObjIntConsumer failableObjIntConsumer0 = org.apache.commons.lang3.function.FailableObjIntConsumer.NOP;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj3 = org.apache.commons.lang3.reflect.FieldUtils.readField((java.lang.Object) failableObjIntConsumer0, "4", false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot locate field 4 on class org.apache.commons.lang3.function.FailableObjIntConsumer$$Lambda$138/0x0000000800ccce80");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(failableObjIntConsumer0);
    }

    @Test
    public void test0948() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0948");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair1 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray2 = charSequenceArrayImmutablePair1.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair3 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair1);
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle4 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle5 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str6 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle4, toStringStyle5);
        java.lang.StringBuffer stringBuffer7 = null;
        java.lang.Object obj8 = null;
        standardToStringStyle4.appendStart(stringBuffer7, obj8);
        java.lang.String str10 = standardToStringStyle4.getNullText();
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayImmutablePairReflectionDiffBuilder11 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>>(charSequenceArrayImmutablePair0, charSequenceArrayImmutablePair1, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle4);
        standardToStringStyle4.setSizeEndText("16.0.1+9");
        standardToStringStyle4.setDefaultFullDetail(true);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair1);
        org.junit.Assert.assertNull(charSequenceArray2);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
    }

    @Test
    public void test0949() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0949");
        double[] doubleArray4 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray8 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray8, (double) '4');
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray4, doubleArray8);
        org.apache.commons.lang3.ArrayUtils.shuffle(doubleArray4);
        org.apache.commons.lang3.ArrayUtils.reverse(doubleArray4);
        org.junit.Assert.assertNotNull(doubleArray4);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray4), "[52.0, 1.0, -1.0, 97.0]");
        org.junit.Assert.assertNotNull(doubleArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray8), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test0950() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0950");
        java.util.List<java.util.Locale> localeList0 = org.apache.commons.lang3.LocaleUtils.availableLocaleList();
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream1 = org.apache.commons.lang3.Streams.stream((java.util.Collection<java.util.Locale>) localeList0);
        java.util.stream.Stream<java.util.Locale> localeStream2 = org.apache.commons.lang3.stream.Streams.of((java.lang.Iterable<java.util.Locale>) localeList0);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream3 = org.apache.commons.lang3.function.Failable.stream(localeStream2);
        java.util.stream.Stream<java.util.Locale> localeStream4 = localeFailableStream3.stream();
        org.junit.Assert.assertNotNull(localeList0);
        org.junit.Assert.assertNotNull(localeFailableStream1);
        org.junit.Assert.assertNotNull(localeStream2);
        org.junit.Assert.assertNotNull(localeFailableStream3);
        org.junit.Assert.assertNotNull(localeStream4);
    }

    @Test
    public void test0951() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0951");
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException1 = new org.apache.commons.lang3.exception.ContextedRuntimeException("mixed mode, sharing");
        java.util.stream.IntStream intStream4 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream6 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle7 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle8 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str9 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle7, toStringStyle8);
        java.lang.StringBuffer stringBuffer10 = null;
        java.lang.Object obj11 = null;
        standardToStringStyle7.appendStart(stringBuffer10, obj11);
        java.lang.String str13 = standardToStringStyle7.getNullText();
        standardToStringStyle7.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder17 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream4, (java.lang.AutoCloseable) intStream6, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle7, true);
        long[] longArray20 = new long[] { 3 };
        long[] longArray21 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray20);
        org.apache.commons.lang3.ArrayUtils.shuffle(longArray20);
        long[] longArray24 = new long[] { '4' };
        long[] longArray30 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet33 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray30, (long) '\n', 100);
        boolean boolean34 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray30);
        long[] longArray36 = org.apache.commons.lang3.ArrayUtils.add(longArray30, (long) (short) 101);
        boolean boolean37 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray24, longArray36);
        long[] longArray39 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray36, 60000L);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder40 = autoCloseableDiffBuilder17.append("java.awt.headless", longArray20, longArray39);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException41 = contextedRuntimeException1.addContextValue(" ", (java.lang.Object) longArray20);
        float[] floatArray47 = new float[] { (short) 1, (short) 100, 1.0f, '4' };
        float float48 = org.apache.commons.lang3.math.NumberUtils.min(floatArray47);
        org.apache.commons.lang3.JavaVersion javaVersion49 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion50 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate51 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion49, javaVersion50);
        boolean boolean53 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) floatArray47, (java.lang.Object) javaVersionPredicate51, false);
        float[] floatArray58 = new float[] { (short) 1, (short) 100, 1.0f, '4' };
        float float59 = org.apache.commons.lang3.math.NumberUtils.min(floatArray58);
        org.apache.commons.lang3.JavaVersion javaVersion60 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion61 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate62 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion60, javaVersion61);
        boolean boolean64 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) floatArray58, (java.lang.Object) javaVersionPredicate62, false);
        float[] floatArray69 = new float[] { (short) 1, (short) 100, 1.0f, '4' };
        float float70 = org.apache.commons.lang3.math.NumberUtils.min(floatArray69);
        org.apache.commons.lang3.JavaVersion javaVersion71 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion72 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate73 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion71, javaVersion72);
        boolean boolean75 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) floatArray69, (java.lang.Object) javaVersionPredicate73, false);
        org.apache.commons.lang3.JavaVersion javaVersion76 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion77 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate78 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion76, javaVersion77);
        java.util.function.Predicate[] predicateArray80 = new java.util.function.Predicate[4];
        @SuppressWarnings("unchecked")
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion>[] javaVersionPredicateArray81 = (java.util.function.Predicate<org.apache.commons.lang3.JavaVersion>[]) predicateArray80;
        javaVersionPredicateArray81[0] = javaVersionPredicate51;
        javaVersionPredicateArray81[1] = javaVersionPredicate62;
        javaVersionPredicateArray81[2] = javaVersionPredicate73;
        javaVersionPredicateArray81[3] = javaVersionPredicate78;
        java.util.stream.Stream<java.util.function.Predicate<org.apache.commons.lang3.JavaVersion>> javaVersionPredicateStream90 = org.apache.commons.lang3.stream.Streams.nonNull(javaVersionPredicateArray81);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException91 = contextedRuntimeException41.setContextValue("", (java.lang.Object) javaVersionPredicateStream90);
        org.junit.Assert.assertNotNull(intStream4);
        org.junit.Assert.assertNotNull(intStream6);
        org.junit.Assert.assertNotNull(toStringStyle8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str9, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "<null>" + "'", str13, "<null>");
        org.junit.Assert.assertNotNull(longArray20);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray20), "[3]");
        org.junit.Assert.assertNotNull(longArray21);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray21), "[3]");
        org.junit.Assert.assertNotNull(longArray24);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray24), "[52]");
        org.junit.Assert.assertNotNull(longArray30);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray30), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet33);
        org.junit.Assert.assertEquals(bitSet33.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertNotNull(longArray36);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray36), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        org.junit.Assert.assertNotNull(longArray39);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray39), "[60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder40);
        org.junit.Assert.assertNotNull(contextedRuntimeException41);
        org.junit.Assert.assertNotNull(floatArray47);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray47), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + float48 + "' != '" + 1.0f + "'", float48 == 1.0f);
        org.junit.Assert.assertTrue("'" + javaVersion49 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion49.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion50 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion50.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate51);
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + false + "'", boolean53 == false);
        org.junit.Assert.assertNotNull(floatArray58);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray58), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + float59 + "' != '" + 1.0f + "'", float59 == 1.0f);
        org.junit.Assert.assertTrue("'" + javaVersion60 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion60.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion61 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion61.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate62);
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + false + "'", boolean64 == false);
        org.junit.Assert.assertNotNull(floatArray69);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray69), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + float70 + "' != '" + 1.0f + "'", float70 == 1.0f);
        org.junit.Assert.assertTrue("'" + javaVersion71 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion71.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion72 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion72.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate73);
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + false + "'", boolean75 == false);
        org.junit.Assert.assertTrue("'" + javaVersion76 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion76.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion77 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion77.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate78);
        org.junit.Assert.assertNotNull(predicateArray80);
        org.junit.Assert.assertNotNull(javaVersionPredicateArray81);
        org.junit.Assert.assertNotNull(javaVersionPredicateStream90);
        org.junit.Assert.assertNotNull(contextedRuntimeException91);
    }

    @Test
    public void test0952() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0952");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.removeElement(byteArray3, (byte) 100);
        boolean boolean6 = org.apache.commons.lang3.ArrayUtils.isSorted(byteArray3);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[0, -1]");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test0953() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0953");
        java.lang.String str3 = org.apache.commons.lang3.RandomStringUtils.random(44, false, true);
// flaky:         org.junit.Assert.assertEquals("'" + str3 + "' != '" + "48863097415783261487593240510173336250165997" + "'", str3, "48863097415783261487593240510173336250165997");
    }

    @Test
    public void test0954() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0954");
        long[] longArray5 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray5, (long) '\n', 100);
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray5);
        long[] longArray11 = org.apache.commons.lang3.ArrayUtils.add(longArray5, (long) (short) 101);
        org.apache.commons.lang3.ArrayUtils.shift(longArray11, (int) (byte) 100, 10, (int) 'M');
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray5), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(longArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray11), "[10, 100, 100, 97, 52, 101]");
    }

    @Test
    public void test0955() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0955");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.wrapIfMissing("16.0.1", 'M');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "M16.0.1M" + "'", str2, "M16.0.1M");
    }

    @Test
    public void test0956() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0956");
        org.apache.commons.lang3.function.FailableIntUnaryOperator<org.apache.commons.lang3.SerializationException> serializationExceptionFailableIntUnaryOperator0 = org.apache.commons.lang3.function.FailableIntUnaryOperator.nop();
        org.junit.Assert.assertNotNull(serializationExceptionFailableIntUnaryOperator0);
    }

    @Test
    public void test0957() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0957");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = strTokenizer3.reset("");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer7 = strTokenizer5.setDelimiterString("java.awt.headless");
        java.lang.String str8 = strTokenizer5.nextToken();
        org.junit.Assert.assertNotNull(strTokenizer5);
        org.junit.Assert.assertNotNull(strTokenizer7);
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test0958() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0958");
        float float3 = org.apache.commons.lang3.math.NumberUtils.min((float) (-1L), 0.0f, (float) ' ');
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + (-1.0f) + "'", float3 == (-1.0f));
    }

    @Test
    public void test0959() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0959");
        java.lang.String str1 = org.apache.commons.lang3.BooleanUtils.toStringTrueFalse(true);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "true" + "'", str1, "true");
    }

    @Test
    public void test0960() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0960");
        boolean boolean1 = org.apache.commons.lang3.CharUtils.isAsciiPrintable('$');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0961() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0961");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.LINE_SEPARATOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "\n" + "'", str0, "\n");
    }

    @Test
    public void test0962() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0962");
        short short1 = org.apache.commons.lang3.ObjectUtils.CONST_SHORT((int) 'a');
        org.junit.Assert.assertTrue("'" + short1 + "' != '" + (short) 97 + "'", short1 == (short) 97);
    }

    @Test
    public void test0963() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0963");
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException2, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException6 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException5);
        java.io.PrintStream printStream7 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.exception.ExceptionUtils.printRootCauseStackTrace((java.lang.Throwable) notImplementedException5, printStream7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: printStream");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray3);
    }

    @Test
    public void test0964() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0964");
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = org.apache.commons.lang3.text.StrMatcher.stringMatcher(" ");
        org.junit.Assert.assertNotNull(strMatcher1);
    }

    @Test
    public void test0965() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0965");
        java.util.Calendar calendar0 = null;
        java.util.Calendar calendar1 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean2 = org.apache.commons.lang3.time.DateUtils.isSameInstant(calendar0, calendar1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: cal1");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0966() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0966");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isAlphanumeric((java.lang.CharSequence) ".]Wr1`~U#8P1RR^y~QA|^cKs1{%\\1T?5lK0:E`Sb.&C>Ti|7U`_rdX-~ezvoa,]'Y`!G4\"%H.wF)`\",%`~,Oq)sru73.75Tg2");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0967() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0967");
        double[] doubleArray0 = null;
        double[] doubleArray2 = org.apache.commons.lang3.ArrayUtils.addFirst(doubleArray0, (double) 10L);
        double[] doubleArray5 = org.apache.commons.lang3.ArrayUtils.subarray(doubleArray2, 3, (int) '\n');
        double[] doubleArray7 = org.apache.commons.lang3.ArrayFill.fill(doubleArray5, (double) 17);
        org.junit.Assert.assertNotNull(doubleArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray2), "[10.0]");
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[]");
        org.junit.Assert.assertNotNull(doubleArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray7), "[]");
    }

    @Test
    public void test0968() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0968");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.addFirst(byteArray2, (byte) -1);
        byte[] byteArray6 = org.apache.commons.lang3.ArraySorter.sort(byteArray2);
        org.apache.commons.lang3.ArrayUtils.reverse(byteArray6);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[-1, 0, -1]");
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray6), "[0, -1]");
    }

    @Test
    public void test0969() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0969");
        org.apache.commons.lang3.function.FailableDoubleUnaryOperator<java.lang.Exception> exceptionFailableDoubleUnaryOperator0 = org.apache.commons.lang3.function.FailableDoubleUnaryOperator.identity();
        org.junit.Assert.assertNotNull(exceptionFailableDoubleUnaryOperator0);
    }

    @Test
    public void test0970() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0970");
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException2, "Integer");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer6 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService7 = multiBackgroundInitializer6.getExternalExecutor();
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer9 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService10 = multiBackgroundInitializer9.getExternalExecutor();
        multiBackgroundInitializer6.addInitializer("60.0", (org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>) multiBackgroundInitializer9);
        org.apache.commons.lang3.tuple.MutablePair<org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.concurrent.MultiBackgroundInitializer> notImplementedExceptionMutablePair12 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull(notImplementedException5, multiBackgroundInitializer9);
        java.lang.Class<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierClass13 = org.apache.commons.lang3.ObjectUtils.getClass((org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>) multiBackgroundInitializer9);
        boolean boolean14 = multiBackgroundInitializer9.isStarted();
        java.util.concurrent.ExecutorService executorService15 = multiBackgroundInitializer9.getExternalExecutor();
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(executorService15);
    }

    @Test
    public void test0971() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0971");
        java.lang.String str1 = org.apache.commons.lang3.CharUtils.toString('$');
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "$" + "'", str1, "$");
    }

    @Test
    public void test0972() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0972");
        char[] charArray7 = new char[] { ' ', '#' };
        char[] charArray9 = new char[] { ' ' };
        char[] charArray10 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray7, charArray9);
        char[] charArray13 = org.apache.commons.lang3.ArrayUtils.add(charArray9, (int) (short) 0, ' ');
        char[] charArray18 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray21 = org.apache.commons.lang3.ArrayUtils.subarray(charArray18, (int) (short) 1, (-1));
        char[] charArray22 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray9, charArray18);
        char[] charArray24 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(charArray9, 'o');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer26 = new org.apache.commons.lang3.text.StrTokenizer(charArray24, '#');
        java.util.Random random27 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str28 = org.apache.commons.lang3.RandomStringUtils.random((int) '#', 4, (int) '\r', false, false, charArray24, random27);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray7), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray7), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray7), "[ , #]");
        org.junit.Assert.assertNotNull(charArray9);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray9), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray9), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray9), "[ ]");
        org.junit.Assert.assertNotNull(charArray10);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray10), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray10), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray10), "[#]");
        org.junit.Assert.assertNotNull(charArray13);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray13), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray13), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray13), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray18);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray18), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray18), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray18), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray21);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray21), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray21), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray21), "[]");
        org.junit.Assert.assertNotNull(charArray22);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray22), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray22), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray22), "[]");
        org.junit.Assert.assertNotNull(charArray24);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray24), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray24), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray24), "[ ]");
    }

    @Test
    public void test0973() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0973");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort1.setValue((java.lang.Number) (short) 100);
        java.lang.String str4 = mutableShort1.toString();
        mutableShort1.add((java.lang.Number) (byte) 0);
        short short7 = mutableShort1.getAndDecrement();
        mutableShort1.increment();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "100" + "'", str4, "100");
        org.junit.Assert.assertTrue("'" + short7 + "' != '" + (short) 100 + "'", short7 == (short) 100);
    }

    @Test
    public void test0974() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0974");
        org.apache.commons.lang3.text.translate.UnicodeEscaper unicodeEscaper0 = new org.apache.commons.lang3.text.translate.UnicodeEscaper();
    }

    @Test
    public void test0975() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0975");
        java.util.Calendar calendar0 = null;
        java.util.TimeZone timeZone3 = org.apache.commons.lang3.time.FastTimeZone.getGmtTimeZone();
        java.util.Locale locale4 = null;
        java.util.Locale locale5 = org.apache.commons.lang3.LocaleUtils.toLocale(locale4);
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat6 = org.apache.commons.lang3.time.FastDateFormat.getTimeInstance(0, timeZone3, locale4);
        java.util.Locale locale7 = null;
        java.util.Locale locale8 = org.apache.commons.lang3.LocaleUtils.toLocale(locale7);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str9 = org.apache.commons.lang3.time.DateFormatUtils.format(calendar0, "StrTokenizer[not tokenized yet]", timeZone3, locale8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: t");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(timeZone3);
        org.junit.Assert.assertEquals(timeZone3.getDisplayName(), "GMT+00:00");
        org.junit.Assert.assertNotNull(locale5);
        org.junit.Assert.assertEquals(locale5.toString(), "en_SE");
        org.junit.Assert.assertNotNull(fastDateFormat6);
        org.junit.Assert.assertNotNull(locale8);
        org.junit.Assert.assertEquals(locale8.toString(), "en_SE");
    }

    @Test
    public void test0976() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0976");
        java.lang.String str1 = org.apache.commons.lang3.BooleanUtils.toStringTrueFalse((java.lang.Boolean) false);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "false" + "'", str1, "false");
    }

    @Test
    public void test0977() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0977");
        java.lang.Boolean boolean1 = org.apache.commons.lang3.BooleanUtils.toBooleanObject((java.lang.Integer) 1);
        org.junit.Assert.assertEquals("'" + boolean1 + "' != '" + true + "'", boolean1, true);
    }

    @Test
    public void test0978() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0978");
        java.math.RoundingMode roundingMode2 = null;
        java.math.BigDecimal bigDecimal3 = org.apache.commons.lang3.math.NumberUtils.toScaledBigDecimal((java.lang.Float) 32.0f, 17, roundingMode2);
        double double4 = org.apache.commons.lang3.math.NumberUtils.toDouble(bigDecimal3);
        java.math.BigDecimal bigDecimal5 = org.apache.commons.lang3.math.NumberUtils.toScaledBigDecimal(bigDecimal3);
        org.junit.Assert.assertNotNull(bigDecimal3);
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 32.0d + "'", double4 == 32.0d);
        org.junit.Assert.assertNotNull(bigDecimal5);
    }

    @Test
    public void test0979() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0979");
        double[] doubleArray4 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray8 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray8, (double) '4');
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray4, doubleArray8);
        org.apache.commons.lang3.ArrayUtils.reverse(doubleArray4);
        org.apache.commons.lang3.ArrayUtils.reverse(doubleArray4);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray4), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray8), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test0980() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0980");
        java.util.function.Function<java.lang.Object, java.lang.String> objFunction3 = null;
        java.util.stream.Collector<java.lang.Object, ?, java.lang.String> objCollector4 = org.apache.commons.lang3.stream.LangCollectors.joining((java.lang.CharSequence) " ", (java.lang.CharSequence) "StrTokenizer[not tokenized yet]", (java.lang.CharSequence) "100", objFunction3);
        java.util.stream.Collector<java.lang.Object, ?, java.lang.String> objCollector6 = org.apache.commons.lang3.stream.LangCollectors.joining((java.lang.CharSequence) "java.specification.name");
        java.util.stream.Collector<java.lang.Object, ?, java.lang.String> objCollector7 = org.apache.commons.lang3.ObjectUtils.defaultIfNull(objCollector4, objCollector6);
        org.junit.Assert.assertNotNull(objCollector4);
        org.junit.Assert.assertNotNull(objCollector6);
        org.junit.Assert.assertNotNull(objCollector7);
    }

    @Test
    public void test0981() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0981");
        org.apache.commons.lang3.text.translate.UnicodeEscaper unicodeEscaper1 = org.apache.commons.lang3.text.translate.UnicodeEscaper.above(1);
        org.junit.Assert.assertNotNull(unicodeEscaper1);
    }

    @Test
    public void test0982() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0982");
        short[] shortArray3 = new short[] { (short) 1, (short) -1, (byte) 10 };
        boolean boolean4 = org.apache.commons.lang3.ArrayUtils.isSorted(shortArray3);
        short[] shortArray7 = org.apache.commons.lang3.ArrayUtils.subarray(shortArray3, 44, 97);
        org.junit.Assert.assertNotNull(shortArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray3), "[1, -1, 10]");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertNotNull(shortArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray7), "[]");
    }

    @Test
    public void test0983() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0983");
        java.lang.String[] strArray2 = org.apache.commons.lang3.StringUtils.splitPreserveAllTokens("\000\000", 'M');
        org.junit.Assert.assertNotNull(strArray2);
    }

    @Test
    public void test0984() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0984");
        org.apache.commons.lang3.StringEscapeUtils stringEscapeUtils0 = new org.apache.commons.lang3.StringEscapeUtils();
    }

    @Test
    public void test0985() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0985");
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext0 = new org.apache.commons.lang3.exception.DefaultExceptionContext();
        org.apache.commons.lang3.function.FailableBiConsumer<java.io.File, org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.RuntimeException> fileFailableBiConsumer2 = org.apache.commons.lang3.function.FailableBiConsumer.nop();
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext3 = defaultExceptionContext0.addContextValue("\n", (java.lang.Object) fileFailableBiConsumer2);
        java.io.File file4 = org.apache.commons.lang3.SystemUtils.getJavaHome();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle5 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.function.Failable.accept(fileFailableBiConsumer2, file4, (org.apache.commons.lang3.builder.RecursiveToStringStyle) multilineRecursiveToStringStyle5);
        org.apache.commons.lang3.compare.ObjectToStringComparator objectToStringComparator8 = new org.apache.commons.lang3.compare.ObjectToStringComparator();
        org.apache.commons.lang3.Range<java.lang.Object> objRange9 = org.apache.commons.lang3.Range.between((java.lang.Object) file4, (java.lang.Object) "Double", (java.util.Comparator<java.lang.Object>) objectToStringComparator8);
        org.junit.Assert.assertNotNull(fileFailableBiConsumer2);
        org.junit.Assert.assertNotNull(defaultExceptionContext3);
        org.junit.Assert.assertNotNull(file4);
        org.junit.Assert.assertEquals(file4.getParent(), "/Library/Java/JavaVirtualMachines/adoptopenjdk-16.jdk/Contents");
        org.junit.Assert.assertEquals(file4.toString(), "/Library/Java/JavaVirtualMachines/adoptopenjdk-16.jdk/Contents/Home");
        org.junit.Assert.assertNotNull(objRange9);
    }

    @Test
    public void test0986() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0986");
        int int0 = org.apache.commons.lang3.time.DateUtils.RANGE_MONTH_MONDAY;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 6 + "'", int0 == 6);
    }

    @Test
    public void test0987() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0987");
        int[] intArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_INT_ARRAY;
        org.junit.Assert.assertNotNull(intArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray0), "[]");
    }

    @Test
    public void test0988() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0988");
        boolean boolean1 = org.apache.commons.lang3.BooleanUtils.isFalse((java.lang.Boolean) true);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0989() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0989");
        java.lang.reflect.Method[] methodArray0 = new java.lang.reflect.Method[] {};
        java.lang.reflect.Method[] methodArray1 = new java.lang.reflect.Method[] {};
        java.lang.reflect.Method[] methodArray2 = new java.lang.reflect.Method[] {};
        java.lang.reflect.Method[] methodArray3 = new java.lang.reflect.Method[] {};
        java.lang.reflect.Method[][] methodArray4 = new java.lang.reflect.Method[][] { methodArray0, methodArray1, methodArray2, methodArray3 };
        java.lang.reflect.Method method5 = null;
        java.lang.reflect.Method[] methodArray6 = new java.lang.reflect.Method[] { method5 };
        java.lang.reflect.Method[][] methodArray7 = org.apache.commons.lang3.ArrayUtils.addFirst(methodArray4, methodArray6);
        org.junit.Assert.assertNotNull(methodArray0);
        org.junit.Assert.assertNotNull(methodArray1);
        org.junit.Assert.assertNotNull(methodArray2);
        org.junit.Assert.assertNotNull(methodArray3);
        org.junit.Assert.assertNotNull(methodArray4);
        org.junit.Assert.assertNotNull(methodArray6);
        org.junit.Assert.assertNotNull(methodArray7);
    }

    @Test
    public void test0990() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0990");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.builder.HashCodeBuilder hashCodeBuilder2 = new org.apache.commons.lang3.builder.HashCodeBuilder(8, (int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: HashCodeBuilder requires an odd initial value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0991() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0991");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.replaceOnceIgnoreCase("StrTokenizer[not tokenized yet]", ",", "FastDateFormat[,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "StrTokenizer[not tokenized yet]" + "'", str3, "StrTokenizer[not tokenized yet]");
    }

    @Test
    public void test0992() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0992");
        org.apache.commons.lang3.function.FailableLongUnaryOperator<org.apache.commons.lang3.SerializationException> serializationExceptionFailableLongUnaryOperator0 = org.apache.commons.lang3.function.FailableLongUnaryOperator.identity();
        org.junit.Assert.assertNotNull(serializationExceptionFailableLongUnaryOperator0);
    }

    @Test
    public void test0993() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0993");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.setMonths(date0, (-27));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0994() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0994");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        boolean[] booleanArray9 = org.apache.commons.lang3.ArrayUtils.removeElement(booleanArray5, true);
        java.util.Random random10 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(booleanArray9, random10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(booleanArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray9), "[false, false, true, false]");
    }

    @Test
    public void test0995() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0995");
        char char2 = org.apache.commons.lang3.CharUtils.toChar("org.apache.commons.lang3.function", '6');
        org.junit.Assert.assertTrue("'" + char2 + "' != '" + 'o' + "'", char2 == 'o');
    }

    @Test
    public void test0996() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0996");
        java.lang.String str1 = org.apache.commons.lang3.BooleanUtils.toStringYesNo(false);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "no" + "'", str1, "no");
    }

    @Test
    public void test0997() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0997");
        // The following exception was thrown during execution in test generation
        try {
            int int3 = org.apache.commons.lang3.StringUtils.getLevenshteinDistance((java.lang.CharSequence) "aee", (java.lang.CharSequence) "long", (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Threshold must not be negative");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0998() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0998");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        java.lang.Object obj4 = null;
        standardToStringStyle0.appendStart(stringBuffer3, obj4);
        java.lang.String str6 = standardToStringStyle0.getNullText();
        java.lang.String str7 = standardToStringStyle0.getArraySeparator();
        java.lang.String str8 = standardToStringStyle0.getArrayEnd();
        boolean boolean9 = standardToStringStyle0.isUseClassName();
        java.lang.String str10 = standardToStringStyle0.getFieldNameValueSeparator();
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "<null>" + "'", str6, "<null>");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "," + "'", str7, ",");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "}" + "'", str8, "}");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "=" + "'", str10, "=");
    }

    @Test
    public void test0999() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test0999");
        java.util.function.Supplier<java.lang.UnsupportedOperationException> unsupportedOperationExceptionSupplier0 = null;
        java.util.function.Supplier[] supplierArray2 = new java.util.function.Supplier[1];
        @SuppressWarnings("unchecked")
        java.util.function.Supplier<java.lang.UnsupportedOperationException>[] unsupportedOperationExceptionSupplierArray3 = (java.util.function.Supplier<java.lang.UnsupportedOperationException>[]) supplierArray2;
        unsupportedOperationExceptionSupplierArray3[0] = unsupportedOperationExceptionSupplier0;
        java.lang.UnsupportedOperationException unsupportedOperationException6 = org.apache.commons.lang3.ObjectUtils.getFirstNonNull(unsupportedOperationExceptionSupplierArray3);
        org.junit.Assert.assertNotNull(supplierArray2);
        org.junit.Assert.assertNotNull(unsupportedOperationExceptionSupplierArray3);
        org.junit.Assert.assertNull(unsupportedOperationException6);
    }

    @Test
    public void test1000() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test1000");
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException0 = new org.apache.commons.lang3.exception.ContextedRuntimeException();
    }
}
