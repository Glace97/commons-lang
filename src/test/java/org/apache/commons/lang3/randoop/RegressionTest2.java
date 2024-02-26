import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest2 {

    public static boolean debug = false;

    @Test
    public void test1001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1001");
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION oPTION0 = org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonOptional;
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION oPTION1 = org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonOptional;
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION oPTION2 = org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired;
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION oPTION3 = org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired;
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION[] oPTIONArray4 = new org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION[] { oPTION0, oPTION1, oPTION2, oPTION3 };
        org.apache.commons.lang3.text.translate.NumericEntityUnescaper numericEntityUnescaper5 = new org.apache.commons.lang3.text.translate.NumericEntityUnescaper(oPTIONArray4);
        java.lang.String str6 = org.apache.commons.lang3.text.StrSubstitutor.replaceSystemProperties((java.lang.Object) oPTIONArray4);
        org.junit.Assert.assertTrue("'" + oPTION0 + "' != '" + org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonOptional + "'", oPTION0.equals(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonOptional));
        org.junit.Assert.assertTrue("'" + oPTION1 + "' != '" + org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonOptional + "'", oPTION1.equals(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonOptional));
        org.junit.Assert.assertTrue("'" + oPTION2 + "' != '" + org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired + "'", oPTION2.equals(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired));
        org.junit.Assert.assertTrue("'" + oPTION3 + "' != '" + org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired + "'", oPTION3.equals(org.apache.commons.lang3.text.translate.NumericEntityUnescaper.OPTION.semiColonRequired));
        org.junit.Assert.assertNotNull(oPTIONArray4);
    }

    @Test
    public void test1002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1002");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle0 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer4 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray5 = strTokenizer4.getTokenArray();
        java.lang.String str6 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle0, strArray5);
        java.lang.String[] strArray8 = org.apache.commons.lang3.StringUtils.stripAll(strArray5, "UnicodeUnescaper");
        java.lang.String[] strArray9 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(strArray5);
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertNotNull(strArray9);
    }

    @Test
    public void test1003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1003");
        java.util.concurrent.ExecutionException executionException0 = null;
        org.apache.commons.lang3.concurrent.ConcurrentUtils.handleCause(executionException0);
    }

    @Test
    public void test1004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1004");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray1 = charSequenceArrayImmutablePair0.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair2 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0);
        java.lang.String[] strArray3 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.util.Locale[] localeArray4 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList5 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean6 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList5, localeArray4);
        java.net.URL[] uRLArray8 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection9 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList5, "Integer", (java.lang.Object[]) uRLArray8);
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair10 = new org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>((java.lang.CharSequence[]) strArray3, (java.util.AbstractCollection<java.util.Locale>) localeList5);
        java.util.AbstractCollection<java.util.Locale> localeCollection11 = charSequenceArrayMutablePair2.setValue((java.util.AbstractCollection<java.util.Locale>) localeList5);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(charSequenceArray1);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair2);
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertNotNull(localeArray4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(uRLArray8);
        org.junit.Assert.assertNotNull(localeCollection9);
        org.junit.Assert.assertNull(localeCollection11);
    }

    @Test
    public void test1005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1005");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer0 = org.apache.commons.lang3.text.StrTokenizer.getCSVInstance();
        java.lang.String[] strArray1 = strTokenizer0.getTokenArray();
        org.junit.Assert.assertNotNull(strTokenizer0);
        org.junit.Assert.assertNotNull(strArray1);
    }

    @Test
    public void test1006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1006");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer0 = new org.apache.commons.lang3.text.StrTokenizer();
        java.lang.String str1 = strTokenizer0.toString();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = strTokenizer0.setEmptyTokenAsNull(false);
        java.lang.String[] strArray4 = strTokenizer3.getTokenArray();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = strTokenizer3.next();
            org.junit.Assert.fail("Expected exception of type java.util.NoSuchElementException; message: null");
        } catch (java.util.NoSuchElementException e) {
            // Expected exception.
        }
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "StrTokenizer[not tokenized yet]" + "'", str1, "StrTokenizer[not tokenized yet]");
        org.junit.Assert.assertNotNull(strTokenizer3);
        org.junit.Assert.assertNotNull(strArray4);
    }

    @Test
    public void test1007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1007");
        java.lang.String str3 = org.apache.commons.lang3.BooleanUtils.toString(true, "<null>", ".]Wr1`~U#8P1RR^y~QA|^cKs1{%\\1T?5lK0:E`Sb.&C>Ti|7U`_rdX-~ezvoa,]'Y`!G4\"%H.wF)`\",%`~,Oq)sru73.75Tg2");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "<null>" + "'", str3, "<null>");
    }

    @Test
    public void test1008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1008");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.setHours(date0, (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1009");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.time.DateUtils.getFragmentInMilliseconds(calendar0, (int) '\n');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: calendar");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1010");
        org.apache.commons.lang3.function.FailableSupplier failableSupplier0 = org.apache.commons.lang3.function.FailableSupplier.NUL;
        // The following exception was thrown during execution in test generation
        try {
            int int2 = org.apache.commons.lang3.builder.CompareToBuilder.reflectionCompare((java.lang.Object) failableSupplier0, (java.lang.Object) "<null>");
            org.junit.Assert.fail("Expected exception of type java.lang.ClassCastException; message: null");
        } catch (java.lang.ClassCastException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(failableSupplier0);
    }

    @Test
    public void test1011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1011");
        boolean[] booleanArray7 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray9 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray7, false);
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.isNotEmpty(booleanArray7);
        boolean[] booleanArray13 = org.apache.commons.lang3.Conversion.shortToBinary((short) 97, (int) (byte) 10, booleanArray7, (int) (byte) 1, (int) (byte) -1);
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray9), "[true, true]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertNotNull(booleanArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray13), "[false, true, false, true, false]");
    }

    @Test
    public void test1012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1012");
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
        java.lang.reflect.Field field28 = org.apache.commons.lang3.reflect.FieldUtils.getField(multiBackgroundInitializerResultsFailableSupplierClass13, "user.language");
        boolean boolean29 = org.apache.commons.lang3.ClassUtils.isPublic(multiBackgroundInitializerResultsFailableSupplierClass13);
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
        org.junit.Assert.assertNull(field28);
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
    }

    @Test
    public void test1013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1013");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_OS2;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test1014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1014");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_VM_INFO;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.vm.info" + "'", str0, "java.vm.info");
    }

    @Test
    public void test1015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1015");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.mutable.MutableDouble mutableDouble1 = new org.apache.commons.lang3.mutable.MutableDouble("user.name");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"user.name\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1016");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.right("UTF-8", (int) '$');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "UTF-8" + "'", str2, "UTF-8");
    }

    @Test
    public void test1017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1017");
        boolean boolean2 = org.apache.commons.lang3.StringUtils.containsNone((java.lang.CharSequence) "path.separator", "-9");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test1018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1018");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange2 = org.apache.commons.lang3.Range.of(javaVersion0, javaVersion1);
        char[] charArray5 = new char[] { ' ', '#' };
        char[] charArray7 = new char[] { ' ' };
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray5, charArray7);
        boolean boolean9 = javaVersionRange2.equals((java.lang.Object) charArray8);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange10 = null;
        boolean boolean11 = javaVersionRange2.containsRange(javaVersionRange10);
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
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
    }

    @Test
    public void test1019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1019");
        org.apache.commons.lang3.reflect.ConstructorUtils constructorUtils0 = new org.apache.commons.lang3.reflect.ConstructorUtils();
    }

    @Test
    public void test1020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1020");
        java.util.function.LongSupplier longSupplier1 = null;
        long long2 = org.apache.commons.lang3.SystemProperties.getLong("java.awt.headless", longSupplier1);
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
    }

    @Test
    public void test1021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1021");
        org.apache.commons.lang3.mutable.MutableInt mutableInt1 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        mutableInt1.setValue((int) 'a');
        int int4 = mutableInt1.decrementAndGet();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 96 + "'", int4 == 96);
    }

    @Test
    public void test1022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1022");
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
        java.util.List<java.lang.reflect.Field> fieldList14 = org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList(multiBackgroundInitializerResultsFailableSupplierClass13);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.reflect.FieldUtils.writeStaticField(multiBackgroundInitializerResultsFailableSupplierClass13, "", (java.lang.Object) "                                                                                                open", false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The field name must not be blank/empty");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertNotNull(fieldList14);
    }

    @Test
    public void test1023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1023");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        java.lang.Object obj4 = null;
        standardToStringStyle0.appendStart(stringBuffer3, obj4);
        java.lang.String str6 = standardToStringStyle0.getNullText();
        standardToStringStyle0.setSizeStartText("F16.0.1+9e/Stockholm]");
        boolean boolean9 = standardToStringStyle0.isDefaultFullDetail();
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "<null>" + "'", str6, "<null>");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test1024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1024");
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException2, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException6 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException5);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException7 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException5);
        java.lang.Object obj9 = contextedRuntimeException7.getFirstContextValue("glacierali");
        java.lang.String str11 = contextedRuntimeException7.getFormattedExceptionMessage("<");
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(obj9);
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "<" + "'", str11, "<");
    }

    @Test
    public void test1025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1025");
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
        java.util.List<java.lang.reflect.Field> fieldList14 = org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList(multiBackgroundInitializerResultsFailableSupplierClass13);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj16 = org.apache.commons.lang3.reflect.FieldUtils.readDeclaredStaticField(multiBackgroundInitializerResultsFailableSupplierClass13, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot locate declared field org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertNotNull(fieldList14);
    }

    @Test
    public void test1026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1026");
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException7 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException3);
        org.apache.commons.lang3.exception.ContextedException contextedException8 = new org.apache.commons.lang3.exception.ContextedException();
        uncheckedExecutionException3.addSuppressed((java.lang.Throwable) contextedException8);
        org.apache.commons.lang3.exception.UncheckedIllegalAccessException uncheckedIllegalAccessException10 = new org.apache.commons.lang3.exception.UncheckedIllegalAccessException((java.lang.Throwable) uncheckedExecutionException3);
        org.junit.Assert.assertNotNull(throwableArray4);
    }

    @Test
    public void test1027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1027");
        char[] charArray0 = null;
        char[] charArray2 = org.apache.commons.lang3.ArrayUtils.addFirst(charArray0, '6');
        org.junit.Assert.assertNotNull(charArray2);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray2), "6");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray2), "6");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray2), "[6]");
    }

    @Test
    public void test1028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1028");
        java.lang.String str1 = org.apache.commons.lang3.text.WordUtils.swapCase("OpenJDK Runtime Environment");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "oPENjdk rUNTIME eNVIRONMENT" + "'", str1, "oPENjdk rUNTIME eNVIRONMENT");
    }

    @Test
    public void test1029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1029");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.time.Duration duration2 = org.apache.commons.lang3.time.DurationUtils.toDuration((long) (-27), timeUnit1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1030");
        java.lang.reflect.Method method0 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.function.FailableBiFunction<org.apache.commons.lang3.exception.UncheckedReflectiveOperationException, org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle, org.apache.commons.lang3.concurrent.LazyInitializer<org.apache.commons.lang3.builder.ToStringStyle>, java.lang.Throwable> uncheckedReflectiveOperationExceptionFailableBiFunction1 = org.apache.commons.lang3.function.MethodInvokers.asFailableBiFunction(method0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1031");
        long[] longArray1 = new long[] { '4' };
        long[] longArray7 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet10 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray7, (long) '\n', 100);
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray7);
        long[] longArray13 = org.apache.commons.lang3.ArrayUtils.add(longArray7, (long) (short) 101);
        boolean boolean14 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray1, longArray13);
        long[] longArray16 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray13, 60000L);
        long[] longArray18 = org.apache.commons.lang3.ArrayUtils.removeElement(longArray16, (long) '4');
        long long19 = org.apache.commons.lang3.math.NumberUtils.max(longArray18);
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
        org.junit.Assert.assertNotNull(longArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray18), "[60000, 10, 100, 100, 97, 101]");
        org.junit.Assert.assertTrue("'" + long19 + "' != '" + 60000L + "'", long19 == 60000L);
    }

    @Test
    public void test1032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1032");
        java.lang.String[] strArray3 = org.apache.commons.lang3.StringUtils.split("file.separator", "", 8);
        org.junit.Assert.assertNotNull(strArray3);
    }

    @Test
    public void test1033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1033");
        int[] intArray5 = new int[] { (short) 100, (short) 10, (short) 10, '\n', '\n' };
        int[] intArray7 = org.apache.commons.lang3.ArrayUtils.add(intArray5, (int) '4');
        int int9 = org.apache.commons.lang3.ArrayUtils.indexOf(intArray5, 0);
        int[] intArray11 = new int[] { '\n' };
        java.util.BitSet bitSet14 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray11, (int) (byte) -1, (int) (short) -1);
        org.apache.commons.lang3.ArrayUtils.shuffle(intArray11);
        int[] intArray16 = org.apache.commons.lang3.ArraySorter.sort(intArray11);
        int[] intArray17 = org.apache.commons.lang3.ArrayUtils.addAll(intArray5, intArray11);
        java.lang.Throwable throwable19 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException20 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable19);
        java.lang.Throwable[] throwableArray21 = uncheckedExecutionException20.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException23 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException20, "Integer");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer24 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService25 = multiBackgroundInitializer24.getExternalExecutor();
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer27 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService28 = multiBackgroundInitializer27.getExternalExecutor();
        multiBackgroundInitializer24.addInitializer("60.0", (org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>) multiBackgroundInitializer27);
        org.apache.commons.lang3.tuple.MutablePair<org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.concurrent.MultiBackgroundInitializer> notImplementedExceptionMutablePair30 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull(notImplementedException23, multiBackgroundInitializer27);
        java.lang.Class<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierClass31 = org.apache.commons.lang3.ObjectUtils.getClass((org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>) multiBackgroundInitializer27);
        org.apache.commons.lang3.tuple.Pair<int[], java.lang.reflect.GenericDeclaration> intArrayPair32 = org.apache.commons.lang3.tuple.Pair.of(intArray11, (java.lang.reflect.GenericDeclaration) multiBackgroundInitializerResultsFailableSupplierClass31);
        boolean boolean33 = org.apache.commons.lang3.reflect.TypeUtils.containsTypeVariables((java.lang.reflect.Type) multiBackgroundInitializerResultsFailableSupplierClass31);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray5), "[100, 10, 10, 10, 10]");
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray7), "[100, 10, 10, 10, 10, 52]");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray11), "[10]");
        org.junit.Assert.assertNotNull(bitSet14);
        org.junit.Assert.assertEquals(bitSet14.toString(), "{}");
        org.junit.Assert.assertNotNull(intArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray16), "[10]");
        org.junit.Assert.assertNotNull(intArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray17), "[100, 10, 10, 10, 10, 10]");
        org.junit.Assert.assertNotNull(throwableArray21);
        org.junit.Assert.assertNull(executorService25);
        org.junit.Assert.assertNull(executorService28);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair30);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass31);
        org.junit.Assert.assertNotNull(intArrayPair32);
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + false + "'", boolean33 == false);
    }

    @Test
    public void test1034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1034");
        java.lang.String str0 = org.apache.commons.lang3.time.DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'" + "'", str0, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'");
    }

    @Test
    public void test1035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1035");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.util.AbstractCollection<java.util.Locale> localeCollection1 = charSequenceArrayImmutablePair0.getRight();
        java.lang.String[] strArray8 = new java.lang.String[] { "java.lang", "                                                                                                open", "60.0", "16.0.1", ":", "Integer" };
        org.apache.commons.lang3.CharSet charSet9 = org.apache.commons.lang3.CharSet.getInstance(strArray8);
        boolean boolean10 = charSequenceArrayImmutablePair0.equals((java.lang.Object) strArray8);
        java.lang.CharSequence[] charSequenceArray11 = charSequenceArrayImmutablePair0.left;
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(localeCollection1);
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertNotNull(charSet9);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNull(charSequenceArray11);
    }

    @Test
    public void test1036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1036");
        short[] shortArray0 = new short[] {};
        boolean boolean2 = org.apache.commons.lang3.ArrayUtils.contains(shortArray0, (short) (byte) -11);
        org.junit.Assert.assertNotNull(shortArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray0), "[]");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
    }

    @Test
    public void test1037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1037");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate2 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion0, javaVersion1);
        org.apache.commons.lang3.JavaVersion javaVersion3 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion4 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange5 = org.apache.commons.lang3.Range.of(javaVersion3, javaVersion4);
        boolean boolean6 = javaVersion1.atLeast(javaVersion3);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj9 = org.apache.commons.lang3.reflect.FieldUtils.readField((java.lang.Object) javaVersion3, "https://adoptopenjdk.net/", false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot locate field https://adoptopenjdk.net/ on class org.apache.commons.lang3.JavaVersion");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate2);
        org.junit.Assert.assertTrue("'" + javaVersion3 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion3.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion4 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion4.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange5);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test1038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1038");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        // The following exception was thrown during execution in test generation
        try {
            strTokenizer3.add("pen");
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: add() is unsupported");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1039");
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder0 = new org.apache.commons.lang3.builder.EqualsBuilder();
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder3 = equalsBuilder0.append(false, false);
        java.lang.Object obj4 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer5 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService6 = multiBackgroundInitializer5.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle9 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer13 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray14 = strTokenizer13.getTokenArray();
        java.lang.String str15 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle9, strArray14);
        java.lang.String str19 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray14, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int20 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray14);
        boolean boolean21 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray14);
        boolean boolean22 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj4, (java.lang.Object) executorService6, strArray14);
        java.lang.Object[] objArray23 = org.apache.commons.lang3.ArrayUtils.nullToEmpty((java.lang.Object[]) strArray14);
        java.lang.Object obj24 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer25 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService26 = multiBackgroundInitializer25.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle29 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer33 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray34 = strTokenizer33.getTokenArray();
        java.lang.String str35 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle29, strArray34);
        java.lang.String str39 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray34, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int40 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray34);
        boolean boolean41 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray34);
        boolean boolean42 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj24, (java.lang.Object) executorService26, strArray34);
        java.lang.Object[] objArray43 = org.apache.commons.lang3.ArrayUtils.nullToEmpty((java.lang.Object[]) strArray34);
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder44 = equalsBuilder0.append((java.lang.Object[]) strArray14, objArray43);
        java.lang.Long[] longArray51 = new java.lang.Long[] { 10L, 0L, (-1L), (-1L), 10L, 1L };
        java.lang.Long[] longArray52 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray51);
        java.net.URL[] uRLArray53 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        boolean boolean54 = org.apache.commons.lang3.ArrayUtils.isSameLength((java.lang.Object[]) longArray51, (java.lang.Object[]) uRLArray53);
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper55 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper56 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper57 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper58 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper59 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper60 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper61 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray62 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper56, unicodeUnescaper57, unicodeUnescaper58, unicodeUnescaper59, unicodeUnescaper60, unicodeUnescaper61 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator63 = unicodeUnescaper55.with(charSequenceTranslatorArray62);
        java.lang.String str65 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) charSequenceTranslatorArray62, ' ');
        java.util.BitSet bitSet67 = org.apache.commons.lang3.ArrayUtils.indexesOf((java.lang.Object[]) charSequenceTranslatorArray62, (java.lang.Object) "pen");
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder68 = equalsBuilder44.append((java.lang.Object[]) uRLArray53, (java.lang.Object[]) charSequenceTranslatorArray62);
        org.junit.Assert.assertNotNull(equalsBuilder3);
        org.junit.Assert.assertNull(executorService6);
        org.junit.Assert.assertNotNull(strArray14);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "" + "'", str19, "");
        org.junit.Assert.assertTrue("'" + int20 + "' != '" + (-1) + "'", int20 == (-1));
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        org.junit.Assert.assertNotNull(objArray23);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray23), "[581cd446]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray23), "[581cd446]");
        org.junit.Assert.assertNull(executorService26);
        org.junit.Assert.assertNotNull(strArray34);
        org.junit.Assert.assertEquals("'" + str39 + "' != '" + "" + "'", str39, "");
        org.junit.Assert.assertTrue("'" + int40 + "' != '" + (-1) + "'", int40 == (-1));
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
        org.junit.Assert.assertTrue("'" + boolean42 + "' != '" + true + "'", boolean42 == true);
        org.junit.Assert.assertNotNull(objArray43);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray43), "[581cd446]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray43), "[581cd446]");
        org.junit.Assert.assertNotNull(equalsBuilder44);
        org.junit.Assert.assertNotNull(longArray51);
        org.junit.Assert.assertNotNull(longArray52);
        org.junit.Assert.assertNotNull(uRLArray53);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + false + "'", boolean54 == false);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray62);
        org.junit.Assert.assertNotNull(charSequenceTranslator63);
        org.junit.Assert.assertNotNull(bitSet67);
        org.junit.Assert.assertEquals(bitSet67.toString(), "{}");
        org.junit.Assert.assertNotNull(equalsBuilder68);
    }

    @Test
    public void test1040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1040");
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle0 = org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
        java.lang.StringBuffer stringBuffer1 = null;
        // The following exception was thrown during execution in test generation
        try {
            toStringStyle0.append(stringBuffer1, "java.awt.headless", (long) 'o');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(toStringStyle0);
    }

    @Test
    public void test1041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1041");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.removeFirst("}", "AdoptOpenJDK");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "}" + "'", str2, "}");
    }

    @Test
    public void test1042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1042");
        java.math.BigDecimal bigDecimal0 = null;
        java.math.BigDecimal bigDecimal1 = org.apache.commons.lang3.math.NumberUtils.toScaledBigDecimal(bigDecimal0);
        org.junit.Assert.assertNotNull(bigDecimal1);
    }

    @Test
    public void test1043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1043");
        java.lang.String[] strArray3 = org.apache.commons.lang3.StringUtils.splitByWholeSeparatorPreserveAllTokens("0\n0", "                                                                                                open");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle4 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer8 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray9 = strTokenizer8.getTokenArray();
        java.lang.String str10 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle4, strArray9);
        java.lang.String[] strArray12 = org.apache.commons.lang3.StringUtils.stripAll(strArray9, "UnicodeUnescaper");
        java.lang.String str13 = org.apache.commons.lang3.StringUtils.replaceEach("6f51daee", strArray3, strArray12);
        org.apache.commons.lang3.exception.ExceptionUtils exceptionUtils14 = new org.apache.commons.lang3.exception.ExceptionUtils();
        int int16 = org.apache.commons.lang3.ArrayUtils.indexOf((java.lang.Object[]) strArray3, (java.lang.Object) exceptionUtils14, 0);
        java.util.Locale[] localeArray17 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList18 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList18, localeArray17);
        java.net.URL[] uRLArray21 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection22 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList18, "Integer", (java.lang.Object[]) uRLArray21);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream23 = org.apache.commons.lang3.stream.Streams.failableStream((java.util.Collection<java.util.Locale>) localeList18);
        java.util.Locale[] localeArray24 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList25 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean26 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList25, localeArray24);
        java.net.URL[] uRLArray28 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection29 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList25, "Integer", (java.lang.Object[]) uRLArray28);
        java.util.Locale[] localeArray30 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList31 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean32 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList31, localeArray30);
        java.net.URL[] uRLArray34 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection35 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList31, "Integer", (java.lang.Object[]) uRLArray34);
        java.util.Locale[] localeArray36 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList37 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean38 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList37, localeArray36);
        java.net.URL[] uRLArray40 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection41 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList37, "Integer", (java.lang.Object[]) uRLArray40);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream42 = org.apache.commons.lang3.stream.Streams.failableStream((java.util.Collection<java.util.Locale>) localeList37);
        java.util.RandomAccess[] randomAccessArray43 = new java.util.RandomAccess[] { localeList18, localeList25, localeList31, localeList37 };
        java.util.Locale[] localeArray44 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList45 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean46 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList45, localeArray44);
        java.net.URL[] uRLArray48 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection49 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList45, "Integer", (java.lang.Object[]) uRLArray48);
        java.util.RandomAccess[] randomAccessArray50 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(randomAccessArray43, (java.util.RandomAccess) localeList45);
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair51 = new org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>((java.lang.CharSequence[]) strArray3, (java.util.AbstractCollection<java.util.Locale>) localeList45);
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertNotNull(strArray12);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "6f51daee" + "'", str13, "6f51daee");
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
        org.junit.Assert.assertNotNull(localeArray17);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(uRLArray21);
        org.junit.Assert.assertNotNull(localeCollection22);
        org.junit.Assert.assertNotNull(localeFailableStream23);
        org.junit.Assert.assertNotNull(localeArray24);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertNotNull(uRLArray28);
        org.junit.Assert.assertNotNull(localeCollection29);
        org.junit.Assert.assertNotNull(localeArray30);
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + false + "'", boolean32 == false);
        org.junit.Assert.assertNotNull(uRLArray34);
        org.junit.Assert.assertNotNull(localeCollection35);
        org.junit.Assert.assertNotNull(localeArray36);
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + false + "'", boolean38 == false);
        org.junit.Assert.assertNotNull(uRLArray40);
        org.junit.Assert.assertNotNull(localeCollection41);
        org.junit.Assert.assertNotNull(localeFailableStream42);
        org.junit.Assert.assertNotNull(randomAccessArray43);
        org.junit.Assert.assertNotNull(localeArray44);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertNotNull(uRLArray48);
        org.junit.Assert.assertNotNull(localeCollection49);
        org.junit.Assert.assertNotNull(randomAccessArray50);
    }

    @Test
    public void test1044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1044");
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator0 = org.apache.commons.lang3.StringEscapeUtils.UNESCAPE_CSV;
        org.junit.Assert.assertNotNull(charSequenceTranslator0);
    }

    @Test
    public void test1045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1045");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray1 = charSequenceArrayImmutablePair0.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair2 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0);
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair3 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair4 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray5 = charSequenceArrayImmutablePair4.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair6 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair4);
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle7 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle8 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str9 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle7, toStringStyle8);
        java.lang.StringBuffer stringBuffer10 = null;
        java.lang.Object obj11 = null;
        standardToStringStyle7.appendStart(stringBuffer10, obj11);
        java.lang.String str13 = standardToStringStyle7.getNullText();
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayImmutablePairReflectionDiffBuilder14 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>>(charSequenceArrayImmutablePair3, charSequenceArrayImmutablePair4, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle7);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayPairRange15 = org.apache.commons.lang3.Range.between((org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0, (org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair4);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayPairRange16 = org.apache.commons.lang3.Range.is((org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(charSequenceArray1);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair2);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair3);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair4);
        org.junit.Assert.assertNull(charSequenceArray5);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair6);
        org.junit.Assert.assertNotNull(toStringStyle8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str9, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "<null>" + "'", str13, "<null>");
        org.junit.Assert.assertNotNull(charSequenceArrayPairRange15);
        org.junit.Assert.assertNotNull(charSequenceArrayPairRange16);
    }

    @Test
    public void test1046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1046");
        float[] floatArray3 = new float[] { 100.0f, 0.0f, 100L };
        org.apache.commons.lang3.ArrayUtils.shift(floatArray3, (int) (short) 100);
        float[] floatArray6 = org.apache.commons.lang3.ArraySorter.sort(floatArray3);
        org.apache.commons.lang3.ArrayUtils.reverse(floatArray3, (int) '4', (int) (short) 10);
        float[] floatArray13 = new float[] { 100.0f, 0.0f, 100L };
        org.apache.commons.lang3.ArrayUtils.shift(floatArray13, (int) (short) 100);
        float[] floatArray16 = org.apache.commons.lang3.ArrayUtils.addAll(floatArray3, floatArray13);
        float[] floatArray17 = org.apache.commons.lang3.ArraySorter.sort(floatArray16);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[0.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray6), "[0.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray13), "[100.0, 100.0, 0.0]");
        org.junit.Assert.assertNotNull(floatArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray16), "[0.0, 0.0, 100.0, 100.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray17), "[0.0, 0.0, 100.0, 100.0, 100.0, 100.0]");
    }

    @Test
    public void test1047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1047");
        boolean[] booleanArray6 = new boolean[] { false, true, true, false, true, false };
        char char7 = org.apache.commons.lang3.Conversion.binaryToHexDigit(booleanArray6);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray6, true);
        org.junit.Assert.assertNotNull(booleanArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray6), "[false, true, true, false, true, false]");
        org.junit.Assert.assertTrue("'" + char7 + "' != '" + '6' + "'", char7 == '6');
        org.junit.Assert.assertNotNull(bitSet9);
        org.junit.Assert.assertEquals(bitSet9.toString(), "{1, 2, 4}");
    }

    @Test
    public void test1048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1048");
        java.util.function.Function<java.lang.Object, java.lang.String> objFunction3 = null;
        java.util.stream.Collector<java.lang.Object, ?, java.lang.String> objCollector4 = org.apache.commons.lang3.stream.LangCollectors.joining((java.lang.CharSequence) "<null>", (java.lang.CharSequence) "x86_64", (java.lang.CharSequence) "java.vm.specification.name", objFunction3);
        org.junit.Assert.assertNotNull(objCollector4);
    }

    @Test
    public void test1049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1049");
        short[] shortArray4 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray4, (int) (byte) -1, 1, (int) (byte) 10);
        org.apache.commons.lang3.ArrayUtils.shuffle(shortArray4);
        short[] shortArray12 = org.apache.commons.lang3.ArrayUtils.subarray(shortArray4, 2, 3);
        org.apache.commons.lang3.ArrayUtils.shift(shortArray12, (-1));
        // The following exception was thrown during execution in test generation
        try {
            short[] shortArray17 = org.apache.commons.lang3.Conversion.intToShortArray(100, (int) 'M', shortArray12, (int) '\000', (int) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nShorts-1)*16+srcPos is greater or equal to than 32");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(shortArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray4), "[100, 100]");
        org.junit.Assert.assertNotNull(shortArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray12), "[]");
    }

    @Test
    public void test1050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1050");
        int int2 = org.apache.commons.lang3.CharUtils.compare('\n', 'a');
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-87) + "'", int2 == (-87));
    }

    @Test
    public void test1051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1051");
        org.apache.commons.lang3.text.translate.UnicodeEscaper unicodeEscaper1 = org.apache.commons.lang3.text.translate.UnicodeEscaper.below(6);
        org.junit.Assert.assertNotNull(unicodeEscaper1);
    }

    @Test
    public void test1052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1052");
        boolean boolean0 = org.apache.commons.lang3.RandomUtils.nextBoolean();
