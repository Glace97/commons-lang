package org.apache.commons.lang3.randoop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test0001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0001");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_IRIX;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0002");
        java.lang.Boolean boolean1 = org.apache.commons.lang3.BooleanUtils.toBooleanObject((java.lang.Integer) 10);
        org.junit.Assert.assertEquals("'" + boolean1 + "' != '" + true + "'", boolean1, true);
    }

    @Test
    public void test0003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0003");
        java.lang.reflect.Type type0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str1 = org.apache.commons.lang3.reflect.TypeUtils.toString(type0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: type");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0004");
        java.lang.CharSequence charSequence1 = null;
        int int3 = org.apache.commons.lang3.StringUtils.indexOfIgnoreCase((java.lang.CharSequence) "hi!", charSequence1, (int) (short) -1);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test0005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0005");
        org.apache.commons.lang3.CharSet charSet0 = org.apache.commons.lang3.CharSet.EMPTY;
        org.junit.Assert.assertNotNull(charSet0);
    }

//    @Test
//    public void test0006() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0006");
//        org.apache.commons.lang3.tuple.ImmutableTriple<java.lang.String, java.lang.constant.ConstantDesc, java.lang.constant.Constable>[] strImmutableTripleArray0 = null;
//        boolean boolean2 = org.apache.commons.lang3.ArrayUtils.isArrayIndexValid(strImmutableTripleArray0, 10);
//        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
//    }

    @Test
    public void test0007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0007");
        java.util.Locale locale1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.FastDateFormat.getTimeInstance((int) (byte) -1, locale1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal time style -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0008");
        org.apache.commons.lang3.function.FailablePredicate failablePredicate0 = org.apache.commons.lang3.function.FailablePredicate.FALSE;
        org.junit.Assert.assertNotNull(failablePredicate0);
    }

    @Test
    public void test0009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0009");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_UTIL_PREFS_PREFERENCES_FACTORY;
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0010");
        long[] longArray6 = new long[] { (byte) 10, (short) 10, ' ', 'a', (short) -1, (byte) 10 };
        java.util.Random random7 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(longArray6, random7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray6), "[10, 10, 32, 97, -1, 10]");
    }

    @Test
    public void test0011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0011");
        java.lang.reflect.Type type0 = null;
        java.lang.reflect.Type type1 = null;
        boolean boolean2 = org.apache.commons.lang3.reflect.TypeUtils.isAssignable(type0, type1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test0012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0012");
        java.lang.String[][] strArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String[][] strArray1 = org.apache.commons.lang3.text.translate.EntityArrays.invert(strArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read the array length because \"array\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0013");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_SIERRA;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0014");
        float float3 = org.apache.commons.lang3.math.NumberUtils.min(0.0f, (float) 1L, (-1.0f));
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + (-1.0f) + "'", float3 == (-1.0f));
    }

    @Test
    public void test0015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0015");
        org.apache.commons.lang3.function.FailableFunction failableFunction0 = org.apache.commons.lang3.function.FailableFunction.NOP;
        org.junit.Assert.assertNotNull(failableFunction0);
    }

    @Test
    public void test0016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0016");
        char char0 = org.apache.commons.lang3.CharUtils.LF;
        org.junit.Assert.assertTrue("'" + char0 + "' != '" + '\n' + "'", char0 == '\n');
    }

    @Test
    public void test0017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0017");
        java.lang.String str0 = org.apache.commons.lang3.CharEncoding.UTF_16;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-16" + "'", str0, "UTF-16");
    }

    @Test
    public void test0018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0018");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.escapeXml("581cd446");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "581cd446" + "'", str1, "581cd446");
    }

    @Test
    public void test0019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0019");
        // The following exception was thrown during execution in test generation
        try {
            int int1 = org.apache.commons.lang3.CharUtils.toIntValue('#');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The character # is not in the range '0' - '9'");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0020");
        java.util.UUID uUID0 = null;
        byte[] byteArray2 = new byte[] { (byte) 100 };
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray5 = org.apache.commons.lang3.Conversion.uuidToByteArray(uUID0, byteArray2, (int) (short) 100, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.UUID.getMostSignificantBits()\" because \"src\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[100]");
    }

    @Test
    public void test0021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0021");
        java.util.function.BooleanSupplier booleanSupplier1 = null;
        boolean boolean2 = org.apache.commons.lang3.SystemProperties.getBoolean("UTF-16", booleanSupplier1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0022");
        java.lang.String str0 = org.apache.commons.lang3.builder.DiffResult.OBJECTS_SAME_STRING;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "" + "'", str0, "");
    }

    @Test
    public void test0023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0023");
        java.util.TimeZone timeZone2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = org.apache.commons.lang3.time.DateFormatUtils.format(0L, "UTF-16", timeZone2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: U");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0024");
        java.lang.Throwable throwable1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.ConcurrentRuntimeException concurrentRuntimeException2 = new org.apache.commons.lang3.concurrent.ConcurrentRuntimeException("hi!", throwable1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Not a checked exception: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0025");
        java.util.Formatter formatter1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Formatter formatter6 = org.apache.commons.lang3.text.FormattableUtils.append((java.lang.CharSequence) "", formatter1, (int) (byte) 1, (int) (short) -1, (int) (byte) -1, '\n');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Formatter.format(String, Object[])\" because \"formatter\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0026");
        java.lang.String str0 = org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.PROPERTY_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "open" + "'", str0, "open");
    }

    @Test
    public void test0027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0027");
        byte[] byteArray0 = new byte[] {};
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator1 = org.apache.commons.lang3.SerializationUtils.deserialize(byteArray0);
            org.junit.Assert.fail("Expected exception of type org.apache.commons.lang3.SerializationException; message: java.io.EOFException");
        } catch (org.apache.commons.lang3.SerializationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray0), "[]");
    }

    @Test
    public void test0028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0028");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.addMinutes(date0, (int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0029");
        boolean boolean2 = org.apache.commons.lang3.StringUtils.startsWithIgnoreCase((java.lang.CharSequence) "UTF-16", (java.lang.CharSequence) "hi!");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0030");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_MOJAVE;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0031");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.OS_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Mac OS X" + "'", str0, "Mac OS X");
    }

    @Test
    public void test0032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0032");
        java.lang.Throwable throwable1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.ConcurrentRuntimeException concurrentRuntimeException2 = new org.apache.commons.lang3.concurrent.ConcurrentRuntimeException("open", throwable1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Not a checked exception: null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0033");
        java.util.Calendar calendar0 = null;
        java.util.TimeZone timeZone2 = null;
        java.util.Locale locale3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = org.apache.commons.lang3.time.DateFormatUtils.format(calendar0, "UTF-16", timeZone2, locale3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: U");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0034");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_VM_INFO;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "mixed mode, sharing" + "'", str0, "mixed mode, sharing");
    }

//    @Test
//    public void test0035() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0035");
//        org.apache.commons.lang3.builder.ToStringStyle toStringStyle2 = null;
//        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder3 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle2);
//        // The following exception was thrown during execution in test generation
//        try {
//            org.apache.commons.lang3.builder.DiffResult<java.io.Serializable> serializableDiffResult4 = serializableReflectionDiffBuilder3.build();
//            org.junit.Assert.fail("Expected exception of type java.lang.reflect.InaccessibleObjectException; message: Unable to make field private final byte java.lang.Byte.value accessible: module java.base does not \"opens java.lang\" to unnamed module @654b5005");
//        } catch (java.lang.reflect.InaccessibleObjectException e) {
//            // Expected exception.
//        }
//    }

    @Test
    public void test0036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0036");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.replacePattern("mixed mode, sharing", "open", "mixed mode, sharing");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "mixed mode, sharing" + "'", str3, "mixed mode, sharing");
    }

    @Test
    public void test0037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0037");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper0 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper1 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper2 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper3 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper4 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper5 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper6 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray7 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper1, unicodeUnescaper2, unicodeUnescaper3, unicodeUnescaper4, unicodeUnescaper5, unicodeUnescaper6 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator8 = unicodeUnescaper0.with(charSequenceTranslatorArray7);
        java.lang.String str9 = org.apache.commons.lang3.ObjectUtils.hashCodeHex((java.lang.Object) charSequenceTranslator8);
        java.io.Writer writer11 = null;
        // The following exception was thrown during execution in test generation
        try {
            charSequenceTranslator8.translate((java.lang.CharSequence) "mixed mode, sharing", writer11);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: writer");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray7);
        org.junit.Assert.assertNotNull(charSequenceTranslator8);
// flaky:         org.junit.Assert.assertEquals("'" + str9 + "' != '" + "4b0f71f4" + "'", str9, "4b0f71f4");
    }

    @Test
    public void test0038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0038");
        byte byte2 = org.apache.commons.lang3.math.NumberUtils.toByte("hi!", (byte) 100);
        org.junit.Assert.assertTrue("'" + byte2 + "' != '" + (byte) 100 + "'", byte2 == (byte) 100);
    }

    @Test
    public void test0039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0039");
        org.apache.commons.lang3.function.FailableLongToDoubleFunction failableLongToDoubleFunction0 = org.apache.commons.lang3.function.FailableLongToDoubleFunction.NOP;
        org.junit.Assert.assertNotNull(failableLongToDoubleFunction0);
    }

    @Test
    public void test0040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0040");
        java.time.Duration duration0 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean1 = org.apache.commons.lang3.time.DurationUtils.isPositive(duration0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.Duration.isNegative()\" because \"duration\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0041");
        int int2 = org.apache.commons.lang3.StringUtils.indexOf((java.lang.CharSequence) "open", 10);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test0042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0042");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.substring("open", 1, (int) '\n');
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "pen" + "'", str3, "pen");
    }

    @Test
    public void test0043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0043");
        int[] intArray1 = new int[] { '\n' };
        java.util.BitSet bitSet4 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray1, (int) (byte) -1, (int) (short) -1);
        java.lang.Long[] longArray13 = new java.lang.Long[] { 10L, 0L, (-1L), (-1L), 10L, 1L };
        java.lang.Long[] longArray14 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray13);
        java.lang.Class<?> wildcardClass15 = null;
        java.lang.Class[] classArray17 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray18 = (java.lang.Class<?>[]) classArray17;
        wildcardClassArray18[0] = wildcardClass15;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj21 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) intArray1, false, "", (java.lang.Object[]) longArray13, wildcardClassArray18);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: () on object: [I");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray1), "[10]");
        org.junit.Assert.assertNotNull(bitSet4);
        org.junit.Assert.assertEquals(bitSet4.toString(), "{}");
        org.junit.Assert.assertNotNull(longArray13);
        org.junit.Assert.assertNotNull(longArray14);
        org.junit.Assert.assertNotNull(classArray17);
        org.junit.Assert.assertNotNull(wildcardClassArray18);
    }

    @Test
    public void test0044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0044");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getOsName();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Mac OS X" + "'", str0, "Mac OS X");
    }

    @Test
    public void test0045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0045");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.substringBetween("Mac OS X", "581cd446", "hi!");
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test0046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0046");
        org.apache.commons.lang3.Functions functions0 = new org.apache.commons.lang3.Functions();
    }

    @Test
    public void test0047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0047");
        java.lang.String str2 = org.apache.commons.lang3.ClassUtils.getPackageCanonicalName((java.lang.Object) (byte) 1, "UTF-16");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "java.lang" + "'", str2, "java.lang");
    }

    @Test
    public void test0048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0048");
        double double3 = org.apache.commons.lang3.math.NumberUtils.min((double) (short) 1, 0.0d, (double) (short) 100);
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 0.0d + "'", double3 == 0.0d);
    }

    @Test
    public void test0049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0049");
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle0 = org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
        java.lang.StringBuffer stringBuffer1 = null;
        boolean[] booleanArray8 = new boolean[] { true, true, false, true, false };
        // The following exception was thrown during execution in test generation
        try {
            toStringStyle0.append(stringBuffer1, "mixed mode, sharing", booleanArray8, (java.lang.Boolean) false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(toStringStyle0);
        org.junit.Assert.assertNotNull(booleanArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray8), "[true, true, false, true, false]");
    }

    @Test
    public void test0050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0050");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer0 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        // The following exception was thrown during execution in test generation
        try {
            java.util.concurrent.Future<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults> multiBackgroundInitializerResultsFuture1 = multiBackgroundInitializer0.getFuture();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: start() must be called first!");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0051");
        java.lang.String str2 = org.apache.commons.lang3.ClassUtils.getShortCanonicalName((java.lang.Object) 1L, "hi!");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Long" + "'", str2, "Long");
    }

    @Test
    public void test0052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0052");
        org.apache.commons.lang3.function.FailableLongConsumer<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableLongConsumer0 = org.apache.commons.lang3.function.FailableLongConsumer.nop();
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableLongConsumer0);
    }

    @Test
    public void test0053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0053");
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle0 = org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
        java.lang.StringBuffer stringBuffer1 = null;
        char[] charArray5 = new char[] { ' ', '#' };
        char[] charArray7 = new char[] { ' ' };
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray5, charArray7);
        // The following exception was thrown during execution in test generation
        try {
            toStringStyle0.append(stringBuffer1, "UTF-16", charArray8, (java.lang.Boolean) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(toStringStyle0);
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
    }

    @Test
    public void test0054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0054");
        org.apache.commons.lang3.AnnotationUtils annotationUtils0 = new org.apache.commons.lang3.AnnotationUtils();
    }

    @Test
    public void test0055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0055");
        java.util.TimeZone timeZone1 = null;
        java.util.Locale locale2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.time.FastDateFormat fastDateFormat3 = org.apache.commons.lang3.time.FastDateFormat.getTimeInstance((int) (byte) -1, timeZone1, locale2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal time style -1");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0056");
        int int2 = org.apache.commons.lang3.math.NumberUtils.compare((short) -1, (short) 0);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test0057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0057");
        org.apache.commons.lang3.time.DurationFormatUtils durationFormatUtils0 = new org.apache.commons.lang3.time.DurationFormatUtils();
    }

    @Test
    public void test0058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0058");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.chomp("open", "open");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test0059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0059");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.addMonths(date0, (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0060");
        java.lang.String str1 = org.apache.commons.lang3.CharUtils.toString((java.lang.Character) ' ');
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + " " + "'", str1, " ");
    }

    @Test
    public void test0061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0061");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_VERSION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "16.0.1" + "'", str0, "16.0.1");
    }

    @Test
    public void test0062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0062");
        short[] shortArray3 = new short[] { (short) 1, (short) -1, (byte) 10 };
        boolean boolean4 = org.apache.commons.lang3.ArrayUtils.isSorted(shortArray3);
        short[] shortArray5 = null;
        boolean boolean6 = org.apache.commons.lang3.ArrayUtils.isSameLength(shortArray3, shortArray5);
        org.junit.Assert.assertNotNull(shortArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray3), "[1, -1, 10]");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test0063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0063");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = org.apache.commons.lang3.RandomStringUtils.random((int) (byte) 1, (int) (byte) 100, (int) 'a', false, false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Parameter end (97) must be greater than start (100)");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0064");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_2012;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0065");
        java.lang.String str2 = org.apache.commons.lang3.RandomStringUtils.randomGraph(0, (int) '4');
// flaky:         org.junit.Assert.assertEquals("'" + str2 + "' != '" + ";ClT9Ss'St<Q" + "'", str2, ";ClT9Ss'St<Q");
    }

    @Test
    public void test0066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0066");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_HP_UX;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0067");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean1 = new org.apache.commons.lang3.mutable.MutableBoolean((java.lang.Boolean) true);
        org.apache.commons.lang3.CharUtils charUtils2 = new org.apache.commons.lang3.CharUtils();
        boolean boolean3 = mutableBoolean1.equals((java.lang.Object) charUtils2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test0068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0068");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.time.DateUtils.getFragmentInDays(calendar0, 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: calendar");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0069");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper0 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        java.lang.String str2 = org.apache.commons.lang3.ClassUtils.getShortClassName((java.lang.Object) unicodeUnescaper0, "Long");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "UnicodeUnescaper" + "'", str2, "UnicodeUnescaper");
    }

    @Test
    public void test0070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0070");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.OS_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "os.name" + "'", str0, "os.name");
    }

    @Test
    public void test0071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0071");
        java.lang.String str4 = org.apache.commons.lang3.text.WordUtils.wrap(" ", (int) (short) 0, "UTF-16", false);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "" + "'", str4, "");
    }

    @Test
    public void test0072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0072");
        java.lang.String str1 = org.apache.commons.lang3.text.WordUtils.uncapitalize("Long");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "long" + "'", str1, "long");
    }

    @Test
    public void test0073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0073");
        java.lang.StringBuffer stringBuffer0 = null;
        org.apache.commons.lang3.function.FailableIntToDoubleFunction failableIntToDoubleFunction1 = org.apache.commons.lang3.function.FailableIntToDoubleFunction.NOP;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ObjectUtils.identityToString(stringBuffer0, (java.lang.Object) failableIntToDoubleFunction1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.length()\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(failableIntToDoubleFunction1);
    }

    @Test
    public void test0074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0074");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_NET_BSD;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0075");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle0 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        java.lang.StringBuffer stringBuffer1 = null;
        boolean[] booleanArray6 = new boolean[] { true, true, false };
        // The following exception was thrown during execution in test generation
        try {
            multilineRecursiveToStringStyle0.append(stringBuffer1, "", booleanArray6, (java.lang.Boolean) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray6), "[true, true, false]");
    }

    @Test
    public void test0076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0076");
        java.util.concurrent.TimeUnit timeUnit2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.EventCountCircuitBreaker eventCountCircuitBreaker4 = new org.apache.commons.lang3.concurrent.EventCountCircuitBreaker((int) (byte) 10, (long) (byte) 0, timeUnit2, (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.concurrent.TimeUnit.toNanos(long)\" because \"openingUnit\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0077");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.OS_VERSION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "os.version" + "'", str0, "os.version");
    }

    @Test
    public void test0078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0078");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_SUN_OS;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0079");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_AIX;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0080");
        java.lang.reflect.Field field0 = null;
        org.apache.commons.lang3.stream.IntStreams intStreams1 = new org.apache.commons.lang3.stream.IntStreams();
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean3 = new org.apache.commons.lang3.mutable.MutableBoolean((java.lang.Boolean) true);
        boolean boolean5 = mutableBoolean3.equals((java.lang.Object) 0.0f);
        boolean boolean6 = mutableBoolean3.isTrue();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.reflect.FieldUtils.writeField(field0, (java.lang.Object) intStreams1, (java.lang.Object) boolean6, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: field");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test0081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0081");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle0 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        java.lang.StringBuffer stringBuffer1 = null;
        char[] charArray5 = new char[] { ' ', '#' };
        char[] charArray7 = new char[] { ' ' };
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray5, charArray7);
        // The following exception was thrown during execution in test generation
        try {
            multilineRecursiveToStringStyle0.append(stringBuffer1, "Mac OS X", charArray5, (java.lang.Boolean) true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
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
    }

    @Test
    public void test0082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0082");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_RUNTIME_VERSION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "16.0.1+9" + "'", str0, "16.0.1+9");
    }

    @Test
    public void test0083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0083");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_TIGER;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0084");
        int[] intArray5 = new int[] { (short) 100, (short) 10, (short) 10, '\n', '\n' };
        int[] intArray7 = org.apache.commons.lang3.ArrayUtils.add(intArray5, (int) '4');
        java.util.Random random8 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(intArray7, random8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray5), "[100, 10, 10, 10, 10]");
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray7), "[100, 10, 10, 10, 10, 52]");
    }

    @Test
    public void test0085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0085");
        short short1 = org.apache.commons.lang3.ObjectUtils.CONST_SHORT(1);
        org.junit.Assert.assertTrue("'" + short1 + "' != '" + (short) 1 + "'", short1 == (short) 1);
    }

    @Test
    public void test0086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0086");
        char[] charArray1 = org.apache.commons.lang3.CharSequenceUtils.toCharArray((java.lang.CharSequence) "UTF-16");
        org.junit.Assert.assertNotNull(charArray1);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray1), "UTF-16");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray1), "UTF-16");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray1), "[U, T, F, -, 1, 6]");
    }

    @Test
    public void test0087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0087");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray4 = strTokenizer3.getTokenArray();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = strTokenizer3.previous();
            org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException; message: null");
        } catch (java.util.NoSuchElementException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray4);
    }

    @Test
    public void test0088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0088");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_VM_VENDOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "AdoptOpenJDK" + "'", str0, "AdoptOpenJDK");
    }

    @Test
    public void test0089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0089");
        java.lang.String str1 = org.apache.commons.lang3.BooleanUtils.toStringOnOff((java.lang.Boolean) true);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "on" + "'", str1, "on");
    }

    @Test
    public void test0090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0090");
        java.util.Map<java.lang.Object, java.lang.Object> objMap0 = org.apache.commons.lang3.builder.ToStringStyle.getRegistry();
        org.junit.Assert.assertNull(objMap0);
    }

    @Test
    public void test0091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0091");
        java.lang.String str1 = org.apache.commons.lang3.ClassUtils.getSimpleName((java.lang.Object) 1);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Integer" + "'", str1, "Integer");
    }

    @Test
    public void test0092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0092");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.PATH_SEPARATOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + ":" + "'", str0, ":");
    }

    @Test
    public void test0093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0093");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.leftPad("open", (int) (byte) 100);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "                                                                                                open" + "'", str2, "                                                                                                open");
    }

    @Test
    public void test0094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0094");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Long long1 = org.apache.commons.lang3.math.NumberUtils.createLong("UnicodeUnescaper");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"UnicodeUnescaper\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0095");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaClassVersion();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "60.0" + "'", str0, "60.0");
    }

    @Test
    public void test0096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0096");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_ENDORSED_DIRS;
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0097");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_JAGUAR;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0098");
        java.lang.String str0 = org.apache.commons.lang3.BooleanUtils.TRUE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "true" + "'", str0, "true");
    }

//    @Test
//    public void test0099() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0099");
//        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
//        // The following exception was thrown during execution in test generation
//        try {
//            java.lang.String str4 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString((java.lang.Object) ";ClT9Ss'St<Q", toStringStyle1, true, true);
//            org.junit.Assert.fail("Expected exception of type java.lang.reflect.InaccessibleObjectException; message: Unable to make field static final boolean java.lang.String.COMPACT_STRINGS accessible: module java.base does not \"opens java.lang\" to unnamed module @654b5005");
//        } catch (java.lang.reflect.InaccessibleObjectException e) {
//            // Expected exception.
//        }
//        org.junit.Assert.assertNotNull(toStringStyle1);
//    }

    @Test
    public void test0100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0100");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.USER_NAME_KEY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "user.name" + "'", str0, "user.name");
    }

    @Test
    public void test0101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0101");
        double[] doubleArray3 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean5 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray3, (double) '4');
        java.util.Random random6 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(doubleArray3, random6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(doubleArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray3), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test0102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0102");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_UNIX;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test0103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0103");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.isTrue(false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The validated expression is false");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0104");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.builder.HashCodeBuilder hashCodeBuilder2 = new org.apache.commons.lang3.builder.HashCodeBuilder(1, (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: HashCodeBuilder requires an odd multiplier");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0105");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.removeStart("581cd446", '#');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "581cd446" + "'", str2, "581cd446");
    }

    @Test
    public void test0106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0106");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_VM_VERSION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "16.0.1+9" + "'", str0, "16.0.1+9");
    }

    @Test
    public void test0107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0107");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.wrap("16.0.1+9", 'a');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "a16.0.1+9a" + "'", str2, "a16.0.1+9a");
    }

    @Test
    public void test0108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0108");
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
    public void test0109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0109");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.unwrap("pen", ":");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "pen" + "'", str2, "pen");
    }

    @Test
    public void test0110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0110");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Thread thread1 = org.apache.commons.lang3.ThreadUtils.findThreadById((long) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The thread id must be greater than zero");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0111");
        java.lang.String str5 = org.apache.commons.lang3.Conversion.shortToHex((short) (byte) -1, (int) (short) 100, "hi!", 1, 0);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "hi!" + "'", str5, "hi!");
    }

    @Test
    public void test0112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0112");
        int int0 = org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + (-1) + "'", int0 == (-1));
    }

    @Test
    public void test0113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0113");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.stripAccents("AdoptOpenJDK");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "AdoptOpenJDK" + "'", str1, "AdoptOpenJDK");
    }

    @Test
    public void test0114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0114");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_HIGH_SIERRA;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0115");
        float float3 = org.apache.commons.lang3.math.IEEE754rUtils.max((float) ' ', 0.0f, (float) 0);
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + 32.0f + "'", float3 == 32.0f);
    }

    @Test
    public void test0116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0116");
        int int3 = org.apache.commons.lang3.StringUtils.compare("UnicodeUnescaper", "pen", false);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-27) + "'", int3 == (-27));
    }

    @Test
    public void test0117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0117");
        org.apache.commons.lang3.function.FailableLongPredicate<org.apache.commons.lang3.exception.UncheckedException> uncheckedExceptionFailableLongPredicate0 = org.apache.commons.lang3.function.FailableLongPredicate.truePredicate();
        org.junit.Assert.assertNotNull(uncheckedExceptionFailableLongPredicate0);
    }

    @Test
    public void test0118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0118");
        org.apache.commons.lang3.text.translate.JavaUnicodeEscaper javaUnicodeEscaper2 = org.apache.commons.lang3.text.translate.JavaUnicodeEscaper.outsideOf((-1), (int) (short) 101);
        org.junit.Assert.assertNotNull(javaUnicodeEscaper2);
    }

    @Test
    public void test0119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0119");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper4 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper5 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper6 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper7 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper8 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper9 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper10 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray11 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper5, unicodeUnescaper6, unicodeUnescaper7, unicodeUnescaper8, unicodeUnescaper9, unicodeUnescaper10 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator12 = unicodeUnescaper4.with(charSequenceTranslatorArray11);
        java.lang.String str14 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) charSequenceTranslatorArray11, ' ');
        java.util.BitSet bitSet16 = org.apache.commons.lang3.ArrayUtils.indexesOf((java.lang.Object[]) charSequenceTranslatorArray11, (java.lang.Object) "pen");
        int int18 = org.apache.commons.lang3.ArrayUtils.indexOf((java.lang.Object[]) charSequenceTranslatorArray11, (java.lang.Object) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.exclusiveBetween("mixed mode, sharing", "a16.0.1+9a", (java.lang.Comparable<java.lang.String>) "", "java.lang", (java.lang.Object[]) charSequenceTranslatorArray11);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: java.lang");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray11);
        org.junit.Assert.assertNotNull(charSequenceTranslator12);
        org.junit.Assert.assertNotNull(bitSet16);
        org.junit.Assert.assertEquals(bitSet16.toString(), "{}");
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + (-1) + "'", int18 == (-1));
    }

    @Test
    public void test0120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0120");
        java.util.concurrent.Callable<org.apache.commons.lang3.stream.IntStreams> intStreamsCallable0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.CallableBackgroundInitializer<org.apache.commons.lang3.stream.IntStreams> intStreamsCallableBackgroundInitializer1 = new org.apache.commons.lang3.concurrent.CallableBackgroundInitializer<org.apache.commons.lang3.stream.IntStreams>(intStreamsCallable0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: callable");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0121");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.chop("os.name");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "os.nam" + "'", str1, "os.nam");
    }

    @Test
    public void test0122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0122");
        java.lang.String str1 = org.apache.commons.lang3.RandomStringUtils.randomAlphabetic((int) (short) 101);