// flaky:         org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test1053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1053");
        java.math.RoundingMode roundingMode2 = null;
        java.math.BigDecimal bigDecimal3 = org.apache.commons.lang3.math.NumberUtils.toScaledBigDecimal((java.lang.Float) 10.0f, (int) (short) 101, roundingMode2);
        org.junit.Assert.assertNotNull(bigDecimal3);
    }

    @Test
    public void test1054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1054");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.util.AbstractCollection<java.util.Locale> localeCollection1 = charSequenceArrayImmutablePair0.getRight();
        org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayPair2 = org.apache.commons.lang3.tuple.Pair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(localeCollection1);
        org.junit.Assert.assertNotNull(charSequenceArrayPair2);
    }

    @Test
    public void test1055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1055");
        org.apache.commons.lang3.function.FailableIntConsumer failableIntConsumer0 = org.apache.commons.lang3.function.FailableIntConsumer.NOP;
        org.junit.Assert.assertNotNull(failableIntConsumer0);
    }

    @Test
    public void test1056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1056");
        org.apache.commons.lang3.exception.ContextedException contextedException0 = new org.apache.commons.lang3.exception.ContextedException();
        java.lang.Long[] longArray8 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray15 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray22 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray29 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray36 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[][] longArray37 = new java.lang.Long[][] { longArray8, longArray15, longArray22, longArray29, longArray36 };
        java.util.function.Supplier<java.lang.String> strSupplier38 = null;
        java.lang.String str39 = org.apache.commons.lang3.ObjectUtils.toString(longArray37, strSupplier38);
        org.apache.commons.lang3.exception.ContextedException contextedException40 = contextedException0.addContextValue("pen", (java.lang.Object) str39);
        java.util.List<java.lang.Object> objList42 = contextedException0.getContextValues("java.vm.version");
        org.apache.commons.lang3.concurrent.ConcurrentRuntimeException concurrentRuntimeException43 = new org.apache.commons.lang3.concurrent.ConcurrentRuntimeException((java.lang.Throwable) contextedException0);
        org.junit.Assert.assertNotNull(longArray8);
        org.junit.Assert.assertNotNull(longArray15);
        org.junit.Assert.assertNotNull(longArray22);
        org.junit.Assert.assertNotNull(longArray29);
        org.junit.Assert.assertNotNull(longArray36);
        org.junit.Assert.assertNotNull(longArray37);
        org.junit.Assert.assertNotNull(contextedException40);
        org.junit.Assert.assertNotNull(objList42);
    }

    @Test
    public void test1057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1057");
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle2 = null;
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder3 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle2);
        org.apache.commons.lang3.function.FailableIntFunction<org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.RuntimeException> recursiveToStringStyleFailableIntFunction4 = org.apache.commons.lang3.function.FailableIntFunction.nop();
        org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.Builder<org.apache.commons.lang3.builder.DiffResult<java.io.Serializable>>, org.apache.commons.lang3.function.FailableIntFunction<org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.RuntimeException>> serializableDiffResultBuilderPair5 = org.apache.commons.lang3.tuple.Pair.ofNonNull((org.apache.commons.lang3.builder.Builder<org.apache.commons.lang3.builder.DiffResult<java.io.Serializable>>) serializableReflectionDiffBuilder3, recursiveToStringStyleFailableIntFunction4);
        org.apache.commons.lang3.builder.RecursiveToStringStyle recursiveToStringStyle7 = recursiveToStringStyleFailableIntFunction4.apply((int) ' ');
        org.junit.Assert.assertNotNull(recursiveToStringStyleFailableIntFunction4);
        org.junit.Assert.assertNotNull(serializableDiffResultBuilderPair5);
        org.junit.Assert.assertNull(recursiveToStringStyle7);
    }

    @Test
    public void test1058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1058");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.time.DateUtils.getFragmentInMinutes(date0, (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1059");
        org.apache.commons.lang3.mutable.MutableInt mutableInt1 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        int int2 = mutableInt1.getAndDecrement();
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 97 + "'", int2 == 97);
    }

    @Test
    public void test1060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1060");
        boolean boolean1 = org.apache.commons.lang3.CharUtils.isAsciiAlphaLower('$');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test1061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1061");
        java.lang.String str1 = org.apache.commons.lang3.text.WordUtils.capitalize("glacierali");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Glacierali" + "'", str1, "Glacierali");
    }

    @Test
    public void test1062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1062");
        java.io.File[] fileArray0 = null;
        java.lang.Long[] longArray9 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray16 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray23 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray30 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray37 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[][] longArray38 = new java.lang.Long[][] { longArray9, longArray16, longArray23, longArray30, longArray37 };
        java.util.function.Supplier<java.lang.String> strSupplier39 = null;
        java.lang.String str40 = org.apache.commons.lang3.ObjectUtils.toString(longArray38, strSupplier39);
        java.lang.Class<?>[] wildcardClassArray41 = org.apache.commons.lang3.ClassUtils.toClass((java.lang.Object[]) longArray38);
        // The following exception was thrown during execution in test generation
        try {
            java.io.File[] fileArray42 = org.apache.commons.lang3.Validate.validIndex(fileArray0, (int) (short) 101, "\\u0024", (java.lang.Object[]) wildcardClassArray41);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: array");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray9);
        org.junit.Assert.assertNotNull(longArray16);
        org.junit.Assert.assertNotNull(longArray23);
        org.junit.Assert.assertNotNull(longArray30);
        org.junit.Assert.assertNotNull(longArray37);
        org.junit.Assert.assertNotNull(longArray38);
        org.junit.Assert.assertNotNull(wildcardClassArray41);
    }

    @Test
    public void test1063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1063");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle0 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        java.lang.StringBuffer stringBuffer1 = null;
        org.apache.commons.lang3.JavaVersion javaVersion3 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion4 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange5 = org.apache.commons.lang3.Range.of(javaVersion3, javaVersion4);
        // The following exception was thrown during execution in test generation
        try {
            multilineRecursiveToStringStyle0.appendDetail(stringBuffer1, "null", (java.lang.Object) javaVersion4);
            org.junit.Assert.fail("Expected exception of type java.lang.reflect.InaccessibleObjectException; message: Unable to make field private final java.lang.String java.lang.Enum.name accessible: module java.base does not \"opens java.lang\" to unnamed module @654b5005");
        } catch (java.lang.reflect.InaccessibleObjectException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + javaVersion3 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion3.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion4 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion4.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange5);
    }

    @Test
    public void test1064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1064");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        char[] charArray13 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray16 = org.apache.commons.lang3.ArrayUtils.subarray(charArray13, (int) (short) 1, (-1));
        char[] charArray17 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray4, charArray13);
        java.lang.String str18 = org.apache.commons.lang3.StringUtils.valueOf(charArray4);
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
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + " " + "'", str18, " ");
    }

    @Test
    public void test1065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1065");
        java.util.Date date0 = null;
        java.util.TimeZone timeZone2 = org.apache.commons.lang3.time.FastTimeZone.getGmtTimeZone();
        java.util.TimeZone timeZone3 = org.apache.commons.lang3.Validate.notNull(timeZone2);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = org.apache.commons.lang3.time.DateFormatUtils.format(date0, "file.encoding", timeZone2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: f");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(timeZone2);
        org.junit.Assert.assertEquals(timeZone2.getDisplayName(), "GMT+00:00");
        org.junit.Assert.assertNotNull(timeZone3);
        org.junit.Assert.assertEquals(timeZone3.getDisplayName(), "GMT+00:00");
    }

    @Test
    public void test1066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1066");
        java.lang.ThreadGroup threadGroup1 = org.apache.commons.lang3.ThreadUtils.getSystemThreadGroup();
        java.util.Collection<java.lang.Thread> threadCollection2 = org.apache.commons.lang3.ThreadUtils.findThreadsByName("UnicodeUnescaper", threadGroup1);
        org.junit.Assert.assertNotNull(threadGroup1);
        org.junit.Assert.assertEquals(threadGroup1.toString(), "java.lang.ThreadGroup[name=system,maxpri=10]");
        org.junit.Assert.assertNotNull(threadCollection2);
    }

    @Test
    public void test1067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1067");
        java.util.TimeZone timeZone5 = org.apache.commons.lang3.time.FastTimeZone.getTimeZone("java.awt.headless");
        java.util.Locale locale7 = null;
        java.util.Locale locale8 = org.apache.commons.lang3.LocaleUtils.toLocale(locale7);
        java.lang.String str9 = org.apache.commons.lang3.StringUtils.lowerCase("user.name", locale8);
        java.lang.String str10 = org.apache.commons.lang3.time.DateFormatUtils.format((long) (-5), "", timeZone5, locale8);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.time.FastDateFormat fastDateFormat11 = org.apache.commons.lang3.time.FastDateFormat.getDateTimeInstance((int) '#', (int) (short) 101, locale8);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal time style 101");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(timeZone5);
        org.junit.Assert.assertEquals(timeZone5.getDisplayName(), "Greenwich Mean Time");
        org.junit.Assert.assertNotNull(locale8);
        org.junit.Assert.assertEquals(locale8.toString(), "en_SE");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "user.name" + "'", str9, "user.name");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "" + "'", str10, "");
    }

    @Test
    public void test1068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1068");
        short[] shortArray3 = new short[] { (short) 1, (short) -1, (byte) 10 };
        boolean boolean4 = org.apache.commons.lang3.ArrayUtils.isSorted(shortArray3);
        int int7 = org.apache.commons.lang3.ArrayUtils.indexOf(shortArray3, (short) 0, (int) 'a');
        short short8 = org.apache.commons.lang3.math.NumberUtils.max(shortArray3);
        java.lang.Short[] shortArray14 = new java.lang.Short[] { (short) 100, (short) 1, (short) 1, (short) 10, (short) 1 };
        java.lang.Short[] shortArray15 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(shortArray14);
        short[] shortArray16 = org.apache.commons.lang3.ArrayUtils.toPrimitive(shortArray15);
        short[] shortArray17 = org.apache.commons.lang3.ArrayUtils.removeElements(shortArray3, shortArray16);
        org.junit.Assert.assertNotNull(shortArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray3), "[1, -1, 10]");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertTrue("'" + short8 + "' != '" + (short) 10 + "'", short8 == (short) 10);
        org.junit.Assert.assertNotNull(shortArray14);
        org.junit.Assert.assertNotNull(shortArray15);
        org.junit.Assert.assertNotNull(shortArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray16), "[100, 1, 1, 10, 1]");
        org.junit.Assert.assertNotNull(shortArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray17), "[-1]");
    }

    @Test
    public void test1069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1069");
        org.apache.commons.lang3.exception.ContextedException contextedException1 = new org.apache.commons.lang3.exception.ContextedException();
        java.lang.Long[] longArray9 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray16 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray23 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray30 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray37 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[][] longArray38 = new java.lang.Long[][] { longArray9, longArray16, longArray23, longArray30, longArray37 };
        java.util.function.Supplier<java.lang.String> strSupplier39 = null;
        java.lang.String str40 = org.apache.commons.lang3.ObjectUtils.toString(longArray38, strSupplier39);
        org.apache.commons.lang3.exception.ContextedException contextedException41 = contextedException1.addContextValue("pen", (java.lang.Object) str40);
        java.util.List<java.lang.Object> objList43 = contextedException1.getContextValues("java.vm.version");
        java.lang.Object obj45 = contextedException1.getFirstContextValue("os.name");
        org.apache.commons.lang3.exception.ContextedException contextedException46 = new org.apache.commons.lang3.exception.ContextedException();
        java.lang.Long[] longArray54 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray61 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray68 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray75 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray82 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[][] longArray83 = new java.lang.Long[][] { longArray54, longArray61, longArray68, longArray75, longArray82 };
        java.util.function.Supplier<java.lang.String> strSupplier84 = null;
        java.lang.String str85 = org.apache.commons.lang3.ObjectUtils.toString(longArray83, strSupplier84);
        org.apache.commons.lang3.exception.ContextedException contextedException86 = contextedException46.addContextValue("pen", (java.lang.Object) str85);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException87 = new org.apache.commons.lang3.exception.ContextedRuntimeException("EEE, dd MMM yyyy HH:mm:ss Z", (java.lang.Throwable) contextedException1, (org.apache.commons.lang3.exception.ExceptionContext) contextedException46);
        org.junit.Assert.assertNotNull(longArray9);
        org.junit.Assert.assertNotNull(longArray16);
        org.junit.Assert.assertNotNull(longArray23);
        org.junit.Assert.assertNotNull(longArray30);
        org.junit.Assert.assertNotNull(longArray37);
        org.junit.Assert.assertNotNull(longArray38);
        org.junit.Assert.assertNotNull(contextedException41);
        org.junit.Assert.assertNotNull(objList43);
        org.junit.Assert.assertNull(obj45);
        org.junit.Assert.assertNotNull(longArray54);
        org.junit.Assert.assertNotNull(longArray61);
        org.junit.Assert.assertNotNull(longArray68);
        org.junit.Assert.assertNotNull(longArray75);
        org.junit.Assert.assertNotNull(longArray82);
        org.junit.Assert.assertNotNull(longArray83);
        org.junit.Assert.assertNotNull(contextedException86);
    }

    @Test
    public void test1070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1070");
        java.lang.String str3 = org.apache.commons.lang3.RandomStringUtils.random((int) (byte) 100, true, true);