// flaky:         org.junit.Assert.assertEquals("'" + str1 + "' != '" + "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc" + "'", str1, "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc");
    }

    @Test
    public void test0123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0123");
        int[] intArray0 = null;
        org.apache.commons.lang3.ArrayUtils.shift(intArray0, 10);
    }

    @Test
    public void test0124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0124");
        long[] longArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(longArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read the array length because \"array\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0125");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isNumericSpace((java.lang.CharSequence) "UTF-16");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0126");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.removeEnd("Integer", "60.0");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Integer" + "'", str2, "Integer");
    }

    @Test
    public void test0127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0127");
        java.lang.String str2 = org.apache.commons.lang3.ClassUtils.getShortCanonicalName((java.lang.Object) 10.0d, "os.nam");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Double" + "'", str2, "Double");
    }

    @Test
    public void test0128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0128");
        short[] shortArray3 = new short[] { (short) 1, (short) -1, (byte) 10 };
        boolean boolean4 = org.apache.commons.lang3.ArrayUtils.isSorted(shortArray3);
        java.util.Random random5 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(shortArray3, random5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(shortArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray3), "[1, -1, 10]");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0129");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.exclusiveBetween((long) (short) -1, (-1L), 100L, "581cd446");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 581cd446");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0130");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Long long1 = org.apache.commons.lang3.math.NumberUtils.createLong("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0131");
        java.util.Formatter formatter1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Formatter formatter6 = org.apache.commons.lang3.text.FormattableUtils.append((java.lang.CharSequence) ";ClT9Ss'St<Q", formatter1, (int) (short) 101, (int) ' ', (int) (byte) 10, '\n');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Formatter.format(String, Object[])\" because \"formatter\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0132");
        double[] doubleArray3 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean5 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray3, (double) '4');
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(doubleArray3, (double) 1, (double) ' ');
        org.junit.Assert.assertNotNull(doubleArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray3), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{1, 2}");
    }

    @Test
    public void test0133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0133");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Boolean boolean4 = org.apache.commons.lang3.BooleanUtils.toBooleanObject("60.0", "16.0.1", "Integer", ";ClT9Ss'St<Q");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The String did not match any specified value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0134");
        java.util.Locale locale2 = null;
        // The following exception was thrown during execution in test generation
        try {
            int int3 = org.apache.commons.lang3.StringUtils.getFuzzyDistance((java.lang.CharSequence) "AdoptOpenJDK", (java.lang.CharSequence) "java.lang", locale2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Locale must not be null");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0135");
        java.lang.CharSequence charSequence2 = org.apache.commons.lang3.StringUtils.defaultIfEmpty((java.lang.CharSequence) "16.0.1+9", (java.lang.CharSequence) "");
        org.junit.Assert.assertEquals("'" + charSequence2 + "' != '" + "16.0.1+9" + "'", charSequence2, "16.0.1+9");
    }

    @Test
    public void test0136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0136");
        java.lang.reflect.Type type0 = null;
        java.lang.reflect.Type type1 = org.apache.commons.lang3.reflect.TypeUtils.getArrayComponentType(type0);
        org.junit.Assert.assertNull(type1);
    }

    @Test
    public void test0137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0137");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.ceiling(date0, (-27));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0138");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.unwrap("Long", "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Long" + "'", str2, "Long");
    }

    @Test
    public void test0139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0139");
        java.util.function.Supplier<java.lang.Object> objSupplier0 = null;
        java.util.function.Supplier<java.lang.String> strSupplier1 = null;
        java.lang.String str2 = org.apache.commons.lang3.ObjectUtils.toString(objSupplier0, strSupplier1);
        org.junit.Assert.assertNull(str2);
    }

    @Test
    public void test0140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0140");
        java.lang.Throwable throwable0 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException1 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable0);
        java.lang.Throwable[] throwableArray2 = uncheckedExecutionException1.getSuppressed();
        org.apache.commons.lang3.concurrent.CircuitBreakingException circuitBreakingException3 = new org.apache.commons.lang3.concurrent.CircuitBreakingException((java.lang.Throwable) uncheckedExecutionException1);
        org.junit.Assert.assertNotNull(throwableArray2);
    }

    @Test
    public void test0141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0141");
        short short3 = org.apache.commons.lang3.math.NumberUtils.max((short) (byte) 1, (short) 0, (short) 10);
        org.junit.Assert.assertTrue("'" + short3 + "' != '" + (short) 10 + "'", short3 == (short) 10);
    }

    @Test
    public void test0142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0142");
        java.lang.Long[] longArray9 = new java.lang.Long[] { 10L, 0L, (-1L), (-1L), 10L, 1L };
        java.lang.Long[] longArray10 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray9);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj11 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) "16.0.1", false, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]", (java.lang.Object[]) longArray10);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]() on object: java.lang.String");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray9);
        org.junit.Assert.assertNotNull(longArray10);
    }

    @Test
    public void test0143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0143");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_11;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0144");
        // The following exception was thrown during execution in test generation
        try {
            int int2 = org.apache.commons.lang3.RandomUtils.nextInt((int) (short) 100, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Start value must be smaller or equal to end value.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0145");
        org.apache.commons.lang3.text.StrMatcher strMatcher0 = org.apache.commons.lang3.text.StrMatcher.spaceMatcher();
        org.junit.Assert.assertNotNull(strMatcher0);
    }

    @Test
    public void test0146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0146");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str2 = org.apache.commons.lang3.RandomStringUtils.randomNumeric((int) (byte) 100, (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Start value must be smaller or equal to end value.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0147");
        org.apache.commons.lang3.stream.IntStreams[] intStreamsArray0 = null;
        org.apache.commons.lang3.stream.IntStreams intStreams1 = new org.apache.commons.lang3.stream.IntStreams();
        org.apache.commons.lang3.stream.IntStreams[] intStreamsArray2 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(intStreamsArray0, intStreams1);
        org.junit.Assert.assertNull(intStreamsArray2);
    }

    @Test
    public void test0148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0148");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.chomp("Long");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Long" + "'", str1, "Long");
    }

    @Test
    public void test0149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0149");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((java.lang.Number) 1.0f);
    }

    @Test
    public void test0150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0150");
        java.lang.String str0 = org.apache.commons.lang3.BooleanUtils.YES;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "yes" + "'", str0, "yes");
    }

    @Test
    public void test0151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0151");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper0 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper1 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper2 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper3 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper4 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper5 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper6 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray7 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper1, unicodeUnescaper2, unicodeUnescaper3, unicodeUnescaper4, unicodeUnescaper5, unicodeUnescaper6 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator8 = unicodeUnescaper0.with(charSequenceTranslatorArray7);
        java.lang.String str10 = charSequenceTranslator8.translate((java.lang.CharSequence) "os.nam");
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray7);
        org.junit.Assert.assertNotNull(charSequenceTranslator8);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "os.nam" + "'", str10, "os.nam");
    }

    @Test
    public void test0152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0152");
        org.apache.commons.lang3.function.FailableLongUnaryOperator failableLongUnaryOperator0 = org.apache.commons.lang3.function.FailableLongUnaryOperator.NOP;
        org.junit.Assert.assertNotNull(failableLongUnaryOperator0);
    }

    @Test
    public void test0153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0153");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.time.DateUtils.getFragmentInSeconds(calendar0, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: calendar");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0154");
        java.util.TimeZone timeZone1 = org.apache.commons.lang3.time.FastTimeZone.getGmtTimeZone();
        java.util.Locale locale2 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.time.FastDateFormat fastDateFormat3 = org.apache.commons.lang3.time.FastDateFormat.getTimeInstance((int) '4', timeZone1, locale2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal time style 52");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(timeZone1);
        org.junit.Assert.assertEquals(timeZone1.getDisplayName(), "GMT+00:00");
    }

    @Test
    public void test0155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0155");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getUserName();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "glacierali" + "'", str0, "glacierali");
    }

    @Test
    public void test0156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0156");
        java.lang.String str0 = org.apache.commons.lang3.CharEncoding.UTF_16BE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-16BE" + "'", str0, "UTF-16BE");
    }

    @Test
    public void test0157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0157");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.ceiling(date0, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0158");
        java.lang.String[][] strArray2 = org.apache.commons.lang3.text.translate.EntityArrays.ISO8859_1_ESCAPE();
        org.apache.commons.lang3.Validate.notNaN((double) (short) -1, "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc", (java.lang.Object[]) strArray2);
        org.junit.Assert.assertNotNull(strArray2);
    }

    @Test
    public void test0159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0159");
        org.apache.commons.lang3.reflect.TypeUtils typeUtils0 = new org.apache.commons.lang3.reflect.TypeUtils();
    }

    @Test
    public void test0160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0160");
        java.util.Date date0 = null;
        java.util.Date date1 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean2 = org.apache.commons.lang3.time.DateUtils.isSameInstant(date0, date1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date1");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0161");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.center("a16.0.1+9a", (int) (short) 101, "hi!");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!a16.0.1+9ahi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!h" + "'", str3, "hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!a16.0.1+9ahi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!hi!h");
    }

    @Test
    public void test0162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0162");
        float[] floatArray5 = new float[] { (byte) 100, 10.0f, (-1.0f), 0L, 100L };
        org.apache.commons.lang3.ArrayUtils.reverse(floatArray5, (int) (byte) 10, (int) 'a');
        java.util.stream.Stream<short[]> shortArrayStream9 = null;
        org.apache.commons.lang3.Streams.FailableStream<short[]> shortArrayFailableStream10 = new org.apache.commons.lang3.Streams.FailableStream<short[]>(shortArrayStream9);
        java.lang.String[] strArray19 = new java.lang.String[] { "long", "UTF-16BE", "long", "java.lang", "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]", "Mac OS X", "open", "                                                                                                open" };
        java.util.ArrayList<java.lang.String> strList20 = new java.util.ArrayList<java.lang.String>();
        boolean boolean21 = java.util.Collections.addAll((java.util.Collection<java.lang.String>) strList20, strArray19);
        // The following exception was thrown during execution in test generation
        try {
            int int22 = org.apache.commons.lang3.builder.CompareToBuilder.reflectionCompare((java.lang.Object) floatArray5, (java.lang.Object) shortArrayFailableStream10, (java.util.Collection<java.lang.String>) strList20);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: null");
        } catch (java.lang.ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(floatArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray5), "[100.0, 10.0, -1.0, 0.0, 100.0]");
        org.junit.Assert.assertNotNull(strArray19);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
    }

    @Test
    public void test0163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0163");
        boolean boolean1 = org.apache.commons.lang3.math.NumberUtils.isParsable("Long");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0164");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_VM_VERSION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.vm.version" + "'", str0, "java.vm.version");
    }

    @Test
    public void test0165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0165");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.upperCase("60.0");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "60.0" + "'", str1, "60.0");
    }

    @Test
    public void test0166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0166");
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION oPTION0 = org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired;
        org.junit.Assert.assertTrue("'" + oPTION0 + "' != '" + org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired + "'", oPTION0.equals(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired));
    }

    @Test
    public void test0167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0167");
        int int0 = org.apache.commons.lang3.time.FastDatePrinter.SHORT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test0168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0168");
        org.apache.commons.lang3.function.FailableDoubleUnaryOperator failableDoubleUnaryOperator0 = org.apache.commons.lang3.function.FailableDoubleUnaryOperator.NOP;
        org.junit.Assert.assertNotNull(failableDoubleUnaryOperator0);
    }

    @Test
    public void test0169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0169");
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
        java.lang.Long[] longArray19 = new java.lang.Long[] { 10L, 0L, (-1L), (-1L), 10L, 1L };
        java.lang.Long[] longArray20 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray19);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj21 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) str10, true, "AdoptOpenJDK", (java.lang.Object[]) longArray20);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such method: AdoptOpenJDK() on object: java.lang.String");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray7);
        org.junit.Assert.assertNotNull(charSequenceTranslator8);
        org.junit.Assert.assertNotNull(longArray19);
        org.junit.Assert.assertNotNull(longArray20);
    }

    @Test
    public void test0170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0170");
        java.lang.Object obj0 = null;
        java.lang.String[] strArray2 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray4 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray2, (java.lang.CharSequence) "Integer");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj5 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod(obj0, "UTF-16BE", (java.lang.Object[]) charSequenceArray4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: object");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertNotNull(charSequenceArray4);
    }

    @Test
    public void test0171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0171");
        org.apache.commons.lang3.Conversion conversion0 = new org.apache.commons.lang3.Conversion();
    }

    @Test
    public void test0172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0172");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        short short2 = mutableShort1.incrementAndGet();
        short short3 = mutableShort1.decrementAndGet();
        org.junit.Assert.assertTrue("'" + short2 + "' != '" + (short) 101 + "'", short2 == (short) 101);
        org.junit.Assert.assertTrue("'" + short3 + "' != '" + (short) 100 + "'", short3 == (short) 100);
    }

    @Test
    public void test0173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0173");
        org.apache.commons.lang3.math.Fraction fraction2 = org.apache.commons.lang3.math.Fraction.getReducedFraction(1, 3);
        org.junit.Assert.assertNotNull(fraction2);
    }

    @Test
    public void test0174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0174");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isWhitespace((java.lang.CharSequence) "");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0175");
        boolean[] booleanArray1 = new boolean[] { false };
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray4 = org.apache.commons.lang3.ArrayUtils.add(booleanArray1, (int) (short) 10, true);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 10, Length: 1");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray1), "[false]");
    }

    @Test
    public void test0176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0176");
        org.apache.commons.lang3.function.FailableDoubleToLongFunction failableDoubleToLongFunction0 = org.apache.commons.lang3.function.FailableDoubleToLongFunction.NOP;
        org.junit.Assert.assertNotNull(failableDoubleToLongFunction0);
    }

    @Test
    public void test0177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0177");
        java.lang.Boolean[] booleanArray4 = new java.lang.Boolean[] { false, false, false, false };
        java.lang.Boolean boolean5 = org.apache.commons.lang3.BooleanUtils.or(booleanArray4);
        java.lang.Boolean boolean6 = org.apache.commons.lang3.BooleanUtils.or(booleanArray4);
        org.junit.Assert.assertNotNull(booleanArray4);
        org.junit.Assert.assertEquals("'" + boolean5 + "' != '" + false + "'", boolean5, false);
        org.junit.Assert.assertEquals("'" + boolean6 + "' != '" + false + "'", boolean6, false);
    }

    @Test
    public void test0178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0178");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.strip("open", "60.0");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "open" + "'", str2, "open");
    }

    @Test
    public void test0179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0179");
        org.apache.commons.lang3.exception.ContextedException contextedException0 = new org.apache.commons.lang3.exception.ContextedException();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle4 = null;
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder5 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle4);
        org.apache.commons.lang3.exception.ContextedException contextedException6 = contextedException0.setContextValue("yes", (java.lang.Object) 0);
        java.io.PrintWriter printWriter7 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.exception.ExceptionUtils.printRootCauseStackTrace((java.lang.Throwable) contextedException0, printWriter7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: printWriter");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(contextedException6);
    }

    @Test
    public void test0180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0180");
        org.apache.commons.lang3.concurrent.CircuitBreakingException circuitBreakingException1 = new org.apache.commons.lang3.concurrent.CircuitBreakingException("UnicodeUnescaper");
    }

    @Test
    public void test0181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0181");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_21;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0182");
        char char0 = org.apache.commons.lang3.CharUtils.NUL;
        org.junit.Assert.assertTrue("'" + char0 + "' != '" + '\000' + "'", char0 == '\000');
    }

    @Test
    public void test0183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0183");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        org.apache.commons.lang3.ArrayUtils.swap(booleanArray7, (int) ' ', (int) (short) 100);
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
    }

    @Test
    public void test0184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0184");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.substringBetween("UTF-16BE", "os.name", "on");
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test0185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0185");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = org.apache.commons.lang3.time.DurationFormatUtils.formatPeriod((long) '#', 1L, "os.nam");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: startMillis must not be greater than endMillis");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0186");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_15;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0187");
        int int1 = org.apache.commons.lang3.BooleanUtils.toInteger(false);
        org.junit.Assert.assertTrue("'" + int1 + "' != '" + 0 + "'", int1 == 0);
    }

    @Test
    public void test0188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0188");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_AWT_HEADLESS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.awt.headless" + "'", str0, "java.awt.headless");
    }

    @Test
    public void test0189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0189");
        java.lang.reflect.Method method0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.function.Function<org.apache.commons.lang3.function.FailableLongToDoubleFunction, java.util.Iterator<java.lang.String>> failableLongToDoubleFunctionFunction1 = org.apache.commons.lang3.function.MethodInvokers.asFunction(method0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0190");
        org.apache.commons.lang3.ThreadUtils.ThreadPredicate threadPredicate0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Collection<java.lang.Thread> threadCollection1 = org.apache.commons.lang3.ThreadUtils.findThreads(threadPredicate0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0191");
        java.lang.reflect.Method method0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.function.FailableFunction<java.lang.CharSequence, org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.Throwable> charSequenceFailableFunction1 = org.apache.commons.lang3.function.MethodInvokers.asFailableFunction(method0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0192");
        long[] longArray5 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray5, (long) '\n', 100);
        // The following exception was thrown during execution in test generation
        try {
            long[] longArray11 = org.apache.commons.lang3.ArrayUtils.add(longArray5, (int) (short) 101, 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 101, Length: 5");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray5), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
    }

    @Test
    public void test0193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0193");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.replaceOnce("", ";ClT9Ss'St<Q", "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test0194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0194");
        java.lang.Boolean boolean4 = org.apache.commons.lang3.BooleanUtils.toBooleanObject((java.lang.Integer) 100, (java.lang.Integer) 3, (java.lang.Integer) 100, (java.lang.Integer) (-1));
        org.junit.Assert.assertEquals("'" + boolean4 + "' != '" + false + "'", boolean4, false);
    }

    @Test
    public void test0195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0195");
        float float2 = org.apache.commons.lang3.math.IEEE754rUtils.min((float) ' ', (float) 100);
        org.junit.Assert.assertTrue("'" + float2 + "' != '" + 32.0f + "'", float2 == 32.0f);
    }

    @Test
    public void test0196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0196");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.OS_VERSION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "11.5" + "'", str0, "11.5");
    }

    @Test
    public void test0197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0197");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.removePattern("os.name", "16.0.1+9");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "os.name" + "'", str2, "os.name");
    }

    @Test
    public void test0198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0198");
        java.lang.String[] strArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY;
        org.junit.Assert.assertNotNull(strArray0);
    }

    @Test
    public void test0199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0199");
        org.apache.commons.lang3.function.FailableBiPredicate failableBiPredicate0 = org.apache.commons.lang3.function.FailableBiPredicate.TRUE;
        org.junit.Assert.assertNotNull(failableBiPredicate0);
    }

    @Test
    public void test0200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0200");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = org.apache.commons.lang3.time.DurationFormatUtils.formatPeriod((long) (byte) 10, (long) 1, "16.0.1+9");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: startMillis must not be greater than endMillis");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0201");
        float float3 = org.apache.commons.lang3.math.IEEE754rUtils.max(0.0f, (float) (short) -1, 0.0f);
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + 0.0f + "'", float3 == 0.0f);
    }

    @Test
    public void test0202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0202");
        java.lang.String[] strArray1 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray3 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray1, (java.lang.CharSequence) "Integer");
        boolean boolean4 = org.apache.commons.lang3.StringUtils.containsAnyIgnoreCase((java.lang.CharSequence) "pen", charSequenceArray3);
        org.junit.Assert.assertNotNull(strArray1);
        org.junit.Assert.assertNotNull(charSequenceArray3);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test0203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0203");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = org.apache.commons.lang3.BooleanUtils.toBoolean("os.name", "Mac OS X", "UnicodeUnescaper");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The String did not match either specified value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0204");
        java.lang.String str0 = org.apache.commons.lang3.BooleanUtils.NO;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "no" + "'", str0, "no");
    }

    @Test
    public void test0205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0205");
        int[] intArray1 = new int[] { '\n' };
        java.util.BitSet bitSet4 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray1, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray1);
        java.time.Duration duration6 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ObjectUtils.wait((java.lang.Object) intArray1, duration6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalMonitorStateException; message: current thread is not owner");
        } catch (java.lang.IllegalMonitorStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(intArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray1), "[10]");
        org.junit.Assert.assertNotNull(bitSet4);
        org.junit.Assert.assertEquals(bitSet4.toString(), "{}");
    }

    @Test
    public void test0206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0206");
        java.lang.Package package0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str2 = org.apache.commons.lang3.ClassPathUtils.toFullyQualifiedPath(package0, "on");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: context");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0207");
        java.lang.String str1 = org.apache.commons.lang3.RandomStringUtils.random((int) (byte) 10);
// flaky:         org.junit.Assert.assertEquals("'" + str1 + "' != '" + "\u3928\ud86e\udf97\u5072\u6c6c\ud700\ud842\udf9d\u6baf\u19ab" + "'", str1, "\u3928\ud86e\udf97\u5072\u6c6c\ud700\ud842\udf9d\u6baf\u19ab");
    }

    @Test
    public void test0208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0208");
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException7 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException3);
        java.lang.Throwable throwable9 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException10 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable9);
        java.lang.Throwable[] throwableArray11 = uncheckedExecutionException10.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException13 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException10, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException14 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException13);
        java.lang.Throwable throwable15 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException16 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable15);
        java.lang.Throwable[] throwableArray17 = uncheckedExecutionException16.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException19 = new org.apache.commons.lang3.NotImplementedException((java.lang.Throwable) uncheckedExecutionException16, "os.version");
        java.lang.Throwable throwable22 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException23 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable22);
        java.lang.Throwable[] throwableArray24 = uncheckedExecutionException23.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException26 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException23, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException27 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException23);
        java.lang.Throwable throwable30 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException31 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable30);
        java.lang.Throwable[] throwableArray32 = uncheckedExecutionException31.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException34 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException31, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException35 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException31);
        org.apache.commons.lang3.NotImplementedException[] notImplementedExceptionArray36 = new org.apache.commons.lang3.NotImplementedException[] { notImplementedException7, notImplementedException13, notImplementedException19, notImplementedException27, notImplementedException35 };
        java.lang.String str37 = org.apache.commons.lang3.StringUtils.join(notImplementedExceptionArray36);
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertNotNull(throwableArray11);
        org.junit.Assert.assertNotNull(throwableArray17);
        org.junit.Assert.assertNotNull(throwableArray24);
        org.junit.Assert.assertNotNull(throwableArray32);
        org.junit.Assert.assertNotNull(notImplementedExceptionArray36);
        org.junit.Assert.assertEquals("'" + str37 + "' != '" + "org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on" + "'", str37, "org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on");
    }

    @Test
    public void test0209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0209");
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle2 = null;
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder3 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle2);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String[] strArray4 = serializableReflectionDiffBuilder3.getExcludeFieldNames();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"[Ljava.lang.String;.clone()\" because \"this.excludeFieldNames\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0210");
        long[] longArray5 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray5, (long) '\n', 100);
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray5);
        long[] longArray11 = org.apache.commons.lang3.ArrayUtils.add(longArray5, (long) (short) 101);
        int int14 = org.apache.commons.lang3.ArrayUtils.indexOf(longArray5, (long) 'a', 10);
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray5), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(longArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray11), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
    }

    @Test
    public void test0211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0211");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.time.DateUtils.getFragmentInMinutes(calendar0, 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: calendar");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0212");
        java.lang.CharSequence charSequence0 = null;
        int int2 = org.apache.commons.lang3.StringUtils.indexOfAny(charSequence0, "581cd446");
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test0213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0213");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_1_2;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_1_2 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_1_2));
    }

    @Test
    public void test0214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0214");
        org.apache.commons.lang3.function.FailableObjIntConsumer<java.util.stream.BaseStream<java.lang.Integer, java.util.stream.IntStream>, java.lang.Throwable> intBaseStreamFailableObjIntConsumer0 = org.apache.commons.lang3.function.FailableObjIntConsumer.nop();
        org.junit.Assert.assertNotNull(intBaseStreamFailableObjIntConsumer0);
    }

    @Test
    public void test0215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0215");
        org.apache.commons.lang3.StringUtils stringUtils0 = new org.apache.commons.lang3.StringUtils();
    }

    @Test
    public void test0216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0216");
        org.apache.commons.lang3.concurrent.Computable<org.apache.commons.lang3.text.StrTokenizer, org.apache.commons.lang3.CharSet> strTokenizerComputable0 = null;
        org.apache.commons.lang3.concurrent.Memoizer<org.apache.commons.lang3.text.StrTokenizer, org.apache.commons.lang3.CharSet> strTokenizerMemoizer1 = new org.apache.commons.lang3.concurrent.Memoizer<org.apache.commons.lang3.text.StrTokenizer, org.apache.commons.lang3.CharSet>(strTokenizerComputable0);
    }

    @Test
    public void test0217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0217");
        char char2 = org.apache.commons.lang3.CharUtils.toChar((java.lang.Character) 'a', '4');
        org.junit.Assert.assertTrue("'" + char2 + "' != '" + 'a' + "'", char2 == 'a');
    }

    @Test
    public void test0218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0218");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.mid("pen", (int) (byte) -1, (int) (short) 0);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test0219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0219");
        float float1 = org.apache.commons.lang3.ObjectUtils.CONST((float) '#');
        org.junit.Assert.assertTrue("'" + float1 + "' != '" + 35.0f + "'", float1 == 35.0f);
    }

    @Test
    public void test0220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0220");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        short short2 = mutableShort1.incrementAndGet();
        org.apache.commons.lang3.mutable.MutableShort mutableShort4 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        short short5 = mutableShort4.incrementAndGet();
        int int6 = org.apache.commons.lang3.ObjectUtils.compare(mutableShort1, mutableShort4);
        org.junit.Assert.assertTrue("'" + short2 + "' != '" + (short) 101 + "'", short2 == (short) 101);
        org.junit.Assert.assertTrue("'" + short5 + "' != '" + (short) 101 + "'", short5 == (short) 101);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test0221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0221");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat((float) (short) -1);
        float float3 = mutableFloat1.getAndAdd((java.lang.Number) (byte) 0);
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + (-1.0f) + "'", float3 == (-1.0f));
    }

    @Test
    public void test0222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0222");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.USER_HOME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "/Users/glacierali" + "'", str0, "/Users/glacierali");
    }

//    @Test
//    public void test0223() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0223");
//        org.apache.commons.lang3.tuple.ImmutableTriple<java.lang.String, java.lang.constant.ConstantDesc, java.lang.constant.Constable> strImmutableTriple0 = org.apache.commons.lang3.tuple.ImmutableTriple.nullTriple();
//        org.apache.commons.lang3.function.FailableObjIntConsumer failableObjIntConsumer1 = org.apache.commons.lang3.function.FailableObjIntConsumer.NOP;
//        boolean boolean2 = strImmutableTriple0.equals((java.lang.Object) failableObjIntConsumer1);
//        java.lang.String str3 = strImmutableTriple0.getLeft();
//        org.junit.Assert.assertNotNull(strImmutableTriple0);
//        org.junit.Assert.assertNotNull(failableObjIntConsumer1);
//        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
//        org.junit.Assert.assertNull(str3);
//    }

    @Test
    public void test0224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0224");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.replaceAll("Long", "on", "open");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Lopeng" + "'", str3, "Lopeng");
    }

    @Test
    public void test0225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0225");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.USER_REGION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "user.region" + "'", str0, "user.region");
    }

    @Test
    public void test0226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0226");
        org.apache.commons.lang3.function.FailableIntPredicate failableIntPredicate0 = org.apache.commons.lang3.function.FailableIntPredicate.TRUE;
        org.apache.commons.lang3.function.FailableIntPredicate[] failableIntPredicateArray1 = new org.apache.commons.lang3.function.FailableIntPredicate[] { failableIntPredicate0 };
        org.apache.commons.lang3.function.FailableIntPredicate failableIntPredicate2 = org.apache.commons.lang3.function.FailableIntPredicate.TRUE;
        org.apache.commons.lang3.function.FailableIntPredicate[] failableIntPredicateArray3 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(failableIntPredicateArray1, failableIntPredicate2);
        java.lang.String str5 = org.apache.commons.lang3.ClassUtils.getPackageCanonicalName((java.lang.Object) failableIntPredicate2, "UTF-16");
        org.junit.Assert.assertNotNull(failableIntPredicate0);
        org.junit.Assert.assertNotNull(failableIntPredicateArray1);
        org.junit.Assert.assertNotNull(failableIntPredicate2);
        org.junit.Assert.assertNotNull(failableIntPredicateArray3);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "org.apache.commons.lang3.function" + "'", str5, "org.apache.commons.lang3.function");
    }

    @Test
    public void test0227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0227");
        org.apache.commons.lang3.text.FormattableUtils formattableUtils0 = new org.apache.commons.lang3.text.FormattableUtils();
    }

    @Test
    public void test0228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0228");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.truncate("a16.0.1+9a", (int) ' ');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "a16.0.1+9a" + "'", str2, "a16.0.1+9a");
    }

    @Test
    public void test0229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0229");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.mutable.MutableInt mutableInt1 = new org.apache.commons.lang3.mutable.MutableInt("AdoptOpenJDK");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"AdoptOpenJDK\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0230");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str1 = org.apache.commons.lang3.RandomStringUtils.random((-1));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Requested random string length -1 is less than 0.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0231");
        java.lang.String[] strArray3 = org.apache.commons.lang3.StringUtils.substringsBetween("os.name", "glacierali", "os.version");
        org.junit.Assert.assertNull(strArray3);
    }

    @Test
    public void test0232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0232");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.unescapeCsv("100");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "100" + "'", str1, "100");
    }

    @Test
    public void test0233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0233");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.builder.HashCodeBuilder hashCodeBuilder2 = new org.apache.commons.lang3.builder.HashCodeBuilder((int) '\000', (-27));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: HashCodeBuilder requires an odd initial value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0234");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        float[] floatArray12 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(floatArray10);
        java.lang.Float[] floatArray13 = org.apache.commons.lang3.ArrayUtils.toObject(floatArray12);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(floatArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray12), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray13);
    }

    @Test
    public void test0235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0235");
        org.apache.commons.lang3.mutable.MutableLong mutableLong0 = null;
        org.apache.commons.lang3.mutable.MutableLong mutableLong1 = null;
        org.apache.commons.lang3.mutable.MutableLong mutableLong3 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        org.apache.commons.lang3.mutable.MutableLong mutableLong4 = org.apache.commons.lang3.compare.ComparableUtils.min(mutableLong1, mutableLong3);
        java.util.Comparator<org.apache.commons.lang3.mutable.MutableLong> mutableLongComparator5 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.NumberRange<org.apache.commons.lang3.mutable.MutableLong> mutableLongNumberRange6 = new org.apache.commons.lang3.NumberRange<org.apache.commons.lang3.mutable.MutableLong>(mutableLong0, mutableLong1, mutableLongComparator5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: element1");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(mutableLong4);
    }

    @Test
    public void test0236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0236");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        java.lang.String str11 = org.apache.commons.lang3.StringUtils.join(booleanArray5, '\000');
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet9);
        org.junit.Assert.assertEquals(bitSet9.toString(), "{1, 3}");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "false\000true\000false\000true\000false" + "'", str11, "false\000true\000false\000true\000false");
    }

    @Test
    public void test0237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0237");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_PUMA;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0238");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.LINE_SEPARATOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "line.separator" + "'", str0, "line.separator");
    }

    @Test
    public void test0239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0239");
        int int0 = org.apache.commons.lang3.ArrayUtils.INDEX_NOT_FOUND;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + (-1) + "'", int0 == (-1));
    }

    @Test
    public void test0240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0240");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_COMPILER;
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0241");
        boolean boolean1 = org.apache.commons.lang3.BooleanUtils.isNotFalse((java.lang.Boolean) true);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0242");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_17;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0243");
        boolean[] booleanArray3 = new boolean[] { true, true, false };
        // The following exception was thrown during execution in test generation
        try {
            byte byte8 = org.apache.commons.lang3.Conversion.binaryToByte(booleanArray3, (int) (byte) -1, (byte) 100, (int) '\000', (int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: nBools-1+dstPos is greater or equal to than 8");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray3), "[true, true, false]");
    }

    @Test
    public void test0244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0244");
        long[] longArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long[] longArray3 = org.apache.commons.lang3.ArrayUtils.add(longArray0, 100, (long) (-27));
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 100, Length: 0");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0245");
        java.lang.reflect.Method method0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.function.FailableFunction<java.net.URL[], org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.Throwable> uRLArrayFailableFunction1 = org.apache.commons.lang3.function.MethodInvokers.asFailableFunction(method0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0246");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isBlank((java.lang.CharSequence) "UnicodeUnescaper");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0247");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.strip("Lopeng");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Lopeng" + "'", str1, "Lopeng");
    }

    @Test
    public void test0248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0248");
        double double3 = org.apache.commons.lang3.math.IEEE754rUtils.max((double) (short) 100, (double) (short) 10, (double) 0);
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 100.0d + "'", double3 == 100.0d);
    }

    @Test
    public void test0249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0249");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.substringBetween("100", "UnicodeUnescaper", "");
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test0250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0250");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.rightPad("a16.0.1+9a", (int) (byte) -1, "16.0.1+9");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "a16.0.1+9a" + "'", str3, "a16.0.1+9a");
    }

    @Test
    public void test0251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0251");
        org.apache.commons.lang3.ThreadUtils threadUtils0 = new org.apache.commons.lang3.ThreadUtils();
    }

    @Test
    public void test0252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0252");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.stream.IntStream intStream1 = org.apache.commons.lang3.SerializationUtils.deserialize(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: inputStream");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0253");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.substringBeforeLast(" ", "yes");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + " " + "'", str2, " ");
    }

    @Test
    public void test0254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0254");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.USER_DIR_KEY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "user.dir" + "'", str0, "user.dir");
    }

    @Test
    public void test0255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0255");
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray1 = org.apache.commons.lang3.Conversion.hexDigitMsb0ToBinary('\n');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot interpret '?' as a hexadecimal digit");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0256");
        java.util.Locale locale1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.FastDateFormat.getInstance("os.nam", locale1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: o");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0257");
        long[] longArray6 = new long[] { (short) 10, 1L, 'a', 100L, ' ', 100 };
        long[] longArray8 = org.apache.commons.lang3.ArrayUtils.remove(longArray6, 3);
        int[] intArray13 = new int[] { 1, (byte) -1, (byte) 10, '\n' };
        // The following exception was thrown during execution in test generation
        try {
            long[] longArray14 = org.apache.commons.lang3.ArrayUtils.removeAll(longArray8, intArray13);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 10, Length: 5");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray6), "[10, 1, 97, 100, 32, 100]");
        org.junit.Assert.assertNotNull(longArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray8), "[10, 1, 97, 32, 100]");
        org.junit.Assert.assertNotNull(intArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray13), "[1, -1, 10, 10]");
    }

    @Test
    public void test0258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0258");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isAlphanumericSpace((java.lang.CharSequence) "on");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0259");
        int int3 = org.apache.commons.lang3.math.NumberUtils.max((int) 'a', (int) ' ', (int) ' ');
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 97 + "'", int3 == 97);
    }

    @Test
    public void test0260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0260");
        long long0 = org.apache.commons.lang3.time.DateUtils.MILLIS_PER_MINUTE;
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + 60000L + "'", long0 == 60000L);
    }

    @Test
    public void test0261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0261");
        int[] intArray6 = new int[] { 10, (short) 10, (short) -1, (short) 100, ' ', (short) 0 };
        org.apache.commons.lang3.ArrayUtils.swap(intArray6, (int) '#', (-1), (int) '#');
        org.junit.Assert.assertNotNull(intArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray6), "[10, 10, -1, 100, 32, 0]");
    }

    @Test
    public void test0262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0262");
        java.lang.CharSequence charSequence1 = null;
        int int2 = org.apache.commons.lang3.StringUtils.indexOfDifference((java.lang.CharSequence) "on", charSequence1);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test0263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0263");
        org.apache.commons.lang3.RandomStringUtils randomStringUtils0 = new org.apache.commons.lang3.RandomStringUtils();
    }

    @Test
    public void test0264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0264");
        float float0 = org.apache.commons.lang3.RandomUtils.nextFloat();
// flaky:         org.junit.Assert.assertTrue("'" + float0 + "' != '" + 2.3398232E38f + "'", float0 == 2.3398232E38f);
    }

    @Test
    public void test0265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0265");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.unwrap("", "long");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test0266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0266");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.unwrap(" ", '\000');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + " " + "'", str2, " ");
    }

    @Test
    public void test0267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0267");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer0 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults multiBackgroundInitializerResults1 = org.apache.commons.lang3.concurrent.ConcurrentUtils.initialize((org.apache.commons.lang3.concurrent.ConcurrentInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>) multiBackgroundInitializer0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: start() must be called first!");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0268");
        long[] longArray1 = new long[] { 3 };
        long[] longArray2 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray1);
        boolean boolean3 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray1);
        org.junit.Assert.assertNotNull(longArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray1), "[3]");
        org.junit.Assert.assertNotNull(longArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray2), "[3]");
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test0269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0269");
        org.apache.commons.lang3.function.FailableDoubleToIntFunction failableDoubleToIntFunction0 = org.apache.commons.lang3.function.FailableDoubleToIntFunction.NOP;
        org.junit.Assert.assertNotNull(failableDoubleToIntFunction0);
    }

    @Test
    public void test0270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0270");
        int int3 = org.apache.commons.lang3.BooleanUtils.toInteger(true, (int) (short) 0, (int) '#');
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 0 + "'", int3 == 0);
    }

    @Test
    public void test0271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0271");
        java.lang.String str4 = org.apache.commons.lang3.StringUtils.overlay("no", ";ClT9Ss'St<Q", (int) (byte) -1, (int) '#');
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + ";ClT9Ss'St<Q" + "'", str4, ";ClT9Ss'St<Q");
    }

    @Test
    public void test0272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0272");
        java.util.List<java.util.Locale> localeList0 = org.apache.commons.lang3.LocaleUtils.availableLocaleList();
        boolean boolean1 = org.apache.commons.lang3.ObjectUtils.isArray((java.lang.Object) localeList0);
        org.junit.Assert.assertNotNull(localeList0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0273");
        long[] longArray1 = new long[] { 3 };
        long[] longArray2 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray1);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str6 = org.apache.commons.lang3.StringUtils.join(longArray1, ' ', 0, 10);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Index 1 out of bounds for length 1");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray1), "[3]");
        org.junit.Assert.assertNotNull(longArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray2), "[3]");
    }

    @Test
    public void test0274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0274");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_18;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

//    @Test
//    public void test0275() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0275");
//        java.lang.Long[] longArray9 = new java.lang.Long[] { 10L, 0L, (-1L), (-1L), 10L, 1L };
//        java.lang.Long[] longArray10 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray9);
//        java.net.URL[] uRLArray11 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
//        boolean boolean12 = org.apache.commons.lang3.ArrayUtils.isSameLength((java.lang.Object[]) longArray9, (java.lang.Object[]) uRLArray11);
//        java.lang.constant.ConstantDesc[] constantDescArray14 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences((java.lang.constant.ConstantDesc[]) longArray9, (java.lang.constant.ConstantDesc) (-1.0d));
//        java.lang.Class[] classArray16 = new java.lang.Class[0];
//        @SuppressWarnings("unchecked")
//        java.lang.Class<?>[] wildcardClassArray17 = (java.lang.Class<?>[]) classArray16;
//        // The following exception was thrown during execution in test generation
//        try {
//            java.lang.Object obj18 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) "org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on", true, "<null>", (java.lang.Object[]) longArray9, wildcardClassArray17);
//            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such method: <null>() on object: java.lang.String");
//        } catch (java.lang.NoSuchMethodException e) {
//            // Expected exception.
//        }
//        org.junit.Assert.assertNotNull(longArray9);
//        org.junit.Assert.assertNotNull(longArray10);
//        org.junit.Assert.assertNotNull(uRLArray11);
//        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
//        org.junit.Assert.assertNotNull(constantDescArray14);
//        org.junit.Assert.assertNotNull(classArray16);
//        org.junit.Assert.assertNotNull(wildcardClassArray17);
//    }

    @Test
    public void test0276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0276");
        double[] doubleArray0 = null;
        int int4 = org.apache.commons.lang3.ArrayUtils.lastIndexOf(doubleArray0, (double) (byte) 0, (int) (short) 0, (double) 0);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + (-1) + "'", int4 == (-1));
    }

    @Test
    public void test0277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0277");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.rightPad("java.awt.headless", 0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "java.awt.headless" + "'", str2, "java.awt.headless");
    }

    @Test
    public void test0278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0278");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_SPECIFICATION_VERSION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.specification.version" + "'", str0, "java.specification.version");
    }

//    @Test
//    public void test0279() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0279");
//        org.apache.commons.lang3.builder.ToStringStyle toStringStyle2 = null;
//        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder3 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle2);
//        // The following exception was thrown during execution in test generation
//        try {
//            org.apache.commons.lang3.builder.DiffResult<java.io.Serializable> serializableDiffResult4 = serializableReflectionDiffBuilder3.build();
//            org.junit.Assert.fail("Expected exception of type java.lang.reflect.InaccessibleObjectException; message: Unable to make field private final byte java.lang.Byte.value accessible: module java.base does not \"opens java.lang\" to unnamed module @654b5005");
//        } catch (java.lang.reflect.InaccessibleObjectException e) {
//            // Expected exception.
//        }
//    }

    @Test
    public void test0280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0280");
        java.lang.String str1 = org.apache.commons.lang3.ObjectUtils.identityHashCodeHex((java.lang.Object) "UTF-16");
// flaky:         org.junit.Assert.assertEquals("'" + str1 + "' != '" + "6f51daee" + "'", str1, "6f51daee");
    }

    @Test
    public void test0281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0281");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_95;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0282");
        java.lang.reflect.Method method0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.function.BiConsumer<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>, org.apache.commons.lang3.mutable.MutableBoolean> charSequenceArrayImmutablePairBiConsumer1 = org.apache.commons.lang3.function.MethodInvokers.asBiConsumer(method0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0283");
        byte byte1 = org.apache.commons.lang3.ObjectUtils.CONST((byte) 0);
        org.junit.Assert.assertTrue("'" + byte1 + "' != '" + (byte) 0 + "'", byte1 == (byte) 0);
    }

    @Test
    public void test0284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0284");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaVendorUrl();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "https://adoptopenjdk.net/" + "'", str0, "https://adoptopenjdk.net/");
    }

    @Test
    public void test0285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0285");
        java.lang.String[] strArray3 = org.apache.commons.lang3.StringUtils.splitPreserveAllTokens("Long", ":", (int) 'a');
        org.junit.Assert.assertNotNull(strArray3);
    }

    @Test
    public void test0286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0286");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.time.DateUtils.getFragmentInHours(date0, (int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0287");
        java.util.concurrent.ExecutionException executionException0 = null;
        org.apache.commons.lang3.concurrent.ConcurrentUtils.handleCauseUnchecked(executionException0);
    }

    @Test
    public void test0288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0288");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_7;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0289");
        boolean[] booleanArray0 = null;
        java.lang.Boolean[] booleanArray1 = org.apache.commons.lang3.ArrayUtils.toObject(booleanArray0);
        org.junit.Assert.assertNull(booleanArray1);
    }

    @Test
    public void test0290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0290");
        java.util.function.Consumer<java.util.TimeZone> timeZoneConsumer0 = org.apache.commons.lang3.function.Consumers.nop();
        org.junit.Assert.assertNotNull(timeZoneConsumer0);
    }

    @Test
    public void test0291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0291");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort1.setValue((java.lang.Number) (short) 100);
        org.apache.commons.lang3.mutable.MutableShort mutableShort5 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        short short6 = mutableShort5.incrementAndGet();
        org.apache.commons.lang3.mutable.MutableLong mutableLong8 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        mutableLong8.add((long) 0);
        mutableShort5.setValue((java.lang.Number) 0);
        org.apache.commons.lang3.mutable.MutableShort mutableShort12 = org.apache.commons.lang3.compare.ComparableUtils.min(mutableShort1, mutableShort5);
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat13 = new org.apache.commons.lang3.mutable.MutableFloat();
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat14 = new org.apache.commons.lang3.mutable.MutableFloat();
        org.apache.commons.lang3.Range<org.apache.commons.lang3.mutable.MutableFloat> mutableFloatRange15 = org.apache.commons.lang3.Range.of(mutableFloat13, mutableFloat14);
        short short16 = mutableShort12.getAndAdd((java.lang.Number) mutableFloat14);
        org.junit.Assert.assertTrue("'" + short6 + "' != '" + (short) 101 + "'", short6 == (short) 101);
        org.junit.Assert.assertNotNull(mutableShort12);
        org.junit.Assert.assertNotNull(mutableFloatRange15);
        org.junit.Assert.assertTrue("'" + short16 + "' != '" + (short) 0 + "'", short16 == (short) 0);
    }

    @Test
    public void test0292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0292");
        org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper0 = new org.apache.commons.lang3.text.translate.NumericEntityEscaper();
    }

    @Test
    public void test0293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0293");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str1 = org.apache.commons.lang3.RandomStringUtils.randomGraph((int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Requested random string length -1 is less than 0.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0294");
        java.util.Collection<java.lang.ThreadGroup> threadGroupCollection0 = org.apache.commons.lang3.ThreadUtils.getAllThreadGroups();
        org.junit.Assert.assertNotNull(threadGroupCollection0);
    }

    @Test
    public void test0295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0295");
        java.lang.Boolean[] booleanArray8 = new java.lang.Boolean[] { false, false, false, false };
        java.lang.Boolean boolean9 = org.apache.commons.lang3.BooleanUtils.or(booleanArray8);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.exclusiveBetween("java.lang", ",", (java.lang.Comparable<java.lang.String>) "<null>", "open", (java.lang.Object[]) booleanArray8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: open");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray8);
        org.junit.Assert.assertEquals("'" + boolean9 + "' != '" + false + "'", boolean9, false);
    }