// flaky:         org.junit.Assert.assertEquals("'" + str3 + "' != '" + "8b7AglZUJfMxGWQ0jmrPsP1qOE5I2LDiTVGyoeDJzIlNKs8rcThoqjVUtpA8pc4q1Jwe0PSbI9up4xYUV1OY8d3SNYeTEpzYJ7l6" + "'", str3, "8b7AglZUJfMxGWQ0jmrPsP1qOE5I2LDiTVGyoeDJzIlNKs8rcThoqjVUtpA8pc4q1Jwe0PSbI9up4xYUV1OY8d3SNYeTEpzYJ7l6");
    }

    @Test
    public void test1071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1071");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.unescapeJson("Oracle Corporation");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "Oracle Corporation" + "'", str1, "Oracle Corporation");
    }

    @Test
    public void test1072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1072");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.mutable.MutableByte mutableByte1 = new org.apache.commons.lang3.mutable.MutableByte("0\n0");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"0?0\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1073");
        org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException> strItorMutableTriple0 = new org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException>();
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException7 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException6);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException8 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException6);
        strItorMutableTriple0.setRight(contextedRuntimeException8);
        java.lang.Throwable throwable11 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException12 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable11);
        java.lang.Throwable[] throwableArray13 = uncheckedExecutionException12.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException15 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException12, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException16 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException15);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException17 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException15);
        java.lang.Object obj19 = contextedRuntimeException17.getFirstContextValue("glacierali");
        org.apache.commons.lang3.mutable.MutableInt mutableInt22 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException23 = contextedRuntimeException17.setContextValue("mixed mode, sharing", (java.lang.Object) 'a');
        strItorMutableTriple0.right = contextedRuntimeException17;
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertNotNull(throwableArray13);
        org.junit.Assert.assertNull(obj19);
        org.junit.Assert.assertNotNull(contextedRuntimeException23);
    }

    @Test
    public void test1074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1074");
        java.lang.Class<org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>> multiBackgroundInitializerResultsFailableSupplierClass0 = null;
        java.lang.Class<?> wildcardClass1 = org.apache.commons.lang3.ClassUtils.primitiveToWrapper(multiBackgroundInitializerResultsFailableSupplierClass0);
        org.junit.Assert.assertNull(wildcardClass1);
    }

    @Test
    public void test1075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1075");
        short[] shortArray2 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray2, (int) (byte) -1, 1, (int) (byte) 10);
        short[] shortArray7 = org.apache.commons.lang3.ArraySorter.sort(shortArray2);
        org.apache.commons.lang3.ArrayUtils.swap(shortArray7, (int) 'o', (int) 'a');
        org.junit.Assert.assertNotNull(shortArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray2), "[100, 100]");
        org.junit.Assert.assertNotNull(shortArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray7), "[100, 100]");
    }

    @Test
    public void test1076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1076");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        java.lang.Object obj4 = null;
        standardToStringStyle0.appendStart(stringBuffer3, obj4);
        java.lang.StringBuffer stringBuffer6 = null;
        standardToStringStyle0.appendSuper(stringBuffer6, "Oracle Corporation");
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
    }

    @Test
    public void test1077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1077");
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
        long[] longArray39 = org.apache.commons.lang3.ArrayUtils.add(longArray36, (-1L));
        long[] longArray41 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray36, (long) (byte) 1);
        long long42 = org.apache.commons.lang3.math.NumberUtils.max(longArray36);
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
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray39), "[60000, 10, 100, 100, 97, 52, 101, -1]");
        org.junit.Assert.assertNotNull(longArray41);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray41), "[1, 60000, 10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertTrue("'" + long42 + "' != '" + 60000L + "'", long42 == 60000L);
    }

    @Test
    public void test1078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1078");
        java.lang.Object[] objArray0 = null;
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair1 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray2 = charSequenceArrayImmutablePair1.getLeft();
        java.util.BitSet bitSet3 = org.apache.commons.lang3.ArrayUtils.indexesOf(objArray0, (java.lang.Object) charSequenceArrayImmutablePair1);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair1);
        org.junit.Assert.assertNull(charSequenceArray2);
        org.junit.Assert.assertNotNull(bitSet3);
        org.junit.Assert.assertEquals(bitSet3.toString(), "{}");
    }

    @Test
    public void test1079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1079");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_IO_TMPDIR_KEY;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.io.tmpdir" + "'", str0, "java.io.tmpdir");
    }

    @Test
    public void test1080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1080");
        boolean boolean1 = org.apache.commons.lang3.CharUtils.isAsciiAlpha('o');
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + true + "'", boolean1 == true);
    }

    @Test
    public void test1081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1081");
        double double3 = org.apache.commons.lang3.math.NumberUtils.min((double) ' ', (double) (short) 97, 0.0d);
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 0.0d + "'", double3 == 0.0d);
    }

    @Test
    public void test1082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1082");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_17;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_17 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_17));
    }

    @Test
    public void test1083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1083");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.util.concurrent.Future<org.apache.commons.lang3.builder.StandardToStringStyle> standardToStringStyleFuture3 = org.apache.commons.lang3.concurrent.ConcurrentUtils.constantFuture(standardToStringStyle0);
        java.lang.String str4 = standardToStringStyle0.getSummaryObjectEndText();
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertNotNull(standardToStringStyleFuture3);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + ">" + "'", str4, ">");
    }

    @Test
    public void test1084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1084");
        double[] doubleArray0 = null;
        double[] doubleArray2 = org.apache.commons.lang3.ArrayUtils.addFirst(doubleArray0, (double) 10L);
        double[] doubleArray5 = org.apache.commons.lang3.ArrayUtils.subarray(doubleArray2, 3, (int) '\n');
        org.apache.commons.lang3.ArrayUtils.reverse(doubleArray5, (int) (short) 100, (int) (byte) -1);
        org.junit.Assert.assertNotNull(doubleArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray2), "[10.0]");
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[]");
    }

    @Test
    public void test1085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1085");
        java.lang.Throwable throwable0 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException1 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable0);
        java.lang.Throwable[] throwableArray2 = uncheckedExecutionException1.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException4 = new org.apache.commons.lang3.NotImplementedException((java.lang.Throwable) uncheckedExecutionException1, "os.version");
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException5 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException((java.lang.Throwable) notImplementedException4);
        org.apache.commons.lang3.exception.UncheckedInterruptedException uncheckedInterruptedException6 = new org.apache.commons.lang3.exception.UncheckedInterruptedException((java.lang.Throwable) uncheckedExecutionException5);
        org.junit.Assert.assertNotNull(throwableArray2);
    }

    @Test
    public void test1086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1086");
        org.apache.commons.lang3.arch.Processor.Arch arch0 = null;
        org.apache.commons.lang3.arch.Processor.Type type1 = org.apache.commons.lang3.arch.Processor.Type.PPC;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.arch.Processor.Type> typeRange2 = org.apache.commons.lang3.Range.is(type1);
        org.apache.commons.lang3.arch.Processor processor3 = new org.apache.commons.lang3.arch.Processor(arch0, type1);
        org.apache.commons.lang3.arch.Processor.Type type4 = processor3.getType();
        java.lang.Class<org.apache.commons.lang3.arch.Processor> processorClass5 = org.apache.commons.lang3.ObjectUtils.getClass(processor3);
        org.junit.Assert.assertTrue("'" + type1 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type1.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNotNull(typeRange2);
        org.junit.Assert.assertTrue("'" + type4 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type4.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNotNull(processorClass5);
    }

    @Test
    public void test1087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1087");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer9 = org.apache.commons.lang3.text.StrTokenizer.getTSVInstance(charArray8);
        java.lang.Character[] charArray10 = org.apache.commons.lang3.ArrayUtils.toObject(charArray8);
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
        org.junit.Assert.assertNotNull(charArray10);
    }

    @Test
    public void test1088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1088");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.wrapIfMissing("java.specification.version", "DOUBLE");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "DOUBLEjava.specification.versionDOUBLE" + "'", str2, "DOUBLEjava.specification.versionDOUBLE");
    }

    @Test
    public void test1089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1089");
        org.apache.commons.lang3.function.FailableIntUnaryOperator<org.apache.commons.lang3.exception.UncheckedIllegalAccessException> uncheckedIllegalAccessExceptionFailableIntUnaryOperator0 = org.apache.commons.lang3.function.FailableIntUnaryOperator.nop();
        org.junit.Assert.assertNotNull(uncheckedIllegalAccessExceptionFailableIntUnaryOperator0);
    }

    @Test
    public void test1090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1090");
        org.apache.commons.lang3.util.FluentBitSet fluentBitSet0 = new org.apache.commons.lang3.util.FluentBitSet();
        int int2 = fluentBitSet0.nextClearBit(96);
        boolean[] booleanArray8 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray10 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray8, false);
        boolean[] booleanArray12 = org.apache.commons.lang3.ArrayUtils.removeElement(booleanArray8, true);
        boolean boolean13 = org.apache.commons.lang3.ArrayUtils.isNotEmpty(booleanArray12);
        java.util.BitSet bitSet15 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray12, false);
        org.apache.commons.lang3.util.FluentBitSet fluentBitSet16 = fluentBitSet0.or(bitSet15);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 96 + "'", int2 == 96);
        org.junit.Assert.assertNotNull(booleanArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray8), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray10), "[true, true]");
        org.junit.Assert.assertNotNull(booleanArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray12), "[false, false, true, false]");
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        org.junit.Assert.assertNotNull(bitSet15);
        org.junit.Assert.assertEquals(bitSet15.toString(), "{0, 1, 3}");
        org.junit.Assert.assertNotNull(fluentBitSet16);
    }

    @Test
    public void test1091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1091");
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
        java.lang.StringBuffer stringBuffer15 = null;
        java.text.FieldPosition fieldPosition16 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.StringBuffer stringBuffer17 = compositeFormat13.format((java.lang.Object) "os.name", stringBuffer15, fieldPosition16);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Unknown class: java.lang.String");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
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
    }

    @Test
    public void test1092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1092");
        org.apache.commons.lang3.arch.Processor.Arch arch0 = null;
        org.apache.commons.lang3.arch.Processor.Type type1 = org.apache.commons.lang3.arch.Processor.Type.PPC;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.arch.Processor.Type> typeRange2 = org.apache.commons.lang3.Range.is(type1);
        org.apache.commons.lang3.arch.Processor processor3 = new org.apache.commons.lang3.arch.Processor(arch0, type1);
        org.apache.commons.lang3.arch.Processor.Type type4 = processor3.getType();
        boolean boolean5 = processor3.isRISCV();
        boolean boolean6 = processor3.is64Bit();
        org.junit.Assert.assertTrue("'" + type1 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type1.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNotNull(typeRange2);
        org.junit.Assert.assertTrue("'" + type4 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type4.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test1093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1093");
        float float3 = org.apache.commons.lang3.math.NumberUtils.max((float) 6, (float) (-87), (float) 0L);
        org.junit.Assert.assertTrue("'" + float3 + "' != '" + 6.0f + "'", float3 == 6.0f);
    }

    @Test
    public void test1094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1094");
        long[] longArray1 = new long[] { '4' };
        long[] longArray7 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet10 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray7, (long) '\n', 100);
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray7);
        long[] longArray13 = org.apache.commons.lang3.ArrayUtils.add(longArray7, (long) (short) 101);
        boolean boolean14 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray1, longArray13);
        long[] longArray16 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray13, 60000L);
        org.apache.commons.lang3.ArrayUtils.reverse(longArray16, (int) '\r', 1);
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
    public void test1095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1095");
        java.net.URLClassLoader uRLClassLoader0 = null;
        java.lang.String str1 = org.apache.commons.lang3.ClassLoaderUtils.toString(uRLClassLoader0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "null" + "'", str1, "null");
    }

    @Test
    public void test1096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1096");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setNullText("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        java.lang.String str3 = standardToStringStyle0.getSummaryObjectEndText();
        java.lang.String str4 = standardToStringStyle0.getFieldSeparator();
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + ">" + "'", str3, ">");
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "," + "'", str4, ",");
    }

    @Test
    public void test1097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1097");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray4 = strTokenizer3.getTokenArray();
        org.apache.commons.lang3.text.StrMatcher strMatcher5 = org.apache.commons.lang3.text.StrMatcher.tabMatcher();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer6 = strTokenizer3.setIgnoredMatcher(strMatcher5);
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertNotNull(strMatcher5);
        org.junit.Assert.assertNotNull(strTokenizer6);
    }

    @Test
    public void test1098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1098");
        org.apache.commons.lang3.util.FluentBitSet fluentBitSet0 = new org.apache.commons.lang3.util.FluentBitSet();
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException((java.lang.Throwable) uncheckedExecutionException2, "os.version");
        boolean boolean6 = org.apache.commons.lang3.exception.ExceptionUtils.isChecked((java.lang.Throwable) notImplementedException5);
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper7 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper8 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper9 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper10 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper11 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper12 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper13 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray14 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper8, unicodeUnescaper9, unicodeUnescaper10, unicodeUnescaper11, unicodeUnescaper12, unicodeUnescaper13 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator15 = unicodeUnescaper7.with(charSequenceTranslatorArray14);
        java.lang.String str17 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) charSequenceTranslatorArray14, ' ');
        java.util.BitSet bitSet19 = org.apache.commons.lang3.ArrayUtils.indexesOf((java.lang.Object[]) charSequenceTranslatorArray14, (java.lang.Object) "pen");
        org.apache.commons.lang3.tuple.ImmutablePair<org.apache.commons.lang3.NotImplementedException, java.util.BitSet> notImplementedExceptionImmutablePair20 = new org.apache.commons.lang3.tuple.ImmutablePair<org.apache.commons.lang3.NotImplementedException, java.util.BitSet>(notImplementedException5, bitSet19);
        org.apache.commons.lang3.util.FluentBitSet fluentBitSet21 = fluentBitSet0.andNot(bitSet19);
        int int22 = fluentBitSet0.length();
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray14);
        org.junit.Assert.assertNotNull(charSequenceTranslator15);
        org.junit.Assert.assertNotNull(bitSet19);
        org.junit.Assert.assertEquals(bitSet19.toString(), "{}");
        org.junit.Assert.assertNotNull(fluentBitSet21);
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + 0 + "'", int22 == 0);
    }

    @Test
    public void test1099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1099");
        org.apache.commons.lang3.SystemProperties systemProperties0 = new org.apache.commons.lang3.SystemProperties();
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle1 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle2 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str3 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle1, toStringStyle2);
        java.lang.StringBuffer stringBuffer4 = null;
        java.lang.Object obj5 = null;
        standardToStringStyle1.appendStart(stringBuffer4, obj5);
        java.lang.String str7 = standardToStringStyle1.getNullText();
        java.lang.String str8 = standardToStringStyle1.getArraySeparator();
        java.lang.String str9 = standardToStringStyle1.getArrayEnd();
        java.lang.String str10 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString((java.lang.Object) systemProperties0, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle1);
        org.junit.Assert.assertNotNull(toStringStyle2);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str3, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "<null>" + "'", str7, "<null>");
        org.junit.Assert.assertEquals("'" + str8 + "' != '" + "," + "'", str8, ",");
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "}" + "'", str9, "}");
    }

    @Test
    public void test1100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1100");
        java.lang.reflect.Field field0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj2 = org.apache.commons.lang3.reflect.FieldUtils.readStaticField(field0, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: field");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1101");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.USER_TIMEZONE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "user.timezone" + "'", str0, "user.timezone");
    }

    @Test
    public void test1102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1102");
        int[] intArray5 = new int[] { (short) 100, (short) 10, (short) 10, '\n', '\n' };
        int[] intArray7 = org.apache.commons.lang3.ArrayUtils.add(intArray5, (int) '4');
        int int9 = org.apache.commons.lang3.ArrayUtils.indexOf(intArray5, 0);
        int[] intArray11 = org.apache.commons.lang3.ArrayUtils.addFirst(intArray5, 17);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray5), "[100, 10, 10, 10, 10]");
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray7), "[100, 10, 10, 10, 10, 52]");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + (-1) + "'", int9 == (-1));
        org.junit.Assert.assertNotNull(intArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray11), "[17, 100, 10, 10, 10, 10]");
    }

    @Test
    public void test1103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1103");
        org.apache.commons.lang3.mutable.MutableInt mutableInt1 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        org.apache.commons.lang3.mutable.MutableShort mutableShort3 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort3.setValue((java.lang.Number) (short) 100);
        long long6 = mutableShort3.longValue();
        mutableShort3.add((short) 10);
        mutableInt1.setValue((java.lang.Number) mutableShort3);
        org.junit.Assert.assertTrue("'" + long6 + "' != '" + 100L + "'", long6 == 100L);
    }

    @Test
    public void test1104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1104");
        org.apache.commons.lang3.mutable.MutableLong mutableLong1 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        double double2 = mutableLong1.doubleValue();
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 1.0d + "'", double2 == 1.0d);
    }

    @Test
    public void test1105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1105");
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
        long[] longArray39 = org.apache.commons.lang3.ArrayUtils.add(longArray36, (-1L));
        org.apache.commons.lang3.ArrayUtils.shift(longArray39, (int) (byte) -11);
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
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray39), "[100, 97, 52, 101, -1, 60000, 10, 100]");
    }

    @Test
    public void test1106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1106");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer9 = org.apache.commons.lang3.text.StrTokenizer.getTSVInstance(charArray8);
        org.apache.commons.lang3.text.StrTokenizer strTokenizer11 = strTokenizer9.reset("line.separator");
        org.apache.commons.lang3.text.StrMatcher strMatcher12 = strTokenizer9.getTrimmerMatcher();
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
        org.junit.Assert.assertNotNull(strMatcher12);
    }

    @Test
    public void test1107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1107");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.exclusiveBetween((-1.0d), (double) 0.0f, (double) '\000', "\\u0061");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: \\u0061");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1108");
        int int2 = org.apache.commons.lang3.StringUtils.lastIndexOfIgnoreCase((java.lang.CharSequence) "\n", (java.lang.CharSequence) "yes");
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test1109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1109");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        standardToStringStyle0.setFieldSeparatorAtStart(false);
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
    }

    @Test
    public void test1110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1110");
        org.apache.commons.lang3.arch.Processor.Arch arch0 = null;
        org.apache.commons.lang3.arch.Processor.Type type1 = org.apache.commons.lang3.arch.Processor.Type.PPC;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.arch.Processor.Type> typeRange2 = org.apache.commons.lang3.Range.is(type1);
        org.apache.commons.lang3.arch.Processor processor3 = new org.apache.commons.lang3.arch.Processor(arch0, type1);
        org.apache.commons.lang3.arch.Processor.Type type4 = processor3.getType();
        org.apache.commons.lang3.arch.Processor.Arch arch5 = processor3.getArch();
        org.apache.commons.lang3.arch.Processor.Arch arch6 = null;
        org.apache.commons.lang3.arch.Processor.Type type7 = org.apache.commons.lang3.arch.Processor.Type.PPC;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.arch.Processor.Type> typeRange8 = org.apache.commons.lang3.Range.is(type7);
        org.apache.commons.lang3.arch.Processor processor9 = new org.apache.commons.lang3.arch.Processor(arch6, type7);
        boolean boolean10 = processor9.is32Bit();
        org.apache.commons.lang3.arch.Processor[] processorArray11 = new org.apache.commons.lang3.arch.Processor[] { processor3, processor9 };
        java.lang.Class<org.apache.commons.lang3.arch.Processor> processorClass12 = org.apache.commons.lang3.ArrayUtils.getComponentType(processorArray11);
        org.junit.Assert.assertTrue("'" + type1 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type1.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNotNull(typeRange2);
        org.junit.Assert.assertTrue("'" + type4 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type4.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNull(arch5);
        org.junit.Assert.assertTrue("'" + type7 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type7.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNotNull(typeRange8);
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        org.junit.Assert.assertNotNull(processorArray11);
        org.junit.Assert.assertNotNull(processorClass12);
    }

    @Test
    public void test1111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1111");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray4 = strTokenizer3.getTokenArray();
        boolean boolean5 = strTokenizer3.isEmptyTokenAsNull();
        org.apache.commons.lang3.text.StrMatcher strMatcher6 = strTokenizer3.getIgnoredMatcher();
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(strMatcher6);
    }

    @Test
    public void test1112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1112");
        java.lang.reflect.Method method0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.function.Function<java.lang.String[], org.apache.commons.lang3.function.FailableIntPredicate> strArrayFunction1 = org.apache.commons.lang3.function.MethodInvokers.asFunction(method0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1113");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.mutable.MutableDouble mutableDouble1 = new org.apache.commons.lang3.mutable.MutableDouble("ava.specif");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"ava.specif\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1114");
        org.apache.commons.lang3.exception.ContextedException contextedException0 = new org.apache.commons.lang3.exception.ContextedException();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle4 = null;
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder5 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle4);
        org.apache.commons.lang3.exception.ContextedException contextedException6 = contextedException0.setContextValue("yes", (java.lang.Object) 0);
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator7 = org.apache.commons.lang3.StringEscapeUtils.UNESCAPE_HTML4;
        boolean boolean8 = org.apache.commons.lang3.ObjectUtils.equals((java.lang.Object) contextedException0, (java.lang.Object) charSequenceTranslator7);
        org.apache.commons.lang3.exception.ContextedException contextedException11 = contextedException0.setContextValue("os.name", (java.lang.Object) "OpenJDK Runtime Environment");
        org.apache.commons.lang3.NotImplementedException notImplementedException12 = new org.apache.commons.lang3.NotImplementedException((java.lang.Throwable) contextedException11);
        org.junit.Assert.assertNotNull(contextedException6);
        org.junit.Assert.assertNotNull(charSequenceTranslator7);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(contextedException11);
    }

    @Test
    public void test1115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1115");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str5 = org.apache.commons.lang3.RandomStringUtils.random((int) (byte) -11, (int) (short) 99, 44, false, false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Requested random string length -11 is less than 0.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1116");
        java.lang.String[][] strArray0 = org.apache.commons.lang3.text.translate.EntityArrays.APOS_ESCAPE();
        java.lang.String[][] strArray1 = org.apache.commons.lang3.text.translate.EntityArrays.invert(strArray0);
        org.junit.Assert.assertNotNull(strArray0);
        org.junit.Assert.assertNotNull(strArray1);
    }

    @Test
    public void test1117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1117");
        long[] longArray1 = new long[] { '4' };
        long[] longArray7 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet10 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray7, (long) '\n', 100);
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray7);
        long[] longArray13 = org.apache.commons.lang3.ArrayUtils.add(longArray7, (long) (short) 101);
        boolean boolean14 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray1, longArray13);
        long[] longArray16 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray13, 60000L);
        boolean boolean17 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray13);
        java.lang.String str19 = org.apache.commons.lang3.StringUtils.join(longArray13, '\r');
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
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "10\r100\r100\r97\r52\r101" + "'", str19, "10\r100\r100\r97\r52\r101");
    }

    @Test
    public void test1118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1118");
        org.apache.commons.lang3.arch.Processor.Arch arch0 = org.apache.commons.lang3.arch.Processor.Arch.UNKNOWN;
        org.junit.Assert.assertTrue("'" + arch0 + "' != '" + org.apache.commons.lang3.arch.Processor.Arch.UNKNOWN + "'", arch0.equals(org.apache.commons.lang3.arch.Processor.Arch.UNKNOWN));
    }

    @Test
    public void test1119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1119");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        org.apache.commons.lang3.ArrayUtils.shift(booleanArray11, (int) '\n');
        org.apache.commons.lang3.ArrayUtils.shift(booleanArray11, (int) '\n', (int) (byte) 100, (int) (byte) 10);
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
    public void test1120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1120");
        org.apache.commons.lang3.DoubleRange doubleRange2 = org.apache.commons.lang3.DoubleRange.of((double) 2147483647L, (double) 0L);
        int int4 = doubleRange2.elementCompareTo((java.lang.Double) 3.0d);
        org.junit.Assert.assertNotNull(doubleRange2);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
    }

    @Test
    public void test1121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1121");
        java.lang.StringBuffer stringBuffer0 = null;
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException7 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException6);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException8 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException6);
        java.lang.Throwable[] throwableArray9 = org.apache.commons.lang3.exception.ExceptionUtils.getThrowables((java.lang.Throwable) notImplementedException6);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ObjectUtils.identityToString(stringBuffer0, (java.lang.Object) throwableArray9);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.length()\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertNotNull(throwableArray9);
    }

    @Test
    public void test1122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1122");
        boolean[] booleanArray6 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray8 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray6, false);
        java.util.BitSet bitSet10 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray6, true);
        boolean[] booleanArray12 = org.apache.commons.lang3.ArrayUtils.add(booleanArray6, true);
        boolean[] booleanArray18 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray20 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray18, false);
        boolean[] booleanArray22 = org.apache.commons.lang3.ArrayUtils.removeElement(booleanArray18, true);
        boolean boolean23 = org.apache.commons.lang3.ArrayUtils.isNotEmpty(booleanArray22);
        boolean[] booleanArray24 = org.apache.commons.lang3.ArrayUtils.insert(3, booleanArray12, booleanArray22);
        java.util.Random random25 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(booleanArray22, random25);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray6), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray8), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet10);
        org.junit.Assert.assertEquals(bitSet10.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(booleanArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray12), "[false, true, false, true, false, true]");
        org.junit.Assert.assertNotNull(booleanArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray18), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray20);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray20), "[true, true]");
        org.junit.Assert.assertNotNull(booleanArray22);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray22), "[false, false, true, false]");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(booleanArray24);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray24), "[false, true, false, false, false, true, false, true, false, true]");
    }

    @Test
    public void test1123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1123");
        java.util.Date date0 = null;
        java.util.Date date1 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = org.apache.commons.lang3.time.DateUtils.truncatedEquals(date0, date1, 5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1124");
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
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder41 = autoCloseableDiffBuilder14.append(")<+WncT", (int) '\n', 8);
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
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder41);
    }

    @Test
    public void test1125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1125");
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
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle92 = org.apache.commons.lang3.builder.ToStringStyle.DEFAULT_STYLE;
        java.lang.String str93 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) equalsBuilder91, toStringStyle92);
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
        org.junit.Assert.assertNotNull(toStringStyle92);
    }

    @Test
    public void test1126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1126");
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
        char[] charArray47 = org.apache.commons.lang3.ArrayUtils.add(charArray43, (int) (short) 0, ' ');
        char[] charArray50 = new char[] { ' ', '#' };
        char[] charArray52 = new char[] { ' ' };
        char[] charArray53 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray50, charArray52);
        char[] charArray56 = org.apache.commons.lang3.ArrayUtils.add(charArray52, (int) (short) 0, ' ');
        char[] charArray61 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray64 = org.apache.commons.lang3.ArrayUtils.subarray(charArray61, (int) (short) 1, (-1));
        char[] charArray65 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray52, charArray61);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder66 = autoCloseableDiffBuilder14.append("user.name", charArray47, charArray65);
        float[] floatArray72 = new float[] { (short) 1, (short) 100, 1.0f, '4' };
        float float73 = org.apache.commons.lang3.math.NumberUtils.min(floatArray72);
        org.apache.commons.lang3.JavaVersion javaVersion74 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion75 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate76 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion74, javaVersion75);
        boolean boolean78 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) floatArray72, (java.lang.Object) javaVersionPredicate76, false);
        float[] floatArray79 = org.apache.commons.lang3.ArrayUtils.clone(floatArray72);
        float[] floatArray83 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray90 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean91 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray83, floatArray90);
        float[] floatArray93 = org.apache.commons.lang3.ArrayUtils.addFirst(floatArray90, (float) (short) 0);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder94 = autoCloseableDiffBuilder14.append("60.0", floatArray79, floatArray93);
        // The following exception was thrown during execution in test generation
        try {
            float[] floatArray96 = org.apache.commons.lang3.ArrayUtils.remove(floatArray79, (int) 'o');
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 111, Length: 4");
        } catch (java.lang.IndexOutOfBoundsException e) {
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
        org.junit.Assert.assertNotNull(charArray50);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray50), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray50), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray50), "[ , #]");
        org.junit.Assert.assertNotNull(charArray52);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray52), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray52), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray52), "[ ]");
        org.junit.Assert.assertNotNull(charArray53);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray53), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray53), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray53), "[#]");
        org.junit.Assert.assertNotNull(charArray56);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray56), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray56), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray56), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray61);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray61), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray61), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray61), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray64);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray64), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray64), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray64), "[]");
        org.junit.Assert.assertNotNull(charArray65);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray65), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray65), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray65), "[]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder66);
        org.junit.Assert.assertNotNull(floatArray72);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray72), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + float73 + "' != '" + 1.0f + "'", float73 == 1.0f);
        org.junit.Assert.assertTrue("'" + javaVersion74 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion74.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion75 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion75.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate76);
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + false + "'", boolean78 == false);
        org.junit.Assert.assertNotNull(floatArray79);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray79), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertNotNull(floatArray83);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray83), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray90);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray90), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean91 + "' != '" + false + "'", boolean91 == false);
        org.junit.Assert.assertNotNull(floatArray93);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray93), "[0.0, 32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder94);
    }

    @Test
    public void test1127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1127");
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
        boolean boolean17 = javaVersionRange2.isOverlappedBy(javaVersionRange16);
        org.apache.commons.lang3.JavaVersion javaVersion18 = org.apache.commons.lang3.JavaVersion.JAVA_21;
        boolean boolean19 = javaVersionRange16.contains(javaVersion18);
        java.lang.String[] strArray24 = org.apache.commons.lang3.StringUtils.splitByWholeSeparatorPreserveAllTokens("0\n0", "                                                                                                open");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle25 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer29 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray30 = strTokenizer29.getTokenArray();
        java.lang.String str31 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle25, strArray30);
        java.lang.String[] strArray33 = org.apache.commons.lang3.StringUtils.stripAll(strArray30, "UnicodeUnescaper");
        java.lang.String str34 = org.apache.commons.lang3.StringUtils.replaceEach("6f51daee", strArray24, strArray33);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj35 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) javaVersion18, "                                                                                                open", (java.lang.Object[]) strArray33);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method:                                                                                                 open() on object: org.apache.commons.lang3.JavaVersion");
        } catch (java.lang.NoSuchMethodException e) {
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
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertTrue("'" + javaVersion18 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_21 + "'", javaVersion18.equals(org.apache.commons.lang3.JavaVersion.JAVA_21));
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertNotNull(strArray24);
        org.junit.Assert.assertNotNull(strArray30);
        org.junit.Assert.assertNotNull(strArray33);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + "6f51daee" + "'", str34, "6f51daee");
    }

    @Test
    public void test1128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1128");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = strTokenizer3.reset("");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle6 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer10 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray11 = strTokenizer10.getTokenArray();
        java.lang.String str12 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle6, strArray11);
        java.lang.String str16 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray11, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int17 = org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode((java.lang.Object) strTokenizer3, strArray11);
        org.junit.Assert.assertNotNull(strTokenizer5);
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
// flaky:         org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-981035596) + "'", int17 == (-981035596));
    }

    @Test
    public void test1129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1129");
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
        boolean boolean15 = standardToStringStyle4.isUseFieldNames();
        org.junit.Assert.assertNotNull(intStream1);
        org.junit.Assert.assertNotNull(intStream3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test1130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1130");
        float[] floatArray3 = new float[] { 100.0f, 0.0f, 100L };
        org.apache.commons.lang3.ArrayUtils.shift(floatArray3, (int) (short) 100);
        float[] floatArray6 = org.apache.commons.lang3.ArraySorter.sort(floatArray3);
        float[] floatArray7 = org.apache.commons.lang3.ArrayUtils.clone(floatArray6);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj10 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) floatArray6, false, "org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on");
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: org.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: hi!org.apache.commons.lang3.NotImplementedException: org.apache.commons.lang3.concurrent.UncheckedExecutionExceptionorg.apache.commons.lang3.NotImplementedException: onorg.apache.commons.lang3.NotImplementedException: on() on object: [F");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[0.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray6), "[0.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray7), "[0.0, 100.0, 100.0]");
    }

    @Test
    public void test1131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1131");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer3 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray4 = strTokenizer3.getTokenArray();
        org.apache.commons.lang3.text.StrMatcher strMatcher5 = org.apache.commons.lang3.text.StrMatcher.tabMatcher();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer6 = strTokenizer3.setIgnoredMatcher(strMatcher5);
        org.apache.commons.lang3.text.StrMatcher[] strMatcherArray7 = new org.apache.commons.lang3.text.StrMatcher[] { strMatcher5 };
        org.apache.commons.lang3.text.StrMatcher[] strMatcherArray8 = org.apache.commons.lang3.ObjectUtils.requireNonEmpty(strMatcherArray7);
        org.junit.Assert.assertNotNull(strArray4);
        org.junit.Assert.assertNotNull(strMatcher5);
        org.junit.Assert.assertNotNull(strTokenizer6);
        org.junit.Assert.assertNotNull(strMatcherArray7);
        org.junit.Assert.assertNotNull(strMatcherArray8);
    }

    @Test
    public void test1132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1132");
        java.lang.String str1 = org.apache.commons.lang3.BooleanUtils.toStringYesNo(true);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "yes" + "'", str1, "yes");
    }

    @Test
    public void test1133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1133");
        org.apache.commons.lang3.function.FailableIntPredicate failableIntPredicate0 = org.apache.commons.lang3.function.FailableIntPredicate.TRUE;
        org.apache.commons.lang3.function.FailableIntPredicate[] failableIntPredicateArray1 = new org.apache.commons.lang3.function.FailableIntPredicate[] { failableIntPredicate0 };
        org.apache.commons.lang3.function.FailableIntPredicate failableIntPredicate2 = org.apache.commons.lang3.function.FailableIntPredicate.TRUE;
        org.apache.commons.lang3.function.FailableIntPredicate[] failableIntPredicateArray3 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(failableIntPredicateArray1, failableIntPredicate2);
        java.util.stream.IntStream intStream5 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream7 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle8 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle9 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str10 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle8, toStringStyle9);
        java.lang.StringBuffer stringBuffer11 = null;
        java.lang.Object obj12 = null;
        standardToStringStyle8.appendStart(stringBuffer11, obj12);
        java.lang.String str14 = standardToStringStyle8.getNullText();
        standardToStringStyle8.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder18 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream5, (java.lang.AutoCloseable) intStream7, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle8, true);
        org.apache.commons.lang3.text.StrTokenizer strTokenizer22 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray23 = strTokenizer22.getTokenArray();
        boolean boolean24 = strTokenizer22.isEmptyTokenAsNull();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer26 = strTokenizer22.setIgnoredChar('\n');
        org.apache.commons.lang3.tuple.ImmutableTriple<org.apache.commons.lang3.function.FailableIntPredicate[], java.util.stream.IntStream, java.util.ListIterator<java.lang.String>> failableIntPredicateArrayImmutableTriple27 = org.apache.commons.lang3.tuple.ImmutableTriple.ofNonNull(failableIntPredicateArray1, intStream5, (java.util.ListIterator<java.lang.String>) strTokenizer22);
        java.lang.String str29 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) failableIntPredicateArray1, ' ');
        org.junit.Assert.assertNotNull(failableIntPredicate0);
        org.junit.Assert.assertNotNull(failableIntPredicateArray1);
        org.junit.Assert.assertNotNull(failableIntPredicate2);
        org.junit.Assert.assertNotNull(failableIntPredicateArray3);
        org.junit.Assert.assertNotNull(intStream5);
        org.junit.Assert.assertNotNull(intStream7);
        org.junit.Assert.assertNotNull(toStringStyle9);
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str10, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str14 + "' != '" + "<null>" + "'", str14, "<null>");
        org.junit.Assert.assertNotNull(strArray23);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertNotNull(strTokenizer26);
        org.junit.Assert.assertNotNull(failableIntPredicateArrayImmutableTriple27);
    }

    @Test
    public void test1134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1134");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.defaultString("en");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "en" + "'", str1, "en");
    }

    @Test
    public void test1135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1135");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        boolean[] booleanArray17 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray19 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray17, false);
        java.util.BitSet bitSet21 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray17, true);
        boolean[] booleanArray22 = org.apache.commons.lang3.ArrayUtils.removeElements(booleanArray11, booleanArray17);
        int int24 = org.apache.commons.lang3.ArrayUtils.indexOf(booleanArray22, false);
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
        org.junit.Assert.assertTrue("'" + int24 + "' != '" + (-1) + "'", int24 == (-1));
    }

    @Test
    public void test1136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1136");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate2 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion0, javaVersion1);
        org.apache.commons.lang3.JavaVersion javaVersion3 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean4 = javaVersion1.atLeast(javaVersion3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read field \"value\" because \"requiredVersion\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate2);
    }

    @Test
    public void test1137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1137");
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
        boolean boolean17 = javaVersionRange2.isOverlappedBy(javaVersionRange16);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange18 = org.apache.commons.lang3.ObjectUtils.cloneIfPossible(javaVersionRange2);
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
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + true + "'", boolean17 == true);
        org.junit.Assert.assertNotNull(javaVersionRange18);
    }

    @Test
    public void test1138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1138");
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
        java.lang.String str27 = org.apache.commons.lang3.ClassUtils.getCanonicalName(multiBackgroundInitializerResultsFailableSupplierClass13);
        java.lang.String str29 = org.apache.commons.lang3.ClassUtils.getSimpleName(multiBackgroundInitializerResultsFailableSupplierClass13, "11.5");
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
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "org.apache.commons.lang3.concurrent.MultiBackgroundInitializer" + "'", str27, "org.apache.commons.lang3.concurrent.MultiBackgroundInitializer");
        org.junit.Assert.assertEquals("'" + str29 + "' != '" + "MultiBackgroundInitializer" + "'", str29, "MultiBackgroundInitializer");
    }

    @Test
    public void test1139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1139");
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
        java.lang.String str27 = org.apache.commons.lang3.ClassUtils.getCanonicalName(multiBackgroundInitializerResultsFailableSupplierClass13);
        boolean boolean28 = org.apache.commons.lang3.ClassUtils.isInnerClass(multiBackgroundInitializerResultsFailableSupplierClass13);
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
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "org.apache.commons.lang3.concurrent.MultiBackgroundInitializer" + "'", str27, "org.apache.commons.lang3.concurrent.MultiBackgroundInitializer");
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test1140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1140");
        org.apache.commons.lang3.function.FailableConsumer<java.lang.Long[], org.apache.commons.lang3.exception.ContextedException> longArrayFailableConsumer0 = org.apache.commons.lang3.function.FailableConsumer.nop();
        org.junit.Assert.assertNotNull(longArrayFailableConsumer0);
    }

    @Test
    public void test1141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1141");
        org.apache.commons.lang3.arch.Processor.Arch arch0 = null;
        org.apache.commons.lang3.arch.Processor.Type type1 = org.apache.commons.lang3.arch.Processor.Type.PPC;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.arch.Processor.Type> typeRange2 = org.apache.commons.lang3.Range.is(type1);
        org.apache.commons.lang3.arch.Processor processor3 = new org.apache.commons.lang3.arch.Processor(arch0, type1);
        org.apache.commons.lang3.arch.Processor.Type type4 = processor3.getType();
        org.apache.commons.lang3.arch.Processor.Arch arch5 = processor3.getArch();
        org.apache.commons.lang3.arch.Processor.Type type6 = processor3.getType();
        boolean boolean7 = processor3.is64Bit();
        org.junit.Assert.assertTrue("'" + type1 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type1.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNotNull(typeRange2);
        org.junit.Assert.assertTrue("'" + type4 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type4.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertNull(arch5);
        org.junit.Assert.assertTrue("'" + type6 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.PPC + "'", type6.equals(org.apache.commons.lang3.arch.Processor.Type.PPC));
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test1142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1142");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.trimToNull("FastDateFormat[yyyy-MM-dd,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "FastDateFormat[yyyy-MM-dd,en_SE,Europe/Stockholm]" + "'", str1, "FastDateFormat[yyyy-MM-dd,en_SE,Europe/Stockholm]");
    }

    @Test
    public void test1143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1143");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_BIG_SUR;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test1144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1144");
        float[] floatArray6 = new float[] { (short) 1, (short) 100, 1.0f, '4' };
        float float7 = org.apache.commons.lang3.math.NumberUtils.min(floatArray6);
        org.apache.commons.lang3.JavaVersion javaVersion8 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion9 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate10 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion8, javaVersion9);
        boolean boolean12 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) floatArray6, (java.lang.Object) javaVersionPredicate10, false);
        float[] floatArray17 = new float[] { (short) 1, (short) 100, 1.0f, '4' };
        float float18 = org.apache.commons.lang3.math.NumberUtils.min(floatArray17);
        org.apache.commons.lang3.JavaVersion javaVersion19 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion20 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate21 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion19, javaVersion20);
        boolean boolean23 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) floatArray17, (java.lang.Object) javaVersionPredicate21, false);
        float[] floatArray28 = new float[] { (short) 1, (short) 100, 1.0f, '4' };
        float float29 = org.apache.commons.lang3.math.NumberUtils.min(floatArray28);
        org.apache.commons.lang3.JavaVersion javaVersion30 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion31 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate32 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion30, javaVersion31);
        boolean boolean34 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) floatArray28, (java.lang.Object) javaVersionPredicate32, false);
        org.apache.commons.lang3.JavaVersion javaVersion35 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion36 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate37 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion35, javaVersion36);
        java.util.function.Predicate[] predicateArray39 = new java.util.function.Predicate[4];
        @SuppressWarnings("unchecked")
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion>[] javaVersionPredicateArray40 = (java.util.function.Predicate<org.apache.commons.lang3.JavaVersion>[]) predicateArray39;
        javaVersionPredicateArray40[0] = javaVersionPredicate10;
        javaVersionPredicateArray40[1] = javaVersionPredicate21;
        javaVersionPredicateArray40[2] = javaVersionPredicate32;
        javaVersionPredicateArray40[3] = javaVersionPredicate37;
        java.util.stream.Stream<java.util.function.Predicate<org.apache.commons.lang3.JavaVersion>> javaVersionPredicateStream49 = org.apache.commons.lang3.stream.Streams.nonNull(javaVersionPredicateArray40);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.isTrue(false, "                                                                                                  100", (java.lang.Object[]) javaVersionPredicateArray40);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message:                                                                                                   100");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(floatArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray6), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + float7 + "' != '" + 1.0f + "'", float7 == 1.0f);
        org.junit.Assert.assertTrue("'" + javaVersion8 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion8.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion9 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion9.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(floatArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray17), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + float18 + "' != '" + 1.0f + "'", float18 == 1.0f);
        org.junit.Assert.assertTrue("'" + javaVersion19 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion19.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion20 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion20.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate21);
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertNotNull(floatArray28);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray28), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + float29 + "' != '" + 1.0f + "'", float29 == 1.0f);
        org.junit.Assert.assertTrue("'" + javaVersion30 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion30.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion31 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion31.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate32);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
        org.junit.Assert.assertTrue("'" + javaVersion35 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion35.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion36 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion36.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate37);
        org.junit.Assert.assertNotNull(predicateArray39);
        org.junit.Assert.assertNotNull(javaVersionPredicateArray40);
        org.junit.Assert.assertNotNull(javaVersionPredicateStream49);
    }

    @Test
    public void test1145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1145");
        int int0 = org.apache.commons.lang3.time.FastDatePrinter.MEDIUM;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 2 + "'", int0 == 2);
    }

    @Test
    public void test1146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1146");
        double[] doubleArray4 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray8 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray8, (double) '4');
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray4, doubleArray8);
        java.util.BitSet bitSet14 = org.apache.commons.lang3.ArrayUtils.indexesOf(doubleArray4, (double) (-1.0f), 0);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray4), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray8), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(bitSet14);
        org.junit.Assert.assertEquals(bitSet14.toString(), "{2}");
    }

    @Test
    public void test1147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1147");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str2 = org.apache.commons.lang3.RandomStringUtils.randomNumeric((int) '\r', (int) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Start value must be smaller or equal to end value.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1148");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaHome();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "/Library/Java/JavaVirtualMachines/adoptopenjdk-16.jdk/Contents/Home" + "'", str0, "/Library/Java/JavaVirtualMachines/adoptopenjdk-16.jdk/Contents/Home");
    }

    @Test
    public void test1149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1149");
        java.util.Calendar calendar0 = null;
        // The following exception was thrown during execution in test generation
        try {
            long long2 = org.apache.commons.lang3.time.DateUtils.getFragmentInDays(calendar0, 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: calendar");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1150");
        java.util.Locale[] localeArray0 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList1 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean2 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList1, localeArray0);
        java.net.URL[] uRLArray4 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection5 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList1, "Integer", (java.lang.Object[]) uRLArray4);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream6 = org.apache.commons.lang3.stream.Streams.failableStream(localeCollection5);
        org.junit.Assert.assertNotNull(localeArray0);
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + false + "'", boolean2 == false);
        org.junit.Assert.assertNotNull(uRLArray4);
        org.junit.Assert.assertNotNull(localeCollection5);
        org.junit.Assert.assertNotNull(localeFailableStream6);
    }

    @Test
    public void test1151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1151");
        org.apache.commons.lang3.compare.ObjectToStringComparator objectToStringComparator0 = new org.apache.commons.lang3.compare.ObjectToStringComparator();
        org.apache.commons.lang3.compare.ObjectToStringComparator objectToStringComparator1 = org.apache.commons.lang3.ObjectUtils.clone(objectToStringComparator0);
        org.junit.Assert.assertNull(objectToStringComparator1);
    }

    @Test
    public void test1152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1152");
        java.util.Date date0 = null;
        java.util.TimeZone timeZone5 = org.apache.commons.lang3.time.FastTimeZone.getGmtTimeZone();
        java.util.Locale locale6 = null;
        java.util.Locale locale7 = org.apache.commons.lang3.LocaleUtils.toLocale(locale6);
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat8 = org.apache.commons.lang3.time.FastDateFormat.getTimeInstance(0, timeZone5, locale6);
        java.util.TimeZone timeZone12 = org.apache.commons.lang3.time.FastTimeZone.getTimeZone("java.awt.headless");
        java.util.Locale locale14 = null;
        java.util.Locale locale15 = org.apache.commons.lang3.LocaleUtils.toLocale(locale14);
        java.lang.String str16 = org.apache.commons.lang3.StringUtils.lowerCase("user.name", locale15);
        java.lang.String str17 = org.apache.commons.lang3.time.DateFormatUtils.format((long) (-5), "", timeZone12, locale15);
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat18 = org.apache.commons.lang3.time.FastDateFormat.getDateTimeInstance((int) (short) 1, 0, timeZone5, locale15);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str19 = org.apache.commons.lang3.time.DateFormatUtils.format(date0, "pen", locale15);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: p");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(timeZone5);
        org.junit.Assert.assertEquals(timeZone5.getDisplayName(), "GMT+00:00");
        org.junit.Assert.assertNotNull(locale7);
        org.junit.Assert.assertEquals(locale7.toString(), "en_SE");
        org.junit.Assert.assertNotNull(fastDateFormat8);
        org.junit.Assert.assertNotNull(timeZone12);
        org.junit.Assert.assertEquals(timeZone12.getDisplayName(), "Greenwich Mean Time");
        org.junit.Assert.assertNotNull(locale15);
        org.junit.Assert.assertEquals(locale15.toString(), "en_SE");
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "user.name" + "'", str16, "user.name");
        org.junit.Assert.assertEquals("'" + str17 + "' != '" + "" + "'", str17, "");
        org.junit.Assert.assertNotNull(fastDateFormat18);
    }

    @Test
    public void test1153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1153");
        long long0 = org.apache.commons.lang3.time.DateUtils.MILLIS_PER_DAY;
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + 86400000L + "'", long0 == 86400000L);
    }

    @Test
    public void test1154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1154");
        float[] floatArray3 = new float[] { 100.0f, 0.0f, 100L };
        org.apache.commons.lang3.ArrayUtils.shift(floatArray3, (int) (short) 100);
        float[] floatArray6 = org.apache.commons.lang3.ArraySorter.sort(floatArray3);
        org.apache.commons.lang3.ArrayUtils.reverse(floatArray3, (int) '4', (int) (short) 10);
        float[] floatArray13 = new float[] { 100.0f, 0.0f, 100L };
        org.apache.commons.lang3.ArrayUtils.shift(floatArray13, (int) (short) 100);
        float[] floatArray16 = org.apache.commons.lang3.ArrayUtils.addAll(floatArray3, floatArray13);
        float[] floatArray17 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(floatArray3);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[0.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray6), "[0.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray13), "[100.0, 100.0, 0.0]");
        org.junit.Assert.assertNotNull(floatArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray16), "[0.0, 100.0, 100.0, 100.0, 100.0, 0.0]");
        org.junit.Assert.assertNotNull(floatArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray17), "[0.0, 100.0, 100.0]");
    }

    @Test
    public void test1155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1155");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_10;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test1156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1156");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.abbreviateMiddle("user.region", "ava.specif", (-1));
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "user.region" + "'", str3, "user.region");
    }

    @Test
    public void test1157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1157");
        int[] intArray5 = new int[] { (short) 100, (short) 10, (short) 10, '\n', '\n' };
        int[] intArray7 = org.apache.commons.lang3.ArrayUtils.add(intArray5, (int) '4');
        java.util.BitSet bitSet10 = org.apache.commons.lang3.ArrayUtils.indexesOf(intArray5, (int) '6', 99);
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray5), "[100, 10, 10, 10, 10]");
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray7), "[100, 10, 10, 10, 10, 52]");
        org.junit.Assert.assertNotNull(bitSet10);
        org.junit.Assert.assertEquals(bitSet10.toString(), "{}");
    }

    @Test
    public void test1158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1158");
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext0 = new org.apache.commons.lang3.exception.DefaultExceptionContext();
        org.apache.commons.lang3.function.FailableBiConsumer<java.io.File, org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.RuntimeException> fileFailableBiConsumer2 = org.apache.commons.lang3.function.FailableBiConsumer.nop();
        org.apache.commons.lang3.exception.DefaultExceptionContext defaultExceptionContext3 = defaultExceptionContext0.addContextValue("\n", (java.lang.Object) fileFailableBiConsumer2);
        java.lang.Object obj5 = defaultExceptionContext0.getFirstContextValue("java.lang");
        org.junit.Assert.assertNotNull(fileFailableBiConsumer2);
        org.junit.Assert.assertNotNull(defaultExceptionContext3);
        org.junit.Assert.assertNull(obj5);
    }

    @Test
    public void test1159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1159");
        int int0 = org.apache.commons.lang3.time.DateUtils.RANGE_WEEK_RELATIVE;
        org.junit.Assert.assertTrue("'" + int0 + "' != '" + 3 + "'", int0 == 3);
    }

    @Test
    public void test1160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1160");
        java.lang.String[] strArray7 = new java.lang.String[] { "java.lang", "                                                                                                open", "60.0", "16.0.1", ":", "Integer" };
        org.apache.commons.lang3.CharSet charSet8 = org.apache.commons.lang3.CharSet.getInstance(strArray7);
        java.lang.String str9 = org.apache.commons.lang3.CharSetUtils.delete("OpenJDK 64-Bit Server VM", strArray7);
        java.lang.String str11 = org.apache.commons.lang3.ClassUtils.getCanonicalName((java.lang.Object) strArray7, "/Users/glacierali/randoop-4.3.2");
        org.junit.Assert.assertNotNull(strArray7);
        org.junit.Assert.assertNotNull(charSet8);
        org.junit.Assert.assertEquals("'" + str9 + "' != '" + "OJDK4-BiSVM" + "'", str9, "OJDK4-BiSVM");
        org.junit.Assert.assertEquals("'" + str11 + "' != '" + "java.lang.String[]" + "'", str11, "java.lang.String[]");
    }

    @Test
    public void test1161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1161");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle1 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer5 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray6 = strTokenizer5.getTokenArray();
        java.lang.String str7 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle1, strArray6);
        java.lang.String[] strArray9 = org.apache.commons.lang3.StringUtils.stripAll(strArray6, "UnicodeUnescaper");
        java.lang.Object obj10 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer11 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService12 = multiBackgroundInitializer11.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle15 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer19 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray20 = strTokenizer19.getTokenArray();
        java.lang.String str21 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle15, strArray20);
        java.lang.String str25 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray20, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int26 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray20);
        boolean boolean27 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray20);
        boolean boolean28 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj10, (java.lang.Object) executorService12, strArray20);
        java.lang.Object[] objArray29 = org.apache.commons.lang3.ArrayUtils.nullToEmpty((java.lang.Object[]) strArray20);
        java.lang.String str30 = org.apache.commons.lang3.StringUtils.replaceEachRepeatedly("java.vm.version", strArray6, strArray20);
        org.junit.Assert.assertNotNull(strArray6);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertNull(executorService12);
        org.junit.Assert.assertNotNull(strArray20);
        org.junit.Assert.assertEquals("'" + str25 + "' != '" + "" + "'", str25, "");
        org.junit.Assert.assertTrue("'" + int26 + "' != '" + (-1) + "'", int26 == (-1));
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
        org.junit.Assert.assertNotNull(objArray29);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray29), "[581cd446]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray29), "[581cd446]");
        org.junit.Assert.assertEquals("'" + str30 + "' != '" + "java.vm.version" + "'", str30, "java.vm.version");
    }

    @Test
    public void test1162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1162");
        org.apache.commons.lang3.text.StrTokenizer strTokenizer0 = new org.apache.commons.lang3.text.StrTokenizer();
        org.apache.commons.lang3.text.StrMatcher strMatcher1 = org.apache.commons.lang3.text.StrMatcher.doubleQuoteMatcher();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer2 = strTokenizer0.setTrimmerMatcher(strMatcher1);
        org.apache.commons.lang3.text.StrTokenizer strTokenizer4 = strTokenizer0.setDelimiterString(".]Wr1`~U#8P1RR^y~QA|^cKs1{%\\1T?5lK0:E`Sb.&C>Ti|7U`_rdX-~ezvoa,]'Y`!G4\"%H.wF)`\",%`~,Oq)sru73.75Tg2");
        org.junit.Assert.assertNotNull(strMatcher1);
        org.junit.Assert.assertNotNull(strTokenizer2);
        org.junit.Assert.assertNotNull(strTokenizer4);
    }

    @Test
    public void test1163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1163");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        float[] floatArray13 = org.apache.commons.lang3.ArrayUtils.remove(floatArray3, 1);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(floatArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray13), "[-1.0, 101.0]");
    }

    @Test
    public void test1164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1164");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.inclusiveBetween((double) 10.0f, (double) '#', (double) 101.0f, "GMT");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: GMT");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1165");
        byte[] byteArray1 = org.apache.commons.lang3.SerializationUtils.serialize((java.io.Serializable) (short) 100);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray1), "[-84, -19, 0, 5, 115, 114, 0, 15, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 104, 111, 114, 116, 104, 77, 55, 19, 52, 96, -38, 82, 2, 0, 1, 83, 0, 5, 118, 97, 108, 117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101, 114, -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 0, 100]");
    }

    @Test
    public void test1166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1166");
        java.lang.String str1 = org.apache.commons.lang3.text.translate.CharSequenceTranslator.hex((int) (short) 0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "0" + "'", str1, "0");
    }

    @Test
    public void test1167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1167");
        org.apache.commons.lang3.util.FluentBitSet fluentBitSet0 = new org.apache.commons.lang3.util.FluentBitSet();
        byte[] byteArray1 = fluentBitSet0.toByteArray();
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.util.FluentBitSet fluentBitSet4 = fluentBitSet0.set((int) (short) 100, 2);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: fromIndex: 100 > toIndex: 2");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray1), "[]");
    }

    @Test
    public void test1168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1168");
        org.apache.commons.lang3.tuple.ImmutableTriple<java.lang.String, java.lang.constant.ConstantDesc, java.lang.constant.Constable> strImmutableTriple0 = org.apache.commons.lang3.tuple.ImmutableTriple.nullTriple();
        java.lang.String str2 = strImmutableTriple0.toString("hi!");
        java.lang.constant.ConstantDesc constantDesc3 = strImmutableTriple0.getMiddle();
        org.junit.Assert.assertNotNull(strImmutableTriple0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "hi!" + "'", str2, "hi!");
        org.junit.Assert.assertNull(constantDesc3);
    }

    @Test
    public void test1169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1169");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.replaceChars("581cd446", 'a', 'o');
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "581cd446" + "'", str3, "581cd446");
    }

    @Test
    public void test1170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1170");
        org.apache.commons.lang3.function.FailableIntUnaryOperator failableIntUnaryOperator0 = org.apache.commons.lang3.function.FailableIntUnaryOperator.NOP;
        org.apache.commons.lang3.mutable.MutableInt mutableInt3 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        mutableInt3.setValue((int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.reflect.FieldUtils.writeField((java.lang.Object) failableIntUnaryOperator0, "100", (java.lang.Object) 'a', true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot locate declared field org.apache.commons.lang3.function.FailableIntUnaryOperator$$Lambda$129/0x0000000800cc7490.100");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(failableIntUnaryOperator0);
    }

    @Test
    public void test1171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1171");
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
        boolean boolean15 = multiBackgroundInitializer9.isInitialized();
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test1172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1172");
        long long3 = org.apache.commons.lang3.math.NumberUtils.min((long) (short) 10, (long) (-5), (long) (short) -1);
        org.junit.Assert.assertTrue("'" + long3 + "' != '" + (-5L) + "'", long3 == (-5L));
    }

    @Test
    public void test1173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1173");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.truncate("", 100, (int) (short) 100);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "" + "'", str3, "");
    }

    @Test
    public void test1174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1174");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.unescapeEcmaScript("0\n0");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "0\n0" + "'", str1, "0\n0");
    }

    @Test
    public void test1175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1175");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        org.apache.commons.lang3.ArrayUtils.swap(byteArray2, (int) 'o', (-27));
        byte byte7 = org.apache.commons.lang3.math.NumberUtils.max(byteArray2);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertTrue("'" + byte7 + "' != '" + (byte) 0 + "'", byte7 == (byte) 0);
    }

    @Test
    public void test1176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1176");
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
        org.apache.commons.lang3.JavaVersion javaVersion20 = javaVersionRange19.getMinimum();
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
        org.junit.Assert.assertTrue("'" + javaVersion20 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion20.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
    }

    @Test
    public void test1177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1177");
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
        org.apache.commons.lang3.builder.ToStringBuilder.setDefaultStyle((org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle4);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair1);
        org.junit.Assert.assertNull(charSequenceArray2);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
    }

    @Test
    public void test1178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1178");
        java.lang.Byte[] byteArray0 = new java.lang.Byte[] {};
        byte[] byteArray2 = org.apache.commons.lang3.ArrayUtils.toPrimitive(byteArray0, (byte) 10);
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.toPrimitive(byteArray0);
        java.util.Map<java.lang.Object, java.lang.Object> objMap4 = org.apache.commons.lang3.ArrayUtils.toMap((java.lang.Object[]) byteArray0);
        org.junit.Assert.assertNotNull(byteArray0);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[]");
        org.junit.Assert.assertNotNull(objMap4);
    }

    @Test
    public void test1179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1179");
        org.apache.commons.lang3.mutable.MutableShort mutableShort1 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort1.setValue((java.lang.Number) (short) 100);
        java.lang.String str4 = mutableShort1.toString();
        mutableShort1.add((java.lang.Number) (byte) 0);
        short short7 = mutableShort1.getAndDecrement();
        mutableShort1.subtract((short) (byte) 0);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "100" + "'", str4, "100");
        org.junit.Assert.assertTrue("'" + short7 + "' != '" + (short) 100 + "'", short7 == (short) 100);
    }

    @Test
    public void test1180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1180");
        byte[] byteArray4 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray4);
        byte[] byteArray8 = org.apache.commons.lang3.Conversion.shortToByteArray((short) (byte) -1, 0, byteArray5, (-27), (int) (short) 0);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray10 = org.apache.commons.lang3.ArrayUtils.remove(byteArray5, (int) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 100, Length: 2");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray4), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray8), "[0, -1]");
    }

    @Test
    public void test1181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1181");
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle2 = null;
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder3 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle2);
        org.apache.commons.lang3.function.FailableIntFunction<org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.RuntimeException> recursiveToStringStyleFailableIntFunction4 = org.apache.commons.lang3.function.FailableIntFunction.nop();
        org.apache.commons.lang3.tuple.Pair<org.apache.commons.lang3.builder.Builder<org.apache.commons.lang3.builder.DiffResult<java.io.Serializable>>, org.apache.commons.lang3.function.FailableIntFunction<org.apache.commons.lang3.builder.RecursiveToStringStyle, java.lang.RuntimeException>> serializableDiffResultBuilderPair5 = org.apache.commons.lang3.tuple.Pair.ofNonNull((org.apache.commons.lang3.builder.Builder<org.apache.commons.lang3.builder.DiffResult<java.io.Serializable>>) serializableReflectionDiffBuilder3, recursiveToStringStyleFailableIntFunction4);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.builder.DiffResult<java.io.Serializable> serializableDiffResult6 = serializableReflectionDiffBuilder3.build();
            org.junit.Assert.fail("Expected exception of type java.lang.reflect.InaccessibleObjectException; message: Unable to make field private final byte java.lang.Byte.value accessible: module java.base does not \"opens java.lang\" to unnamed module @654b5005");
        } catch (java.lang.reflect.InaccessibleObjectException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(recursiveToStringStyleFailableIntFunction4);
        org.junit.Assert.assertNotNull(serializableDiffResultBuilderPair5);
    }

    @Test
    public void test1182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1182");
        org.apache.commons.lang3.function.FailableLongFunction<org.apache.commons.lang3.time.FastDateFormat, java.lang.Throwable> fastDateFormatFailableLongFunction0 = org.apache.commons.lang3.function.FailableLongFunction.nop();
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = fastDateFormatFailableLongFunction0.apply((long) (-1));
        org.junit.Assert.assertNotNull(fastDateFormatFailableLongFunction0);
        org.junit.Assert.assertNull(fastDateFormat2);
    }

    @Test
    public void test1183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1183");
        short short2 = org.apache.commons.lang3.math.NumberUtils.toShort("16.0.1", (short) 0);
        org.junit.Assert.assertTrue("'" + short2 + "' != '" + (short) 0 + "'", short2 == (short) 0);
    }

    @Test
    public void test1184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1184");
        org.apache.commons.lang3.mutable.MutableByte mutableByte0 = new org.apache.commons.lang3.mutable.MutableByte();
        mutableByte0.setValue((byte) 10);
        org.apache.commons.lang3.mutable.MutableByte mutableByte3 = new org.apache.commons.lang3.mutable.MutableByte();
        mutableByte3.setValue((byte) 10);
        int int6 = mutableByte0.compareTo(mutableByte3);
        long long7 = mutableByte0.longValue();
        mutableByte0.subtract((byte) 10);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
        org.junit.Assert.assertTrue("'" + long7 + "' != '" + 10L + "'", long7 == 10L);
    }

    @Test
    public void test1185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1185");
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
        java.text.ParsePosition parsePosition15 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj16 = compositeFormat13.parseObject("\ufffd\ufffd\001\000\n", parsePosition15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.text.ParsePosition.getIndex()\" because \"pos\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
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
    }

    @Test
    public void test1186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1186");
        org.apache.commons.lang3.function.FailableLongConsumer failableLongConsumer0 = org.apache.commons.lang3.function.FailableLongConsumer.NOP;
        org.junit.Assert.assertNotNull(failableLongConsumer0);
    }

    @Test
    public void test1187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1187");
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
        org.apache.commons.lang3.text.StrTokenizer strTokenizer29 = org.apache.commons.lang3.text.StrTokenizer.getTSVInstance("java.vm.vendor");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.reflect.FieldUtils.writeDeclaredStaticField(multiBackgroundInitializerResultsFailableSupplierClass13, "user.name", (java.lang.Object) strTokenizer29, false);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot locate declared field org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.user.name");
        } catch (java.lang.NullPointerException e) {
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
        org.junit.Assert.assertNotNull(strTokenizer29);
    }

    @Test
    public void test1188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1188");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        java.lang.String str1 = fastDateFormat0.toString();
        java.lang.String[] strArray2 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray4 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray2, (java.lang.CharSequence) "Integer");
        boolean boolean5 = fastDateFormat0.equals((java.lang.Object) charSequenceArray4);
        java.text.ParsePosition parsePosition7 = null;
        java.util.Calendar calendar8 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean9 = fastDateFormat0.parse("user.name", parsePosition7, calendar8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.text.ParsePosition.getIndex()\" because \"pos\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]" + "'", str1, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertNotNull(strArray2);
        org.junit.Assert.assertNotNull(charSequenceArray4);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test1189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1189");
        org.apache.commons.lang3.text.StrBuilder strBuilder1 = new org.apache.commons.lang3.text.StrBuilder("java.ext.dirs");
        org.apache.commons.lang3.text.StrBuilder strBuilder3 = strBuilder1.deleteFirst('o');
        boolean boolean5 = org.apache.commons.lang3.StringUtils.endsWithIgnoreCase((java.lang.CharSequence) strBuilder1, (java.lang.CharSequence) "M16.0.1M");
        org.junit.Assert.assertNotNull(strBuilder3);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test1190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1190");
        int int2 = org.apache.commons.lang3.StringUtils.countMatches((java.lang.CharSequence) "java.ext.dirs", (java.lang.CharSequence) "java.vm.specification.name");
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 0 + "'", int2 == 0);
    }

    @Test
    public void test1191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1191");
        double double2 = org.apache.commons.lang3.math.IEEE754rUtils.max((double) (short) 1, (double) 100);
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 100.0d + "'", double2 == 100.0d);
    }

    @Test
    public void test1192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1192");
        java.util.Locale locale0 = null;
        java.util.Locale locale1 = org.apache.commons.lang3.LocaleUtils.toLocale(locale0);
        boolean boolean2 = org.apache.commons.lang3.LocaleUtils.isLanguageUndetermined(locale0);
        org.junit.Assert.assertNotNull(locale1);
        org.junit.Assert.assertEquals(locale1.toString(), "en_SE");
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test1193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1193");
        long long1 = org.apache.commons.lang3.math.NumberUtils.toLong("hi!");
        org.junit.Assert.assertTrue("'" + long1 + "' != '" + 0L + "'", long1 == 0L);
    }

    @Test
    public void test1194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1194");
        double[] doubleArray5 = new double[] { 1.0d, 2147483647L, 100.0d, 10, 32.0f };
        double[] doubleArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(doubleArray5, 1.0d);
        double[] doubleArray12 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray16 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean18 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray16, (double) '4');
        boolean boolean19 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray12, doubleArray16);
        int int23 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray12, (-1.0d), (int) '\n', (double) 100);
        boolean boolean24 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray7, doubleArray12);
        org.apache.commons.lang3.ArrayUtils.shuffle(doubleArray7);
        double[] doubleArray27 = org.apache.commons.lang3.ArrayUtils.removeElement(doubleArray7, (double) 1.0f);
        java.lang.Double[] doubleArray28 = org.apache.commons.lang3.ArrayUtils.toObject(doubleArray27);
        org.apache.commons.lang3.ArrayUtils.shift(doubleArray27, 97);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[1.0, 2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray7);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray7), "[32.0, 10.0, 100.0, 2.147483647E9]");
        org.junit.Assert.assertNotNull(doubleArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray12), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray16), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(doubleArray27);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray27), "[2.147483647E9, 32.0, 10.0, 100.0]");
        org.junit.Assert.assertNotNull(doubleArray28);
    }

    @Test
    public void test1195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1195");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.toRootLowerCase("");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "" + "'", str1, "");
    }

    @Test
    public void test1196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1196");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.remove("}", 'a');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "}" + "'", str2, "}");
    }

    @Test
    public void test1197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1197");
        org.apache.commons.lang3.text.StrBuilder strBuilder1 = new org.apache.commons.lang3.text.StrBuilder("java.ext.dirs");
        org.apache.commons.lang3.text.StrBuilder strBuilder3 = strBuilder1.deleteFirst('o');
        org.apache.commons.lang3.text.StrBuilder strBuilder5 = strBuilder1.appendln((float) 6);
        org.junit.Assert.assertNotNull(strBuilder3);
        org.junit.Assert.assertNotNull(strBuilder5);
    }

    @Test
    public void test1198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1198");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray1 = charSequenceArrayImmutablePair0.left;
        java.util.Locale locale2 = null;
        java.util.Locale locale3 = org.apache.commons.lang3.LocaleUtils.toLocale(locale2);
        java.util.TimeZone timeZone7 = org.apache.commons.lang3.time.FastTimeZone.getGmtTimeZone();
        java.util.Locale locale8 = null;
        java.util.Locale locale9 = org.apache.commons.lang3.LocaleUtils.toLocale(locale8);
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat10 = org.apache.commons.lang3.time.FastDateFormat.getTimeInstance(0, timeZone7, locale8);
        java.util.TimeZone timeZone14 = org.apache.commons.lang3.time.FastTimeZone.getTimeZone("java.awt.headless");
        java.util.Locale locale16 = null;
        java.util.Locale locale17 = org.apache.commons.lang3.LocaleUtils.toLocale(locale16);
        java.lang.String str18 = org.apache.commons.lang3.StringUtils.lowerCase("user.name", locale17);
        java.lang.String str19 = org.apache.commons.lang3.time.DateFormatUtils.format((long) (-5), "", timeZone14, locale17);
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat20 = org.apache.commons.lang3.time.FastDateFormat.getDateTimeInstance((int) (short) 1, 0, timeZone7, locale17);
        java.util.Locale locale21 = null;
        java.util.Locale locale22 = org.apache.commons.lang3.LocaleUtils.toLocale(locale21);
        java.util.Locale[] localeArray23 = new java.util.Locale[] { locale2, locale17, locale22 };
        java.util.ArrayList<java.util.Locale> localeList24 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean25 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList24, localeArray23);
        // The following exception was thrown during execution in test generation
        try {
            java.util.AbstractCollection<java.util.Locale> localeCollection26 = charSequenceArrayImmutablePair0.setValue((java.util.AbstractCollection<java.util.Locale>) localeList24);
            org.junit.Assert.fail("Expected exception of type java.lang.UnsupportedOperationException; message: null");
        } catch (java.lang.UnsupportedOperationException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(charSequenceArray1);
        org.junit.Assert.assertNotNull(locale3);
        org.junit.Assert.assertEquals(locale3.toString(), "en_SE");
        org.junit.Assert.assertNotNull(timeZone7);
        org.junit.Assert.assertEquals(timeZone7.getDisplayName(), "GMT+00:00");
        org.junit.Assert.assertNotNull(locale9);
        org.junit.Assert.assertEquals(locale9.toString(), "en_SE");
        org.junit.Assert.assertNotNull(fastDateFormat10);
        org.junit.Assert.assertNotNull(timeZone14);
        org.junit.Assert.assertEquals(timeZone14.getDisplayName(), "Greenwich Mean Time");
        org.junit.Assert.assertNotNull(locale17);
        org.junit.Assert.assertEquals(locale17.toString(), "en_SE");
        org.junit.Assert.assertEquals("'" + str18 + "' != '" + "user.name" + "'", str18, "user.name");
        org.junit.Assert.assertEquals("'" + str19 + "' != '" + "" + "'", str19, "");
        org.junit.Assert.assertNotNull(fastDateFormat20);
        org.junit.Assert.assertNotNull(locale22);
        org.junit.Assert.assertEquals(locale22.toString(), "en_SE");
        org.junit.Assert.assertNotNull(localeArray23);
        org.junit.Assert.assertTrue("'" + boolean25 + "' != '" + true + "'", boolean25 == true);
    }

    @Test
    public void test1199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1199");
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
        java.lang.String str27 = org.apache.commons.lang3.ClassUtils.getCanonicalName(multiBackgroundInitializerResultsFailableSupplierClass13);
        boolean boolean28 = org.apache.commons.lang3.reflect.TypeUtils.isArrayType((java.lang.reflect.Type) multiBackgroundInitializerResultsFailableSupplierClass13);
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
        org.junit.Assert.assertEquals("'" + str27 + "' != '" + "org.apache.commons.lang3.concurrent.MultiBackgroundInitializer" + "'", str27, "org.apache.commons.lang3.concurrent.MultiBackgroundInitializer");
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test1200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1200");
        org.apache.commons.lang3.IntegerRange integerRange2 = org.apache.commons.lang3.IntegerRange.of((java.lang.Integer) 2, (java.lang.Integer) (-5));
        org.apache.commons.lang3.IntegerRange integerRange3 = org.apache.commons.lang3.ObjectUtils.CONST(integerRange2);
        java.lang.String str5 = integerRange2.toString("                                                                                                  100");
        org.junit.Assert.assertNotNull(integerRange2);
        org.junit.Assert.assertNotNull(integerRange3);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "                                                                                                  100" + "'", str5, "                                                                                                  100");
    }

    @Test
    public void test1201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1201");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.addMilliseconds(date0, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1202");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.USER_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "user.name" + "'", str0, "user.name");
    }

    @Test
    public void test1203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1203");
        org.apache.commons.lang3.function.BooleanConsumer booleanConsumer0 = org.apache.commons.lang3.function.BooleanConsumer.nop();
        org.apache.commons.lang3.function.BooleanConsumer booleanConsumer1 = org.apache.commons.lang3.function.BooleanConsumer.nop();
        org.apache.commons.lang3.function.BooleanConsumer booleanConsumer2 = booleanConsumer0.andThen(booleanConsumer1);
        org.junit.Assert.assertNotNull(booleanConsumer0);
        org.junit.Assert.assertNotNull(booleanConsumer1);
        org.junit.Assert.assertNotNull(booleanConsumer2);
    }

    @Test
    public void test1204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1204");
        boolean[] booleanArray0 = null;
        // The following exception was thrown during execution in test generation
        try {
            char char1 = org.apache.commons.lang3.Conversion.binaryToHexDigit(booleanArray0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read the array length because \"src\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1205");
        java.lang.reflect.Field field0 = null;
        java.lang.Object obj1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.reflect.FieldUtils.writeStaticField(field0, obj1, true);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: field");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1206");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        int int9 = org.apache.commons.lang3.ArrayUtils.lastIndexOf(booleanArray5, false);
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 4 + "'", int9 == 4);
    }

    @Test
    public void test1207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1207");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setSizeStartText("\000\000");
        standardToStringStyle0.setContentStart("path.separator");
    }

    @Test
    public void test1208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1208");
        java.nio.charset.Charset charset1 = null;
        byte[] byteArray2 = org.apache.commons.lang3.StringUtils.getBytes("os.version", charset1);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[111, 115, 46, 118, 101, 114, 115, 105, 111, 110]");
    }

    @Test
    public void test1209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1209");
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
        java.util.List<java.lang.Class<?>> wildcardClassList18 = org.apache.commons.lang3.ClassUtils.getAllInterfaces(multiBackgroundInitializerResultsFailableSupplierClass13);
        java.util.List<java.lang.Class<?>> wildcardClassList19 = org.apache.commons.lang3.ClassUtils.getAllSuperclasses(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertTrue("'" + interfaces14 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces14.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces15 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces15.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces16 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces16.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertNotNull(wildcardClassIterable17);
        org.junit.Assert.assertNotNull(wildcardClassList18);
        org.junit.Assert.assertNotNull(wildcardClassList19);
    }

    @Test
    public void test1210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1210");
        org.apache.commons.lang3.mutable.MutableInt mutableInt1 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        int int3 = mutableInt1.addAndGet(2);
        org.apache.commons.lang3.mutable.MutableShort mutableShort4 = new org.apache.commons.lang3.mutable.MutableShort((java.lang.Number) 2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 99 + "'", int3 == 99);
    }

    @Test
    public void test1211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1211");
        java.lang.Integer[] intArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
        int[] intArray2 = org.apache.commons.lang3.ArrayUtils.toPrimitive(intArray0, 0);
        org.junit.Assert.assertNotNull(intArray0);
        org.junit.Assert.assertNotNull(intArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray2), "[]");
    }

    @Test
    public void test1212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1212");
        java.lang.String str0 = org.apache.commons.lang3.StringUtils.CR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "\r" + "'", str0, "\r");
    }

    @Test
    public void test1213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1213");
        java.util.function.Consumer<org.apache.commons.lang3.function.FailableDoublePredicate<org.apache.commons.lang3.concurrent.UncheckedExecutionException>> uncheckedExecutionExceptionFailableDoublePredicateConsumer0 = org.apache.commons.lang3.function.Consumers.nop();
        org.junit.Assert.assertNotNull(uncheckedExecutionExceptionFailableDoublePredicateConsumer0);
    }

    @Test
    public void test1214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1214");
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
        char[] charArray47 = org.apache.commons.lang3.ArrayUtils.add(charArray43, (int) (short) 0, ' ');
        char[] charArray50 = new char[] { ' ', '#' };
        char[] charArray52 = new char[] { ' ' };
        char[] charArray53 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray50, charArray52);
        char[] charArray56 = org.apache.commons.lang3.ArrayUtils.add(charArray52, (int) (short) 0, ' ');
        char[] charArray61 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray64 = org.apache.commons.lang3.ArrayUtils.subarray(charArray61, (int) (short) 1, (-1));
        char[] charArray65 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray52, charArray61);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder66 = autoCloseableDiffBuilder14.append("user.name", charArray47, charArray65);
        float[] floatArray72 = new float[] { (short) 1, (short) 100, 1.0f, '4' };
        float float73 = org.apache.commons.lang3.math.NumberUtils.min(floatArray72);
        org.apache.commons.lang3.JavaVersion javaVersion74 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion75 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate76 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion74, javaVersion75);
        boolean boolean78 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) floatArray72, (java.lang.Object) javaVersionPredicate76, false);
        float[] floatArray79 = org.apache.commons.lang3.ArrayUtils.clone(floatArray72);
        float[] floatArray83 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray90 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean91 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray83, floatArray90);
        float[] floatArray93 = org.apache.commons.lang3.ArrayUtils.addFirst(floatArray90, (float) (short) 0);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder94 = autoCloseableDiffBuilder14.append("60.0", floatArray79, floatArray93);
        float[] floatArray95 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(floatArray93);
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
        org.junit.Assert.assertNotNull(charArray47);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray47), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray47), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray47), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray50);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray50), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray50), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray50), "[ , #]");
        org.junit.Assert.assertNotNull(charArray52);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray52), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray52), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray52), "[ ]");
        org.junit.Assert.assertNotNull(charArray53);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray53), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray53), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray53), "[#]");
        org.junit.Assert.assertNotNull(charArray56);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray56), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray56), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray56), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray61);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray61), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray61), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray61), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray64);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray64), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray64), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray64), "[]");
        org.junit.Assert.assertNotNull(charArray65);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray65), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray65), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray65), "[]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder66);
        org.junit.Assert.assertNotNull(floatArray72);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray72), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + float73 + "' != '" + 1.0f + "'", float73 == 1.0f);
        org.junit.Assert.assertTrue("'" + javaVersion74 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion74.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion75 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion75.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate76);
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + false + "'", boolean78 == false);
        org.junit.Assert.assertNotNull(floatArray79);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray79), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertNotNull(floatArray83);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray83), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray90);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray90), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean91 + "' != '" + false + "'", boolean91 == false);
        org.junit.Assert.assertNotNull(floatArray93);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray93), "[0.0, 32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder94);
        org.junit.Assert.assertNotNull(floatArray95);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray95), "[0.0, 32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
    }

    @Test
    public void test1215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1215");
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
        org.apache.commons.lang3.SerializationException serializationException14 = new org.apache.commons.lang3.SerializationException((java.lang.Throwable) notImplementedException13);
        org.apache.commons.lang3.SerializationException serializationException15 = new org.apache.commons.lang3.SerializationException((java.lang.Throwable) notImplementedException13);
        org.apache.commons.lang3.NotImplementedException notImplementedException17 = new org.apache.commons.lang3.NotImplementedException("Long");
        java.lang.Throwable throwable19 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException20 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable19);
        java.lang.Throwable[] throwableArray21 = uncheckedExecutionException20.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException23 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException20, "Integer");
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer24 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService25 = multiBackgroundInitializer24.getExternalExecutor();
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer27 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService28 = multiBackgroundInitializer27.getExternalExecutor();
        multiBackgroundInitializer24.addInitializer("60.0", (org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>) multiBackgroundInitializer27);
        org.apache.commons.lang3.tuple.MutablePair<org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.concurrent.MultiBackgroundInitializer> notImplementedExceptionMutablePair30 = org.apache.commons.lang3.tuple.MutablePair.ofNonNull(notImplementedException23, multiBackgroundInitializer27);
        java.lang.Throwable throwable33 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException34 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable33);
        java.lang.Throwable[] throwableArray35 = uncheckedExecutionException34.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException37 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException34, "Integer");
        org.apache.commons.lang3.NotImplementedException notImplementedException38 = new org.apache.commons.lang3.NotImplementedException("on", (java.lang.Throwable) uncheckedExecutionException34);
        org.apache.commons.lang3.SerializationException serializationException39 = new org.apache.commons.lang3.SerializationException((java.lang.Throwable) notImplementedException38);
        org.apache.commons.lang3.SerializationException serializationException40 = new org.apache.commons.lang3.SerializationException((java.lang.Throwable) notImplementedException38);
        java.lang.Throwable throwable41 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException42 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable41);
        java.lang.Throwable[] throwableArray43 = uncheckedExecutionException42.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException45 = new org.apache.commons.lang3.NotImplementedException((java.lang.Throwable) uncheckedExecutionException42, "os.version");
        boolean boolean46 = org.apache.commons.lang3.exception.ExceptionUtils.isChecked((java.lang.Throwable) notImplementedException45);
        org.apache.commons.lang3.NotImplementedException[] notImplementedExceptionArray47 = new org.apache.commons.lang3.NotImplementedException[] { notImplementedException4, notImplementedException13, notImplementedException17, notImplementedException23, notImplementedException38, notImplementedException45 };
        java.util.concurrent.Future<org.apache.commons.lang3.NotImplementedException[]> notImplementedExceptionArrayFuture48 = org.apache.commons.lang3.concurrent.ConcurrentUtils.constantFuture(notImplementedExceptionArray47);
        org.junit.Assert.assertNotNull(throwableArray2);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertNotNull(throwableArray10);
        org.junit.Assert.assertNotNull(throwableArray21);
        org.junit.Assert.assertNull(executorService25);
        org.junit.Assert.assertNull(executorService28);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair30);
        org.junit.Assert.assertNotNull(throwableArray35);
        org.junit.Assert.assertNotNull(throwableArray43);
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + false + "'", boolean46 == false);
        org.junit.Assert.assertNotNull(notImplementedExceptionArray47);
        org.junit.Assert.assertNotNull(notImplementedExceptionArrayFuture48);
    }

    @Test
    public void test1216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1216");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.chop("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm" + "'", str1, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm");
    }

    @Test
    public void test1217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1217");
        java.util.List<java.util.Locale> localeList0 = org.apache.commons.lang3.LocaleUtils.availableLocaleList();
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream1 = org.apache.commons.lang3.Streams.stream((java.util.Collection<java.util.Locale>) localeList0);
        java.util.stream.Stream<java.util.Locale> localeStream2 = org.apache.commons.lang3.stream.Streams.of((java.lang.Iterable<java.util.Locale>) localeList0);
        java.util.stream.Stream<java.util.Locale> localeStream3 = org.apache.commons.lang3.stream.Streams.nonNull(localeStream2);
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream4 = org.apache.commons.lang3.Functions.stream(localeStream3);
        org.apache.commons.lang3.function.FailableLongFunction<org.apache.commons.lang3.time.FastDateFormat, java.lang.Throwable> fastDateFormatFailableLongFunction5 = org.apache.commons.lang3.function.FailableLongFunction.nop();
        java.lang.String[] strArray12 = new java.lang.String[] { "java.lang", "                                                                                                open", "60.0", "16.0.1", ":", "Integer" };
        org.apache.commons.lang3.CharSet charSet13 = org.apache.commons.lang3.CharSet.getInstance(strArray12);
        org.apache.commons.lang3.tuple.Triple<java.lang.AutoCloseable, org.apache.commons.lang3.function.FailableLongFunction<org.apache.commons.lang3.time.FastDateFormat, java.lang.Throwable>, java.lang.String[]> autoCloseableTriple14 = org.apache.commons.lang3.tuple.Triple.ofNonNull((java.lang.AutoCloseable) localeStream3, fastDateFormatFailableLongFunction5, strArray12);
        java.util.List<java.util.Locale> localeList15 = org.apache.commons.lang3.LocaleUtils.availableLocaleList();
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream16 = org.apache.commons.lang3.Streams.stream((java.util.Collection<java.util.Locale>) localeList15);
        java.util.stream.Stream<java.util.Locale> localeStream17 = org.apache.commons.lang3.stream.Streams.of((java.lang.Iterable<java.util.Locale>) localeList15);
        java.util.stream.Stream<java.util.Locale> localeStream18 = org.apache.commons.lang3.stream.Streams.nonNull(localeStream17);
        org.apache.commons.lang3.Streams.FailableStream<java.util.Locale> localeFailableStream19 = org.apache.commons.lang3.Streams.stream(localeStream18);
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle20 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle21 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str22 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle20, toStringStyle21);
        java.util.concurrent.Future<org.apache.commons.lang3.builder.StandardToStringStyle> standardToStringStyleFuture23 = org.apache.commons.lang3.concurrent.ConcurrentUtils.constantFuture(standardToStringStyle20);
        java.lang.String str24 = standardToStringStyle20.getFieldSeparator();
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder25 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) localeStream3, (java.lang.AutoCloseable) localeStream18, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle20);
        org.junit.Assert.assertNotNull(localeList0);
        org.junit.Assert.assertNotNull(localeFailableStream1);
        org.junit.Assert.assertNotNull(localeStream2);
        org.junit.Assert.assertNotNull(localeStream3);
        org.junit.Assert.assertNotNull(localeFailableStream4);
        org.junit.Assert.assertNotNull(fastDateFormatFailableLongFunction5);
        org.junit.Assert.assertNotNull(strArray12);
        org.junit.Assert.assertNotNull(charSet13);
        org.junit.Assert.assertNotNull(autoCloseableTriple14);
        org.junit.Assert.assertNotNull(localeList15);
        org.junit.Assert.assertNotNull(localeFailableStream16);
        org.junit.Assert.assertNotNull(localeStream17);
        org.junit.Assert.assertNotNull(localeStream18);
        org.junit.Assert.assertNotNull(localeFailableStream19);
        org.junit.Assert.assertNotNull(toStringStyle21);
        org.junit.Assert.assertEquals("'" + str22 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str22, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertNotNull(standardToStringStyleFuture23);
        org.junit.Assert.assertEquals("'" + str24 + "' != '" + "," + "'", str24, ",");
    }

    @Test
    public void test1218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1218");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.replaceOnceIgnoreCase("java.specification.version", " ", "}");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "java.specification.version" + "'", str3, "java.specification.version");
    }

    @Test
    public void test1219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1219");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS_VISTA;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test1220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1220");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.JAVA_VENDOR;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "java.vendor" + "'", str0, "java.vendor");
    }

    @Test
    public void test1221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1221");
        long[] longArray5 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray5, (long) '\n', 100);
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray5);
        long[] longArray11 = org.apache.commons.lang3.ArrayUtils.add(longArray5, (long) (short) 101);
        long[] longArray12 = org.apache.commons.lang3.ArraySorter.sort(longArray11);
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray5), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(longArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray11), "[10, 52, 97, 100, 100, 101]");
        org.junit.Assert.assertNotNull(longArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray12), "[10, 52, 97, 100, 100, 101]");
    }

    @Test
    public void test1222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1222");
        org.apache.commons.lang3.compare.ObjectToStringComparator objectToStringComparator0 = org.apache.commons.lang3.compare.ObjectToStringComparator.INSTANCE;
        org.junit.Assert.assertNotNull(objectToStringComparator0);
    }

    @Test
    public void test1223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1223");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        org.apache.commons.lang3.ArrayUtils.shift(booleanArray11, (int) '\n');
        org.apache.commons.lang3.ArrayUtils.swap(booleanArray11, 99, (int) '#', 100);
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
    public void test1224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1224");
        org.apache.commons.lang3.exception.ContextedException contextedException0 = new org.apache.commons.lang3.exception.ContextedException();
        java.lang.Long[] longArray8 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray15 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray22 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray29 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray36 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[][] longArray37 = new java.lang.Long[][] { longArray8, longArray15, longArray22, longArray29, longArray36 };
        java.util.function.Supplier<java.lang.String> strSupplier38 = null;
        java.lang.String str39 = org.apache.commons.lang3.ObjectUtils.toString(longArray37, strSupplier38);
        org.apache.commons.lang3.exception.ContextedException contextedException40 = contextedException0.addContextValue("pen", (java.lang.Object) str39);
        java.util.List<java.lang.Object> objList42 = contextedException0.getContextValues("java.vm.version");
        java.util.stream.IntStream intStream45 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        java.util.stream.IntStream intStream47 = org.apache.commons.lang3.stream.IntStreams.rangeClosed((int) '\000');
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle48 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle49 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str50 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle48, toStringStyle49);
        java.lang.StringBuffer stringBuffer51 = null;
        java.lang.Object obj52 = null;
        standardToStringStyle48.appendStart(stringBuffer51, obj52);
        java.lang.String str54 = standardToStringStyle48.getNullText();
        standardToStringStyle48.setSizeStartText("F16.0.1+9e/Stockholm]");
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder58 = new org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable>((java.lang.AutoCloseable) intStream45, (java.lang.AutoCloseable) intStream47, (org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle48, true);
        org.apache.commons.lang3.exception.ExceptionContext exceptionContext59 = contextedException0.setContextValue("oPENjdk rUNTIME eNVIRONMENT", (java.lang.Object) intStream47);
        org.junit.Assert.assertNotNull(longArray8);
        org.junit.Assert.assertNotNull(longArray15);
        org.junit.Assert.assertNotNull(longArray22);
        org.junit.Assert.assertNotNull(longArray29);
        org.junit.Assert.assertNotNull(longArray36);
        org.junit.Assert.assertNotNull(longArray37);
        org.junit.Assert.assertNotNull(contextedException40);
        org.junit.Assert.assertNotNull(objList42);
        org.junit.Assert.assertNotNull(intStream45);
        org.junit.Assert.assertNotNull(intStream47);
        org.junit.Assert.assertNotNull(toStringStyle49);
        org.junit.Assert.assertEquals("'" + str50 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str50, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str54 + "' != '" + "<null>" + "'", str54, "<null>");
        org.junit.Assert.assertNotNull(exceptionContext59);
    }

    @Test
    public void test1225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1225");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.ZERO;
        org.junit.Assert.assertNotNull(fraction0);
    }

    @Test
    public void test1226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1226");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat((float) (short) -1);
        mutableFloat1.subtract((java.lang.Number) 0.6f);
    }

    @Test
    public void test1227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1227");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + true + "'", boolean0 == true);
    }

    @Test
    public void test1228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1228");
        java.lang.Long[] longArray9 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray16 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray23 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray30 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray37 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[][] longArray38 = new java.lang.Long[][] { longArray9, longArray16, longArray23, longArray30, longArray37 };
        java.util.function.Supplier<java.lang.String> strSupplier39 = null;
        java.lang.String str40 = org.apache.commons.lang3.ObjectUtils.toString(longArray38, strSupplier39);
        java.lang.Class<?>[] wildcardClassArray41 = org.apache.commons.lang3.ClassUtils.toClass((java.lang.Object[]) longArray38);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj42 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) "10", false, "=", (java.lang.Object[]) longArray38);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such accessible method: =() on object: java.lang.String");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray9);
        org.junit.Assert.assertNotNull(longArray16);
        org.junit.Assert.assertNotNull(longArray23);
        org.junit.Assert.assertNotNull(longArray30);
        org.junit.Assert.assertNotNull(longArray37);
        org.junit.Assert.assertNotNull(longArray38);
        org.junit.Assert.assertNotNull(wildcardClassArray41);
    }

    @Test
    public void test1229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1229");
        org.apache.commons.lang3.function.FailableDoubleToLongFunction<java.lang.UnsupportedOperationException> unsupportedOperationExceptionFailableDoubleToLongFunction0 = org.apache.commons.lang3.function.FailableDoubleToLongFunction.nop();
        org.junit.Assert.assertNotNull(unsupportedOperationExceptionFailableDoubleToLongFunction0);
    }

    @Test
    public void test1230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1230");
        java.util.Date date0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.util.Date date2 = org.apache.commons.lang3.time.DateUtils.setMonths(date0, (int) 'M');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: date");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1231");
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
        java.lang.Boolean boolean95 = equalsBuilder94.build();
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
        org.junit.Assert.assertEquals("'" + boolean95 + "' != '" + true + "'", boolean95, true);
    }

    @Test
    public void test1232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1232");
        java.lang.Double[] doubleArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY;
        double[] doubleArray1 = org.apache.commons.lang3.ArrayUtils.toPrimitive(doubleArray0);
        // The following exception was thrown during execution in test generation
        try {
            double double2 = org.apache.commons.lang3.math.NumberUtils.min(doubleArray1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Array cannot be empty.");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(doubleArray0);
        org.junit.Assert.assertNotNull(doubleArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray1), "[]");
    }

    @Test
    public void test1233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1233");
        java.util.Set<java.util.Locale> localeSet0 = org.apache.commons.lang3.LocaleUtils.availableLocaleSet();
        java.util.Set<java.util.Locale> localeSet1 = org.apache.commons.lang3.Validate.noNullElements(localeSet0);
        org.junit.Assert.assertNotNull(localeSet0);
        org.junit.Assert.assertNotNull(localeSet1);
    }

    @Test
    public void test1234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1234");
        org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException> strItorMutableTriple0 = new org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException>();
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException7 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException6);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException8 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException6);
        strItorMutableTriple0.setRight(contextedRuntimeException8);
        java.lang.Throwable throwable10 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException11 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable10);
        java.lang.Throwable[] throwableArray12 = uncheckedExecutionException11.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException14 = new org.apache.commons.lang3.NotImplementedException((java.lang.Throwable) uncheckedExecutionException11, "os.version");
        boolean boolean15 = org.apache.commons.lang3.exception.ExceptionUtils.isChecked((java.lang.Throwable) notImplementedException14);
        strItorMutableTriple0.setMiddle(notImplementedException14);
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertNotNull(throwableArray12);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
    }

    @Test
    public void test1235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1235");
        org.apache.commons.lang3.arch.Processor processor0 = org.apache.commons.lang3.ArchUtils.getProcessor();
        org.junit.Assert.assertNotNull(processor0);
    }

    @Test
    public void test1236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1236");
        java.lang.String str1 = org.apache.commons.lang3.ClassUtils.getCanonicalName((java.lang.Object) 17);
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "java.lang.Integer" + "'", str1, "java.lang.Integer");
    }

    @Test
    public void test1237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1237");
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
        java.util.List<java.lang.reflect.Field> fieldList14 = org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList(multiBackgroundInitializerResultsFailableSupplierClass13);
        java.lang.String str16 = org.apache.commons.lang3.ClassPathUtils.toFullyQualifiedName(multiBackgroundInitializerResultsFailableSupplierClass13, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        boolean boolean17 = org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertNotNull(fieldList14);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "org.apache.commons.lang3.concurrent.true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str16, "org.apache.commons.lang3.concurrent.true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test1238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1238");
        java.lang.Float[] floatArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY;
        org.junit.Assert.assertNotNull(floatArray0);
    }

    @Test
    public void test1239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1239");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.toRootLowerCase("11.5");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "11.5" + "'", str1, "11.5");
    }

    @Test
    public void test1240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1240");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.USER_NAME;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "glacierali" + "'", str0, "glacierali");
    }

    @Test
    public void test1241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1241");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_12;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_12 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_12));
    }

    @Test
    public void test1242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1242");
        org.apache.commons.lang3.function.FailableFunction<java.util.Comparator<java.lang.Object>, org.apache.commons.lang3.arch.Processor[], org.apache.commons.lang3.exception.UncheckedException> objComparatorFailableFunction0 = org.apache.commons.lang3.function.FailableFunction.nop();
        org.junit.Assert.assertNotNull(objComparatorFailableFunction0);
    }

    @Test
    public void test1243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1243");
        org.apache.commons.lang3.function.FailableBiPredicate<org.apache.commons.lang3.JavaVersion, org.apache.commons.lang3.compare.ObjectToStringComparator, org.apache.commons.lang3.exception.ContextedRuntimeException> javaVersionFailableBiPredicate0 = org.apache.commons.lang3.function.FailableBiPredicate.falsePredicate();
        org.junit.Assert.assertNotNull(javaVersionFailableBiPredicate0);
    }

    @Test
    public void test1244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1244");
        org.apache.commons.lang3.function.FailableFunction<java.net.URL[], java.net.URL[], java.lang.RuntimeException> uRLArrayFailableFunction0 = org.apache.commons.lang3.function.FailableFunction.identity();
        org.junit.Assert.assertNotNull(uRLArrayFailableFunction0);
    }

    @Test
    public void test1245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1245");
        int[] intArray0 = null;
        int int3 = org.apache.commons.lang3.ArrayUtils.lastIndexOf(intArray0, 97, (int) 'M');
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test1246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1246");
        org.apache.commons.lang3.mutable.MutableLong mutableLong1 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        org.apache.commons.lang3.mutable.MutableByte mutableByte2 = new org.apache.commons.lang3.mutable.MutableByte();
        org.apache.commons.lang3.mutable.MutableByte mutableByte3 = new org.apache.commons.lang3.mutable.MutableByte();
        int int4 = mutableByte2.compareTo(mutableByte3);
        long long5 = mutableLong1.addAndGet((java.lang.Number) int4);
        float float6 = mutableLong1.floatValue();
        java.lang.String str7 = mutableLong1.toString();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + long5 + "' != '" + 1L + "'", long5 == 1L);
        org.junit.Assert.assertTrue("'" + float6 + "' != '" + 1.0f + "'", float6 == 1.0f);
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "1" + "'", str7, "1");
    }

    @Test
    public void test1247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1247");
        java.math.RoundingMode roundingMode2 = null;
        java.math.BigDecimal bigDecimal3 = org.apache.commons.lang3.math.NumberUtils.toScaledBigDecimal((java.lang.Float) 0.0f, 0, roundingMode2);
        org.junit.Assert.assertNotNull(bigDecimal3);
    }

    @Test
    public void test1248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1248");
        java.lang.Throwable throwable0 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException1 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable0);
        java.lang.Throwable[] throwableArray2 = uncheckedExecutionException1.getSuppressed();
        int int3 = org.apache.commons.lang3.exception.ExceptionUtils.getThrowableCount((java.lang.Throwable) uncheckedExecutionException1);
        org.apache.commons.lang3.exception.CloneFailedException cloneFailedException4 = new org.apache.commons.lang3.exception.CloneFailedException((java.lang.Throwable) uncheckedExecutionException1);
        org.junit.Assert.assertNotNull(throwableArray2);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 1 + "'", int3 == 1);
    }

    @Test
    public void test1249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1249");
        java.lang.String str0 = org.apache.commons.lang3.StringUtils.LF;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "\n" + "'", str0, "\n");
    }

    @Test
    public void test1250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1250");
        org.apache.commons.lang3.arch.Processor.Type type0 = org.apache.commons.lang3.arch.Processor.Type.AARCH_64;
        org.junit.Assert.assertTrue("'" + type0 + "' != '" + org.apache.commons.lang3.arch.Processor.Type.AARCH_64 + "'", type0.equals(org.apache.commons.lang3.arch.Processor.Type.AARCH_64));
    }

    @Test
    public void test1251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1251");
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
        java.lang.String[] strArray95 = new java.lang.String[] {};
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder96 = equalsBuilder94.setExcludeFields(strArray95);
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
        org.junit.Assert.assertNotNull(strArray95);
        org.junit.Assert.assertNotNull(equalsBuilder96);
    }

    @Test
    public void test1252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1252");
        float[] floatArray3 = new float[] { 100.0f, 0.0f, 100L };
        org.apache.commons.lang3.ArrayUtils.shift(floatArray3, (int) (short) 100);
        float[] floatArray6 = org.apache.commons.lang3.ArraySorter.sort(floatArray3);
        org.apache.commons.lang3.ArrayUtils.reverse(floatArray3, (int) '4', (int) (short) 10);
        float[] floatArray13 = new float[] { 100.0f, 0.0f, 100L };
        org.apache.commons.lang3.ArrayUtils.shift(floatArray13, (int) (short) 100);
        float[] floatArray16 = org.apache.commons.lang3.ArrayUtils.addAll(floatArray3, floatArray13);
        // The following exception was thrown during execution in test generation
        try {
            float[] floatArray19 = org.apache.commons.lang3.ArrayUtils.add(floatArray16, (int) (byte) -11, (float) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: -11, Length: 6");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[0.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray6), "[0.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray13), "[100.0, 100.0, 0.0]");
        org.junit.Assert.assertNotNull(floatArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray16), "[0.0, 100.0, 100.0, 100.0, 100.0, 0.0]");
    }

    @Test
    public void test1253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1253");
        java.lang.Class[] classArray1 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray2 = (java.lang.Class<?>[]) classArray1;
        java.lang.Class[] classArray4 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray5 = (java.lang.Class<?>[]) classArray4;
        java.lang.Class<?> wildcardClass6 = null;
        java.lang.Class[] classArray8 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray9 = (java.lang.Class<?>[]) classArray8;
        wildcardClassArray9[0] = wildcardClass6;
        boolean boolean12 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray4, wildcardClassArray9);
        java.lang.Class[] classArray14 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray15 = (java.lang.Class<?>[]) classArray14;
        java.lang.Class<?> wildcardClass16 = null;
        java.lang.Class[] classArray18 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray19 = (java.lang.Class<?>[]) classArray18;
        wildcardClassArray19[0] = wildcardClass16;
        boolean boolean22 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray14, wildcardClassArray19);
        boolean boolean24 = org.apache.commons.lang3.ClassUtils.isAssignable(wildcardClassArray9, (java.lang.Class<?>[]) classArray14, false);
        boolean boolean26 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray1, (java.lang.Class<?>[]) classArray14, true);
        java.lang.Class<?>[] wildcardClassArray27 = org.apache.commons.lang3.ClassUtils.wrappersToPrimitives((java.lang.Class<?>[]) classArray14);
        java.lang.Class[] classArray29 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray30 = (java.lang.Class<?>[]) classArray29;
        java.lang.Class[] classArray32 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray33 = (java.lang.Class<?>[]) classArray32;
        java.lang.Class<?> wildcardClass34 = null;
        java.lang.Class[] classArray36 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray37 = (java.lang.Class<?>[]) classArray36;
        wildcardClassArray37[0] = wildcardClass34;
        boolean boolean40 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray32, wildcardClassArray37);
        java.lang.Class[] classArray42 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray43 = (java.lang.Class<?>[]) classArray42;
        java.lang.Class<?> wildcardClass44 = null;
        java.lang.Class[] classArray46 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray47 = (java.lang.Class<?>[]) classArray46;
        wildcardClassArray47[0] = wildcardClass44;
        boolean boolean50 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray42, wildcardClassArray47);
        boolean boolean52 = org.apache.commons.lang3.ClassUtils.isAssignable(wildcardClassArray37, (java.lang.Class<?>[]) classArray42, false);
        boolean boolean54 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray29, (java.lang.Class<?>[]) classArray42, true);
        boolean boolean55 = org.apache.commons.lang3.ClassUtils.isAssignable(wildcardClassArray27, (java.lang.Class<?>[]) classArray42);
        org.junit.Assert.assertNotNull(classArray1);
        org.junit.Assert.assertNotNull(wildcardClassArray2);
        org.junit.Assert.assertNotNull(classArray4);
        org.junit.Assert.assertNotNull(wildcardClassArray5);
        org.junit.Assert.assertNotNull(classArray8);
        org.junit.Assert.assertNotNull(wildcardClassArray9);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
        org.junit.Assert.assertNotNull(classArray14);
        org.junit.Assert.assertNotNull(wildcardClassArray15);
        org.junit.Assert.assertNotNull(classArray18);
        org.junit.Assert.assertNotNull(wildcardClassArray19);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + true + "'", boolean26 == true);
        org.junit.Assert.assertNotNull(wildcardClassArray27);
        org.junit.Assert.assertNotNull(classArray29);
        org.junit.Assert.assertNotNull(wildcardClassArray30);
        org.junit.Assert.assertNotNull(classArray32);
        org.junit.Assert.assertNotNull(wildcardClassArray33);
        org.junit.Assert.assertNotNull(classArray36);
        org.junit.Assert.assertNotNull(wildcardClassArray37);
        org.junit.Assert.assertTrue("'" + boolean40 + "' != '" + false + "'", boolean40 == false);
        org.junit.Assert.assertNotNull(classArray42);
        org.junit.Assert.assertNotNull(wildcardClassArray43);
        org.junit.Assert.assertNotNull(classArray46);
        org.junit.Assert.assertNotNull(wildcardClassArray47);
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + false + "'", boolean50 == false);
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + true + "'", boolean54 == true);
        org.junit.Assert.assertTrue("'" + boolean55 + "' != '" + true + "'", boolean55 == true);
    }

    @Test
    public void test1254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1254");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle3 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer7 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray8 = strTokenizer7.getTokenArray();
        java.lang.String str9 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle3, strArray8);
        java.lang.String str13 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray8, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int14 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray8);
        boolean boolean15 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray8);
        boolean boolean16 = org.apache.commons.lang3.StringUtils.containsAny((java.lang.CharSequence) "utf-16", (java.lang.CharSequence[]) strArray8);
        org.junit.Assert.assertNotNull(strArray8);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "" + "'", str13, "");
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test1255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1255");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.wrapIfMissing("Europe/Stockholm", 'a');
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "aEurope/Stockholma" + "'", str2, "aEurope/Stockholma");
    }

    @Test
    public void test1256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1256");
        org.apache.commons.lang3.mutable.MutableInt mutableInt0 = new org.apache.commons.lang3.mutable.MutableInt();
    }

    @Test
    public void test1257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1257");
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
        long[] longArray39 = org.apache.commons.lang3.ArrayUtils.add(longArray36, (-1L));
        long[] longArray41 = org.apache.commons.lang3.ArrayUtils.removeElement(longArray36, (long) (-1));
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
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray39), "[60000, 10, 100, 100, 97, 52, 101, -1]");
        org.junit.Assert.assertNotNull(longArray41);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray41), "[60000, 10, 100, 100, 97, 52, 101]");
    }

    @Test
    public void test1258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1258");
        byte[] byteArray3 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray4 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray3);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.EMPTY_BYTE_ARRAY;
        byte[] byteArray6 = org.apache.commons.lang3.ArrayUtils.insert((int) (short) 10, byteArray3, byteArray5);
        byte[] byteArray7 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray6);
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray4), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[]");
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray6), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray7), "[0, -1]");
    }

    @Test
    public void test1259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1259");
        char char0 = org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR;
        org.junit.Assert.assertTrue("'" + char0 + "' != '" + '.' + "'", char0 == '.');
    }

    @Test
    public void test1260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1260");
        java.lang.Boolean[] booleanArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
        org.junit.Assert.assertNotNull(booleanArray0);
    }

    @Test
    public void test1261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1261");
        java.lang.Short[] shortArray5 = new java.lang.Short[] { (short) 100, (short) 1, (short) 1, (short) 10, (short) 1 };
        java.lang.Short[] shortArray6 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(shortArray5);
        short[] shortArray8 = org.apache.commons.lang3.ArrayUtils.toPrimitive(shortArray6, (short) 99);
        short[] shortArray9 = org.apache.commons.lang3.ArraySorter.sort(shortArray8);
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.contains(shortArray9, (short) (byte) 1);
        org.junit.Assert.assertNotNull(shortArray5);
        org.junit.Assert.assertNotNull(shortArray6);
        org.junit.Assert.assertNotNull(shortArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray8), "[1, 1, 1, 10, 100]");
        org.junit.Assert.assertNotNull(shortArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray9), "[1, 1, 1, 10, 100]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test1262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1262");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_VENTURA;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test1263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1263");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_DATE_FORMAT;
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat1 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        java.lang.String str2 = fastDateFormat1.toString();
        int int3 = fastDateFormat1.getMaxLengthEstimate();
        org.apache.commons.lang3.text.CompositeFormat compositeFormat4 = new org.apache.commons.lang3.text.CompositeFormat((java.text.Format) fastDateFormat0, (java.text.Format) fastDateFormat1);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str6 = compositeFormat4.reformat("FastDateFormat[,en_SE,Europe/Stockholm]");
            org.junit.Assert.fail("Expected exception of type java.text.ParseException; message: Format.parseObject(String) failed");
        } catch (java.text.ParseException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertNotNull(fastDateFormat1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]" + "'", str2, "FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 8 + "'", int3 == 8);
    }

    @Test
    public void test1264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1264");
        org.apache.commons.lang3.mutable.MutableObject<org.apache.commons.lang3.function.BooleanConsumer> booleanConsumerMutableObject0 = new org.apache.commons.lang3.mutable.MutableObject<org.apache.commons.lang3.function.BooleanConsumer>();
        org.apache.commons.lang3.mutable.MutableShort mutableShort2 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort2.setValue((java.lang.Number) (short) 100);
        java.lang.String str5 = mutableShort2.toString();
        org.apache.commons.lang3.mutable.MutableShort mutableShort7 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort7.setValue((java.lang.Number) (short) 100);
        long long10 = mutableShort7.longValue();
        mutableShort2.setValue((java.lang.Number) long10);
        org.apache.commons.lang3.mutable.MutableShort mutableShort13 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort13.setValue((java.lang.Number) (short) 100);
        org.apache.commons.lang3.mutable.MutableShort mutableShort17 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        short short18 = mutableShort17.incrementAndGet();
        org.apache.commons.lang3.mutable.MutableLong mutableLong20 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        mutableLong20.add((long) 0);
        mutableShort17.setValue((java.lang.Number) 0);
        org.apache.commons.lang3.mutable.MutableShort mutableShort24 = org.apache.commons.lang3.compare.ComparableUtils.min(mutableShort13, mutableShort17);
        org.apache.commons.lang3.math.Fraction fraction27 = org.apache.commons.lang3.math.Fraction.getFraction((int) (byte) -1, (-1));
        mutableShort17.add((java.lang.Number) fraction27);
        mutableShort2.add((java.lang.Number) fraction27);
        boolean boolean30 = booleanConsumerMutableObject0.equals((java.lang.Object) mutableShort2);
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair31 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray32 = charSequenceArrayImmutablePair31.getLeft();
        org.apache.commons.lang3.tuple.MutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayMutablePair33 = org.apache.commons.lang3.tuple.MutablePair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair31);
        boolean boolean34 = booleanConsumerMutableObject0.equals((java.lang.Object) charSequenceArrayImmutablePair31);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "100" + "'", str5, "100");
        org.junit.Assert.assertTrue("'" + long10 + "' != '" + 100L + "'", long10 == 100L);
        org.junit.Assert.assertTrue("'" + short18 + "' != '" + (short) 101 + "'", short18 == (short) 101);
        org.junit.Assert.assertNotNull(mutableShort24);
        org.junit.Assert.assertNotNull(fraction27);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair31);
        org.junit.Assert.assertNull(charSequenceArray32);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair33);
        org.junit.Assert.assertTrue("'" + boolean34 + "' != '" + false + "'", boolean34 == false);
    }

    @Test
    public void test1265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1265");
        java.util.concurrent.Callable<org.apache.commons.lang3.SerializationException> serializationExceptionCallable0 = null;
        java.util.concurrent.ExecutorService executorService1 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.CallableBackgroundInitializer<org.apache.commons.lang3.SerializationException> serializationExceptionCallableBackgroundInitializer2 = new org.apache.commons.lang3.concurrent.CallableBackgroundInitializer<org.apache.commons.lang3.SerializationException>(serializationExceptionCallable0, executorService1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: callable");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1266");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_19;
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_19 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_19));
    }

    @Test
    public void test1267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1267");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Boolean boolean4 = org.apache.commons.lang3.BooleanUtils.toBooleanObject("1/1", "SE", "11.5", "                                                                                                  100");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The String did not match any specified value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1268");
        org.apache.commons.lang3.BitField bitField1 = new org.apache.commons.lang3.BitField((int) (byte) 0);
    }

    @Test
    public void test1269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1269");
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator0 = org.apache.commons.lang3.StringEscapeUtils.ESCAPE_ECMASCRIPT;
        org.junit.Assert.assertNotNull(charSequenceTranslator0);
    }

    @Test
    public void test1270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1270");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.chomp(")<+WncT");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + ")<+WncT" + "'", str1, ")<+WncT");
    }

    @Test
    public void test1271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1271");
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
        java.util.List<java.lang.Class<?>> wildcardClassList18 = org.apache.commons.lang3.ClassUtils.getAllInterfaces(multiBackgroundInitializerResultsFailableSupplierClass13);
        java.lang.Object obj19 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer20 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService21 = multiBackgroundInitializer20.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle24 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer28 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray29 = strTokenizer28.getTokenArray();
        java.lang.String str30 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle24, strArray29);
        java.lang.String str34 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray29, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int35 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray29);
        boolean boolean36 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray29);
        boolean boolean37 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj19, (java.lang.Object) executorService21, strArray29);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.Validate.isInstanceOf(multiBackgroundInitializerResultsFailableSupplierClass13, (java.lang.Object) boolean37);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Expected type: org.apache.commons.lang3.concurrent.MultiBackgroundInitializer, actual: java.lang.Boolean");
        } catch (java.lang.IllegalArgumentException e) {
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
        org.junit.Assert.assertNotNull(wildcardClassList18);
        org.junit.Assert.assertNull(executorService21);
        org.junit.Assert.assertNotNull(strArray29);
        org.junit.Assert.assertEquals("'" + str34 + "' != '" + "" + "'", str34, "");
        org.junit.Assert.assertTrue("'" + int35 + "' != '" + (-1) + "'", int35 == (-1));
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + true + "'", boolean37 == true);
    }

    @Test
    public void test1272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1272");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle0 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer4 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray5 = strTokenizer4.getTokenArray();
        java.lang.String str6 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle0, strArray5);
        java.lang.StringBuffer stringBuffer7 = null;
        java.util.Locale[] localeArray9 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList10 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean11 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList10, localeArray9);
        java.net.URL[] uRLArray13 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection14 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList10, "Integer", (java.lang.Object[]) uRLArray13);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream15 = org.apache.commons.lang3.stream.Streams.failableStream((java.util.Collection<java.util.Locale>) localeList10);
        java.util.stream.Stream<java.util.Locale> localeStream16 = localeFailableStream15.stream();
        // The following exception was thrown during execution in test generation
        try {
            multilineRecursiveToStringStyle0.appendDetail(stringBuffer7, "UTF-16", (java.lang.Object) localeStream16);
            org.junit.Assert.fail("Expected exception of type java.lang.reflect.InaccessibleObjectException; message: Unable to make field static final boolean java.util.stream.AbstractPipeline.$assertionsDisabled accessible: module java.base does not \"opens java.util.stream\" to unnamed module @654b5005");
        } catch (java.lang.reflect.InaccessibleObjectException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strArray5);
        org.junit.Assert.assertNotNull(localeArray9);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(uRLArray13);
        org.junit.Assert.assertNotNull(localeCollection14);
        org.junit.Assert.assertNotNull(localeFailableStream15);
        org.junit.Assert.assertNotNull(localeStream16);
    }

    @Test
    public void test1273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1273");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.removeElement(byteArray3, (byte) 100);
        // The following exception was thrown during execution in test generation
        try {
            long long10 = org.apache.commons.lang3.Conversion.byteArrayToLong(byteArray5, (int) (byte) 10, (-1L), 3, (int) (byte) 100);
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
    public void test1274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1274");
        double[] doubleArray5 = new double[] { 1.0d, 2147483647L, 100.0d, 10, 32.0f };
        double[] doubleArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(doubleArray5, 1.0d);
        org.apache.commons.lang3.ArrayUtils.shift(doubleArray7, (int) (short) 0);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[1.0, 2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray7), "[2.147483647E9, 100.0, 10.0, 32.0]");
    }

    @Test
    public void test1275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1275");
        org.apache.commons.lang3.util.FluentBitSet fluentBitSet0 = new org.apache.commons.lang3.util.FluentBitSet();
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException((java.lang.Throwable) uncheckedExecutionException2, "os.version");
        boolean boolean6 = org.apache.commons.lang3.exception.ExceptionUtils.isChecked((java.lang.Throwable) notImplementedException5);
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper7 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper8 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper9 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper10 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper11 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper12 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.UnicodeUnescaper unicodeUnescaper13 = new org.apache.commons.lang3.text.translate.UnicodeUnescaper();
        org.apache.commons.lang3.text.translate.CharSequenceTranslator[] charSequenceTranslatorArray14 = new org.apache.commons.lang3.text.translate.CharSequenceTranslator[] { unicodeUnescaper8, unicodeUnescaper9, unicodeUnescaper10, unicodeUnescaper11, unicodeUnescaper12, unicodeUnescaper13 };
        org.apache.commons.lang3.text.translate.CharSequenceTranslator charSequenceTranslator15 = unicodeUnescaper7.with(charSequenceTranslatorArray14);
        java.lang.String str17 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) charSequenceTranslatorArray14, ' ');
        java.util.BitSet bitSet19 = org.apache.commons.lang3.ArrayUtils.indexesOf((java.lang.Object[]) charSequenceTranslatorArray14, (java.lang.Object) "pen");
        org.apache.commons.lang3.tuple.ImmutablePair<org.apache.commons.lang3.NotImplementedException, java.util.BitSet> notImplementedExceptionImmutablePair20 = new org.apache.commons.lang3.tuple.ImmutablePair<org.apache.commons.lang3.NotImplementedException, java.util.BitSet>(notImplementedException5, bitSet19);
        org.apache.commons.lang3.util.FluentBitSet fluentBitSet21 = fluentBitSet0.andNot(bitSet19);
        org.apache.commons.lang3.util.FluentBitSet fluentBitSet24 = fluentBitSet0.set(17, true);
        java.util.BitSet bitSet25 = fluentBitSet24.bitSet();
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(charSequenceTranslatorArray14);
        org.junit.Assert.assertNotNull(charSequenceTranslator15);
        org.junit.Assert.assertNotNull(bitSet19);
        org.junit.Assert.assertEquals(bitSet19.toString(), "{}");
        org.junit.Assert.assertNotNull(fluentBitSet21);
        org.junit.Assert.assertNotNull(fluentBitSet24);
        org.junit.Assert.assertNotNull(bitSet25);
        org.junit.Assert.assertEquals(bitSet25.toString(), "{17}");
    }

    @Test
    public void test1276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1276");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        boolean[] booleanArray17 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray19 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray17, false);
        java.util.BitSet bitSet21 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray17, true);
        boolean[] booleanArray22 = org.apache.commons.lang3.ArrayUtils.removeElements(booleanArray11, booleanArray17);
        boolean[] booleanArray23 = org.apache.commons.lang3.ArrayUtils.clone(booleanArray22);
        boolean boolean24 = org.apache.commons.lang3.BooleanUtils.and(booleanArray22);
        boolean[] booleanArray26 = org.apache.commons.lang3.ArrayUtils.addFirst(booleanArray22, true);
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
        org.junit.Assert.assertNotNull(booleanArray23);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray23), "[true]");
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(booleanArray26);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray26), "[true, true]");
    }

    @Test
    public void test1277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1277");
        org.apache.commons.lang3.BitField bitField1 = new org.apache.commons.lang3.BitField((int) (byte) 10);
        byte byte3 = bitField1.clearByte((byte) -1);
        short short5 = bitField1.setShort((short) 0);
        org.junit.Assert.assertTrue("'" + byte3 + "' != '" + (byte) -11 + "'", byte3 == (byte) -11);
        org.junit.Assert.assertTrue("'" + short5 + "' != '" + (short) 10 + "'", short5 == (short) 10);
    }

    @Test
    public void test1278() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1278");
        long[] longArray1 = new long[] { '4' };
        long[] longArray7 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet10 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray7, (long) '\n', 100);
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray7);
        long[] longArray13 = org.apache.commons.lang3.ArrayUtils.add(longArray7, (long) (short) 101);
        boolean boolean14 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray1, longArray13);
        boolean boolean16 = org.apache.commons.lang3.ArrayUtils.contains(longArray1, (long) 2);
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
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
    }

    @Test
    public void test1279() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1279");
        org.apache.commons.lang3.builder.ReflectionDiffBuilder.Builder<org.apache.commons.lang3.reflect.TypeUtils> typeUtilsBuilder0 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder.Builder<org.apache.commons.lang3.reflect.TypeUtils>();
    }

    @Test
    public void test1280() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1280");
        java.lang.Long[] longArray4 = new java.lang.Long[] { 1L, 0L, 1L, 0L };
        java.lang.Long[][] longArray5 = new java.lang.Long[][] { longArray4 };
        org.apache.commons.lang3.math.Fraction fraction6 = org.apache.commons.lang3.math.Fraction.TWO_THIRDS;
        java.lang.Long[][] longArray7 = org.apache.commons.lang3.ArrayUtils.removeElement(longArray5, (java.lang.Object) fraction6);
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle8 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer12 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray13 = strTokenizer12.getTokenArray();
        java.lang.String str14 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle8, strArray13);
        boolean boolean15 = org.apache.commons.lang3.ObjectUtils.equals((java.lang.Object) longArray5, (java.lang.Object) strArray13);
        boolean boolean16 = org.apache.commons.lang3.StringUtils.isNoneBlank((java.lang.CharSequence[]) strArray13);
        org.junit.Assert.assertNotNull(longArray4);
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertNotNull(fraction6);
        org.junit.Assert.assertNotNull(longArray7);
        org.junit.Assert.assertNotNull(strArray13);
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + false + "'", boolean15 == false);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test1281() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1281");
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
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder97 = equalsBuilder94.append((byte) -1, (byte) -11);
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder99 = equalsBuilder94.setTestTransients(false);
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
        org.junit.Assert.assertNotNull(equalsBuilder99);
    }

    @Test
    public void test1282() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1282");
        java.lang.String[] strArray3 = org.apache.commons.lang3.StringUtils.splitByWholeSeparatorPreserveAllTokens("0\n0", "                                                                                                open");
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle4 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer8 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray9 = strTokenizer8.getTokenArray();
        java.lang.String str10 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle4, strArray9);
        java.lang.String[] strArray12 = org.apache.commons.lang3.StringUtils.stripAll(strArray9, "UnicodeUnescaper");
        java.lang.String str13 = org.apache.commons.lang3.StringUtils.replaceEach("6f51daee", strArray3, strArray12);
        org.apache.commons.lang3.exception.ExceptionUtils exceptionUtils14 = new org.apache.commons.lang3.exception.ExceptionUtils();
        int int16 = org.apache.commons.lang3.ArrayUtils.indexOf((java.lang.Object[]) strArray3, (java.lang.Object) exceptionUtils14, 0);
        org.apache.commons.lang3.exception.ExceptionUtils[] exceptionUtilsArray17 = new org.apache.commons.lang3.exception.ExceptionUtils[] { exceptionUtils14 };
        org.apache.commons.lang3.exception.ExceptionUtils exceptionUtils18 = org.apache.commons.lang3.ObjectUtils.mode(exceptionUtilsArray17);
        org.junit.Assert.assertNotNull(strArray3);
        org.junit.Assert.assertNotNull(strArray9);
        org.junit.Assert.assertNotNull(strArray12);
        org.junit.Assert.assertEquals("'" + str13 + "' != '" + "6f51daee" + "'", str13, "6f51daee");
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
        org.junit.Assert.assertNotNull(exceptionUtilsArray17);
        org.junit.Assert.assertNotNull(exceptionUtils18);
    }

    @Test
    public void test1283() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1283");
        char[] charArray2 = new char[] { ' ', '#' };
        char[] charArray4 = new char[] { ' ' };
        char[] charArray5 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray2, charArray4);
        char[] charArray8 = org.apache.commons.lang3.ArrayUtils.add(charArray4, (int) (short) 0, ' ');
        char[] charArray13 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray16 = org.apache.commons.lang3.ArrayUtils.subarray(charArray13, (int) (short) 1, (-1));
        char[] charArray17 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray4, charArray13);
        char[] charArray20 = new char[] { ' ', '#' };
        char[] charArray22 = new char[] { ' ' };
        char[] charArray23 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray20, charArray22);
        char[] charArray26 = org.apache.commons.lang3.ArrayUtils.add(charArray22, (int) (short) 0, ' ');
        char[] charArray31 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray34 = org.apache.commons.lang3.ArrayUtils.subarray(charArray31, (int) (short) 1, (-1));
        char[] charArray35 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray22, charArray31);
        char[] charArray36 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray13, charArray35);
        java.lang.Character[] charArray37 = org.apache.commons.lang3.ArrayUtils.toObject(charArray13);
        java.lang.Character[] charArray38 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(charArray37);
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
        org.junit.Assert.assertNotNull(charArray20);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray20), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray20), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray20), "[ , #]");
        org.junit.Assert.assertNotNull(charArray22);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray22), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray22), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray22), "[ ]");
        org.junit.Assert.assertNotNull(charArray23);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray23), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray23), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray23), "[#]");
        org.junit.Assert.assertNotNull(charArray26);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray26), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray26), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray26), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray31);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray31), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray31), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray31), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray34);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray34), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray34), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray34), "[]");
        org.junit.Assert.assertNotNull(charArray35);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray35), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray35), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray35), "[]");
        org.junit.Assert.assertNotNull(charArray36);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray36), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray36), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray36), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray37);
        org.junit.Assert.assertNotNull(charArray38);
    }

    @Test
    public void test1284() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1284");
        double[] doubleArray5 = new double[] { 1.0d, 2147483647L, 100.0d, 10, 32.0f };
        double[] doubleArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(doubleArray5, 1.0d);
        double[] doubleArray12 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray16 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean18 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray16, (double) '4');
        boolean boolean19 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray12, doubleArray16);
        int int23 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray12, (-1.0d), (int) '\n', (double) 100);
        boolean boolean24 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray7, doubleArray12);
        double double25 = org.apache.commons.lang3.math.IEEE754rUtils.max(doubleArray12);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[1.0, 2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray7), "[2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray12), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray16), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + int23 + "' != '" + (-1) + "'", int23 == (-1));
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertTrue("'" + double25 + "' != '" + 97.0d + "'", double25 == 97.0d);
    }

    @Test
    public void test1285() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1285");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore3 = new org.apache.commons.lang3.concurrent.TimedSemaphore((long) (short) 1, timeUnit1, (int) (byte) -1);
        double double4 = timedSemaphore3.getAverageCallsPerPeriod();
        int int5 = timedSemaphore3.getAvailablePermits();
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + (-1) + "'", int5 == (-1));
    }

    @Test
    public void test1286() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1286");
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray1 = org.apache.commons.lang3.Conversion.hexDigitToBinary('\000');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Cannot interpret '?' as a hexadecimal digit");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1287() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1287");
        double[] doubleArray4 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray8 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray8, (double) '4');
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray4, doubleArray8);
        double[] doubleArray12 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(doubleArray8);
        java.util.BitSet bitSet15 = org.apache.commons.lang3.ArrayUtils.indexesOf(doubleArray12, (double) (byte) 100, (int) (short) 100);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray4), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray8), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(doubleArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray12), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertNotNull(bitSet15);
        org.junit.Assert.assertEquals(bitSet15.toString(), "{}");
    }

    @Test
    public void test1288() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1288");
        char[] charArray4 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray7 = org.apache.commons.lang3.ArrayUtils.subarray(charArray4, (int) (short) 1, (-1));
        org.apache.commons.lang3.text.StrTokenizer strTokenizer9 = new org.apache.commons.lang3.text.StrTokenizer(charArray7, "os.version");
        java.lang.String str10 = strTokenizer9.previousToken();
        org.junit.Assert.assertNotNull(charArray4);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray4), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray4), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray4), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray7);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray7), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray7), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray7), "[]");
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test1289() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1289");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        float[] floatArray12 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(floatArray10);
        float[] floatArray13 = org.apache.commons.lang3.ArraySorter.sort(floatArray12);
        int int16 = org.apache.commons.lang3.ArrayUtils.indexOf(floatArray12, 0.0f, (int) (short) 100);
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[0.0, 10.0, 10.0, 32.0, 100.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(floatArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray12), "[0.0, 10.0, 10.0, 32.0, 100.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray13), "[0.0, 10.0, 10.0, 32.0, 100.0, 100.0]");
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + (-1) + "'", int16 == (-1));
    }

    @Test
    public void test1290() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1290");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.time.Duration duration2 = org.apache.commons.lang3.time.DurationUtils.toDuration((long) '\000', timeUnit1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1291() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1291");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setNullText("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        standardToStringStyle0.setFieldSeparatorAtStart(true);
        java.lang.String str5 = standardToStringStyle0.getArraySeparator();
        java.lang.StringBuffer stringBuffer6 = null;
        java.lang.Object obj7 = null;
        standardToStringStyle0.appendStart(stringBuffer6, obj7);
        boolean boolean9 = standardToStringStyle0.isDefaultFullDetail();
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "," + "'", str5, ",");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test1292() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1292");
        java.lang.String str1 = org.apache.commons.lang3.CharUtils.unicodeEscaped('.');
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "\\u002e" + "'", str1, "\\u002e");
    }

    @Test
    public void test1293() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1293");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_TIME_TIME_ZONE_FORMAT;
        org.junit.Assert.assertNotNull(fastDateFormat0);
    }

    @Test
    public void test1294() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1294");
        org.apache.commons.lang3.function.FailableLongPredicate failableLongPredicate0 = org.apache.commons.lang3.function.FailableLongPredicate.FALSE;
        org.junit.Assert.assertNotNull(failableLongPredicate0);
    }

    @Test
    public void test1295() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1295");
        java.math.BigDecimal bigDecimal1 = org.apache.commons.lang3.math.NumberUtils.toScaledBigDecimal((java.lang.Float) 1.0f);
        org.apache.commons.lang3.Range<java.math.BigDecimal> bigDecimalRange2 = org.apache.commons.lang3.Range.is(bigDecimal1);
        org.junit.Assert.assertNotNull(bigDecimal1);
        org.junit.Assert.assertNotNull(bigDecimalRange2);
    }

    @Test
    public void test1296() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1296");
        java.lang.String str0 = org.apache.commons.lang3.SystemUtils.JAVA_CLASS_PATH;