//    @Test
//    public void test0296() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0296");
//        org.apache.commons.lang3.tuple.ImmutableTriple<java.lang.String, java.lang.constant.ConstantDesc, java.lang.constant.Constable> strImmutableTriple0 = org.apache.commons.lang3.tuple.ImmutableTriple.nullTriple();
//        org.apache.commons.lang3.function.FailableObjIntConsumer failableObjIntConsumer1 = org.apache.commons.lang3.function.FailableObjIntConsumer.NOP;
//        boolean boolean2 = strImmutableTriple0.equals((java.lang.Object) failableObjIntConsumer1);
//        java.lang.constant.Constable constable3 = strImmutableTriple0.right;
//        org.junit.Assert.assertNotNull(strImmutableTriple0);
//        org.junit.Assert.assertNotNull(failableObjIntConsumer1);
//        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
//        org.junit.Assert.assertNull(constable3);
//    }

    @Test
    public void test0297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0297");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Long[] longArray1 = org.apache.commons.lang3.SerializationUtils.deserialize(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: inputStream");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0298");
        java.util.Locale[] localeArray0 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList1 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean2 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList1, localeArray0);
        java.net.URL[] uRLArray4 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection5 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList1, "Integer", (java.lang.Object[]) uRLArray4);
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream6 = org.apache.commons.lang3.Streams.stream(localeCollection5);
        org.junit.Assert.assertNotNull(localeArray0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(uRLArray4);
        org.junit.Assert.assertNotNull(localeCollection5);
        org.junit.Assert.assertNotNull(localeFailableStream6);
    }

    @Test
    public void test0299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0299");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper0 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper1 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper2 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper3 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper4 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper5 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper6 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray7 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper1, unicodeUnescaper2, unicodeUnescaper3, unicodeUnescaper4, unicodeUnescaper5, unicodeUnescaper6 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator8 = unicodeUnescaper0.with(charSequenceTranslatorArray7);
        java.time.Duration duration9 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ObjectUtils.wait((java.lang.Object) charSequenceTranslatorArray7, duration9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalMonitorStateException; message: current thread is not owner");
        } catch (java.lang.IllegalMonitorStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray7);
        org.junit.Assert.assertNotNull(charSequenceTranslator8);
    }

    @Test
    public void test0300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0300");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.stripAccents("open");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "open" + "'", str1, "open");
    }

    @Test
    public void test0301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0301");
        java.util.function.LongSupplier longSupplier1 = null;
        long long2 = org.apache.commons.lang3.SystemProperties.getLong("StrTokenizer[not tokenized yet]", longSupplier1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
    }

    @Test
    public void test0302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0302");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort1.setValue((java.lang.Number) (short) 100);
        java.lang.String str4 = mutableShort1.toString();
        short short5 = mutableShort1.decrementAndGet();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "100" + "'", str4, "100");
        org.junit.Assert.assertTrue("'" + short5 + "' != '" + (short) 99 + "'", short5 == (short) 99);
    }

    @Test
    public void test0303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0303");
        org.apache.commons.lang3.text.StrMatcher strMatcher0 = org.apache.commons.lang3.text.StrMatcher.doubleQuoteMatcher();
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = org.apache.commons.lang3.text.StrMatcher.doubleQuoteMatcher();
        org.apache.commons.lang3.text.StrMatcher strMatcher2 = org.apache.commons.lang3.text.StrMatcher.doubleQuoteMatcher();
        org.apache.commons.lang3.text.StrMatcher[] strMatcherArray3 = new org.apache.commons.lang3.text.StrMatcher[] { strMatcher0, strMatcher1, strMatcher2 };
        org.apache.commons.lang3.text.StrMatcher[] strMatcherArray4 = new org.apache.commons.lang3.text.StrMatcher[] {};
        org.apache.commons.lang3.text.StrMatcher[] strMatcherArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(strMatcherArray3, strMatcherArray4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.text.StrMatcher[] strMatcherArray7 = org.apache.commons.lang3.Validate.validIndex(strMatcherArray5, 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: The validated array index is invalid: 10");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strMatcher0);
        org.junit.Assert.assertNotNull(strMatcher1);
        org.junit.Assert.assertNotNull(strMatcher2);
        org.junit.Assert.assertNotNull(strMatcherArray3);
        org.junit.Assert.assertNotNull(strMatcherArray4);
        org.junit.Assert.assertNotNull(strMatcherArray5);
    }

    @Test
    public void test0304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0304");
        java.util.Locale locale1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.FastDateFormat.getDateInstance((int) (short) 99, locale1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal date style 99");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0305");
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray1 = org.apache.commons.lang3.RandomUtils.nextBytes((int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Count cannot be negative.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0306");
        java.lang.String str4 = org.apache.commons.lang3.StringUtils.overlay("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]", "16.0.1+9", (int) '#', (int) (short) 1);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "F16.0.1+9e/Stockholm]" + "'", str4, "F16.0.1+9e/Stockholm]");
    }

    @Test
    public void test0307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0307");
        org.apache.commons.lang3.function.FailableToLongFunction<org.apache.commons.lang3.function.FailableLongToDoubleFunction, java.lang.Throwable> failableLongToDoubleFunctionFailableToLongFunction0 = org.apache.commons.lang3.function.FailableToLongFunction.nop();
        org.junit.Assert.assertNotNull(failableLongToDoubleFunctionFailableToLongFunction0);
    }

    @Test
    public void test0308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0308");
        short[] shortArray2 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray2, (int) (byte) -1, 1, (int) (byte) 10);
        org.apache.commons.lang3.ArrayUtils.shuffle(shortArray2);
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.contains(shortArray2, (short) 1);
        org.junit.Assert.assertNotNull(shortArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray2), "[100, 100]");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test0309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0309");
        short short1 = org.apache.commons.lang3.ObjectUtils.CONST((short) (byte) 1);
        org.junit.Assert.assertTrue("'" + short1 + "' != '" + (short) 1 + "'", short1 == (short) 1);
    }

    @Test
    public void test0310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0310");
        java.lang.String str1 = org.apache.commons.lang3.ClassPathUtils.pathToPackage("QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc" + "'", str1, "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc");
    }

    @Test
    public void test0311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0311");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        float[] floatArray13 = org.apache.commons.lang3.ArrayFill.fill(floatArray10, (float) (short) 99);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[99.0, 99.0, 99.0, 99.0, 99.0, 99.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(floatArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray13), "[99.0, 99.0, 99.0, 99.0, 99.0, 99.0]");
    }

//    @Test
//    public void test0312() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0312");
//        java.lang.reflect.Method method0 = null;
//        // The following exception was thrown during execution in test generation
//        try {
//            org.apache.commons.lang3.function.FailableSupplier<java.lang.constant.ConstantDesc, java.lang.Throwable> constantDescFailableSupplier1 = org.apache.commons.lang3.function.MethodInvokers.asFailableSupplier(method0);
//            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
//        } catch (java.lang.NullPointerException e) {
//            // Expected exception.
//        }
//    }

    @Test
    public void test0313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0313");
        org.apache.commons.lang3.text.translate.JavaUnicodeEscaper javaUnicodeEscaper1 = org.apache.commons.lang3.text.translate.JavaUnicodeEscaper.below((int) (short) 100);
        java.io.Writer writer3 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean4 = javaUnicodeEscaper1.translate((int) (short) 99, writer3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.io.Writer.write(String)\" because \"out\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(javaUnicodeEscaper1);
    }

    @Test
    public void test0314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0314");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_98;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0315");
        java.lang.String str1 = org.apache.commons.lang3.BooleanUtils.toStringYesNo((java.lang.Boolean) false);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "no" + "'", str1, "no");
    }

    @Test
    public void test0316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0316");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.right("java.lang", (-1));
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test0317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0317");
        java.lang.CharSequence[] charSequenceArray6 = new java.lang.CharSequence[] { "mixed mode, sharing", "100", "16.0.1", "AdoptOpenJDK", "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]" };
        boolean boolean7 = org.apache.commons.lang3.StringUtils.isAnyEmpty(charSequenceArray6);
        boolean boolean8 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "Integer", charSequenceArray6);
        org.junit.Assert.assertNotNull(charSequenceArray6);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test0318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0318");
        org.apache.commons.lang3.function.FailableBiFunction failableBiFunction0 = org.apache.commons.lang3.function.FailableBiFunction.NOP;
        java.util.concurrent.locks.ReadWriteLock readWriteLock1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.locks.LockingVisitors.ReadWriteLockVisitor<org.apache.commons.lang3.function.FailableBiFunction> failableBiFunctionReadWriteLockVisitor2 = org.apache.commons.lang3.concurrent.locks.LockingVisitors.create(failableBiFunction0, readWriteLock1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(failableBiFunction0);
    }

    @Test
    public void test0319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0319");
        java.lang.String str0 = org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.PROPERTY_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "open" + "'", str0, "open");
    }

    @Test
    public void test0320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0320");
        float float2 = org.apache.commons.lang3.math.IEEE754rUtils.max((float) 3, (float) 100);
        org.junit.Assert.assertTrue("'" + float2 + "' != '" + 100.0f + "'", float2 == 100.0f);
    }

    @Test
    public void test0321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0321");
        int int3 = org.apache.commons.lang3.StringUtils.lastOrdinalIndexOf((java.lang.CharSequence) "no", (java.lang.CharSequence) "os.nam", (int) (byte) 1);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test0322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0322");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        org.apache.commons.lang3.ArrayUtils.reverse(floatArray10);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[100.0, 0.0, 10.0, 10.0, 100.0, 32.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test0323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0323");
        char char1 = org.apache.commons.lang3.CharUtils.toChar("org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on");
        org.junit.Assert.assertTrue("'" + char1 + "' != '" + 'o' + "'", char1 == 'o');
    }

    @Test
    public void test0324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0324");
        java.lang.String str1 = org.apache.commons.lang3.CharUtils.unicodeEscaped(' ');
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "\\u0020" + "'", str1, "\\u0020");
    }

    @Test
    public void test0325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0325");
        short[] shortArray4 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray4, (int) (byte) -1, 1, (int) (byte) 10);
        org.apache.commons.lang3.ArrayUtils.shuffle(shortArray4);
        // The following exception was thrown during execution in test generation
        try {
            short[] shortArray12 = org.apache.commons.lang3.Conversion.intToShortArray((int) ' ', (int) '#', shortArray4, (int) (short) 99, (int) (short) 101);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nShorts-1)*16+srcPos is greater or equal to than 32");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(shortArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray4), "[100, 100]");
    }

    @Test
    public void test0326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0326");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.setHours(date0, 3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0327");
        org.apache.commons.lang3.function.FailableIntPredicate<java.lang.UnsupportedOperationException> unsupportedOperationExceptionFailableIntPredicate0 = org.apache.commons.lang3.function.FailableIntPredicate.truePredicate();
        org.junit.Assert.assertNotNull(unsupportedOperationExceptionFailableIntPredicate0);
    }

    @Test
    public void test0328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0328");
        char char0 = org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR;
        org.junit.Assert.assertTrue("'" + char0 + "' != '" + '$' + "'", char0 == '$');
    }

    @Test
    public void test0329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0329");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_RUNTIME_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "OpenJDK Runtime Environment" + "'", str0, "OpenJDK Runtime Environment");
    }

    @Test
    public void test0330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0330");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.leftPad("100", (int) (short) 101);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "                                                                                                  100" + "'", str2, "                                                                                                  100");
    }

    @Test
    public void test0331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0331");
        java.lang.Throwable throwable3 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException4 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable3);
        java.lang.Throwable[] throwableArray5 = uncheckedExecutionException4.getSuppressed();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.matchesPattern((java.lang.CharSequence) "                                                                                                open", "Lopeng", "60.0", (java.lang.Object[]) throwableArray5);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: 60.0");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray5);
    }

    @Test
    public void test0332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0332");
        short[] shortArray5 = new short[] { (short) 0, (short) 100, (short) 99, (short) 99, (short) 100 };
        // The following exception was thrown during execution in test generation
        try {
            int int10 = org.apache.commons.lang3.Conversion.shortArrayToInt(shortArray5, (int) (byte) 1, (int) (byte) -1, (-27), (int) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nShorts-1)*16+dstPos is greater or equal to than 32");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(shortArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray5), "[0, 100, 99, 99, 100]");
    }

    @Test
    public void test0333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0333");
        org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper1 = org.apache.commons.lang3.text.translate.NumericEntityEscaper.below((int) 'o');
        org.junit.Assert.assertNotNull(numericEntityEscaper1);
    }

    @Test
    public void test0334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0334");
        org.apache.commons.lang3.BitField bitField1 = new org.apache.commons.lang3.BitField(1);
    }

    @Test
    public void test0335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0335");
        org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException> uncheckedExecutionExceptionFailableDoublePredicate0 = org.apache.commons.lang3.function.FailableDoublePredicate.falsePredicate();
        boolean boolean2 = uncheckedExecutionExceptionFailableDoublePredicate0.test(10.0d);
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicate0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0336");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        java.lang.String str1 = fastDateFormat0.toString();
        java.lang.String[] strArray2 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray4 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray2, (java.lang.CharSequence) "Integer");
        boolean boolean5 = fastDateFormat0.equals((java.lang.Object) charSequenceArray4);
        java.lang.String str6 = fastDateFormat0.getPattern();
        java.util.Calendar calendar7 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str8 = fastDateFormat0.format(calendar7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Calendar.getTimeZone()\" because \"calendar\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]" + "'", str1, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertNotNull(charSequenceArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "HH:mm:ss" + "'", str6, "HH:mm:ss");
    }

    @Test
    public void test0337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0337");
        java.lang.CharSequence charSequence2 = org.apache.commons.lang3.StringUtils.defaultIfBlank((java.lang.CharSequence) "\u3928\ud86e\udf97\u5072\u6c6c\ud700\ud842\udf9d\u6baf\u19ab", (java.lang.CharSequence) "100");
        org.junit.Assert.assertEquals("'" + charSequence2 + "' != '" + "\u3928\ud86e\udf97\u5072\u6c6c\ud700\ud842\udf9d\u6baf\u19ab" + "'", charSequence2, "\u3928\ud86e\udf97\u5072\u6c6c\ud700\ud842\udf9d\u6baf\u19ab");
    }

    @Test
    public void test0338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0338");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaSpecificationVendor();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "Oracle Corporation" + "'", str0, "Oracle Corporation");
    }

    @Test
    public void test0339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0339");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort1.setValue((java.lang.Number) (short) 100);
        mutableShort1.decrement();
    }

    @Test
    public void test0340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0340");
        int int3 = org.apache.commons.lang3.math.NumberUtils.min((-1), (int) '\n', (int) '\n');
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test0341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0341");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getLineSeparator();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "\n" + "'", str0, "\n");
    }

    @Test
    public void test0342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0342");
        int int0 = org.apache.commons.lang3.time.FastDateFormat.SHORT;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test0343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0343");
        boolean[] booleanArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_BOOLEAN_ARRAY;
        // The following exception was thrown during execution in test generation
        try {
            char char1 = org.apache.commons.lang3.Conversion.binaryToHexDigit(booleanArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot convert an empty array.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray0), "[]");
    }

    @Test
    public void test0344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0344");
        java.util.stream.Collector<java.lang.Object, ?, java.lang.String> objCollector3 = org.apache.commons.lang3.stream.LangCollectors.joining((java.lang.CharSequence) "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]", (java.lang.CharSequence) "long", (java.lang.CharSequence) "java.lang");
        org.junit.Assert.assertNotNull(objCollector3);
    }

    @Test
    public void test0345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0345");
        org.apache.commons.lang3.function.FailableDoubleToIntFunction<java.lang.Exception> exceptionFailableDoubleToIntFunction0 = org.apache.commons.lang3.function.FailableDoubleToIntFunction.nop();
        org.junit.Assert.assertNotNull(exceptionFailableDoubleToIntFunction0);
    }

    @Test
    public void test0346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0346");
        org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper1 = org.apache.commons.lang3.text.translate.NumericEntityEscaper.above((int) (short) 101);
        org.junit.Assert.assertNotNull(numericEntityEscaper1);
    }

    @Test
    public void test0347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0347");
        java.lang.reflect.ParameterizedType parameterizedType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type> wildcardTypeVariableMap1 = org.apache.commons.lang3.reflect.TypeUtils.getTypeArguments(parameterizedType0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.reflect.ParameterizedType.getRawType()\" because \"parameterizedType\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0348");
        java.lang.CharSequence charSequence1 = org.apache.commons.lang3.Validate.notBlank((java.lang.CharSequence) "581cd446");
        org.junit.Assert.assertEquals("'" + charSequence1 + "' != '" + "581cd446" + "'", charSequence1, "581cd446");
    }

    @Test
    public void test0349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0349");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Boolean boolean4 = org.apache.commons.lang3.BooleanUtils.toBooleanObject("a16.0.1+9a", "glacierali", "java.lang", "os.version");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The String did not match any specified value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0350");
        int int2 = org.apache.commons.lang3.StringUtils.indexOf((java.lang.CharSequence) " ", 0);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test0351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0351");
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair0 = null;
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair1 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray2 = charSequenceArrayImmutablePair1.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair3 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Range<org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayMutablePairRange4 = org.apache.commons.lang3.Range.between(charSequenceArrayMutablePair0, charSequenceArrayMutablePair3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: element1");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair1);
        org.junit.Assert.assertNull(charSequenceArray2);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair3);
    }

    @Test
    public void test0352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0352");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_LIBRARY_PATH;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.library.path" + "'", str0, "java.library.path");
    }

    @Test
    public void test0353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0353");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isNumeric((java.lang.CharSequence) "user.dir");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0354");
        boolean boolean1 = org.apache.commons.lang3.BooleanUtils.toBoolean((java.lang.Boolean) true);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0355");
        java.lang.CharSequence charSequence2 = org.apache.commons.lang3.StringUtils.defaultIfBlank((java.lang.CharSequence) "", (java.lang.CharSequence) "UnicodeUnescaper");
        org.junit.Assert.assertEquals("'" + charSequence2 + "' != '" + "UnicodeUnescaper" + "'", charSequence2, "UnicodeUnescaper");
    }

    @Test
    public void test0356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0356");
        org.apache.commons.lang3.tuple.MutablePair<java.util.ListIterator<java.lang.String>, java.util.Iterator<java.lang.String>> strItorMutablePair0 = new org.apache.commons.lang3.tuple.MutablePair<java.util.ListIterator<java.lang.String>, java.util.Iterator<java.lang.String>>();
    }

    @Test
    public void test0357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0357");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.removeAll("Mac OS X", "pen");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "Mac OS X" + "'", str2, "Mac OS X");
    }

    @Test
    public void test0358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0358");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_ME;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0359");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.add(byteArray2, (byte) 100);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[0, -1, 100]");
    }

    @Test
    public void test0360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0360");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("UTF-16", '4', '\n');
        java.lang.String str4 = strTokenizer3.nextToken();
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "UTF-16" + "'", str4, "UTF-16");
    }

    @Test
    public void test0361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0361");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean1 = new org.apache.commons.lang3.mutable.MutableBoolean((java.lang.Boolean) true);
        mutableBoolean1.setValue((java.lang.Boolean) true);
        mutableBoolean1.setFalse();
    }

    @Test
    public void test0362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0362");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayFill.fill(byteArray2, (byte) 0);
        byte byte6 = org.apache.commons.lang3.math.NumberUtils.max(byteArray2);
        boolean boolean7 = org.apache.commons.lang3.ArrayUtils.isEmpty(byteArray2);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[0, 0]");
        org.junit.Assert.assertTrue("'" + byte6 + "' != '" + (byte) 0 + "'", byte6 == (byte) 0);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test0363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0363");
        java.util.Calendar calendar0 = null;
        java.util.Locale locale2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = org.apache.commons.lang3.time.DateFormatUtils.format(calendar0, "AdoptOpenJDK", locale2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: A");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0364");
        org.apache.commons.lang3.function.FailableIntToDoubleFunction<org.apache.commons.lang3.exception.UncheckedException> uncheckedExceptionFailableIntToDoubleFunction0 = org.apache.commons.lang3.function.FailableIntToDoubleFunction.nop();
        org.junit.Assert.assertNotNull(uncheckedExceptionFailableIntToDoubleFunction0);
    }

    @Test
    public void test0365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0365");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaLibraryPath();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "/Users/glacierali/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:." + "'", str0, "/Users/glacierali/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.");
    }

    @Test
    public void test0366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0366");
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException2, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException6 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException5);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException7 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException5);
        java.lang.Object obj9 = contextedRuntimeException7.getFirstContextValue("glacierali");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.ConcurrentException concurrentException10 = new org.apache.commons.lang3.concurrent.ConcurrentException((java.lang.Throwable) contextedRuntimeException7);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Not a checked exception: org.apache.commons.lang3.exception.ContextedRuntimeException: org.apache.commons.lang3.NotImplementedException: hi!");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(obj9);
    }

    @Test
    public void test0367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0367");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        int[] intArray15 = new int[] { '\000', ' ', '\n', (short) 101, '\000' };
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray16 = org.apache.commons.lang3.ArrayUtils.removeAll(booleanArray5, intArray15);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 101, Length: 5");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet9);
        org.junit.Assert.assertEquals(bitSet9.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(intArray15);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray15), "[0, 32, 10, 101, 0]");
    }

    @Test
    public void test0368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0368");
        java.util.Formatter formatter1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Formatter formatter6 = org.apache.commons.lang3.text.FormattableUtils.append((java.lang.CharSequence) "F16.0.1+9e/Stockholm]", formatter1, (int) 'o', 10, (int) ' ', '$');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Formatter.format(String, Object[])\" because \"formatter\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0369");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayFill.fill(byteArray2, (byte) 0);
        java.lang.String str7 = org.apache.commons.lang3.StringUtils.join(byteArray5, '\n');
        byte byte8 = org.apache.commons.lang3.math.NumberUtils.min(byteArray5);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[0, 0]");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "0\n0" + "'", str7, "0\n0");
        org.junit.Assert.assertTrue("'" + byte8 + "' != '" + (byte) 0 + "'", byte8 == (byte) 0);
    }

    @Test
    public void test0370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0370");
        java.lang.Long[] longArray6 = new java.lang.Long[] { 10L, 0L, (-1L), (-1L), 10L, 1L };
        java.lang.Long[] longArray7 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray6);
        java.net.URL[] uRLArray8 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.isSameLength((java.lang.Object[]) longArray6, (java.lang.Object[]) uRLArray8);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj11 = org.apache.commons.lang3.reflect.FieldUtils.readField((java.lang.Object) longArray6, "60.0");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot locate field 60.0 on class [Ljava.lang.Long;");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertNotNull(longArray7);
        org.junit.Assert.assertNotNull(uRLArray8);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
    }

    @Test
    public void test0371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0371");
        java.lang.reflect.Method method0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.function.BiConsumer<java.util.AbstractCollection<java.util.Locale>, java.lang.String[][]> localeCollectionBiConsumer1 = org.apache.commons.lang3.function.MethodInvokers.asBiConsumer(method0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0372");
        java.lang.String[][] strArray2 = org.apache.commons.lang3.text.translate.EntityArrays.APOS_ESCAPE();
        java.lang.Class<?> wildcardClass3 = null;
        java.lang.Class[] classArray5 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray6 = (java.lang.Class<?>[]) classArray5;
        wildcardClassArray6[0] = wildcardClass3;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj9 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) (byte) -1, "line.separator", (java.lang.Object[]) strArray2, wildcardClassArray6);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: line.separator() on object: java.lang.Byte");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertNotNull(classArray5);
        org.junit.Assert.assertNotNull(wildcardClassArray6);
    }

    @Test
    public void test0373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0373");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean1 = new org.apache.commons.lang3.mutable.MutableBoolean(false);
        mutableBoolean1.setValue((java.lang.Boolean) true);
    }

    @Test
    public void test0374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0374");
        short[] shortArray2 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray2, (int) (byte) -1, 1, (int) (byte) 10);
        org.apache.commons.lang3.ArrayUtils.shuffle(shortArray2);
        org.apache.commons.lang3.ArrayUtils.reverse(shortArray2);
        java.util.Random random9 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(shortArray2, random9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(shortArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray2), "[100, 100]");
    }

    @Test
    public void test0375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0375");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.FILE_ENCODING;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-8" + "'", str0, "UTF-8");
    }

    @Test
    public void test0376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0376");
        double double2 = org.apache.commons.lang3.math.IEEE754rUtils.min((double) (short) -1, (double) 8);
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-1.0d) + "'", double2 == (-1.0d));
    }

    @Test
    public void test0377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0377");
        java.lang.Throwable throwable0 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException1 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable0);
        boolean boolean2 = org.apache.commons.lang3.exception.ExceptionUtils.isChecked(throwable0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0378");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_SNOW_LEOPARD;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0379");
        org.apache.commons.lang3.mutable.MutableLong mutableLong1 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        mutableLong1.add((long) 0);
        long long4 = mutableLong1.getAndDecrement();
        org.junit.Assert.assertTrue("'" + long4 + "' != '" + 1L + "'", long4 == 1L);
    }

    @Test
    public void test0380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0380");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_1_4;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_1_4 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_1_4));
    }

    @Test
    public void test0381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0381");
        boolean boolean1 = org.apache.commons.lang3.CharUtils.isAsciiAlphaLower('o');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0382");
        int[] intArray5 = new int[] { (short) 100, (short) 10, (short) 10, '\n', '\n' };
        int[] intArray7 = org.apache.commons.lang3.ArrayUtils.add(intArray5, (int) '4');
        int int9 = org.apache.commons.lang3.ArrayUtils.indexOf(intArray5, 0);
        org.apache.commons.lang3.ArrayUtils.swap(intArray5, (int) 'o', (int) (short) 100, 97);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray5), "[100, 10, 10, 10, 10]");
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray7), "[100, 10, 10, 10, 10, 52]");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
    }

//    @Test
//    public void test0383() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0383");
//        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle1 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
//        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
//        java.lang.String[] strArray6 = strTokenizer5.getTokenArray();
//        java.lang.String str7 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle1, strArray6);
//        // The following exception was thrown during execution in test generation
//        try {
//            java.lang.String str8 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringInclude((java.lang.Object) "Integer", strArray6);
//            org.junit.Assert.fail("Expected exception of type java.lang.reflect.InaccessibleObjectException; message: Unable to make field static final boolean java.lang.String.COMPACT_STRINGS accessible: module java.base does not \"opens java.lang\" to unnamed module @654b5005");
//        } catch (java.lang.reflect.InaccessibleObjectException e) {
//            // Expected exception.
//        }
//        org.junit.Assert.assertNotNull(strArray6);
//    }

    @Test
    public void test0384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0384");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_1_9;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0385");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.defaultIfBlank("true", "");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true" + "'", str2, "true");
    }

    @Test
    public void test0386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0386");
        java.util.Locale locale1 = null;
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.FastDateFormat.getInstance("", locale1);
        java.text.ParsePosition parsePosition4 = null;
        java.lang.Object obj5 = fastDateFormat2.parseObject("open", parsePosition4);
        java.lang.Object obj6 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.text.AttributedCharacterIterator attributedCharacterIterator7 = fastDateFormat2.formatToCharacterIterator(obj6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Unknown class: <null>");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat2);
        org.junit.Assert.assertNotNull(obj5);
        org.junit.Assert.assertEquals(obj5.toString(), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj5), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj5), "Thu Jan 01 00:00:00 CET 1970");
    }

    @Test
    public void test0387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0387");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj2 = fastDateFormat0.parseObject(":");
            org.junit.Assert.fail("Expected exception of type java.text.ParseException; message: Format.parseObject(String) failed");
        } catch (java.text.ParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
    }

    @Test
    public void test0388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0388");
        java.lang.Throwable throwable3 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException4 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable3);
        java.lang.Throwable[] throwableArray5 = uncheckedExecutionException4.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException7 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException4, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException8 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException4);
        org.apache.commons.lang3.concurrent.CircuitBreakingException circuitBreakingException9 = new org.apache.commons.lang3.concurrent.CircuitBreakingException("Integer", (java.lang.Throwable) uncheckedExecutionException4);
        org.junit.Assert.assertNotNull(throwableArray5);
    }

    @Test
    public void test0389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0389");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean1 = new org.apache.commons.lang3.mutable.MutableBoolean((java.lang.Boolean) true);
        boolean boolean3 = mutableBoolean1.equals((java.lang.Object) 0.0f);
        boolean boolean4 = mutableBoolean1.isTrue();
        java.util.function.Predicate<org.apache.commons.lang3.mutable.MutableBoolean> mutableBooleanPredicate5 = org.apache.commons.lang3.compare.ComparableUtils.le(mutableBoolean1);
        mutableBoolean1.setFalse();
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        org.junit.Assert.assertNotNull(mutableBooleanPredicate5);
    }

    @Test
    public void test0390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0390");
        org.apache.commons.lang3.function.FailableObjLongConsumer<org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.exception.UncheckedException> dateParserFailableObjLongConsumer0 = org.apache.commons.lang3.function.FailableObjLongConsumer.nop();
        org.junit.Assert.assertNotNull(dateParserFailableObjLongConsumer0);
    }

    @Test
    public void test0391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0391");
        byte[] byteArray4 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray4);
        byte[] byteArray7 = org.apache.commons.lang3.ArrayFill.fill(byteArray4, (byte) 0);
        java.nio.charset.Charset charset8 = null;
        java.lang.String str9 = org.apache.commons.lang3.StringUtils.toEncodedString(byteArray7, charset8);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray12 = org.apache.commons.lang3.Conversion.shortToByteArray((short) (byte) 0, (int) '$', byteArray7, (int) ' ', (int) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nBytes-1)*8+srcPos is greater or equal to than 16");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray4), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray7), "[0, 0]");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "\000\000" + "'", str9, "\000\000");
    }

    @Test
    public void test0392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0392");
        org.apache.commons.lang3.function.FailableToIntBiFunction failableToIntBiFunction0 = org.apache.commons.lang3.function.FailableToIntBiFunction.NOP;
        org.junit.Assert.assertNotNull(failableToIntBiFunction0);
    }

    @Test
    public void test0393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0393");
        double[] doubleArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_DOUBLE_ARRAY;
        org.apache.commons.lang3.ArrayUtils.shift(doubleArray0, 100);
        org.junit.Assert.assertNotNull(doubleArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray0), "[]");
    }

    @Test
    public void test0394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0394");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean1 = new org.apache.commons.lang3.mutable.MutableBoolean((java.lang.Boolean) false);
    }

    @Test
    public void test0395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0395");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        java.util.Calendar calendar1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str2 = fastDateFormat0.format(calendar1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Calendar.getTimeZone()\" because \"calendar\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
    }

    @Test
    public void test0396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0396");
        int int3 = org.apache.commons.lang3.StringUtils.lastIndexOf((java.lang.CharSequence) "https://adoptopenjdk.net/", 8, (int) (short) 10);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test0397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0397");
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService0 = null;
        java.util.concurrent.TimeUnit timeUnit2 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore4 = new org.apache.commons.lang3.concurrent.TimedSemaphore(scheduledExecutorService0, (long) (byte) 100, timeUnit2, (int) (short) 10);
    }

    @Test
    public void test0398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0398");
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper0 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper1 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper2 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper3 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper4 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper5 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper6 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray7 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper1, unicodeUnescaper2, unicodeUnescaper3, unicodeUnescaper4, unicodeUnescaper5, unicodeUnescaper6 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator8 = unicodeUnescaper0.with(charSequenceTranslatorArray7);
        java.io.Writer writer11 = null;
        int int12 = charSequenceTranslator8.translate((java.lang.CharSequence) "org.apache.commons.lang3.function", 0, writer11);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray7);
        org.junit.Assert.assertNotNull(charSequenceTranslator8);
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 0 + "'", int12 == 0);
    }

    @Test
    public void test0399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0399");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray4 = strTokenizer3.getTokenArray();
        boolean boolean5 = strTokenizer3.hasPrevious();
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test0400() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0400");
        org.apache.commons.lang3.function.FailableConsumer failableConsumer0 = org.apache.commons.lang3.function.FailableConsumer.NOP;
        org.junit.Assert.assertNotNull(failableConsumer0);
    }

    @Test
    public void test0401() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0401");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.escapeJson("true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str1, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
    }

    @Test
    public void test0402() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0402");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getOsVersion();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "11.5" + "'", str0, "11.5");
    }

    @Test
    public void test0403() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0403");
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair0 = new org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>();
    }

    @Test
    public void test0404() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0404");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.substringAfter("                                                                                                  100", (int) (byte) 10);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test0405() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0405");
        boolean boolean1 = org.apache.commons.lang3.math.NumberUtils.isNumber("org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0406() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0406");
        java.lang.Object obj0 = null;
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle1 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray6 = strTokenizer5.getTokenArray();
        java.lang.String str7 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle1, strArray6);
        // The following exception was thrown during execution in test generation
        try {
            int int8 = org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(obj0, strArray6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: object");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray6);
    }

    @Test
    public void test0407() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0407");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaLocaleProviders();
        org.junit.Assert.assertNull(str0);
    }

    @Test
    public void test0408() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0408");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat((float) (short) -1);
        int int2 = mutableFloat1.intValue();
        float float3 = mutableFloat1.incrementAndGet();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + 0.0f + "'", float3 == 0.0f);
    }

    @Test
    public void test0409() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0409");
        java.lang.String str1 = org.apache.commons.lang3.RandomStringUtils.randomAscii(97);