// flaky:         org.junit.Assert.assertEquals("'" + str0 + "' != '" + "./bin/commons-lang3-3.15.0-SNAPSHOT.jar:./randoop-all-4.3.2.jar" + "'", str0, "./bin/commons-lang3-3.15.0-SNAPSHOT.jar:./randoop-all-4.3.2.jar");
    }

    @Test
    public void test1297() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1297");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Boolean boolean4 = org.apache.commons.lang3.BooleanUtils.toBooleanObject("a16.0.1+9a", "java.lang.Integer", "/Users/glacierali/randoop-4.3.2", "aEurope/Stockholma");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The String did not match any specified value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1298() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1298");
        long[] longArray5 = new long[] { 10L, (byte) 100, 100L, 'a', '4' };
        java.util.BitSet bitSet8 = org.apache.commons.lang3.ArrayUtils.indexesOf(longArray5, (long) '\n', 100);
        boolean boolean9 = org.apache.commons.lang3.ArrayUtils.isEmpty(longArray5);
        long[] longArray11 = org.apache.commons.lang3.ArrayUtils.add(longArray5, (long) (short) 101);
        org.apache.commons.lang3.ArrayUtils.swap(longArray5, (int) '$', (-5), (int) (byte) 1);
        long[] longArray17 = org.apache.commons.lang3.ArrayUtils.addFirst(longArray5, (long) 0);
        org.junit.Assert.assertNotNull(longArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray5), "[10, 100, 100, 97, 52]");
        org.junit.Assert.assertNotNull(bitSet8);
        org.junit.Assert.assertEquals(bitSet8.toString(), "{}");
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(longArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray11), "[10, 100, 100, 97, 52, 101]");
        org.junit.Assert.assertNotNull(longArray17);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray17), "[0, 10, 100, 100, 97, 52]");
    }

    @Test
    public void test1299() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1299");
        java.lang.Character[] charArray3 = org.apache.commons.lang3.ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY;
        java.lang.Class[] classArray5 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray6 = (java.lang.Class<?>[]) classArray5;
        java.lang.Class[] classArray8 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray9 = (java.lang.Class<?>[]) classArray8;
        java.lang.Class<?> wildcardClass10 = null;
        java.lang.Class[] classArray12 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray13 = (java.lang.Class<?>[]) classArray12;
        wildcardClassArray13[0] = wildcardClass10;
        boolean boolean16 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray8, wildcardClassArray13);
        java.lang.Class[] classArray18 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray19 = (java.lang.Class<?>[]) classArray18;
        java.lang.Class<?> wildcardClass20 = null;
        java.lang.Class[] classArray22 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray23 = (java.lang.Class<?>[]) classArray22;
        wildcardClassArray23[0] = wildcardClass20;
        boolean boolean26 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray18, wildcardClassArray23);
        boolean boolean28 = org.apache.commons.lang3.ClassUtils.isAssignable(wildcardClassArray13, (java.lang.Class<?>[]) classArray18, false);
        boolean boolean30 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray5, (java.lang.Class<?>[]) classArray18, true);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Object obj31 = org.apache.commons.lang3.reflect.MethodUtils.invokeMethod((java.lang.Object) "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc", true, "user.name", (java.lang.Object[]) charArray3, (java.lang.Class<?>[]) classArray18);
            org.junit.Assert.fail("Expected exception of type java.lang.NoSuchMethodException; message: No such method: user.name() on object: java.lang.String");
        } catch (java.lang.NoSuchMethodException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(charArray3);
        org.junit.Assert.assertNotNull(classArray5);
        org.junit.Assert.assertNotNull(wildcardClassArray6);
        org.junit.Assert.assertNotNull(classArray8);
        org.junit.Assert.assertNotNull(wildcardClassArray9);
        org.junit.Assert.assertNotNull(classArray12);
        org.junit.Assert.assertNotNull(wildcardClassArray13);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(classArray18);
        org.junit.Assert.assertNotNull(wildcardClassArray19);
        org.junit.Assert.assertNotNull(classArray22);
        org.junit.Assert.assertNotNull(wildcardClassArray23);
        org.junit.Assert.assertTrue("'" + boolean26 + "' != '" + false + "'", boolean26 == false);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + true + "'", boolean30 == true);
    }

    @Test
    public void test1300() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1300");
        org.apache.commons.lang3.text.translate.EntityArrays entityArrays0 = new org.apache.commons.lang3.text.translate.EntityArrays();
    }

    @Test
    public void test1301() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1301");
        boolean[] booleanArray3 = new boolean[] { false, true, true };
        boolean[] booleanArray4 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(booleanArray3);
        org.junit.Assert.assertNotNull(booleanArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray3), "[false, true, true]");
        org.junit.Assert.assertNotNull(booleanArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray4), "[false, true, true]");
    }

    @Test
    public void test1302() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1302");
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException2, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException6 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException5);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException7 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException5);
        java.lang.Object obj9 = contextedRuntimeException7.getFirstContextValue("glacierali");
        java.util.concurrent.TimeUnit timeUnit12 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore14 = new org.apache.commons.lang3.concurrent.TimedSemaphore((long) (short) 1, timeUnit12, (int) (byte) -1);
        int int15 = timedSemaphore14.getLastAcquiresPerPeriod();
        int int16 = timedSemaphore14.getLastAcquiresPerPeriod();
        boolean boolean17 = timedSemaphore14.isShutdown();
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException18 = contextedRuntimeException7.setContextValue("10$100$100$97$52", (java.lang.Object) boolean17);
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(obj9);
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 0 + "'", int15 == 0);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 0 + "'", int16 == 0);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertNotNull(contextedRuntimeException18);
    }

    @Test
    public void test1303() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1303");
        org.apache.commons.lang3.exception.ContextedException contextedException1 = new org.apache.commons.lang3.exception.ContextedException();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle5 = null;
        org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable> serializableReflectionDiffBuilder6 = new org.apache.commons.lang3.builder.ReflectionDiffBuilder<java.io.Serializable>((java.io.Serializable) (byte) 10, (java.io.Serializable) 0, toStringStyle5);
        org.apache.commons.lang3.exception.ContextedException contextedException7 = contextedException1.setContextValue("yes", (java.lang.Object) 0);
        org.apache.commons.lang3.exception.ContextedException contextedException8 = new org.apache.commons.lang3.exception.ContextedException();
        java.lang.Object obj10 = contextedException8.getFirstContextValue("os.nam");
        org.apache.commons.lang3.exception.ContextedException contextedException11 = new org.apache.commons.lang3.exception.ContextedException("M16.0.1M", (java.lang.Throwable) contextedException1, (org.apache.commons.lang3.exception.ExceptionContext) contextedException8);
        java.lang.String str12 = org.apache.commons.lang3.exception.ExceptionUtils.getRootCauseMessage((java.lang.Throwable) contextedException1);
        org.junit.Assert.assertNotNull(contextedException7);
        org.junit.Assert.assertNull(obj10);
        org.junit.Assert.assertEquals("'" + str12 + "' != '" + "ContextedException: Exception Context:\n\t[1:yes=0]\n---------------------------------" + "'", str12, "ContextedException: Exception Context:\n\t[1:yes=0]\n---------------------------------");
    }

    @Test
    public void test1304() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1304");
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
        java.util.List<java.lang.Class<?>> wildcardClassList18 = org.apache.commons.lang3.ClassUtils.getAllInterfaces(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.apache.commons.lang3.function.FailableSupplier<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults, org.apache.commons.lang3.concurrent.ConcurrentException>[] multiBackgroundInitializerResultsFailableSupplierArray20 = org.apache.commons.lang3.ArrayUtils.newInstance(multiBackgroundInitializerResultsFailableSupplierClass13, 10);
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertTrue("'" + interfaces14 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces14.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces15 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces15.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces16 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces16.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertNotNull(wildcardClassIterable17);
        org.junit.Assert.assertNotNull(wildcardClassList18);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierArray20);
    }

    @Test
    public void test1305() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1305");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        boolean boolean8 = org.apache.commons.lang3.BooleanUtils.or(booleanArray7);
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test1306() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1306");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.THREE_QUARTERS;
        long long1 = fraction0.longValue();
        org.junit.Assert.assertNotNull(fraction0);
        org.junit.Assert.assertTrue("'" + long1 + "' != '" + 0L + "'", long1 == 0L);
    }

    @Test
    public void test1307() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1307");
        short short1 = org.apache.commons.lang3.math.NumberUtils.toShort("Integer");
        org.junit.Assert.assertTrue("'" + short1 + "' != '" + (short) 0 + "'", short1 == (short) 0);
    }

    @Test
    public void test1308() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1308");
        int int2 = org.apache.commons.lang3.StringUtils.compare("\000\000", "01:00:00");
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-48) + "'", int2 == (-48));
    }

    @Test
    public void test1309() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1309");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = org.apache.commons.lang3.BooleanUtils.toBoolean(100, 0, 6);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The Integer did not match either specified value");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1310() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1310");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Integer int1 = org.apache.commons.lang3.math.NumberUtils.createInteger("F16.0.1+9e/Stockholm]");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"F16.0.1+9e/Stockholm]\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1311() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1311");
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
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair12 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        org.apache.commons.lang3.Range<org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>> charSequenceArrayPairRange13 = org.apache.commons.lang3.Range.between((org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair1, (org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair12);
        java.util.AbstractCollection<java.util.Locale> localeCollection14 = charSequenceArrayImmutablePair1.getRight();
        java.lang.CharSequence[] charSequenceArray15 = charSequenceArrayImmutablePair1.getKey();
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair1);
        org.junit.Assert.assertNull(charSequenceArray2);
        org.junit.Assert.assertNotNull(charSequenceArrayMutablePair3);
        org.junit.Assert.assertNotNull(toStringStyle5);
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str6, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
        org.junit.Assert.assertEquals("'" + str10 + "' != '" + "<null>" + "'", str10, "<null>");
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair12);
        org.junit.Assert.assertNotNull(charSequenceArrayPairRange13);
        org.junit.Assert.assertNull(localeCollection14);
        org.junit.Assert.assertNull(charSequenceArray15);
    }

    @Test
    public void test1312() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1312");
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
        java.util.BitSet bitSet78 = org.apache.commons.lang3.ArrayUtils.indexesOf(charArray73, '#', 10);
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
        org.junit.Assert.assertNotNull(bitSet78);
        org.junit.Assert.assertEquals(bitSet78.toString(), "{}");
    }

    @Test
    public void test1313() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1313");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.mutable.MutableByte mutableByte1 = new org.apache.commons.lang3.mutable.MutableByte("Lopeng");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"Lopeng\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1314() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1314");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.substringAfterLast("user.dir", "/var/folders/hh/thrdkjsj7yn83kx4xl6753y40000gn/T/");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test1315() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1315");
        int int2 = org.apache.commons.lang3.StringUtils.indexOf((java.lang.CharSequence) "\r", (java.lang.CharSequence) "user.name");
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test1316() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1316");
        double[] doubleArray5 = new double[] { 1.0d, 2147483647L, 100.0d, 10, 32.0f };
        double[] doubleArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(doubleArray5, 1.0d);
        double double8 = org.apache.commons.lang3.math.IEEE754rUtils.max(doubleArray7);
        org.junit.Assert.assertNotNull(doubleArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray5), "[1.0, 2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray7), "[2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 2.147483647E9d + "'", double8 == 2.147483647E9d);
    }

    @Test
    public void test1317() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1317");
        java.lang.Class[] classArray1 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray2 = (java.lang.Class<?>[]) classArray1;
        java.lang.Class<?> wildcardClass3 = null;
        java.lang.Class[] classArray5 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray6 = (java.lang.Class<?>[]) classArray5;
        wildcardClassArray6[0] = wildcardClass3;
        boolean boolean9 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray1, wildcardClassArray6);
        java.lang.Class[] classArray11 = new java.lang.Class[0];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray12 = (java.lang.Class<?>[]) classArray11;
        java.lang.Class<?> wildcardClass13 = null;
        java.lang.Class[] classArray15 = new java.lang.Class[1];
        @SuppressWarnings("unchecked")
        java.lang.Class<?>[] wildcardClassArray16 = (java.lang.Class<?>[]) classArray15;
        wildcardClassArray16[0] = wildcardClass13;
        boolean boolean19 = org.apache.commons.lang3.ClassUtils.isAssignable((java.lang.Class<?>[]) classArray11, wildcardClassArray16);
        boolean boolean21 = org.apache.commons.lang3.ClassUtils.isAssignable(wildcardClassArray6, (java.lang.Class<?>[]) classArray11, false);
        java.lang.Class<?>[] wildcardClassArray22 = org.apache.commons.lang3.ClassUtils.wrappersToPrimitives(wildcardClassArray6);
        org.junit.Assert.assertNotNull(classArray1);
        org.junit.Assert.assertNotNull(wildcardClassArray2);
        org.junit.Assert.assertNotNull(classArray5);
        org.junit.Assert.assertNotNull(wildcardClassArray6);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(classArray11);
        org.junit.Assert.assertNotNull(wildcardClassArray12);
        org.junit.Assert.assertNotNull(classArray15);
        org.junit.Assert.assertNotNull(wildcardClassArray16);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        org.junit.Assert.assertNotNull(wildcardClassArray22);
    }

    @Test
    public void test1318() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1318");
        byte byte1 = org.apache.commons.lang3.ObjectUtils.CONST((byte) 10);
        org.junit.Assert.assertTrue("'" + byte1 + "' != '" + (byte) 10 + "'", byte1 == (byte) 10);
    }

    @Test
    public void test1319() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1319");
        org.apache.commons.lang3.math.Fraction fraction0 = org.apache.commons.lang3.math.Fraction.TWO_THIRDS;
        org.apache.commons.lang3.math.Fraction fraction3 = org.apache.commons.lang3.math.Fraction.getFraction((int) (short) 1, (int) (short) 1);
        int int4 = fraction0.compareTo(fraction3);
        org.apache.commons.lang3.math.Fraction fraction7 = org.apache.commons.lang3.math.Fraction.getFraction((int) (short) 1, (int) (short) 1);
        java.util.Comparator<org.apache.commons.lang3.math.Fraction> fractionComparator8 = null;
        org.apache.commons.lang3.NumberRange<org.apache.commons.lang3.math.Fraction> fractionNumberRange9 = new org.apache.commons.lang3.NumberRange<org.apache.commons.lang3.math.Fraction>(fraction0, fraction7, fractionComparator8);
        org.apache.commons.lang3.math.Fraction fraction10 = org.apache.commons.lang3.math.Fraction.TWO_THIRDS;
        org.apache.commons.lang3.math.Fraction fraction13 = org.apache.commons.lang3.math.Fraction.getFraction((int) (short) 1, (int) (short) 1);
        int int14 = fraction10.compareTo(fraction13);
        float float15 = fraction13.floatValue();
        int int16 = fraction13.getNumerator();
        org.apache.commons.lang3.math.Fraction fraction17 = fraction7.add(fraction13);
        org.junit.Assert.assertNotNull(fraction0);
        org.junit.Assert.assertNotNull(fraction3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + (-1) + "'", int4 == (-1));
        org.junit.Assert.assertNotNull(fraction7);
        org.junit.Assert.assertNotNull(fraction10);
        org.junit.Assert.assertNotNull(fraction13);
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
        org.junit.Assert.assertTrue("'" + float15 + "' != '" + 1.0f + "'", float15 == 1.0f);
        org.junit.Assert.assertTrue("'" + int16 + "' != '" + 1 + "'", int16 == 1);
        org.junit.Assert.assertNotNull(fraction17);
    }

    @Test
    public void test1320() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1320");
        boolean[] booleanArray0 = new boolean[] {};
        int[] intArray1 = null;
        // The following exception was thrown during execution in test generation
        try {
            boolean[] booleanArray2 = org.apache.commons.lang3.ArrayUtils.removeAll(booleanArray0, intArray1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot read the array length because \"a\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray0), "[]");
    }

    @Test
    public void test1321() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1321");
        java.lang.Object obj1 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer2 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService3 = multiBackgroundInitializer2.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle6 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer10 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray11 = strTokenizer10.getTokenArray();
        java.lang.String str12 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle6, strArray11);
        java.lang.String str16 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray11, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int17 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray11);
        boolean boolean18 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray11);
        boolean boolean19 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj1, (java.lang.Object) executorService3, strArray11);
        boolean boolean20 = org.apache.commons.lang3.StringUtils.equalsAnyIgnoreCase((java.lang.CharSequence) "user.region", (java.lang.CharSequence[]) strArray11);
        org.junit.Assert.assertNull(executorService3);
        org.junit.Assert.assertNotNull(strArray11);
        org.junit.Assert.assertEquals("'" + str16 + "' != '" + "" + "'", str16, "");
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-1) + "'", int17 == (-1));
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
        org.junit.Assert.assertTrue("'" + boolean20 + "' != '" + false + "'", boolean20 == false);
    }

    @Test
    public void test1322() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1322");
        java.lang.Throwable throwable1 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException2 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable1);
        java.lang.Throwable[] throwableArray3 = uncheckedExecutionException2.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException5 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException2, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException6 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException5);
        org.apache.commons.lang3.exception.UncheckedException uncheckedException7 = new org.apache.commons.lang3.exception.UncheckedException((java.lang.Throwable) uncheckedTimeoutException6);
        org.junit.Assert.assertNotNull(throwableArray3);
    }

    @Test
    public void test1323() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1323");
        java.time.Duration duration0 = null;
        org.apache.commons.lang3.ThreadUtils.sleep(duration0);
    }

    @Test
    public void test1324() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1324");
        java.lang.String[] strArray1 = org.apache.commons.lang3.exception.ExceptionUtils.getDefaultCauseMethodNames();
        java.lang.CharSequence[] charSequenceArray3 = org.apache.commons.lang3.ArrayFill.fill((java.lang.CharSequence[]) strArray1, (java.lang.CharSequence) "Integer");
        int int4 = org.apache.commons.lang3.CharSetUtils.count("FastDateFormat[,en_SE,Europe/Stockholm]", strArray1);
        java.lang.String[] strArray5 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(strArray1);
        org.junit.Assert.assertNotNull(strArray1);
        org.junit.Assert.assertNotNull(charSequenceArray3);
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 10 + "'", int4 == 10);
        org.junit.Assert.assertNotNull(strArray5);
    }

    @Test
    public void test1325() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1325");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat((float) (short) -1);
        int int2 = mutableFloat1.intValue();
        org.apache.commons.lang3.mutable.MutableInt mutableInt3 = new org.apache.commons.lang3.mutable.MutableInt((java.lang.Number) int2);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
    }

    @Test
    public void test1326() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1326");
        java.util.Calendar calendar0 = null;
        java.util.Locale locale2 = null;
        java.util.Locale locale3 = org.apache.commons.lang3.LocaleUtils.toLocale(locale2);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = org.apache.commons.lang3.time.DateFormatUtils.format(calendar0, "org.apache.commons.lang3.concurrent.MultiBackgroundInitializer", locale3);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Illegal pattern component: o");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(locale3);
        org.junit.Assert.assertEquals(locale3.toString(), "en_SE");
    }

    @Test
    public void test1327() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1327");
        char[] charArray8 = new char[] { ' ', '#' };
        char[] charArray10 = new char[] { ' ' };
        char[] charArray11 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray8, charArray10);
        char[] charArray14 = org.apache.commons.lang3.ArrayUtils.add(charArray10, (int) (short) 0, ' ');
        char[] charArray19 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray22 = org.apache.commons.lang3.ArrayUtils.subarray(charArray19, (int) (short) 1, (-1));
        char[] charArray23 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray10, charArray19);
        char[] charArray26 = new char[] { ' ', '#' };
        char[] charArray28 = new char[] { ' ' };
        char[] charArray29 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray26, charArray28);
        char[] charArray32 = org.apache.commons.lang3.ArrayUtils.add(charArray28, (int) (short) 0, ' ');
        char[] charArray37 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray40 = org.apache.commons.lang3.ArrayUtils.subarray(charArray37, (int) (short) 1, (-1));
        char[] charArray41 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray28, charArray37);
        char[] charArray42 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray19, charArray41);
        char[] charArray45 = new char[] { ' ', '#' };
        char[] charArray47 = new char[] { ' ' };
        char[] charArray48 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray45, charArray47);
        char[] charArray51 = org.apache.commons.lang3.ArrayUtils.add(charArray47, (int) (short) 0, ' ');
        char[] charArray56 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray59 = org.apache.commons.lang3.ArrayUtils.subarray(charArray56, (int) (short) 1, (-1));
        char[] charArray60 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray47, charArray56);
        char[] charArray63 = new char[] { ' ', '#' };
        char[] charArray65 = new char[] { ' ' };
        char[] charArray66 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray63, charArray65);
        char[] charArray69 = org.apache.commons.lang3.ArrayUtils.add(charArray65, (int) (short) 0, ' ');
        char[] charArray74 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray77 = org.apache.commons.lang3.ArrayUtils.subarray(charArray74, (int) (short) 1, (-1));
        char[] charArray78 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray65, charArray74);
        char[] charArray79 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray56, charArray78);
        char[] charArray80 = org.apache.commons.lang3.ArrayUtils.insert(3, charArray41, charArray78);
        org.apache.commons.lang3.ArrayUtils.reverse(charArray80);
        java.util.Random random82 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str83 = org.apache.commons.lang3.RandomStringUtils.random(8, 0, (-48), true, true, charArray80, random82);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: The chars array must not be empty");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
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
        org.junit.Assert.assertNotNull(charArray14);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray14), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray14), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray14), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray19);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray19), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray19), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray19), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray22);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray22), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray22), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray22), "[]");
        org.junit.Assert.assertNotNull(charArray23);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray23), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray23), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray23), "[]");
        org.junit.Assert.assertNotNull(charArray26);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray26), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray26), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray26), "[ , #]");
        org.junit.Assert.assertNotNull(charArray28);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray28), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray28), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray28), "[ ]");
        org.junit.Assert.assertNotNull(charArray29);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray29), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray29), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray29), "[#]");
        org.junit.Assert.assertNotNull(charArray32);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray32), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray32), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray32), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray37);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray37), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray37), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray37), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray40);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray40), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray40), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray40), "[]");
        org.junit.Assert.assertNotNull(charArray41);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray41), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray41), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray41), "[]");
        org.junit.Assert.assertNotNull(charArray42);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray42), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray42), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray42), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray45);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray45), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray45), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray45), "[ , #]");
        org.junit.Assert.assertNotNull(charArray47);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray47), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray47), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray47), "[ ]");
        org.junit.Assert.assertNotNull(charArray48);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray48), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray48), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray48), "[#]");
        org.junit.Assert.assertNotNull(charArray51);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray51), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray51), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray51), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray56);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray56), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray56), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray56), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray59);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray59), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray59), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray59), "[]");
        org.junit.Assert.assertNotNull(charArray60);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray60), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray60), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray60), "[]");
        org.junit.Assert.assertNotNull(charArray63);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray63), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray63), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray63), "[ , #]");
        org.junit.Assert.assertNotNull(charArray65);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray65), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray65), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray65), "[ ]");
        org.junit.Assert.assertNotNull(charArray66);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray66), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray66), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray66), "[#]");
        org.junit.Assert.assertNotNull(charArray69);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray69), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray69), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray69), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray74);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray74), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray74), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray74), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray77);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray77), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray77), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray77), "[]");
        org.junit.Assert.assertNotNull(charArray78);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray78), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray78), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray78), "[]");
        org.junit.Assert.assertNotNull(charArray79);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray79), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray79), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray79), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray80);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray80), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray80), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray80), "[]");
    }

    @Test
    public void test1328() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1328");
        int int2 = org.apache.commons.lang3.CharUtils.compare('$', ' ');
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + 4 + "'", int2 == 4);
    }

    @Test
    public void test1329() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1329");
        org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException> strItorMutableTriple0 = new org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException>();
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
        strItorMutableTriple0.setMiddle(notImplementedException6);
        java.util.ListIterator<java.lang.String> strItor15 = strItorMutableTriple0.left;
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertNull(executorService8);
        org.junit.Assert.assertNull(executorService11);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair13);
        org.junit.Assert.assertNull(strItor15);
    }

    @Test
    public void test1330() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1330");
        org.apache.commons.lang3.NotImplementedException notImplementedException2 = new org.apache.commons.lang3.NotImplementedException("Long");
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.ConcurrentRuntimeException concurrentRuntimeException3 = new org.apache.commons.lang3.concurrent.ConcurrentRuntimeException("11.5", (java.lang.Throwable) notImplementedException2);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Not a checked exception: org.apache.commons.lang3.NotImplementedException: Long");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1331() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1331");
        java.lang.String str0 = org.apache.commons.lang3.SystemProperties.getJavaVmVersion();
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "16.0.1+9" + "'", str0, "16.0.1+9");
    }

    @Test
    public void test1332() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1332");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        java.lang.String str2 = fastDateFormat0.format((long) 100);
        org.apache.commons.lang3.concurrent.BackgroundInitializer.Builder<org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.JavaVersion>, org.apache.commons.lang3.JavaVersion> javaVersionBackgroundInitializerBuilder3 = org.apache.commons.lang3.concurrent.BackgroundInitializer.builder();
        org.apache.commons.lang3.mutable.MutableShort mutableShort5 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort5.setValue((java.lang.Number) (short) 100);
        org.apache.commons.lang3.mutable.MutableShort mutableShort9 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        short short10 = mutableShort9.incrementAndGet();
        org.apache.commons.lang3.mutable.MutableLong mutableLong12 = new org.apache.commons.lang3.mutable.MutableLong((long) (short) 1);
        mutableLong12.add((long) 0);
        mutableShort9.setValue((java.lang.Number) 0);
        org.apache.commons.lang3.mutable.MutableShort mutableShort16 = org.apache.commons.lang3.compare.ComparableUtils.min(mutableShort5, mutableShort9);
        org.apache.commons.lang3.math.Fraction fraction19 = org.apache.commons.lang3.math.Fraction.getFraction((int) (byte) -1, (-1));
        mutableShort9.add((java.lang.Number) fraction19);
        mutableShort9.add((java.lang.Number) 2147483647L);
        org.apache.commons.lang3.mutable.MutableShort mutableShort24 = new org.apache.commons.lang3.mutable.MutableShort((short) (byte) 100);
        mutableShort24.setValue((java.lang.Number) (short) 100);
        short short27 = mutableShort24.getAndDecrement();
        byte[] byteArray31 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray32 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray31);
        byte[] byteArray33 = org.apache.commons.lang3.ArrayUtils.EMPTY_BYTE_ARRAY;
        byte[] byteArray34 = org.apache.commons.lang3.ArrayUtils.insert((int) (short) 10, byteArray31, byteArray33);
        boolean boolean35 = mutableShort24.equals((java.lang.Object) (short) 10);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.mutable.MutableShort> mutableShortRange36 = org.apache.commons.lang3.Range.of(mutableShort9, mutableShort24);
        org.apache.commons.lang3.tuple.ImmutableTriple<org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.concurrent.BackgroundInitializer.Builder<org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.JavaVersion>, org.apache.commons.lang3.JavaVersion>, java.lang.Number> dateParserImmutableTriple37 = new org.apache.commons.lang3.tuple.ImmutableTriple<org.apache.commons.lang3.time.DateParser, org.apache.commons.lang3.concurrent.BackgroundInitializer.Builder<org.apache.commons.lang3.concurrent.BackgroundInitializer<org.apache.commons.lang3.JavaVersion>, org.apache.commons.lang3.JavaVersion>, java.lang.Number>((org.apache.commons.lang3.time.DateParser) fastDateFormat0, javaVersionBackgroundInitializerBuilder3, (java.lang.Number) mutableShort24);
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "01:00:00" + "'", str2, "01:00:00");
        org.junit.Assert.assertNotNull(javaVersionBackgroundInitializerBuilder3);
        org.junit.Assert.assertTrue("'" + short10 + "' != '" + (short) 101 + "'", short10 == (short) 101);
        org.junit.Assert.assertNotNull(mutableShort16);
        org.junit.Assert.assertNotNull(fraction19);
        org.junit.Assert.assertTrue("'" + short27 + "' != '" + (short) 100 + "'", short27 == (short) 100);
        org.junit.Assert.assertNotNull(byteArray31);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray31), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray32);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray32), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray33);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray33), "[]");
        org.junit.Assert.assertNotNull(byteArray34);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray34), "[0, -1]");
        org.junit.Assert.assertTrue("'" + boolean35 + "' != '" + false + "'", boolean35 == false);
        org.junit.Assert.assertNotNull(mutableShortRange36);
    }

    @Test
    public void test1333() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1333");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat0 = new org.apache.commons.lang3.mutable.MutableFloat();
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat();
        org.apache.commons.lang3.Range<org.apache.commons.lang3.mutable.MutableFloat> mutableFloatRange2 = org.apache.commons.lang3.Range.of(mutableFloat0, mutableFloat1);
        java.lang.Long[] longArray7 = new java.lang.Long[] { 1L, 0L, 1L, 0L };
        java.lang.Long[][] longArray8 = new java.lang.Long[][] { longArray7 };
        org.apache.commons.lang3.math.Fraction fraction9 = org.apache.commons.lang3.math.Fraction.TWO_THIRDS;
        java.lang.Long[][] longArray10 = org.apache.commons.lang3.ArrayUtils.removeElement(longArray8, (java.lang.Object) fraction9);
        mutableFloat0.setValue((java.lang.Number) fraction9);
        boolean boolean12 = mutableFloat0.isInfinite();
        org.junit.Assert.assertNotNull(mutableFloatRange2);
        org.junit.Assert.assertNotNull(longArray7);
        org.junit.Assert.assertNotNull(longArray8);
        org.junit.Assert.assertNotNull(fraction9);
        org.junit.Assert.assertNotNull(longArray10);
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test1334() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1334");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange2 = org.apache.commons.lang3.Range.of(javaVersion0, javaVersion1);
        java.util.Comparator<org.apache.commons.lang3.JavaVersion> javaVersionComparator3 = javaVersionRange2.getComparator();
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange2);
        org.junit.Assert.assertNotNull(javaVersionComparator3);
    }

    @Test
    public void test1335() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1335");
        // The following exception was thrown during execution in test generation
        try {
            java.util.Locale locale1 = org.apache.commons.lang3.LocaleUtils.toLocale("Mac OS X");
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid locale format: Mac OS X");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1336() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1336");
        org.apache.commons.lang3.DoubleRange doubleRange2 = org.apache.commons.lang3.DoubleRange.of(60000.0d, (double) (-5L));
        org.junit.Assert.assertNotNull(doubleRange2);
    }

    @Test
    public void test1337() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1337");
        java.lang.String[] strArray2 = org.apache.commons.lang3.StringUtils.split("01:00:00", '\n');
        org.junit.Assert.assertNotNull(strArray2);
    }

    @Test
    public void test1338() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1338");
        byte[] byteArray3 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray4 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray3);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.EMPTY_BYTE_ARRAY;
        byte[] byteArray6 = org.apache.commons.lang3.ArrayUtils.insert((int) (short) 10, byteArray3, byteArray5);
        java.util.Random random7 = null;
        org.apache.commons.lang3.ArrayUtils.shuffle(byteArray5, random7);
        byte[] byteArray10 = org.apache.commons.lang3.ArrayUtils.addFirst(byteArray5, (byte) -11);
        int int13 = org.apache.commons.lang3.ArrayUtils.indexOf(byteArray5, (byte) 100, (-87));
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray4), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[]");
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray6), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray10), "[-11]");
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + (-1) + "'", int13 == (-1));
    }

    @Test
    public void test1339() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1339");
        double[] doubleArray0 = null;
        double[] doubleArray1 = null;
        double[] doubleArray3 = org.apache.commons.lang3.ArrayUtils.addFirst(doubleArray1, (double) 10L);
        double[] doubleArray4 = org.apache.commons.lang3.ArrayUtils.addAll(doubleArray0, doubleArray3);
        org.junit.Assert.assertNotNull(doubleArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray3), "[10.0]");
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray4), "[10.0]");
    }

    @Test
    public void test1340() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1340");
        org.apache.commons.lang3.DoubleRange doubleRange2 = org.apache.commons.lang3.DoubleRange.of((double) 2147483647L, (double) 0L);
        java.lang.String str4 = doubleRange2.toString("java.vm.vendor");
        org.junit.Assert.assertNotNull(doubleRange2);
        org.junit.Assert.assertEquals("'" + str4 + "' != '" + "java.vm.vendor" + "'", str4, "java.vm.vendor");
    }

    @Test
    public void test1341() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1341");
        java.lang.Byte[] byteArray0 = new java.lang.Byte[] {};
        byte[] byteArray1 = org.apache.commons.lang3.ArrayUtils.toPrimitive(byteArray0);
        // The following exception was thrown during execution in test generation
        try {
            byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.remove(byteArray1, (int) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 35, Length: 0");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray0);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray1), "[]");
    }

    @Test
    public void test1342() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1342");
        java.lang.Throwable throwable2 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException3 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable2);
        java.lang.Throwable[] throwableArray4 = uncheckedExecutionException3.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException6 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException3, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException7 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException6);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException8 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException6);
        java.lang.Throwable[] throwableArray9 = org.apache.commons.lang3.exception.ExceptionUtils.getThrowables((java.lang.Throwable) notImplementedException6);
        org.apache.commons.lang3.NotImplementedException notImplementedException10 = new org.apache.commons.lang3.NotImplementedException("file.separator", (java.lang.Throwable) notImplementedException6);
        org.junit.Assert.assertNotNull(throwableArray4);
        org.junit.Assert.assertNotNull(throwableArray9);
    }

    @Test
    public void test1343() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1343");
        java.lang.String str2 = org.apache.commons.lang3.text.WordUtils.wrap("pen", (int) (short) 1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "pen" + "'", str2, "pen");
    }

    @Test
    public void test1344() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1344");
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
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder41 = autoCloseableDiffBuilder37.append("F16.0.1+9e/Stockholm]", (float) (byte) -11, (float) '#');
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
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder41);
    }

    @Test
    public void test1345() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1345");
        org.apache.commons.lang3.exception.ContextedException contextedException0 = new org.apache.commons.lang3.exception.ContextedException();
        java.lang.Object obj2 = contextedException0.getFirstContextValue("os.nam");
        org.apache.commons.lang3.exception.ExceptionUtils.printRootCauseStackTrace((java.lang.Throwable) contextedException0);
        org.junit.Assert.assertNull(obj2);
    }

    @Test
    public void test1346() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1346");
        org.apache.commons.lang3.NotImplementedException notImplementedException2 = new org.apache.commons.lang3.NotImplementedException("'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'", "65");
    }

    @Test
    public void test1347() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1347");
        org.apache.commons.lang3.mutable.MutableDouble mutableDouble1 = new org.apache.commons.lang3.mutable.MutableDouble((double) 0.0f);
        long long2 = mutableDouble1.longValue();
        org.junit.Assert.assertTrue("'" + long2 + "' != '" + 0L + "'", long2 == 0L);
    }

    @Test
    public void test1348() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1348");
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat0 = org.apache.commons.lang3.time.DateFormatUtils.ISO_8601_EXTENDED_TIME_FORMAT;
        java.lang.String str2 = fastDateFormat0.format((long) 100);
        java.text.Format format3 = org.apache.commons.lang3.SerializationUtils.roundtrip((java.text.Format) fastDateFormat0);
        org.junit.Assert.assertNotNull(fastDateFormat0);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "01:00:00" + "'", str2, "01:00:00");
        org.junit.Assert.assertNotNull(format3);
    }

    @Test
    public void test1349() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1349");
        org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException> strItorMutableTriple1 = new org.apache.commons.lang3.tuple.MutableTriple<java.util.ListIterator<java.lang.String>, org.apache.commons.lang3.NotImplementedException, org.apache.commons.lang3.exception.ContextedRuntimeException>();
        java.lang.Throwable throwable3 = null;
        org.apache.commons.lang3.concurrent.UncheckedExecutionException uncheckedExecutionException4 = new org.apache.commons.lang3.concurrent.UncheckedExecutionException(throwable3);
        java.lang.Throwable[] throwableArray5 = uncheckedExecutionException4.getSuppressed();
        org.apache.commons.lang3.NotImplementedException notImplementedException7 = new org.apache.commons.lang3.NotImplementedException("hi!", (java.lang.Throwable) uncheckedExecutionException4, "Integer");
        org.apache.commons.lang3.concurrent.UncheckedTimeoutException uncheckedTimeoutException8 = new org.apache.commons.lang3.concurrent.UncheckedTimeoutException((java.lang.Throwable) notImplementedException7);
        org.apache.commons.lang3.exception.ContextedRuntimeException contextedRuntimeException9 = new org.apache.commons.lang3.exception.ContextedRuntimeException((java.lang.Throwable) notImplementedException7);
        strItorMutableTriple1.setRight(contextedRuntimeException9);
        org.apache.commons.lang3.NotImplementedException notImplementedException11 = new org.apache.commons.lang3.NotImplementedException("\r", (java.lang.Throwable) contextedRuntimeException9);
        org.junit.Assert.assertNotNull(throwableArray5);
    }

    @Test
    public void test1350() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1350");
        byte[] byteArray2 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray3 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray2);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayFill.fill(byteArray2, (byte) 0);
        int int7 = org.apache.commons.lang3.ArrayUtils.lastIndexOf(byteArray5, (byte) 100);
        int int10 = org.apache.commons.lang3.ArrayUtils.lastIndexOf(byteArray5, (byte) 1, (int) 'M');
        byte[] byteArray12 = org.apache.commons.lang3.ArrayUtils.removeElement(byteArray5, (byte) -11);
        org.junit.Assert.assertNotNull(byteArray2);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray2), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, 0]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[0, 0]");
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
        org.junit.Assert.assertNotNull(byteArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray12), "[0, 0]");
    }

    @Test
    public void test1351() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1351");
        java.lang.Boolean[] booleanArray2 = new java.lang.Boolean[] { true, false };
        java.lang.Boolean boolean3 = org.apache.commons.lang3.BooleanUtils.oneHot(booleanArray2);
        java.lang.Boolean boolean4 = org.apache.commons.lang3.BooleanUtils.and(booleanArray2);
        org.junit.Assert.assertNotNull(booleanArray2);
        org.junit.Assert.assertEquals("'" + boolean3 + "' != '" + true + "'", boolean3, true);
        org.junit.Assert.assertEquals("'" + boolean4 + "' != '" + false + "'", boolean4, false);
    }

    @Test
    public void test1352() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1352");
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
        boolean boolean14 = org.apache.commons.lang3.ClassUtils.isPrimitiveOrWrapper(multiBackgroundInitializerResultsFailableSupplierClass13);
        java.lang.reflect.Field field17 = org.apache.commons.lang3.reflect.FieldUtils.getField(multiBackgroundInitializerResultsFailableSupplierClass13, "0\n0", false);
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        org.junit.Assert.assertNull(field17);
    }

    @Test
    public void test1353() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1353");
        short short3 = org.apache.commons.lang3.math.NumberUtils.min((short) 99, (short) (byte) 100, (short) 97);
        org.junit.Assert.assertTrue("'" + short3 + "' != '" + (short) 97 + "'", short3 == (short) 97);
    }

    @Test
    public void test1354() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1354");
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
        java.lang.CharSequence[] charSequenceArray43 = charSequenceArrayMutablePair2.left;
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
        org.junit.Assert.assertNull(charSequenceArray43);
    }

    @Test
    public void test1355() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1355");
        byte[] byteArray3 = new byte[] { (byte) 0, (byte) -1 };
        byte[] byteArray4 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(byteArray3);
        byte[] byteArray5 = org.apache.commons.lang3.ArrayUtils.EMPTY_BYTE_ARRAY;
        byte[] byteArray6 = org.apache.commons.lang3.ArrayUtils.insert((int) (short) 10, byteArray3, byteArray5);
        java.util.Random random7 = null;
        org.apache.commons.lang3.ArrayUtils.shuffle(byteArray5, random7);
        byte[] byteArray10 = org.apache.commons.lang3.ArrayUtils.addFirst(byteArray5, (byte) -11);
        org.apache.commons.lang3.ArrayUtils.shift(byteArray10, (int) '4', 3, (int) '4');
        org.junit.Assert.assertNotNull(byteArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray3), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray4), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray5), "[]");
        org.junit.Assert.assertNotNull(byteArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray6), "[0, -1]");
        org.junit.Assert.assertNotNull(byteArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray10), "[-11]");
    }

    @Test
    public void test1356() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1356");
        java.util.Locale locale3 = null;
        java.util.Locale locale4 = org.apache.commons.lang3.LocaleUtils.toLocale(locale3);
        java.lang.String str5 = org.apache.commons.lang3.StringUtils.lowerCase("user.name", locale4);
        int int6 = org.apache.commons.lang3.StringUtils.getFuzzyDistance((java.lang.CharSequence) "HH:mm:ss", (java.lang.CharSequence) "ContextedException: Exception Context:\n\t[1:yes=0]\n---------------------------------", locale4);
        org.junit.Assert.assertNotNull(locale4);
        org.junit.Assert.assertEquals(locale4.toString(), "en_SE");
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "user.name" + "'", str5, "user.name");
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test1357() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1357");
        org.apache.commons.lang3.JavaVersion javaVersion0 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion1 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange2 = org.apache.commons.lang3.Range.of(javaVersion0, javaVersion1);
        boolean boolean3 = javaVersionRange2.isNaturalOrdering();
        org.apache.commons.lang3.JavaVersion javaVersion4 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion5 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange6 = org.apache.commons.lang3.Range.of(javaVersion4, javaVersion5);
        org.apache.commons.lang3.JavaVersion javaVersion7 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion8 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.Range<org.apache.commons.lang3.JavaVersion> javaVersionRange9 = org.apache.commons.lang3.Range.of(javaVersion7, javaVersion8);
        char[] charArray12 = new char[] { ' ', '#' };
        char[] charArray14 = new char[] { ' ' };
        char[] charArray15 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray12, charArray14);
        boolean boolean16 = javaVersionRange9.equals((java.lang.Object) charArray15);
        boolean boolean17 = javaVersionRange6.isAfterRange(javaVersionRange9);
        boolean boolean18 = javaVersionRange2.isAfterRange(javaVersionRange6);
        org.junit.Assert.assertTrue("'" + javaVersion0 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion0.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion1 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion1.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange2);
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        org.junit.Assert.assertTrue("'" + javaVersion4 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion4.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion5 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion5.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange6);
        org.junit.Assert.assertTrue("'" + javaVersion7 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion7.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion8 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion8.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionRange9);
        org.junit.Assert.assertNotNull(charArray12);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray12), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray12), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray12), "[ , #]");
        org.junit.Assert.assertNotNull(charArray14);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray14), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray14), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray14), "[ ]");
        org.junit.Assert.assertNotNull(charArray15);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray15), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray15), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray15), "[#]");
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + false + "'", boolean18 == false);
    }

    @Test
    public void test1358() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1358");
        org.apache.commons.lang3.text.StrBuilder strBuilder1 = new org.apache.commons.lang3.text.StrBuilder("java.ext.dirs");
        org.apache.commons.lang3.text.StrBuilder strBuilder3 = strBuilder1.deleteFirst('o');
        org.apache.commons.lang3.text.StrBuilder strBuilder7 = strBuilder3.appendFixedWidthPadRight((int) '\n', (int) (byte) -1, '$');
        org.junit.Assert.assertNotNull(strBuilder3);
        org.junit.Assert.assertNotNull(strBuilder7);
    }

    @Test
    public void test1359() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1359");
        java.lang.String str0 = org.apache.commons.lang3.CharEncoding.UTF_16LE;
        org.junit.Assert.assertEquals("'" + str0 + "' != '" + "UTF-16LE" + "'", str0, "UTF-16LE");
    }

    @Test
    public void test1360() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1360");
        java.lang.Boolean boolean1 = org.apache.commons.lang3.BooleanUtils.toBooleanObject((int) (short) 101);
        org.junit.Assert.assertEquals("'" + boolean1 + "' != '" + true + "'", boolean1, true);
    }

    @Test
    public void test1361() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1361");
        org.apache.commons.lang3.function.FailableObjDoubleConsumer<java.lang.Long[], org.apache.commons.lang3.concurrent.UncheckedTimeoutException> longArrayFailableObjDoubleConsumer0 = org.apache.commons.lang3.function.FailableObjDoubleConsumer.nop();
        org.junit.Assert.assertNotNull(longArrayFailableObjDoubleConsumer0);
    }

    @Test
    public void test1362() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1362");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        standardToStringStyle0.setNullText("FastDateFormat[HH:mm:ss,en_SE,Europe/Stockholm]");
        standardToStringStyle0.setFieldSeparatorAtStart(true);
        java.lang.String str5 = standardToStringStyle0.getArraySeparator();
        java.lang.String str6 = standardToStringStyle0.getArrayEnd();
        org.apache.commons.lang3.builder.ToStringBuilder.setDefaultStyle((org.apache.commons.lang3.builder.ToStringStyle) standardToStringStyle0);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "," + "'", str5, ",");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "}" + "'", str6, "}");
    }

    @Test
    public void test1363() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1363");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.Integer int1 = org.apache.commons.lang3.math.NumberUtils.createInteger("UTF-16BE");
            org.junit.Assert.fail("Expected exception of type java.lang.NumberFormatException; message: For input string: \"UTF-16BE\"");
        } catch (java.lang.NumberFormatException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1364() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1364");
        org.apache.commons.lang3.reflect.TypeUtils.WildcardTypeBuilder wildcardTypeBuilder0 = org.apache.commons.lang3.reflect.TypeUtils.wildcardType();
        org.junit.Assert.assertNotNull(wildcardTypeBuilder0);
    }

    @Test
    public void test1365() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1365");
        java.lang.String str1 = org.apache.commons.lang3.StringEscapeUtils.unescapeXml("\\u002e");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "\\u002e" + "'", str1, "\\u002e");
    }

    @Test
    public void test1366() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1366");
        org.apache.commons.lang3.builder.StandardToStringStyle standardToStringStyle0 = new org.apache.commons.lang3.builder.StandardToStringStyle();
        org.apache.commons.lang3.builder.ToStringStyle toStringStyle1 = org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;
        java.lang.String str2 = org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString((java.lang.Object) standardToStringStyle0, toStringStyle1);
        java.lang.StringBuffer stringBuffer3 = null;
        java.lang.Object obj4 = null;
        standardToStringStyle0.appendStart(stringBuffer3, obj4);
        java.lang.StringBuffer stringBuffer6 = null;
        // The following exception was thrown during execution in test generation
        try {
            standardToStringStyle0.append(stringBuffer6, "/Users/glacierali", (int) '6');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.lang.StringBuffer.append(String)\" because \"buffer\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(toStringStyle1);
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false" + "'", str2, "true,},,,{,],[,true,=,,,false,false,<null>,>,<size=,>,<,true,true,true,false");
    }

    @Test
    public void test1367() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1367");
        boolean boolean0 = org.apache.commons.lang3.SystemUtils.IS_OS_MAC_OSX_CATALINA;
        org.junit.Assert.assertTrue("'" + boolean0 + "' != '" + false + "'", boolean0 == false);
    }

    @Test
    public void test1368() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1368");
        java.lang.Byte[] byteArray0 = new java.lang.Byte[] {};
        byte[] byteArray1 = org.apache.commons.lang3.ArrayUtils.toPrimitive(byteArray0);
        // The following exception was thrown during execution in test generation
        try {
            int int6 = org.apache.commons.lang3.Conversion.byteArrayToInt(byteArray1, (int) (short) 101, (-981035596), (int) (short) 100, (int) '$');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: (nBytes-1)*8+dstPos is greater or equal to than 32");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(byteArray0);
        org.junit.Assert.assertNotNull(byteArray1);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(byteArray1), "[]");
    }

    @Test
    public void test1369() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1369");
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
        long[] longArray39 = org.apache.commons.lang3.ArrayUtils.add(longArray36, (-1L));
        org.apache.commons.lang3.ArrayUtils.shift(longArray39, 8, 3, 0);
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
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray39), "[60000, 10, 100, 100, 97, 52, 101, -1]");
    }

    @Test
    public void test1370() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1370");
        org.apache.commons.lang3.mutable.MutableDouble mutableDouble1 = new org.apache.commons.lang3.mutable.MutableDouble((java.lang.Number) 8);
    }

    @Test
    public void test1371() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1371");
        org.apache.commons.lang3.mutable.MutableInt mutableInt1 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        mutableInt1.setValue((int) 'a');
        mutableInt1.subtract((int) '4');
        int int6 = mutableInt1.decrementAndGet();
        java.util.Locale[] localeArray7 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList8 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean9 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList8, localeArray7);
        java.net.URL[] uRLArray11 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection12 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList8, "Integer", (java.lang.Object[]) uRLArray11);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream13 = org.apache.commons.lang3.stream.Streams.failableStream((java.util.Collection<java.util.Locale>) localeList8);
        java.util.Locale[] localeArray14 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList15 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList15, localeArray14);
        java.net.URL[] uRLArray18 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection19 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList15, "Integer", (java.lang.Object[]) uRLArray18);
        java.util.Locale[] localeArray20 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList21 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean22 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList21, localeArray20);
        java.net.URL[] uRLArray24 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection25 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList21, "Integer", (java.lang.Object[]) uRLArray24);
        java.util.Locale[] localeArray26 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList27 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean28 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList27, localeArray26);
        java.net.URL[] uRLArray30 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection31 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList27, "Integer", (java.lang.Object[]) uRLArray30);
        org.apache.commons.lang3.stream.Streams.FailableStream<java.util.Locale> localeFailableStream32 = org.apache.commons.lang3.stream.Streams.failableStream((java.util.Collection<java.util.Locale>) localeList27);
        java.util.RandomAccess[] randomAccessArray33 = new java.util.RandomAccess[] { localeList8, localeList15, localeList21, localeList27 };
        java.util.Locale[] localeArray34 = new java.util.Locale[] {};
        java.util.ArrayList<java.util.Locale> localeList35 = new java.util.ArrayList<java.util.Locale>();
        boolean boolean36 = java.util.Collections.addAll((java.util.Collection<java.util.Locale>) localeList35, localeArray34);
        java.net.URL[] uRLArray38 = org.apache.commons.lang3.ClassLoaderUtils.getThreadURLs();
        java.util.Collection<java.util.Locale> localeCollection39 = org.apache.commons.lang3.Validate.noNullElements((java.util.Collection<java.util.Locale>) localeList35, "Integer", (java.lang.Object[]) uRLArray38);
        java.util.RandomAccess[] randomAccessArray40 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(randomAccessArray33, (java.util.RandomAccess) localeList35);
        boolean boolean41 = mutableInt1.equals((java.lang.Object) randomAccessArray40);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 44 + "'", int6 == 44);
        org.junit.Assert.assertNotNull(localeArray7);
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        org.junit.Assert.assertNotNull(uRLArray11);
        org.junit.Assert.assertNotNull(localeCollection12);
        org.junit.Assert.assertNotNull(localeFailableStream13);
        org.junit.Assert.assertNotNull(localeArray14);
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + false + "'", boolean16 == false);
        org.junit.Assert.assertNotNull(uRLArray18);
        org.junit.Assert.assertNotNull(localeCollection19);
        org.junit.Assert.assertNotNull(localeArray20);
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + false + "'", boolean22 == false);
        org.junit.Assert.assertNotNull(uRLArray24);
        org.junit.Assert.assertNotNull(localeCollection25);
        org.junit.Assert.assertNotNull(localeArray26);
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
        org.junit.Assert.assertNotNull(uRLArray30);
        org.junit.Assert.assertNotNull(localeCollection31);
        org.junit.Assert.assertNotNull(localeFailableStream32);
        org.junit.Assert.assertNotNull(randomAccessArray33);
        org.junit.Assert.assertNotNull(localeArray34);
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + false + "'", boolean36 == false);
        org.junit.Assert.assertNotNull(uRLArray38);
        org.junit.Assert.assertNotNull(localeCollection39);
        org.junit.Assert.assertNotNull(randomAccessArray40);
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + false + "'", boolean41 == false);
    }

    @Test
    public void test1372() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1372");
        // The following exception was thrown during execution in test generation
        try {
            int int4 = org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode((-27), (int) (short) 97, (java.lang.Object) "glacierali", true);
            org.junit.Assert.fail("Expected exception of type java.lang.reflect.InaccessibleObjectException; message: Unable to make field static final boolean java.lang.String.COMPACT_STRINGS accessible: module java.base does not \"opens java.lang\" to unnamed module @654b5005");
        } catch (java.lang.reflect.InaccessibleObjectException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1373() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1373");
        org.apache.commons.lang3.text.StrBuilder strBuilder1 = new org.apache.commons.lang3.text.StrBuilder("java.ext.dirs");
        org.apache.commons.lang3.text.StrBuilder strBuilder3 = strBuilder1.append(1L);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.text.StrBuilder strBuilder6 = strBuilder1.delete(96, 2);
            org.junit.Assert.fail("Expected exception of type java.lang.StringIndexOutOfBoundsException; message: end < start");
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strBuilder3);
    }

    @Test
    public void test1374() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1374");
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
        char[] charArray47 = org.apache.commons.lang3.ArrayUtils.add(charArray43, (int) (short) 0, ' ');
        char[] charArray50 = new char[] { ' ', '#' };
        char[] charArray52 = new char[] { ' ' };
        char[] charArray53 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray50, charArray52);
        char[] charArray56 = org.apache.commons.lang3.ArrayUtils.add(charArray52, (int) (short) 0, ' ');
        char[] charArray61 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray64 = org.apache.commons.lang3.ArrayUtils.subarray(charArray61, (int) (short) 1, (-1));
        char[] charArray65 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray52, charArray61);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder66 = autoCloseableDiffBuilder14.append("user.name", charArray47, charArray65);
        float[] floatArray72 = new float[] { (short) 1, (short) 100, 1.0f, '4' };
        float float73 = org.apache.commons.lang3.math.NumberUtils.min(floatArray72);
        org.apache.commons.lang3.JavaVersion javaVersion74 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        org.apache.commons.lang3.JavaVersion javaVersion75 = org.apache.commons.lang3.JavaVersion.JAVA_0_9;
        java.util.function.Predicate<org.apache.commons.lang3.JavaVersion> javaVersionPredicate76 = org.apache.commons.lang3.compare.ComparableUtils.between(javaVersion74, javaVersion75);
        boolean boolean78 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals((java.lang.Object) floatArray72, (java.lang.Object) javaVersionPredicate76, false);
        float[] floatArray79 = org.apache.commons.lang3.ArrayUtils.clone(floatArray72);
        float[] floatArray83 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray90 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean91 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray83, floatArray90);
        float[] floatArray93 = org.apache.commons.lang3.ArrayUtils.addFirst(floatArray90, (float) (short) 0);
        org.apache.commons.lang3.builder.DiffBuilder<java.lang.AutoCloseable> autoCloseableDiffBuilder94 = autoCloseableDiffBuilder14.append("60.0", floatArray79, floatArray93);
        int[] intArray96 = org.apache.commons.lang3.StringUtils.toCodePoints((java.lang.CharSequence) "HH:mm:ss");
        // The following exception was thrown during execution in test generation
        try {
            float[] floatArray97 = org.apache.commons.lang3.ArrayUtils.removeAll(floatArray79, intArray96);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: 115, Length: 4");
        } catch (java.lang.IndexOutOfBoundsException e) {
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
        org.junit.Assert.assertNotNull(charArray50);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray50), " #");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray50), " #");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray50), "[ , #]");
        org.junit.Assert.assertNotNull(charArray52);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray52), " ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray52), " ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray52), "[ ]");
        org.junit.Assert.assertNotNull(charArray53);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray53), "#");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray53), "#");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray53), "[#]");
        org.junit.Assert.assertNotNull(charArray56);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray56), "  ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray56), "  ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray56), "[ ,  ]");
        org.junit.Assert.assertNotNull(charArray61);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray61), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray61), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray61), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray64);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray64), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray64), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray64), "[]");
        org.junit.Assert.assertNotNull(charArray65);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray65), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray65), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray65), "[]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder66);
        org.junit.Assert.assertNotNull(floatArray72);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray72), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertTrue("'" + float73 + "' != '" + 1.0f + "'", float73 == 1.0f);
        org.junit.Assert.assertTrue("'" + javaVersion74 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion74.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertTrue("'" + javaVersion75 + "' != '" + org.apache.commons.lang3.JavaVersion.JAVA_0_9 + "'", javaVersion75.equals(org.apache.commons.lang3.JavaVersion.JAVA_0_9));
        org.junit.Assert.assertNotNull(javaVersionPredicate76);
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + false + "'", boolean78 == false);
        org.junit.Assert.assertNotNull(floatArray79);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray79), "[1.0, 100.0, 1.0, 52.0]");
        org.junit.Assert.assertNotNull(floatArray83);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray83), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray90);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray90), "[32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean91 + "' != '" + false + "'", boolean91 == false);
        org.junit.Assert.assertNotNull(floatArray93);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray93), "[0.0, 32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
        org.junit.Assert.assertNotNull(autoCloseableDiffBuilder94);
        org.junit.Assert.assertNotNull(intArray96);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray96), "[72, 72, 58, 109, 109, 58, 115, 115]");
    }

    @Test
    public void test1375() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1375");
        org.apache.commons.lang3.function.FailableDoubleToLongFunction<org.apache.commons.lang3.exception.ContextedRuntimeException> contextedRuntimeExceptionFailableDoubleToLongFunction0 = org.apache.commons.lang3.function.FailableDoubleToLongFunction.nop();
        org.apache.commons.lang3.function.FailableDoubleToLongFunction failableDoubleToLongFunction1 = org.apache.commons.lang3.function.FailableDoubleToLongFunction.NOP;
        org.apache.commons.lang3.function.FailableDoubleToLongFunction failableDoubleToLongFunction2 = org.apache.commons.lang3.function.FailableDoubleToLongFunction.NOP;
        org.apache.commons.lang3.function.FailableDoubleToLongFunction<java.lang.UnsupportedOperationException> unsupportedOperationExceptionFailableDoubleToLongFunction3 = org.apache.commons.lang3.function.FailableDoubleToLongFunction.nop();
        org.apache.commons.lang3.function.FailableDoubleToLongFunction[] failableDoubleToLongFunctionArray4 = new org.apache.commons.lang3.function.FailableDoubleToLongFunction[] { contextedRuntimeExceptionFailableDoubleToLongFunction0, failableDoubleToLongFunction1, failableDoubleToLongFunction2, unsupportedOperationExceptionFailableDoubleToLongFunction3 };
        org.apache.commons.lang3.function.FailableDoubleToLongFunction<org.apache.commons.lang3.exception.ContextedRuntimeException> contextedRuntimeExceptionFailableDoubleToLongFunction5 = org.apache.commons.lang3.function.FailableDoubleToLongFunction.nop();
        org.apache.commons.lang3.function.FailableDoubleToLongFunction[] failableDoubleToLongFunctionArray6 = org.apache.commons.lang3.ArrayUtils.addFirst(failableDoubleToLongFunctionArray4, (org.apache.commons.lang3.function.FailableDoubleToLongFunction) contextedRuntimeExceptionFailableDoubleToLongFunction5);
        org.junit.Assert.assertNotNull(contextedRuntimeExceptionFailableDoubleToLongFunction0);
        org.junit.Assert.assertNotNull(failableDoubleToLongFunction1);
        org.junit.Assert.assertNotNull(failableDoubleToLongFunction2);
        org.junit.Assert.assertNotNull(unsupportedOperationExceptionFailableDoubleToLongFunction3);
        org.junit.Assert.assertNotNull(failableDoubleToLongFunctionArray4);
        org.junit.Assert.assertNotNull(contextedRuntimeExceptionFailableDoubleToLongFunction5);
        org.junit.Assert.assertNotNull(failableDoubleToLongFunctionArray6);
    }

    @Test
    public void test1376() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1376");
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
        char[] charArray80 = new char[] { 'a', '\n', '4', ' ' };
        char[] charArray83 = org.apache.commons.lang3.ArrayUtils.subarray(charArray80, (int) (short) 1, (-1));
        char[] charArray84 = org.apache.commons.lang3.ArrayUtils.removeElements(charArray75, charArray80);
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
        org.junit.Assert.assertNotNull(charArray80);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray80), "a\n4 ");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray80), "a\n4 ");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray80), "[a, \n, 4,  ]");
        org.junit.Assert.assertNotNull(charArray83);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray83), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray83), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray83), "[]");
        org.junit.Assert.assertNotNull(charArray84);
        org.junit.Assert.assertEquals(java.lang.String.copyValueOf(charArray84), "");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(charArray84), "");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(charArray84), "[]");
    }

    @Test
    public void test1377() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1377");
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
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults multiBackgroundInitializerResults14 = multiBackgroundInitializer9.get();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: start() must be called first!");
        } catch (java.lang.IllegalStateException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(throwableArray3);
        org.junit.Assert.assertNull(executorService7);
        org.junit.Assert.assertNull(executorService10);
        org.junit.Assert.assertNotNull(notImplementedExceptionMutablePair12);
        org.junit.Assert.assertNotNull(multiBackgroundInitializerResultsFailableSupplierClass13);
    }

    @Test
    public void test1378() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1378");
        org.apache.commons.lang3.tuple.ImmutablePair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayImmutablePair0 = org.apache.commons.lang3.tuple.ImmutablePair.nullPair();
        java.lang.CharSequence[] charSequenceArray1 = charSequenceArrayImmutablePair0.left;
        org.apache.commons.lang3.tuple.Pair<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>> charSequenceArrayPair2 = org.apache.commons.lang3.tuple.Pair.of((java.util.Map.Entry<java.lang.CharSequence[], java.util.AbstractCollection<java.util.Locale>>) charSequenceArrayImmutablePair0);
        java.lang.CharSequence[] charSequenceArray3 = charSequenceArrayPair2.getKey();
        org.junit.Assert.assertNotNull(charSequenceArrayImmutablePair0);
        org.junit.Assert.assertNull(charSequenceArray1);
        org.junit.Assert.assertNotNull(charSequenceArrayPair2);
        org.junit.Assert.assertNull(charSequenceArray3);
    }

    @Test
    public void test1379() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1379");
        org.apache.commons.lang3.text.StrBuilder strBuilder1 = new org.apache.commons.lang3.text.StrBuilder("java.ext.dirs");
        org.apache.commons.lang3.text.StrBuilder strBuilder3 = strBuilder1.deleteFirst('o');
        org.apache.commons.lang3.text.StrBuilder strBuilder4 = strBuilder1.trim();
        org.junit.Assert.assertNotNull(strBuilder3);
        org.junit.Assert.assertNotNull(strBuilder4);
    }

    @Test
    public void test1380() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1380");
        org.apache.commons.lang3.builder.DiffBuilder.Builder<org.apache.commons.lang3.concurrent.ConcurrentInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>> multiBackgroundInitializerResultsConcurrentInitializerBuilder0 = new org.apache.commons.lang3.builder.DiffBuilder.Builder<org.apache.commons.lang3.concurrent.ConcurrentInitializer<org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.MultiBackgroundInitializerResults>>();
    }

    @Test
    public void test1381() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1381");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.substringBefore("FastDateFormat[yyyy-MM-dd,en_SE,Europe/Stockholm]", "java.awt.headless");
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "FastDateFormat[yyyy-MM-dd,en_SE,Europe/Stockholm]" + "'", str2, "FastDateFormat[yyyy-MM-dd,en_SE,Europe/Stockholm]");
    }

    @Test
    public void test1382() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1382");
        boolean boolean1 = org.apache.commons.lang3.StringUtils.isAllUpperCase((java.lang.CharSequence) "OpenJDK Runtime Environment");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test1383() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1383");
        long long0 = org.apache.commons.lang3.time.DateUtils.MILLIS_PER_SECOND;
        org.junit.Assert.assertTrue("'" + long0 + "' != '" + 1000L + "'", long0 == 1000L);
    }

    @Test
    public void test1384() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1384");
        java.lang.String str3 = org.apache.commons.lang3.StringUtils.rightPad("false\000true\000false\000true\000false", 0, "false\000true\000false\000true\000false");
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "false\000true\000false\000true\000false" + "'", str3, "false\000true\000false\000true\000false");
    }

    @Test
    public void test1385() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1385");
        boolean[] booleanArray5 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray7 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray5, false);
        java.util.BitSet bitSet9 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray5, true);
        boolean[] booleanArray11 = org.apache.commons.lang3.ArrayUtils.add(booleanArray5, true);
        org.apache.commons.lang3.ArrayUtils.shift(booleanArray11, (int) '\n');
        boolean[] booleanArray15 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(booleanArray11, true);
        boolean boolean16 = org.apache.commons.lang3.BooleanUtils.or(booleanArray11);
        org.junit.Assert.assertNotNull(booleanArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray5), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray7), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet9);
        org.junit.Assert.assertEquals(bitSet9.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(booleanArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray11), "[false, true, false, true, false, true]");
        org.junit.Assert.assertNotNull(booleanArray15);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray15), "[false, false, false]");
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test1386() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1386");
        java.lang.reflect.WildcardType wildcardType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            java.lang.reflect.Type[] typeArray1 = org.apache.commons.lang3.reflect.TypeUtils.getImplicitLowerBounds(wildcardType0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: wildcardType");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
    }

    @Test
    public void test1387() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1387");
        org.apache.commons.lang3.mutable.MutableObject<org.apache.commons.lang3.function.BooleanConsumer> booleanConsumerMutableObject0 = new org.apache.commons.lang3.mutable.MutableObject<org.apache.commons.lang3.function.BooleanConsumer>();
        org.apache.commons.lang3.function.BooleanConsumer booleanConsumer1 = booleanConsumerMutableObject0.getValue();
        org.apache.commons.lang3.function.BooleanConsumer booleanConsumer2 = org.apache.commons.lang3.function.BooleanConsumer.nop();
        booleanConsumerMutableObject0.setValue(booleanConsumer2);
        org.junit.Assert.assertNull(booleanConsumer1);
        org.junit.Assert.assertNotNull(booleanConsumer2);
    }

    @Test
    public void test1388() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1388");
        org.apache.commons.lang3.mutable.MutableInt mutableInt1 = new org.apache.commons.lang3.mutable.MutableInt((int) 'a');
        mutableInt1.setValue((int) 'a');
        mutableInt1.subtract((int) '4');
        int int6 = mutableInt1.decrementAndGet();
        int int7 = mutableInt1.decrementAndGet();
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 44 + "'", int6 == 44);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 43 + "'", int7 == 43);
    }

    @Test
    public void test1389() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1389");
        java.lang.String[] strArray3 = org.apache.commons.lang3.StringUtils.splitByWholeSeparatorPreserveAllTokens("StrTokenizer[not tokenized yet]", "https://adoptopenjdk.net/", 4);
        org.junit.Assert.assertNotNull(strArray3);
    }

    @Test
    public void test1390() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1390");
        java.lang.String str2 = org.apache.commons.lang3.StringUtils.left("16.0.1", (-48));
        org.junit.Assert.assertEquals("'" + str2 + "' != '" + "" + "'", str2, "");
    }

    @Test
    public void test1391() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1391");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.defaultString("QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc" + "'", str1, "QIQdSlhwdZphmnhLDEUObHtrxvPoEpJJkqRvHRXwZdleTEeeBBbJKgYjpSuKYZyECPhBKnXffIxeRtFdRFvnWjWRANAxdDXOqBDzc");
    }

    @Test
    public void test1392() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1392");
        org.apache.commons.lang3.mutable.MutableFloat mutableFloat1 = new org.apache.commons.lang3.mutable.MutableFloat((float) (short) -1);
        int int2 = mutableFloat1.intValue();
        float float4 = mutableFloat1.addAndGet((java.lang.Number) (-1L));
        float float6 = mutableFloat1.getAndAdd((java.lang.Number) 2147483647L);
        org.junit.Assert.assertTrue("'" + int2 + "' != '" + (-1) + "'", int2 == (-1));
        org.junit.Assert.assertTrue("'" + float4 + "' != '" + (-2.0f) + "'", float4 == (-2.0f));
        org.junit.Assert.assertTrue("'" + float6 + "' != '" + (-2.0f) + "'", float6 == (-2.0f));
    }

    @Test
    public void test1393() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1393");
        org.apache.commons.lang3.text.StrBuilder strBuilder1 = new org.apache.commons.lang3.text.StrBuilder("java.ext.dirs");
        org.apache.commons.lang3.text.StrBuilder strBuilder3 = strBuilder1.deleteFirst('o');
        org.apache.commons.lang3.text.StrBuilder strBuilder5 = strBuilder3.append((long) (byte) 1);
        org.apache.commons.lang3.text.StrBuilder strBuilder7 = new org.apache.commons.lang3.text.StrBuilder("java.ext.dirs");
        boolean boolean8 = strBuilder3.equals(strBuilder7);
        org.apache.commons.lang3.text.StrBuilder strBuilder10 = strBuilder3.appendSeparator('.');
        org.junit.Assert.assertNotNull(strBuilder3);
        org.junit.Assert.assertNotNull(strBuilder5);
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        org.junit.Assert.assertNotNull(strBuilder10);
    }

    @Test
    public void test1394() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1394");
        java.lang.String str1 = org.apache.commons.lang3.StringUtils.trim("DOUBLEjava.specification.versionDOUBLE");
        org.junit.Assert.assertEquals("'" + str1 + "' != '" + "DOUBLEjava.specification.versionDOUBLE" + "'", str1, "DOUBLEjava.specification.versionDOUBLE");
    }

    @Test
    public void test1395() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1395");
        org.apache.commons.lang3.concurrent.ThresholdCircuitBreaker thresholdCircuitBreaker1 = new org.apache.commons.lang3.concurrent.ThresholdCircuitBreaker((long) (-48));
    }

    @Test
    public void test1396() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1396");
        long[] longArray6 = new long[] { (short) 10, 1L, 'a', 100L, ' ', 100 };
        long[] longArray8 = org.apache.commons.lang3.ArrayUtils.remove(longArray6, 3);
        long[] longArray10 = new long[] { 3 };
        long[] longArray11 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(longArray10);
        boolean boolean12 = org.apache.commons.lang3.ArrayUtils.isSameLength(longArray8, longArray10);
        org.junit.Assert.assertNotNull(longArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray6), "[10, 1, 97, 100, 32, 100]");
        org.junit.Assert.assertNotNull(longArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray8), "[10, 1, 97, 32, 100]");
        org.junit.Assert.assertNotNull(longArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray10), "[3]");
        org.junit.Assert.assertNotNull(longArray11);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(longArray11), "[3]");
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test1397() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1397");
        int[] intArray5 = new int[] { (short) 100, (short) 10, (short) 10, '\n', '\n' };
        int[] intArray7 = org.apache.commons.lang3.ArrayUtils.add(intArray5, (int) '4');
        int[] intArray9 = org.apache.commons.lang3.ArrayUtils.add(intArray7, (int) (byte) -1);
        int[] intArray12 = org.apache.commons.lang3.ArrayUtils.subarray(intArray9, (int) (byte) 1, (-87));
        org.junit.Assert.assertNotNull(intArray5);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray5), "[100, 10, 10, 10, 10]");
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray7), "[100, 10, 10, 10, 10, 52]");
        org.junit.Assert.assertNotNull(intArray9);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray9), "[100, 10, 10, 10, 10, 52, -1]");
        org.junit.Assert.assertNotNull(intArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(intArray12), "[]");
    }

    @Test
    public void test1398() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1398");
        java.util.concurrent.TimeUnit timeUnit1 = null;
        org.apache.commons.lang3.concurrent.TimedSemaphore timedSemaphore3 = new org.apache.commons.lang3.concurrent.TimedSemaphore((long) (short) 1, timeUnit1, (int) (byte) -1);
        int int4 = timedSemaphore3.getLastAcquiresPerPeriod();
        boolean boolean5 = timedSemaphore3.isShutdown();
        int int6 = timedSemaphore3.getAcquireCount();
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 0 + "'", int4 == 0);
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }

    @Test
    public void test1399() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1399");
        java.lang.String[][] strArray0 = org.apache.commons.lang3.text.translate.EntityArrays.ISO8859_1_UNESCAPE();
        org.junit.Assert.assertNotNull(strArray0);
    }

    @Test
    public void test1400() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1400");
        org.apache.commons.lang3.exception.ContextedException contextedException0 = new org.apache.commons.lang3.exception.ContextedException();
        java.lang.Long[] longArray8 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray15 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray22 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray29 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[] longArray36 = new java.lang.Long[] { 1L, (-1L), (-1L), 0L, 100L, 1L };
        java.lang.Long[][] longArray37 = new java.lang.Long[][] { longArray8, longArray15, longArray22, longArray29, longArray36 };
        java.util.function.Supplier<java.lang.String> strSupplier38 = null;
        java.lang.String str39 = org.apache.commons.lang3.ObjectUtils.toString(longArray37, strSupplier38);
        org.apache.commons.lang3.exception.ContextedException contextedException40 = contextedException0.addContextValue("pen", (java.lang.Object) str39);
        java.io.PrintWriter printWriter41 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.exception.ExceptionUtils.printRootCauseStackTrace((java.lang.Throwable) contextedException40, printWriter41);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: printWriter");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(longArray8);
        org.junit.Assert.assertNotNull(longArray15);
        org.junit.Assert.assertNotNull(longArray22);
        org.junit.Assert.assertNotNull(longArray29);
        org.junit.Assert.assertNotNull(longArray36);
        org.junit.Assert.assertNotNull(longArray37);
        org.junit.Assert.assertNotNull(contextedException40);
    }

    @Test
    public void test1401() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1401");
        java.lang.reflect.Method method0 = null;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces1 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces2 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces3 = org.apache.commons.lang3.compare.ComparableUtils.min(interfaces1, interfaces2);
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces4 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces5 = org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE;
        org.apache.commons.lang3.ClassUtils.Interfaces interfaces6 = org.apache.commons.lang3.compare.ComparableUtils.min(interfaces4, interfaces5);
        org.apache.commons.lang3.Range<org.apache.commons.lang3.ClassUtils.Interfaces> interfacesRange7 = org.apache.commons.lang3.Range.of(interfaces3, interfaces5);
        // The following exception was thrown during execution in test generation
        try {
            java.util.Set<java.lang.reflect.Method> methodSet8 = org.apache.commons.lang3.reflect.MethodUtils.getOverrideHierarchy(method0, interfaces3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: method");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertTrue("'" + interfaces1 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces1.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces2 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces2.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces3 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces3.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces4 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces4.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces5 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces5.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertTrue("'" + interfaces6 + "' != '" + org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE + "'", interfaces6.equals(org.apache.commons.lang3.ClassUtils.Interfaces.EXCLUDE));
        org.junit.Assert.assertNotNull(interfacesRange7);
    }

    @Test
    public void test1402() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1402");
        float[] floatArray0 = null;
        int int3 = org.apache.commons.lang3.ArrayUtils.indexOf(floatArray0, (float) ' ', 17);
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + (-1) + "'", int3 == (-1));
    }

    @Test
    public void test1403() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1403");
        java.util.function.Supplier[] supplierArray1 = new java.util.function.Supplier[0];
        @SuppressWarnings("unchecked")
        java.util.function.Supplier<org.apache.commons.lang3.text.StrMatcher>[] strMatcherSupplierArray2 = (java.util.function.Supplier<org.apache.commons.lang3.text.StrMatcher>[]) supplierArray1;
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate4 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        boolean boolean6 = throwableFailableLongPredicate4.test((long) (byte) 100);
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate7 = org.apache.commons.lang3.function.FailableLongPredicate.falsePredicate();
        org.apache.commons.lang3.function.FailableLongPredicate<java.lang.Throwable> throwableFailableLongPredicate8 = throwableFailableLongPredicate4.or(throwableFailableLongPredicate7);
        java.util.function.Supplier<org.apache.commons.lang3.text.StrMatcher> strMatcherSupplier9 = org.apache.commons.lang3.function.Suppliers.nul();
        org.apache.commons.lang3.compare.ObjectToStringComparator objectToStringComparator10 = new org.apache.commons.lang3.compare.ObjectToStringComparator();
        org.apache.commons.lang3.Range<java.lang.Object> objRange11 = org.apache.commons.lang3.Range.between((java.lang.Object) throwableFailableLongPredicate8, (java.lang.Object) strMatcherSupplier9, (java.util.Comparator<java.lang.Object>) objectToStringComparator10);
        // The following exception was thrown during execution in test generation
        try {
            java.util.function.Supplier<org.apache.commons.lang3.text.StrMatcher>[] strMatcherSupplierArray12 = org.apache.commons.lang3.ArrayUtils.add(strMatcherSupplierArray2, (-87), strMatcherSupplier9);
            org.junit.Assert.fail("Expected exception of type java.lang.IndexOutOfBoundsException; message: Index: -87, Length: 0");
        } catch (java.lang.IndexOutOfBoundsException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(supplierArray1);
        org.junit.Assert.assertNotNull(strMatcherSupplierArray2);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate4);
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate7);
        org.junit.Assert.assertNotNull(throwableFailableLongPredicate8);
        org.junit.Assert.assertNotNull(strMatcherSupplier9);
        org.junit.Assert.assertNotNull(objRange11);
    }

    @Test
    public void test1404() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1404");
        org.apache.commons.lang3.text.StrBuilder strBuilder1 = new org.apache.commons.lang3.text.StrBuilder("java.ext.dirs");
        org.apache.commons.lang3.text.StrBuilder strBuilder3 = strBuilder1.append(1L);
        java.lang.String str5 = strBuilder1.leftString((int) (byte) 0);
        org.junit.Assert.assertNotNull(strBuilder3);
        org.junit.Assert.assertEquals("'" + str5 + "' != '" + "" + "'", str5, "");
    }

    @Test
    public void test1405() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1405");
        java.util.Locale locale1 = null;
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat2 = org.apache.commons.lang3.time.FastDateFormat.getInstance("", locale1);
        java.text.ParsePosition parsePosition4 = null;
        java.lang.Object obj5 = fastDateFormat2.parseObject("open", parsePosition4);
        java.lang.String str6 = fastDateFormat2.toString();
        java.lang.String str7 = fastDateFormat2.getPattern();
        java.util.Date date9 = fastDateFormat2.parse("$");
        java.util.Date date11 = org.apache.commons.lang3.time.DateUtils.addSeconds(date9, 96);
        java.util.Date date13 = org.apache.commons.lang3.time.DateUtils.setMinutes(date9, 17);
        org.junit.Assert.assertNotNull(fastDateFormat2);
        org.junit.Assert.assertNotNull(obj5);
        org.junit.Assert.assertEquals(obj5.toString(), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals(java.lang.String.valueOf(obj5), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals(java.util.Objects.toString(obj5), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertEquals("'" + str6 + "' != '" + "FastDateFormat[,en_SE,Europe/Stockholm]" + "'", str6, "FastDateFormat[,en_SE,Europe/Stockholm]");
        org.junit.Assert.assertEquals("'" + str7 + "' != '" + "" + "'", str7, "");
        org.junit.Assert.assertNotNull(date9);
        org.junit.Assert.assertEquals(date9.toString(), "Thu Jan 01 00:00:00 CET 1970");
        org.junit.Assert.assertNotNull(date11);
        org.junit.Assert.assertEquals(date11.toString(), "Thu Jan 01 00:01:36 CET 1970");
        org.junit.Assert.assertNotNull(date13);
        org.junit.Assert.assertEquals(date13.toString(), "Thu Jan 01 00:17:00 CET 1970");
    }

    @Test
    public void test1406() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1406");
        short[] shortArray3 = new short[] { (short) 1, (short) -1, (byte) 10 };
        boolean boolean4 = org.apache.commons.lang3.ArrayUtils.isSorted(shortArray3);
        int int7 = org.apache.commons.lang3.ArrayUtils.indexOf(shortArray3, (short) 0, (int) 'a');
        short[] shortArray10 = new short[] { (short) 100, (byte) 100 };
        org.apache.commons.lang3.ArrayUtils.shift(shortArray10, (int) (byte) -1, 1, (int) (byte) 10);
        short[] shortArray16 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(shortArray10, (short) (byte) 10);
        boolean boolean17 = org.apache.commons.lang3.ArrayUtils.isSameLength(shortArray3, shortArray16);
        org.junit.Assert.assertNotNull(shortArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray3), "[1, -1, 10]");
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        org.junit.Assert.assertNotNull(shortArray10);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray10), "[100, 100]");
        org.junit.Assert.assertNotNull(shortArray16);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(shortArray16), "[100, 100]");
        org.junit.Assert.assertTrue("'" + boolean17 + "' != '" + false + "'", boolean17 == false);
    }

    @Test
    public void test1407() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1407");
        org.apache.commons.lang3.CharEncoding charEncoding0 = new org.apache.commons.lang3.CharEncoding();
    }

    @Test
    public void test1408() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1408");
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder2 = new org.apache.commons.lang3.builder.EqualsBuilder();
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder5 = equalsBuilder2.append(false, false);
        java.lang.Object obj6 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer7 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService8 = multiBackgroundInitializer7.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle11 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer15 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray16 = strTokenizer15.getTokenArray();
        java.lang.String str17 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle11, strArray16);
        java.lang.String str21 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray16, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int22 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray16);
        boolean boolean23 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray16);
        boolean boolean24 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj6, (java.lang.Object) executorService8, strArray16);
        java.lang.Object[] objArray25 = org.apache.commons.lang3.ArrayUtils.nullToEmpty((java.lang.Object[]) strArray16);
        java.lang.Object obj26 = null;
        org.apache.commons.lang3.concurrent.MultiBackgroundInitializer multiBackgroundInitializer27 = new org.apache.commons.lang3.concurrent.MultiBackgroundInitializer();
        java.util.concurrent.ExecutorService executorService28 = multiBackgroundInitializer27.getExternalExecutor();
        org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle multilineRecursiveToStringStyle31 = new org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle();
        org.apache.commons.lang3.text.StrTokenizer strTokenizer35 = new org.apache.commons.lang3.text.StrTokenizer("581cd446", '\n', 'a');
        java.lang.String[] strArray36 = strTokenizer35.getTokenArray();
        java.lang.String str37 = org.apache.commons.lang3.builder.ReflectionToStringBuilder.toStringExclude((java.lang.Object) multilineRecursiveToStringStyle31, strArray36);
        java.lang.String str41 = org.apache.commons.lang3.StringUtils.join((java.lang.Object[]) strArray36, ";ClT9Ss'St<Q", (int) (short) 10, (-27));
        int int42 = org.apache.commons.lang3.StringUtils.indexOfAny((java.lang.CharSequence) ";ClT9Ss'St<Q", (java.lang.CharSequence[]) strArray36);
        boolean boolean43 = org.apache.commons.lang3.StringUtils.endsWithAny((java.lang.CharSequence) "                                                                                                open", (java.lang.CharSequence[]) strArray36);
        boolean boolean44 = org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(obj26, (java.lang.Object) executorService28, strArray36);
        java.lang.Object[] objArray45 = org.apache.commons.lang3.ArrayUtils.nullToEmpty((java.lang.Object[]) strArray36);
        org.apache.commons.lang3.builder.EqualsBuilder equalsBuilder46 = equalsBuilder2.append((java.lang.Object[]) strArray16, objArray45);
        org.apache.commons.lang3.Validate.isTrue(true, "https://adoptopenjdk.net/", objArray45);
        org.junit.Assert.assertNotNull(equalsBuilder5);
        org.junit.Assert.assertNull(executorService8);
        org.junit.Assert.assertNotNull(strArray16);
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "" + "'", str21, "");
        org.junit.Assert.assertTrue("'" + int22 + "' != '" + (-1) + "'", int22 == (-1));
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        org.junit.Assert.assertNotNull(objArray25);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray25), "[581cd446]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray25), "[581cd446]");
        org.junit.Assert.assertNull(executorService28);
        org.junit.Assert.assertNotNull(strArray36);
        org.junit.Assert.assertEquals("'" + str41 + "' != '" + "" + "'", str41, "");
        org.junit.Assert.assertTrue("'" + int42 + "' != '" + (-1) + "'", int42 == (-1));
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + false + "'", boolean43 == false);
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        org.junit.Assert.assertNotNull(objArray45);
        org.junit.Assert.assertEquals(java.util.Arrays.deepToString(objArray45), "[581cd446]");
        org.junit.Assert.assertEquals(java.util.Arrays.toString(objArray45), "[581cd446]");
        org.junit.Assert.assertNotNull(equalsBuilder46);
    }

    @Test
    public void test1409() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1409");
        org.apache.commons.lang3.tuple.ImmutableTriple<java.lang.String, java.lang.constant.ConstantDesc, java.lang.constant.Constable> strImmutableTriple0 = org.apache.commons.lang3.tuple.ImmutableTriple.nullTriple();
        java.lang.constant.ConstantDesc constantDesc1 = strImmutableTriple0.middle;
        java.lang.String str3 = strImmutableTriple0.toString("HH:mm:ss");
        java.lang.String str4 = strImmutableTriple0.getLeft();
        java.lang.String str5 = strImmutableTriple0.getLeft();
        org.junit.Assert.assertNotNull(strImmutableTriple0);
        org.junit.Assert.assertNull(constantDesc1);
        org.junit.Assert.assertEquals("'" + str3 + "' != '" + "HH:mm:ss" + "'", str3, "HH:mm:ss");
        org.junit.Assert.assertNull(str4);
        org.junit.Assert.assertNull(str5);
    }

    @Test
    public void test1410() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1410");
        boolean[] booleanArray6 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray8 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray6, false);
        java.util.BitSet bitSet10 = org.apache.commons.lang3.ArrayUtils.indexesOf(booleanArray6, true);
        boolean[] booleanArray12 = org.apache.commons.lang3.ArrayUtils.add(booleanArray6, true);
        boolean[] booleanArray18 = new boolean[] { false, true, false, true, false };
        boolean[] booleanArray20 = org.apache.commons.lang3.ArrayUtils.removeAllOccurrences(booleanArray18, false);
        boolean[] booleanArray22 = org.apache.commons.lang3.ArrayUtils.removeElement(booleanArray18, true);
        boolean boolean23 = org.apache.commons.lang3.ArrayUtils.isNotEmpty(booleanArray22);
        boolean[] booleanArray24 = org.apache.commons.lang3.ArrayUtils.insert(3, booleanArray12, booleanArray22);
        // The following exception was thrown during execution in test generation
        try {
            short short29 = org.apache.commons.lang3.Conversion.binaryToShort(booleanArray12, (int) (byte) 1, (short) 97, (int) '$', (int) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: nBools-1+dstPos is greater or equal to than 16");
        } catch (java.lang.IllegalArgumentException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(booleanArray6);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray6), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray8), "[true, true]");
        org.junit.Assert.assertNotNull(bitSet10);
        org.junit.Assert.assertEquals(bitSet10.toString(), "{1, 3}");
        org.junit.Assert.assertNotNull(booleanArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray12), "[false, true, false, true, false, true]");
        org.junit.Assert.assertNotNull(booleanArray18);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray18), "[false, true, false, true, false]");
        org.junit.Assert.assertNotNull(booleanArray20);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray20), "[true, true]");
        org.junit.Assert.assertNotNull(booleanArray22);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray22), "[false, false, true, false]");
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        org.junit.Assert.assertNotNull(booleanArray24);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray24), "[false, true, false, false, false, true, false, true, false, true]");
    }

    @Test
    public void test1411() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1411");
        boolean[] booleanArray0 = org.apache.commons.lang3.ArrayUtils.EMPTY_BOOLEAN_ARRAY;
        boolean boolean1 = org.apache.commons.lang3.ArrayUtils.isNotEmpty(booleanArray0);
        org.junit.Assert.assertNotNull(booleanArray0);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(booleanArray0), "[]");
        org.junit.Assert.assertTrue("'" + boolean1 + "' != '" + false + "'", boolean1 == false);
    }

    @Test
    public void test1412() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1412");
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
        java.lang.String str21 = javaVersionRange19.toString("java.vm.info");
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
        org.junit.Assert.assertEquals("'" + str21 + "' != '" + "java.vm.info" + "'", str21, "java.vm.info");
    }

    @Test
    public void test1413() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1413");
        float[] floatArray3 = new float[] { (short) -1, (short) 10, (short) 101 };
        float[] floatArray10 = new float[] { ' ', 100, (byte) 10, 10.0f, 0, 100.0f };
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(floatArray3, floatArray10);
        float[] floatArray12 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(floatArray10);
        float[] floatArray14 = org.apache.commons.lang3.ArrayUtils.addFirst(floatArray10, (float) 8);
        org.apache.commons.lang3.ArrayUtils.shuffle(floatArray10);
        java.util.Random random16 = null;
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.ArrayUtils.shuffle(floatArray10, random16);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.util.Random.nextInt(int)\" because \"random\" is null");
        } catch (java.lang.NullPointerException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(floatArray3);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray3), "[-1.0, 10.0, 101.0]");
        org.junit.Assert.assertNotNull(floatArray10);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray10), "[100.0, 10.0, 0.0, 10.0, 32.0, 100.0]");
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(floatArray12);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray12), "[100.0, 10.0, 0.0, 10.0, 32.0, 100.0]");
        org.junit.Assert.assertNotNull(floatArray14);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(floatArray14), "[8.0, 32.0, 100.0, 10.0, 10.0, 0.0, 100.0]");
    }

    @Test
    public void test1414() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1414");
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
        org.apache.commons.lang3.ArrayUtils.reverse(charArray75);
        boolean boolean77 = org.apache.commons.lang3.ArrayUtils.isNotEmpty(charArray75);
        boolean boolean79 = org.apache.commons.lang3.ArrayUtils.contains(charArray75, '$');
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
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + false + "'", boolean77 == false);
        org.junit.Assert.assertTrue("'" + boolean79 + "' != '" + false + "'", boolean79 == false);
    }

    @Test
    public void test1415() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1415");
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
        double[] doubleArray33 = new double[] { 1.0d, 2147483647L, 100.0d, 10, 32.0f };
        double[] doubleArray35 = org.apache.commons.lang3.ArrayUtils.removeAllOccurences(doubleArray33, 1.0d);
        double[] doubleArray40 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray44 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean46 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray44, (double) '4');
        boolean boolean47 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray40, doubleArray44);
        int int51 = org.apache.commons.lang3.ArrayUtils.indexOf(doubleArray40, (-1.0d), (int) '\n', (double) 100);
        boolean boolean52 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray35, doubleArray40);
        org.apache.commons.lang3.ArrayUtils.shuffle(doubleArray35);
        double[] doubleArray55 = org.apache.commons.lang3.ArrayUtils.removeElement(doubleArray35, (double) (short) -1);
        // The following exception was thrown during execution in test generation
        try {
            org.apache.commons.lang3.reflect.FieldUtils.writeDeclaredStaticField(multiBackgroundInitializerResultsFailableSupplierClass13, "FastDateFormat[,en_SE,Europe/Stockholm]", (java.lang.Object) doubleArray55);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot locate declared field org.apache.commons.lang3.concurrent.MultiBackgroundInitializer.FastDateFormat[,en_SE,Europe/Stockholm]");
        } catch (java.lang.NullPointerException e) {
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
        org.junit.Assert.assertNotNull(doubleArray33);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray33), "[1.0, 2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray35);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray35), "[2.147483647E9, 100.0, 10.0, 32.0]");
        org.junit.Assert.assertNotNull(doubleArray40);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray40), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray44);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray44), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean46 + "' != '" + true + "'", boolean46 == true);
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + false + "'", boolean47 == false);
        org.junit.Assert.assertTrue("'" + int51 + "' != '" + (-1) + "'", int51 == (-1));
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
        org.junit.Assert.assertNotNull(doubleArray55);