// flaky:         org.junit.Assert.assertEquals("'" + str1 + "' != '" + ".]Wr1`~U#8P1RR^y~QA|^cKs1{%\\1T?5lK0:E`Sb.&C>Ti|7U`_rdX-~ezvoa,]'Y`!G4\"%H.wF)`\",%`~,Oq)sru73.75Tg2" + "'", str1, ".]Wr1`~U#8P1RR^y~QA|^cKs1{%\\1T?5lK0:E`Sb.&C>Ti|7U`_rdX-~ezvoa,]'Y`!G4\"%H.wF)`\",%`~,Oq)sru73.75Tg2");
    }

    @Test
    public void test0410() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0410");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_VM_SPECIFICATION_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.vm.specification.name" + "'", str0, "java.vm.specification.name");
    }

    @Test
    public void test0411() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0411");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_20;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_20 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_20));
    }

    @Test
    public void test0412() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0412");
        boolean boolean2 = org.apache.commons.lang3.StringUtils.equals((java.lang.CharSequence) "100", (java.lang.CharSequence) "");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0413() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0413");
        org.apache.commons.lang3.function.Suppliers suppliers0 = new org.apache.commons.lang3.function.Suppliers();
    }

    @Test
    public void test0414() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0414");
        int[] intArray4 = new int[] { (short) 99, (short) 101, (short) 99, 1 };
        int[] intArray9 = new int[] { (short) 99, (short) 101, (short) 99, 1 };
        int[][] intArray10 = new int[][] { intArray4, intArray9 };
        int[] intArray12 = org.apache.commons.lang3.ArrayUtils.get(intArray10, (int) (byte) -1);
        org.junit.Assert.assertNotNull(intArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray4), "[99, 101, 99, 1]");
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray9), "[99, 101, 99, 1]");
        org.junit.Assert.assertNotNull(intArray10);
        org.junit.Assert.assertNull(intArray12);
    }

    @Test
    public void test0415() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0415");
        org.apache.commons.lang3.mutable.MutableBoolean mutableBoolean0 = new org.apache.commons.lang3.mutable.MutableBoolean();
    }

    @Test
    public void test0416() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0416");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_EXT_DIRS;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.ext.dirs" + "'", str0, "java.ext.dirs");
    }

    @Test
    public void test0417() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0417");
        java.lang.reflect.Field field0 = null;
        double[] doubleArray6 = new double[] { 1.0d, 2147483647L, 100.0d, 10, 32.0f };
        double[] doubleArray8 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(doubleArray6, 1.0d);
        double[] doubleArray13 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray17 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean19 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray17, (double) '4');
        boolean boolean20 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray13, doubleArray17);
        int int24 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray13, (-1.0d), (int) '\n', (double) 100);
        boolean boolean25 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray8, doubleArray13);
        org.apache.commons.lang3.ArrayUtils.shuffle(doubleArray8);
        java.util.List<java.util.Locale> localeList27 = org.apache.commons.lang3.LocaleUtils.availableLocaleList();
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream28 = org.apache.commons.lang3.Streams.stream((java.util.Collection<java.util.Locale>) localeList27);
        java.util.stream.Stream<java.util.Locale> localeStream29 = org.apache.commons.lang3.stream.Streams.of((java.lang.Iterable<java.util.Locale>) localeList27);
        java.util.stream.Stream<java.util.Locale> localeStream30 = org.apache.commons.lang3.stream.Streams.nonNull(localeStream29);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.reflect.FieldUtils.writeField(field0, (java.lang.Object) doubleArray8, (java.lang.Object) localeStream30);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: field");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(doubleArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray6), "[1.0, 2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray8);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray8), "[100.0, 32.0, 10.0, 2.147483647E9]");
        org.junit.Assert.assertNotNull(doubleArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray13), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray17), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + (-1) + "'", int24 == (-1));
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
        org.junit.Assert.assertNotNull(localeList27);
        org.junit.Assert.assertNotNull(localeFailableStream28);
        org.junit.Assert.assertNotNull(localeStream29);
        org.junit.Assert.assertNotNull(localeStream30);
    }

    @Test
    public void test0418() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0418");
        java.lang.Boolean[] booleanArray4 = new java.lang.Boolean[] { true, true, false, false };
        boolean[] booleanArray6 = org.apache.commons.lang3.ArrayUtils.toPrimitive(booleanArray4, true);
        // The following exception was thrown during execution in test generation
        try {
            char char8 = org.apache.commons.lang3.Conversion.binaryToHexDigit(booleanArray6, (int) 'o');
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Index 111 out of bounds for length 4");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray4);
        org.junit.Assert.assertNotNull(booleanArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray6), "[true, true, false, false]");
    }

    @Test
    public void test0419() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0419");
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate0 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        boolean boolean2 = throwableFailableLongPredicate0.test((long) (byte) 100);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate3 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate4 = throwableFailableLongPredicate0.or(throwableFailableLongPredicate3);
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper6 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper7 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper8 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper9 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper10 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper11 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper12 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray13 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper7, unicodeUnescaper8, unicodeUnescaper9, unicodeUnescaper10, unicodeUnescaper11, unicodeUnescaper12 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator14 = unicodeUnescaper6.with(charSequenceTranslatorArray13);
        java.lang.Class[] classArray16 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray17 = (java.lang.Class<?>[]) classArray16;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj18 = org.apache.commons.lang3.reflect.MethodUtils.invokeExactMethod((java.lang.Object) throwableFailableLongPredicate0, "", (java.lang.Object[]) charSequenceTranslatorArray13, (java.lang.Class<?>[]) classArray16);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: () on object: org.apache.commons.lang3.function.FailableLongPredicate$$Lambda$132/0x0000000800cc3420");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate3);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate4);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray13);
        org.junit.Assert.assertNotNull(charSequenceTranslator14);
        org.junit.Assert.assertNotNull(classArray16);
        org.junit.Assert.assertNotNull(wildcardClassArray17);
    }

    @Test
    public void test0420() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0420");
        org.apache.commons.lang3.text.StrMatcher strMatcher0 = org.apache.commons.lang3.text.StrMatcher.doubleQuoteMatcher();
        char[] charArray4 = new char[] { ' ', '#' };
        char[] charArray6 = new char[] { ' ' };
        char[] charArray7 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray4, charArray6);
        char[] charArray10 = org.apache.commons.lang3.ArrayUtils.add(charArray6, (int) (short) 0, ' ');
        char[] charArray15 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray18 = org.apache.commons.lang3.ArrayUtils.subarray(charArray15, (int) (short) 1, (-1));
        char[] charArray19 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray6, charArray15);
        char[] charArray22 = new char[] { ' ', '#' };
        char[] charArray24 = new char[] { ' ' };
        char[] charArray25 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray22, charArray24);
        char[] charArray28 = org.apache.commons.lang3.ArrayUtils.add(charArray24, (int) (short) 0, ' ');
        char[] charArray33 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray36 = org.apache.commons.lang3.ArrayUtils.subarray(charArray33, (int) (short) 1, (-1));
        char[] charArray37 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray24, charArray33);
        char[] charArray38 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray15, charArray37);
        char[] charArray41 = new char[] { ' ', '#' };
        char[] charArray43 = new char[] { ' ' };
        char[] charArray44 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray41, charArray43);
        char[] charArray47 = org.apache.commons.lang3.ArrayUtils.add(charArray43, (int) (short) 0, ' ');
        char[] charArray52 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray55 = org.apache.commons.lang3.ArrayUtils.subarray(charArray52, (int) (short) 1, (-1));
        char[] charArray56 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray43, charArray52);
        char[] charArray59 = new char[] { ' ', '#' };
        char[] charArray61 = new char[] { ' ' };
        char[] charArray62 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray59, charArray61);
        char[] charArray65 = org.apache.commons.lang3.ArrayUtils.add(charArray61, (int) (short) 0, ' ');
        char[] charArray70 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray73 = org.apache.commons.lang3.ArrayUtils.subarray(charArray70, (int) (short) 1, (-1));
        char[] charArray74 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray61, charArray70);
        char[] charArray75 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray52, charArray74);
        char[] charArray76 = org.apache.commons.lang3.ArrayUtils.insert(3, charArray37, charArray74);
        // The following exception was thrown during execution in test generation
        try {
            int int78 = strMatcher0.isMatch(charArray37, (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.ArrayIndexOutOfBoundsException; message: Index 0 out of bounds for length 0");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strMatcher0);
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[ , #]");
        org.junit.Assert.assertNotNull(charArray6);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray6), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray6), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray6), "[ ]");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray7), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray7), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray7), "[#]");
        org.junit.Assert.assertNotNull(charArray10);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray10), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray10), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray10), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray15);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray15), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray15), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray15), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray18);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray18), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray18), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray18), "[]");
        org.junit.Assert.assertNotNull(charArray19);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray19), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray19), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray19), "[]");
        org.junit.Assert.assertNotNull(charArray22);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray22), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray22), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray22), "[ , #]");
        org.junit.Assert.assertNotNull(charArray24);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray24), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray24), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray24), "[ ]");
        org.junit.Assert.assertNotNull(charArray25);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray25), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray25), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray25), "[#]");
        org.junit.Assert.assertNotNull(charArray28);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray28), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray28), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray28), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray33);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray33), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray33), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray33), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray36);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray36), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray36), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray36), "[]");
        org.junit.Assert.assertNotNull(charArray37);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray37), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray37), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray37), "[]");
        org.junit.Assert.assertNotNull(charArray38);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray38), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray38), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray38), "[a, \n, 4,  ]");
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
        org.junit.Assert.assertNotNull(charArray47);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray47), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray47), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray47), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray52);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray52), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray52), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray52), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray55);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray55), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray55), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray55), "[]");
        org.junit.Assert.assertNotNull(charArray56);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray56), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray56), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray56), "[]");
        org.junit.Assert.assertNotNull(charArray59);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray59), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray59), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray59), "[ , #]");
        org.junit.Assert.assertNotNull(charArray61);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray61), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray61), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray61), "[ ]");
        org.junit.Assert.assertNotNull(charArray62);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray62), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray62), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray62), "[#]");
        org.junit.Assert.assertNotNull(charArray65);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray65), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray65), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray65), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray70);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray70), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray70), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray70), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray73);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray73), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray73), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray73), "[]");
        org.junit.Assert.assertNotNull(charArray74);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray74), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray74), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray74), "[]");
        org.junit.Assert.assertNotNull(charArray75);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray75), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray75), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray75), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray76);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray76), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray76), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray76), "[]");
    }

//    @Test
//    public void test0421() throws Throwable {
//        if (debug)
//            System.out.format("%n%s%n", "RegressionTest0.test0421");
//        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle0 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
//        org.apache.commons.lang3.text.StrTokenizer strTokenizer4 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
//        java.lang.String[] strArray5 = strTokenizer4.getTokenArray();
//        java.lang.String str6 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle0, strArray5);
//        java.lang.String str10 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray5, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
//        // The following exception was thrown during execution in test generation
//        try {
//            java.lang.constant.ConstantDesc[] constantDescArray12 = org.apache.commons.lang3.ArrayFill.fill((java.lang.constant.ConstantDesc[]) strArray5, (java.lang.constant.ConstantDesc) 0);
//            org.junit.Assert.fail("Expected exception of type java.lang.ArrayStoreException; message: java.lang.Integer");
//        } catch (java.lang.ArrayStoreException e) {
//            // Expected exception.
//        }
//        org.junit.Assert.assertNotNull(strArray5);
//        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
//    }

    @Test
    public void test0422() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0422");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray1 = charSequenceArrayImmutablePair0.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair2 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0);
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair3 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray4 = charSequenceArrayImmutablePair3.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair5 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair3);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayMutablePairRange6 = org.apache.commons.lang3.Range.between(charSequenceArrayMutablePair2, charSequenceArrayMutablePair5);
        java.util.Locale[] localeArray7 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList8 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean9 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList8, localeArray7);
        java.net.URL[] uRLArray11 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection12 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList8, "Integer", (java.lang.Object[]) uRLArray11);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream13 = org.apache.commons.lang3.stream.Streams.failableStream((java.util.Collection<java.util.Locale>) localeList8);
        charSequenceArrayMutablePair5.right = localeList8;
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(charSequenceArray1);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair2);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair3);
        org.junit.Assert.assertNull(charSequenceArray4);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair5);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePairRange6);
        org.junit.Assert.assertNotNull(localeArray7);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(uRLArray11);
        org.junit.Assert.assertNotNull(localeCollection12);
        org.junit.Assert.assertNotNull(localeFailableStream13);
    }

    @Test
    public void test0423() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0423");
        boolean boolean2 = org.apache.commons.lang3.StringUtils.startsWithIgnoreCase((java.lang.CharSequence) "user.dir", (java.lang.CharSequence) "UnicodeUnescaper");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0424() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0424");
        java.lang.Long[] longArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_LONG_OBJECT_ARRAY;
        org.junit.Assert.assertNotNull(longArray0);
    }

    @Test
    public void test0425() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0425");
        java.lang.Boolean[] booleanArray6 = new java.lang.Boolean[] { true, true, false, false };
        boolean[] booleanArray8 = org.apache.commons.lang3.ArrayUtils.toPrimitive(booleanArray6, true);
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray11 = org.apache.commons.lang3.Conversion.intToBinary((int) (short) 10, 100, booleanArray8, (-27), (int) (short) 99);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: nBools-1+srcPos is greater or equal to than 32");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray6);
        org.junit.Assert.assertNotNull(booleanArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray8), "[true, true, false, false]");
    }

    @Test
    public void test0426() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0426");
        org.apache.commons.lang3.text.translate.UnicodeEscaper unicodeEscaper1 = org.apache.commons.lang3.text.translate.UnicodeEscaper.above((int) '\n');
        org.junit.Assert.assertNotNull(unicodeEscaper1);
    }

    @Test
    public void test0427() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0427");
        java.lang.String str0 = org.apache.commons.lang3.time.TimeZones.GMT_ID;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "GMT" + "'", str0, "GMT");
    }

    @Test
    public void test0428() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0428");
        java.lang.Integer[] intArray3 = new java.lang.Integer[] { (-1), 1, 0 };
        int[] intArray5 = org.apache.commons.lang3.ArrayUtils.toPrimitive(intArray3, (int) (short) 100);
        boolean boolean6 = org.apache.commons.lang3.ObjectUtils.isNotEmpty((java.lang.Object) intArray3);
        org.junit.Assert.assertNotNull(intArray3);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray5), "[-1, 1, 0]");
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test0429() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0429");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.getDigits("true");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "" + "'", str1, "");
    }

    @Test
    public void test0430() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0430");
        boolean boolean1 = org.apache.commons.lang3.CharUtils.isAsciiAlpha('#');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0431() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0431");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.escapeXml("user.region");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "user.region" + "'", str1, "user.region");
    }

    @Test
    public void test0432() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0432");
        java.util.Locale locale1 = null;
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.FastDateFormat.getInstance("", locale1);
        java.util.Calendar calendar3 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = fastDateFormat2.format(calendar3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Calendar.getTimeZone()\" because \"calendar\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat2);
    }

    @Test
    public void test0433() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0433");
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = org.apache.commons.lang3.text.StrMatcher.charSetMatcher("AdoptOpenJDK");
        org.junit.Assert.assertNotNull(strMatcher1);
    }

    @Test
    public void test0434() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0434");
        org.apache.commons.lang3.function.FailableFunction<java.lang.Class[], java.lang.Class[], org.apache.commons.lang3.exception.UncheckedException> classArrayFailableFunction0 = org.apache.commons.lang3.function.FailableFunction.identity();
        org.junit.Assert.assertNotNull(classArrayFailableFunction0);
    }

    @Test
    public void test0435() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0435");
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION oPTION0 = org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonOptional;
        org.junit.Assert.assertTrue("'" + oPTION0 + "' != '" + org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonOptional + "'", oPTION0.equals(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonOptional));
    }

    @Test
    public void test0436() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0436");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str2 = org.apache.commons.lang3.StringUtils.abbreviate("line.separator", (int) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Minimum abbreviation width is 4");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0437() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0437");
        java.util.Collection<java.lang.ThreadGroup> threadGroupCollection1 = org.apache.commons.lang3.ThreadUtils.findThreadGroupsByName(" ");
        org.junit.Assert.assertNotNull(threadGroupCollection1);
    }

    @Test
    public void test0438() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0438");
        java.lang.Throwable throwable0 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException1 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable0);
        java.lang.Throwable[] throwableArray2 = uncheckedExecutionException1.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException4 = new org.apache.commons.lang3.NotImplementedException((java.lang.Throwable) uncheckedExecutionException1, "os.version");
        boolean boolean5 = org.apache.commons.lang3.exception.ExceptionUtils.isChecked((java.lang.Throwable) notImplementedException4);
        java.lang.Throwable throwable8 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException9 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable8);
        java.lang.Throwable[] throwableArray10 = uncheckedExecutionException9.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException12 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException9, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException13 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException9);
        java.lang.Throwable throwable15 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException16 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable15);
        java.lang.Throwable[] throwableArray17 = uncheckedExecutionException16.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException19 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException16, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException20 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException19);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException21 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException19);
        java.lang.Throwable throwable23 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException24 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable23);
        java.lang.Throwable[] throwableArray25 = uncheckedExecutionException24.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException27 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException24, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException28 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException27);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException29 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException27);
        java.lang.Throwable[] throwableArray30 = org.apache.commons.lang3.exception.ExceptionUtils.getThrowables((java.lang.Throwable) notImplementedException27);
        java.lang.Throwable throwable31 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException32 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable31);
        java.lang.Throwable[] throwableArray33 = uncheckedExecutionException32.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException35 = new org.apache.commons.lang3.NotImplementedException((java.lang.Throwable) uncheckedExecutionException32, "os.version");
        boolean boolean36 = org.apache.commons.lang3.exception.ExceptionUtils.isChecked((java.lang.Throwable) notImplementedException35);
        java.lang.Throwable throwable38 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException39 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable38);
        java.lang.Throwable[] throwableArray40 = uncheckedExecutionException39.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException42 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException39, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException43 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException42);
        java.lang.UnsupportedOperationException[] unsupportedOperationExceptionArray44 = new java.lang.UnsupportedOperationException[] { notImplementedException4, notImplementedException13, notImplementedException19, notImplementedException27, notImplementedException35, notImplementedException42 };
        java.lang.UnsupportedOperationException[] unsupportedOperationExceptionArray46 = org.apache.commons.lang3.ArrayUtils.removeElement(unsupportedOperationExceptionArray44, (java.lang.Object) "11.5");
        org.junit.Assert.assertNotNull(throwableArray2);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(throwableArray10);
        org.junit.Assert.assertNotNull(throwableArray17);
        org.junit.Assert.assertNotNull(throwableArray25);
        org.junit.Assert.assertNotNull(throwableArray30);
        org.junit.Assert.assertNotNull(throwableArray33);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(throwableArray40);
        org.junit.Assert.assertNotNull(unsupportedOperationExceptionArray44);
        org.junit.Assert.assertNotNull(unsupportedOperationExceptionArray46);
    }

    @Test
    public void test0439() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0439");
        java.util.Locale locale0 = null;
        boolean boolean1 = org.apache.commons.lang3.LocaleUtils.isLanguageUndetermined(locale0);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test0440() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0440");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_JAVA_11;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0441() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0441");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Boolean boolean4 = org.apache.commons.lang3.BooleanUtils.toBooleanObject(" ", ";ClT9Ss'St<Q", "6f51daee", "a16.0.1+9a");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The String did not match any specified value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0442() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0442");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_SPECIFICATION_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.specification.name" + "'", str0, "java.specification.name");
    }

    @Test
    public void test0443() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0443");
        java.lang.String str4 = org.apache.commons.lang3.text.WordUtils.wrap("Long", (int) (short) -1, "yes", false);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Long" + "'", str4, "Long");
    }

    @Test
    public void test0444() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0444");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = org.apache.commons.lang3.BooleanUtils.toBoolean("java.specification.version", "GMT", "StrTokenizer[not tokenized yet]");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The String did not match either specified value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0445() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0445");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_9;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_9));
    }

    @Test
    public void test0446() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0446");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.USER_DIR;