// flaky:         org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray55), "[2.147483647E9, 100.0, 10.0, 32.0]");
    }

    @Test
    public void test1416() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest2.test1416");
        double[] doubleArray4 = new double[] { 'a', '4', (-1L), 1.0d };
        double[] doubleArray8 = new double[] { '4', (-1), (byte) -1 };
        boolean boolean10 = org.apache.commons.lang3.ArrayUtils.contains(doubleArray8, (double) '4');
        boolean boolean11 = org.apache.commons.lang3.ArrayUtils.isSameLength(doubleArray4, doubleArray8);
        double[] doubleArray12 = org.apache.commons.lang3.ArrayUtils.nullToEmpty(doubleArray8);
        double[] doubleArray13 = org.apache.commons.lang3.ArrayUtils.clone(doubleArray12);
        org.apache.commons.lang3.ArrayUtils.reverse(doubleArray13);
        org.junit.Assert.assertNotNull(doubleArray4);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray4), "[97.0, 52.0, -1.0, 1.0]");
        org.junit.Assert.assertNotNull(doubleArray8);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray8), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        org.junit.Assert.assertNotNull(doubleArray12);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray12), "[52.0, -1.0, -1.0]");
        org.junit.Assert.assertNotNull(doubleArray13);
        org.junit.Assert.assertEquals(java.util.Arrays.toString(doubleArray13), "[-1.0, -1.0, 52.0]");
    }
}