// flaky:         org.junit.Assert.assertEquals("'" + str0 + "' != '" + "/Users/glacierali/randoop-4.3.2" + "'", str0, "/Users/glacierali/randoop-4.3.2");
    }

    @Test
    public void test0447() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0447");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setNullText("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        standardToStringStyle0.setFieldSeparatorAtStart(true);
        standardToStringStyle0.setUseShortClassName(false);
        java.lang.StringBuffer stringBuffer7 = null;
        // The following exception was thrown during execution in test generation
        try {
            standardToStringStyle0.append(stringBuffer7, "Long", 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0448() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0448");
        java.lang.reflect.Type type0 = null;
        java.lang.reflect.Type type1 = null;
        boolean boolean2 = org.apache.commons.lang3.reflect.TypeUtils.equals(type0, type1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test0449() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0449");
        char char1 = org.apache.commons.lang3.CharUtils.toChar((java.lang.Character) '#');
        org.junit.Assert.assertTrue("'" + char1 + "' != '" + '#' + "'", char1 == '#');
    }

    @Test
    public void test0450() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0450");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        java.lang.Object obj4 = null;
        standardToStringStyle0.appendStart(stringBuffer3, obj4);
        java.lang.String str6 = standardToStringStyle0.getNullText();
        java.lang.StringBuffer stringBuffer7 = null;
        // The following exception was thrown during execution in test generation
        try {
            standardToStringStyle0.append(stringBuffer7, "6f51daee", (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "<null>" + "'", str6, "<null>");
    }

    @Test
    public void test0451() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0451");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle0 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer4 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray5 = strTokenizer4.getTokenArray();
        java.lang.String str6 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle0, strArray5);
        java.lang.StringBuffer stringBuffer7 = null;
        org.apache.commons.lang3.function.FailableIntUnaryOperator failableIntUnaryOperator9 = org.apache.commons.lang3.function.FailableIntUnaryOperator.NOP;
        // The following exception was thrown during execution in test generation
        try {
            multilineRecursiveToStringStyle0.appendDetail(stringBuffer7, "java.vm.specification.name", (java.lang.Object) failableIntUnaryOperator9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertNotNull(failableIntUnaryOperator9);
    }

    @Test
    public void test0452() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0452");
        org.apache.commons.lang3.tuple.ImmutablePair<?, ?>[] wildcardImmutablePairArray0 = org.apache.commons.lang3.tuple.ImmutablePair.EMPTY_ARRAY;
        org.junit.Assert.assertNotNull(wildcardImmutablePairArray0);
    }

    @Test
    public void test0453() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0453");
        java.util.Date date0 = null;
        java.util.Locale locale2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = org.apache.commons.lang3.time.DateFormatUtils.format(date0, "6f51daee", locale2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: f");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0454() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0454");
        int int2 = org.apache.commons.lang3.StringUtils.compare("on", "true");
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-5) + "'", int2 == (-5));
    }

    @Test
    public void test0455() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0455");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat0 = new org.apache.commons.lang3.mutable.MutableFloat();
        mutableFloat0.setValue((float) 100);
        float float3 = mutableFloat0.incrementAndGet();
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + 101.0f + "'", float3 == 101.0f);
    }

    @Test
    public void test0456() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0456");
        org.apache.commons.lang3.BitField bitField1 = new org.apache.commons.lang3.BitField((int) (byte) 10);
        boolean boolean2 = org.apache.commons.lang3.ObjectUtils.isArray((java.lang.Object) bitField1);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test0457() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0457");
        double[] doubleArray0 = null;
        double[] doubleArray5 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray9 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray9, (double) '4');
        boolean boolean12 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray5, doubleArray9);
        int int16 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray5, (-1.0d), (int) '\n', (double) 100);
        double[] doubleArray17 = org.apache.commons.lang3.ArrayUtils.removeElements(doubleArray0, doubleArray5);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray9), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
        org.junit.Assert.assertNull(doubleArray17);
    }

    @Test
    public void test0458() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0458");
        java.lang.String[] strArray0 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray2 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray0, (java.lang.CharSequence) "Integer");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.firstNonBlank(strArray0);
        java.lang.String str4 = org.apache.commons.lang3.StringUtils.firstNonEmpty(strArray0);
        org.junit.Assert.assertNotNull(strArray0);
        org.junit.Assert.assertNotNull(charSequenceArray2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "Integer" + "'", str3, "Integer");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "Integer" + "'", str4, "Integer");
    }

    @Test
    public void test0459() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0459");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        char[] charArray13 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray16 = org.apache.commons.lang3.ArrayUtils.subarray(charArray13, (int) (short) 1, (-1));
        char[] charArray17 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray4, charArray13);
        char[] charArray19 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(charArray4, 'o');
        java.lang.String str23 = org.apache.commons.lang3.StringUtils.join(charArray4, '$', (int) (short) 0, (-5));
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
        org.junit.Assert.assertEquals("'" + str23 + "' != '" + "" + "'", str23, "");
    }

    @Test
    public void test0460() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0460");
        org.apache.commons.lang3.function.FailableBiPredicate<org.apache.commons.lang3.function.FailableDoubleUnaryOperator, java.lang.Byte[], java.lang.RuntimeException> failableDoubleUnaryOperatorFailableBiPredicate0 = org.apache.commons.lang3.function.FailableBiPredicate.truePredicate();
        org.junit.Assert.assertNotNull(failableDoubleUnaryOperatorFailableBiPredicate0);
    }

    @Test
    public void test0461() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0461");
        int int3 = org.apache.commons.lang3.StringUtils.getLevenshteinDistance((java.lang.CharSequence) "java.library.path", (java.lang.CharSequence) "Long", (int) '4');
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 17 + "'", int3 == 17);
    }

    @Test
    public void test0462() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0462");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_TIME_FORMAT;
        java.text.ParsePosition parsePosition2 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj3 = fastDateFormat0.parseObject("java.vm.specification.name", parsePosition2);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.text.ParsePosition.getIndex()\" because \"pos\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
    }

    @Test
    public void test0463() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0463");
        org.apache.commons.lang3.arch.Processor processor1 = org.apache.commons.lang3.ArchUtils.getProcessor("java.library.path");
        org.junit.Assert.assertNull(processor1);
    }

    @Test
    public void test0464() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0464");
        java.lang.String str0 = org.apache.commons.lang3.StringUtils.SPACE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + " " + "'", str0, " ");
    }

    @Test
    public void test0465() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0465");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        short short2 = mutableShort1.incrementAndGet();
        org.apache.commons.lang3.mutable.MutableLong mutableLong4 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        mutableLong4.add((long) 0);
        mutableShort1.setValue((java.lang.Number) 0);
        byte byte8 = mutableShort1.byteValue();
        org.junit.Assert.assertTrue("'" + short2 + "' != '" + (short) 101 + "'", short2 == (short) 101);
        org.junit.Assert.assertTrue("'" + byte8 + "' != '" + (byte) 0 + "'", byte8 == (byte) 0);
    }

    @Test
    public void test0466() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0466");
        int int3 = org.apache.commons.lang3.StringUtils.lastOrdinalIndexOf((java.lang.CharSequence) "Lopeng", (java.lang.CharSequence) ";ClT9Ss'St<Q", (int) (short) 0);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test0467() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0467");
        boolean boolean1 = org.apache.commons.lang3.math.NumberUtils.isDigits("glacierali");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0468() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0468");
        java.io.InputStream inputStream0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.text.translate.NumericEntityEscaper numericEntityEscaper1 = org.apache.commons.lang3.SerializationUtils.deserialize(inputStream0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: inputStream");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0469() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0469");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        java.lang.Object obj4 = null;
        standardToStringStyle0.appendStart(stringBuffer3, obj4);
        java.lang.String str6 = standardToStringStyle0.getNullText();
        java.lang.String str7 = standardToStringStyle0.getArraySeparator();
        boolean boolean8 = standardToStringStyle0.isUseIdentityHashCode();
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "<null>" + "'", str6, "<null>");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "," + "'", str7, ",");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test0470() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0470");
        byte byte1 = org.apache.commons.lang3.math.NumberUtils.toByte("java.specification.version");
        org.junit.Assert.assertTrue("'" + byte1 + "' != '" + (byte) 0 + "'", byte1 == (byte) 0);
    }

    @Test
    public void test0471() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0471");
        double double2 = org.apache.commons.lang3.math.IEEE754rUtils.max((double) (-1L), (double) 3);
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 3.0d + "'", double2 == 3.0d);
    }

    @Test
    public void test0472() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0472");
        org.apache.commons.lang3.ClassLoaderUtils classLoaderUtils0 = new org.apache.commons.lang3.ClassLoaderUtils();
    }

    @Test
    public void test0473() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0473");
        boolean[] booleanArray7 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray9 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray7, false);
        java.util.BitSet bitSet11 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray7, true);
        boolean[] booleanArray13 = org.apache.commons.lang3.ArrayUtils.add(booleanArray7, true);
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray16 = org.apache.commons.lang3.Conversion.shortToBinary((short) 0, 0, booleanArray7, 0, 97);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: nBools-1+srcPos is greater or equal to than 16");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray9), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet11);
        org.junit.Assert.assertEquals(bitSet11.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(booleanArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray13), "[false, true, false, true, false, true]");
    }

    @Test
    public void test0474() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0474");
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate0 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        boolean boolean2 = throwableFailableLongPredicate0.test((long) (byte) 100);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate3 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate4 = throwableFailableLongPredicate0.or(throwableFailableLongPredicate3);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate5 = throwableFailableLongPredicate3.negate();
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate3);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate4);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate5);
    }

    @Test
    public void test0475() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0475");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        boolean[] booleanArray17 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray19 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray17, false);
        java.util.BitSet bitSet21 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray17, true);
        boolean[] booleanArray22 = org.apache.commons.lang3.ArrayUtils.removeElements(booleanArray11, booleanArray17);
        org.apache.commons.lang3.ArrayUtils.swap(booleanArray11, (-5), 97);
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
    public void test0476() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0476");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        java.lang.Object obj4 = null;
        standardToStringStyle0.appendStart(stringBuffer3, obj4);
        java.lang.String str6 = standardToStringStyle0.getNullText();
        standardToStringStyle0.setSizeStartText("F16.0.1+9e/Stockholm]");
        java.lang.String str10 = org.apache.commons.lang3.ClassUtils.getCanonicalName((java.lang.Object) standardToStringStyle0, "line.separator");
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "<null>" + "'", str6, "<null>");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "org.apache.commons.lang3.builder.StandardToStringStyle" + "'", str10, "org.apache.commons.lang3.builder.StandardToStringStyle");
    }

    @Test
    public void test0477() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0477");
        java.lang.Throwable throwable0 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException1 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable0);
        org.apache.commons.lang3.SerializationException serializationException2 = new org.apache.commons.lang3.SerializationException(throwable0);
    }

    @Test
    public void test0478() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0478");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer0 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService1 = multiBackgroundInitializer0.getExternalExecutor();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults multiBackgroundInitializerResults2 = org.apache.commons.lang3.function.Failable.get((org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>) multiBackgroundInitializer0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: start() must be called first!");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNull(executorService1);
    }

    @Test
    public void test0479() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0479");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_SPECIFICATION_VENDOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.specification.vendor" + "'", str0, "java.specification.vendor");
    }

    @Test
    public void test0480() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0480");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_VM_VENDOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.vm.vendor" + "'", str0, "java.vm.vendor");
    }

    @Test
    public void test0481() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0481");
        org.apache.commons.lang3.function.FailableFunction<float[], org.apache.commons.lang3.SystemProperties, org.apache.commons.lang3.concurrent.UncheckedExecutionException> floatArrayFailableFunction0 = org.apache.commons.lang3.function.FailableFunction.nop();
        java.util.function.Supplier<java.lang.String> strSupplier1 = null;
        java.lang.String str2 = org.apache.commons.lang3.ObjectUtils.toString((org.apache.commons.lang3.function.FailableFunction) floatArrayFailableFunction0, strSupplier1);
        org.junit.Assert.assertNotNull(floatArrayFailableFunction0);
    }

    @Test
    public void test0482() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0482");
        java.util.stream.IntStream intStream1 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) (short) -1);
        org.junit.Assert.assertNotNull(intStream1);
    }

    @Test
    public void test0483() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0483");
        org.apache.commons.lang3.function.FailableObjLongConsumer<org.apache.commons.lang3.mutable.Mutable<java.lang.Boolean>, org.apache.commons.lang3.exception.UncheckedException> booleanMutableFailableObjLongConsumer0 = org.apache.commons.lang3.function.FailableObjLongConsumer.nop();
        org.junit.Assert.assertNotNull(booleanMutableFailableObjLongConsumer0);
    }

    @Test
    public void test0484() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0484");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.deleteWhitespace("100");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "100" + "'", str1, "100");
    }

    @Test
    public void test0485() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0485");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaVmVendor();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "AdoptOpenJDK" + "'", str0, "AdoptOpenJDK");
    }

    @Test
    public void test0486() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0486");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle2 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer6 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray7 = strTokenizer6.getTokenArray();
        java.lang.String str8 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle2, strArray7);
        java.lang.String str12 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray7, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int13 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray7);
        boolean boolean14 = org.apache.commons.lang3.StringUtils.equalsAnyIgnoreCase((java.lang.CharSequence) "                                                                                                  100", (java.lang.CharSequence[]) strArray7);
        org.junit.Assert.assertNotNull(strArray7);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "" + "'", str12, "");
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + (-1) + "'", int13 == (-1));
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
    }

    @Test
    public void test0487() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0487");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = org.apache.commons.lang3.time.DurationFormatUtils.formatDuration((long) (-27), "long", false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: durationMillis must not be negative");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0488() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0488");
        java.util.Date date0 = null;
        java.util.Date date1 = null;
        // The following exception was thrown during execution in test generation
        try {
            int int3 = org.apache.commons.lang3.time.DateUtils.truncatedCompareTo(date0, date1, (int) '$');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0489() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0489");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.CharSequence charSequence2 = org.apache.commons.lang3.Validate.validIndex((java.lang.CharSequence) "os.version", (int) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: The validated character sequence index is invalid: 10");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
    }

    @Test
    public void test0490() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0490");
        org.apache.commons.lang3.mutable.MutableLong mutableLong1 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        mutableLong1.add((long) 0);
        long long5 = mutableLong1.getAndAdd((long) (short) 101);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date7 = org.apache.commons.lang3.time.DateUtils.truncate((java.lang.Object) long5, (int) (byte) -11);
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: Could not truncate 1");
        } catch (java.lang.ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 1L + "'", long5 == 1L);
    }

    @Test
    public void test0491() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0491");
        org.apache.commons.lang3.function.FailableDoubleUnaryOperator<java.lang.Exception> exceptionFailableDoubleUnaryOperator0 = org.apache.commons.lang3.function.FailableDoubleUnaryOperator.nop();
        org.junit.Assert.assertNotNull(exceptionFailableDoubleUnaryOperator0);
    }

    @Test
    public void test0492() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0492");
        java.lang.String str1 = org.apache.commons.lang3.CharUtils.unicodeEscaped((java.lang.Character) 'a');
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "\\u0061" + "'", str1, "\\u0061");
    }

    @Test
    public void test0493() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0493");
        long[] longArray5 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray5, (long) '\n', 100);
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.contains(longArray5, (long) (byte) 100);
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSorted(longArray5);
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray5), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test0494() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0494");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_CLASS_VERSION;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "60.0" + "'", str0, "60.0");
    }

    @Test
    public void test0495() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0495");
        org.apache.commons.lang3.BitField bitField1 = new org.apache.commons.lang3.BitField((int) (byte) 10);
        byte byte3 = bitField1.clearByte((byte) -1);
        int int5 = bitField1.clear((int) (short) 0);
        org.junit.Assert.assertTrue("'" + byte3 + "' != '" + (byte) -11 + "'", byte3 == (byte) -11);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 0 + "'", int5 == 0);
    }

    @Test
    public void test0496() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0496");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_2003;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test0497() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0497");
        boolean boolean1 = org.apache.commons.lang3.BooleanUtils.isNotFalse((java.lang.Boolean) false);
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test0498() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0498");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaIoTmpdir();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "/var/folders/hh/thrdkjsj7yn83kx4xl6753y40000gn/T/" + "'", str0, "/var/folders/hh/thrdkjsj7yn83kx4xl6753y40000gn/T/");
    }

    @Test
    public void test0499() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0499");
        org.apache.commons.lang3.function.FailableDoubleConsumer failableDoubleConsumer0 = org.apache.commons.lang3.function.FailableDoubleConsumer.NOP;
        org.junit.Assert.assertNotNull(failableDoubleConsumer0);
    }

    @Test
    public void test0500() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test0500");
        int int0 = org.apache.commons.lang3.time.FastDateFormat.FULL;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 0 + "'", int0 == 0);
    }
}
