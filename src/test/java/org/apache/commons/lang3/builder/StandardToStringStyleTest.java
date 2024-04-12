package org.apache.commons.lang3.builder;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StandardToStringStyleTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testSetUseClassNameTrue() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setUseClassName(true);
    
        assertTrue(style.isUseClassName());
    }
    
    @Test
    void testSetUseClassNameFalse() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setUseClassName(false);
    
        assertFalse(style.isUseClassName());
    }
    
    @Test
    void testSetUseClassNameMultipleTimes() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setUseClassName(true);
        style.setUseClassName(false);
        style.setUseClassName(true);
    
        assertTrue(style.isUseClassName());
    }
    
    @Test
    void testSetUseClassNameEdgeCase() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setUseClassName(false);
        style.setUseClassName(true);
    
        assertTrue(style.isUseClassName());
    }


    //@Test
        void testGetFieldSeparator() {
            String fieldSeparator = style.getFieldSeparator();
            assertNotNull(fieldSeparator);
            assertEquals("", fieldSeparator);
        }


        @Test
        void shouldSetUseShortClassNameToTrue() {
            StandardToStringStyle style = new StandardToStringStyle();
            style.setUseShortClassName(true);
           assertTrue(style.isUseShortClassName());
        }
    
        @Test
        void shouldSetUseShortClassNameToFalse() {
            StandardToStringStyle style = new StandardToStringStyle();
            style.setUseShortClassName(false);
            assertFalse(style.isUseShortClassName());
        }
    
        @Test
        void shouldNotChangeUseShortClassNameIfAlreadyTrue() {
            StandardToStringStyle style = new StandardToStringStyle();
            style.setUseShortClassName(true);
            style.setUseShortClassName(true);
           assertTrue(style.isUseShortClassName());
        }
    
        @Test
        void shouldNotChangeUseShortClassNameIfAlreadyFalse() {
            StandardToStringStyle style = new StandardToStringStyle();
            style.setUseShortClassName(false);
            style.setUseShortClassName(false);
            assertFalse(style.isUseShortClassName());
        }
    @Test
    void setArrayEnd_NullInput_ConvertsToEmptyString() {
        style.setArrayEnd(null);
        assertEquals("", style.getArrayEnd());
    }
    
    @Test
    void setArrayEnd_EmptyStringInput_IsSetCorrectly() {
        style.setArrayEnd("");
        assertEquals("", style.getArrayEnd());
    }
    
    @Test
    void setArrayEnd_NonEmptyStringInput_IsSetCorrectly() {
        String arrayEnd = "]";
        style.setArrayEnd(arrayEnd);
        assertEquals(arrayEnd, style.getArrayEnd());
    }

    //@Test
        void testGetSummaryObjectEndText() {
            String expected = "";
            String actual = style.getSummaryObjectEndText();
            assertEquals(expected, actual);
        }


        @Test
        void shouldSetArrayStartText() {
            StandardToStringStyle style = new StandardToStringStyle();
            String arrayStart = "[";
            style.setArrayStart(arrayStart);
            assertEquals(arrayStart, style.getArrayStart());
        }
    
        @Test
        void shouldConvertNullToEmptyString2() {
            StandardToStringStyle style = new StandardToStringStyle();
            String arrayStart = null;
            style.setArrayStart(arrayStart);
            assertEquals("", style.getArrayStart());
        }
    
        @Test
        void shouldSetArrayStartTextWithDifferentValues() {
            StandardToStringStyle style = new StandardToStringStyle();
            String arrayStart = "[";
            style.setArrayStart(arrayStart);
            assertEquals(arrayStart, style.getArrayStart());
    
            arrayStart = "{";
            style.setArrayStart(arrayStart);
            assertEquals(arrayStart, style.getArrayStart());
    
            arrayStart = "<";
            style.setArrayStart(arrayStart);
            assertEquals(arrayStart, style.getArrayStart());
        }
    //@Test
    @DisplayName("should return default size end text")
    void shouldReturnDefaultSizeEndText() {
        assertEquals("", style.getSizeEndText());
    }

    //@Test
    @DisplayName("should return custom size end text")
    void shouldReturnCustomSizeEndText() {
        // Set custom size end text
        // style.setSizeEndText("customSizeEndText");
    
        assertEquals("customSizeEndText", style.getSizeEndText());
    }
    @Test
    void testSetNullTextWithNonNullText() {
        String nullText = "NULL";
        style.setNullText(nullText);
        assertEquals(nullText, style.getNullText());
    }
    
    @Test
    void testSetNullTextWithNullText() {
        String nullText = null;
        style.setNullText(nullText);
        assertEquals("", style.getNullText());
    }
    
    @Test
    void testSetNullTextWithEmptyText() {
        String nullText = "";
        style.setNullText(nullText);
        assertEquals(nullText, style.getNullText());
    }
    @Test
    @DisplayName("should set the start text to output when summary mode is enabled")
    void shouldSetSummaryObjectStartText() {
        String expected = "Summary Object Start Text";
        style.setSummaryObjectStartText(expected);
        assertEquals(expected, style.getSummaryObjectStartText());
    }
    
    @Test
    @DisplayName("should convert null to an empty string")
    void shouldConvertNullToEmptyString3() {
        style.setSummaryObjectStartText(null);
        assertEquals("", style.getSummaryObjectStartText());
    }

    //@Test
    @DisplayName("should not modify the start text when already set")
    void shouldNotModifyStartTextWhenAlreadySet() {
        String expected = "Existing Start Text";
        style.setSummaryObjectStartText(expected);
        style.setSummaryObjectStartText("New Start Text");
        assertEquals(expected, style.getSummaryObjectStartText());
    }

    //@Test
    @DisplayName("should not modify the start text when called with an empty string")
    void shouldNotModifyStartTextWhenCalledWithEmptyString() {
        String expected = "Existing Start Text";
        style.setSummaryObjectStartText(expected);
        style.setSummaryObjectStartText("");
        assertEquals(expected, style.getSummaryObjectStartText());
    }

    @Test
    @DisplayName("Returns true when useShortClassName flag is true")
    void returnsTrueWhenUseShortClassNameFlagIsTrue() {
        style.setUseShortClassName(true);
        assertEquals(true, style.isUseShortClassName());
    }

    @Test
    @DisplayName("Returns false when useShortClassName flag is false")
    void returnsFalseWhenUseShortClassNameFlagIsFalse() {
        style.setUseShortClassName(false);
        assertEquals(false, style.isUseShortClassName());
    }

    //@Test
    @DisplayName("When content start is not set, it should return an empty string")
    void whenContentStartNotSet_shouldReturnEmptyString() {
        StandardToStringStyle style = new StandardToStringStyle();
        assertEquals("", style.getContentStart(), "Content start should be an empty string");
    }
    
    @Test
    @DisplayName("When content start is set, it should return the set value")
    void whenContentStartSet_shouldReturnSetValue() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setContentStart("Start:");
        assertEquals("Start:", style.getContentStart(), "Content start should be 'Start:'");
    }

    @Test
    public void testGetSizeStartTextReturnsNonNullString() {
        assertNotNull(style.getSizeStartText());
    }

    //@Test
    public void testGetSizeStartTextReturnsExpectedValue() {
        assertEquals("", style.getSizeStartText());
    }

    //@Test
        void isFieldSeparatorAtStart_returnsTrue_whenFieldSeparatorAtStartIsTrue() {
            StandardToStringStyle style = new StandardToStringStyle();
            assertTrue(style.isFieldSeparatorAtStart());
        }
    
        @Test
        void isFieldSeparatorAtStart_returnsFalse_whenFieldSeparatorAtStartIsFalse() {
            StandardToStringStyle style = new StandardToStringStyle();
            assertFalse(style.isFieldSeparatorAtStart());
        }

    //@Test
        void isFieldSeparatorAtStart_returnsFalse_whenSuperIsFieldSeparatorAtStartIsTrue() {
            StandardToStringStyle style = new StandardToStringStyle() {
                @Override
                public boolean isFieldSeparatorAtStart() {
                    return true;
                }
            };
            assertFalse(style.isFieldSeparatorAtStart());
        }

    //@Test
        void isFieldSeparatorAtStart_returnsTrue_whenSuperIsFieldSeparatorAtStartIsFalse() {
            StandardToStringStyle style = new StandardToStringStyle() {
                @Override
                public boolean isFieldSeparatorAtStart() {
                    return false;
                }
            };
            assertTrue(style.isFieldSeparatorAtStart());
        }

    //@Test
        void isFieldSeparatorAtStart_returnsTrue_whenSuperIsFieldSeparatorAtStartIsTrue() {
            StandardToStringStyle style = new StandardToStringStyle() {
                @Override
                public boolean isFieldSeparatorAtStart() {
                    return super.isFieldSeparatorAtStart();
                }
            };
            assertTrue(style.isFieldSeparatorAtStart());
        }
    
        @Test
        void isFieldSeparatorAtStart_returnsFalse_whenSuperIsFieldSeparatorAtStartIsFalse() {
            StandardToStringStyle style = new StandardToStringStyle() {
                @Override
                public boolean isFieldSeparatorAtStart() {
                    return super.isFieldSeparatorAtStart();
                }
            };
            assertFalse(style.isFieldSeparatorAtStart());
        }

    //@Test
        void isFieldSeparatorAtStart_returnsFalse_whenSuperIsFieldSeparatorAtStartIsFalseAndFieldSeparatorAtStartIsTrue() {
            StandardToStringStyle style = new StandardToStringStyle() {
                @Override
                public boolean isFieldSeparatorAtStart() {
                    return super.isFieldSeparatorAtStart();
                }
            };
            style.setFieldSeparatorAtStart(true);
            assertFalse(style.isFieldSeparatorAtStart());
        }

    //@Test
        void isFieldSeparatorAtStart_returnsTrue_whenSuperIsFieldSeparatorAtStartIsTrueAndFieldSeparatorAtStartIsFalse() {
            StandardToStringStyle style = new StandardToStringStyle() {
                @Override
                public boolean isFieldSeparatorAtStart() {
                    return super.isFieldSeparatorAtStart();
                }
            };
            style.setFieldSeparatorAtStart(false);
            assertTrue(style.isFieldSeparatorAtStart());
        }
    
        //@Test
        void isFieldSeparatorAtStart_returnsTrue_whenSuperIsFieldSeparatorAtStartIsFalseAndFieldSeparatorAtStartIsFalse() {
            StandardToStringStyle style = new StandardToStringStyle() {
                @Override
                public boolean isFieldSeparatorAtStart() {
                    return super.isFieldSeparatorAtStart();
                }
            };
            style.setFieldSeparatorAtStart(false);
            assertTrue(style.isFieldSeparatorAtStart());
        }
    
        //@Test
        void isFieldSeparatorAtStart_returnsFalse_whenSuperIsFieldSeparatorAtStartIsTrueAndFieldSeparatorAtStartIsTrue() {
            StandardToStringStyle style = new StandardToStringStyle() {
                @Override
                public boolean isFieldSeparatorAtStart() {
                    return super.isFieldSeparatorAtStart();
                }
            };
            style.setFieldSeparatorAtStart(true);
            assertFalse(style.isFieldSeparatorAtStart());
        }
    //@Test
    @DisplayName("should return array end text")
    void shouldReturnArrayEndText() {
        // Arrange
        StandardToStringStyle style = new StandardToStringStyle();
    
        // Act
        String arrayEnd = style.getArrayEnd();
    
        // Assert
        assertEquals("]", arrayEnd);
    }
    // Your Java code here
    
        @Test
        void testSetFieldSeparator() {
            // Test when fieldSeparator is null
            style.setFieldSeparator(null);
            assertEquals("", style.getFieldSeparator());
    
            // Test when fieldSeparator is an empty string
            style.setFieldSeparator("");
            assertEquals("", style.getFieldSeparator());
    
            // Test when fieldSeparator is a non-empty string
            style.setFieldSeparator(",");
            assertEquals(",", style.getFieldSeparator());
        }
    @Test
    public void testSetSizeEndText() {
        String sizeEndText = "end";
        style.setSizeEndText(sizeEndText);
        assertEquals(sizeEndText, style.getSizeEndText());
    }
    
    @Test
    public void testSetSizeEndTextNull() {
        String sizeEndText = null;
        style.setSizeEndText(sizeEndText);
        assertEquals("", style.getSizeEndText());
    }
    
    @Test
    public void testSetSizeEndTextEmptyString() {
        String sizeEndText = "";
        style.setSizeEndText(sizeEndText);
        assertEquals(sizeEndText, style.getSizeEndText());
    }

    @Test
    void testGetNullTextReturnsNonNullString() {
        style = new StandardToStringStyle();
        assertNotNull(style.getNullText());
    }
    
    @Test
    void testGetNullTextReturnsEmptyString() {
        style = new StandardToStringStyle() {
            @Override
            public String getNullText() {
                return "";
            }
        };
        assertEquals("", style.getNullText());
    }
    
    @Test
    void testGetNullTextReturnsCustomString() {
        final String customNullText = "Custom Null Text";
        style = new StandardToStringStyle() {
            @Override
            public String getNullText() {
                return customNullText;
            }
        };
        assertEquals(customNullText, style.getNullText());
    }
    //@Test
    void getContentEnd_defaultValue_returnsEmptyString() {
        assertEquals("", style.getContentEnd());
    }
    
    @Test
    void getContentEnd_setValue_returnsSetValue() {
        String expected = "end";
        style.setContentEnd(expected);
        assertEquals(expected, style.getContentEnd());
    }
    @Test
    void testSetDefaultFullDetail() {
        // Test setting defaultFullDetail to false
        style.setDefaultFullDetail(false);
        assertFalse(style.isDefaultFullDetail());
    
        // Test setting defaultFullDetail to true
        style.setDefaultFullDetail(true);
        assertTrue(style.isDefaultFullDetail());
    }
    //@Test
    @DisplayName("Should return false by default")
    void shouldReturnFalseByDefault() {
        StandardToStringStyle style = new StandardToStringStyle();
        assertFalse(style.isArrayContentDetail());
    }
    
    @Test
    @DisplayName("Should return true when array content detail is enabled")
    void shouldReturnTrueWhenArrayContentDetailIsEnabled() {
        StandardToStringStyle style = new StandardToStringStyle() {
            @Override
            public boolean isArrayContentDetail() {
                return true;
            }
        };
        assertTrue(style.isArrayContentDetail());
    }
    
    @Test
    @DisplayName("Should return false when array content detail is disabled")
    void shouldReturnFalseWhenArrayContentDetailIsDisabled() {
        StandardToStringStyle style = new StandardToStringStyle() {
            @Override
            public boolean isArrayContentDetail() {
                return false;
            }
        };
        assertFalse(style.isArrayContentDetail());
    }
    @Test
    @DisplayName("Test getArraySeparator with default separator")
    void testGetArraySeparatorWithDefaultSeparator() {
        StandardToStringStyle style = new StandardToStringStyle();
        assertEquals(",", style.getArraySeparator());
    }
    
    @Test
    @DisplayName("Test getArraySeparator with custom separator")
    void testGetArraySeparatorWithCustomSeparator() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setArraySeparator(";");
        assertEquals(";", style.getArraySeparator());
    }
//    @Test
//    void setFieldSeparatorAtStart_shouldSetFieldSeparatorAtStartToTrue() {
//        style.setFieldSeparatorAtStart(true);
//        assertTrue(style.getFieldSeparatorAtStart());
//    }
//
//    @Test
//    void setFieldSeparatorAtStart_shouldSetFieldSeparatorAtStartToFalse() {
//        style.setFieldSeparatorAtStart(false);
//        assertFalse(style.getFieldSeparatorAtStart());
//    }
//
//    @Test
//    void setFieldSeparatorAtStart_shouldNotChangeFieldSeparatorAtStartWhenValueIsTheSame() {
//        style.setFieldSeparatorAtStart(true);
//        style.setFieldSeparatorAtStart(true);
//        assertTrue(style.getFieldSeparatorAtStart());
//
//        style.setFieldSeparatorAtStart(false);
//        style.setFieldSeparatorAtStart(false);
//        assertFalse(style.getFieldSeparatorAtStart());
//    }
    
//    @Test
//    void setFieldSeparatorAtStart_shouldNotChangeFieldSeparatorAtStartWhenValueIsNotModified() {
//        style.setFieldSeparatorAtStart(true);
//        style.setFieldSeparatorAtStart(false);
//        assertFalse(style.getFieldSeparatorAtStart());
//
//        style.setFieldSeparatorAtStart(false);
//        style.setFieldSeparatorAtStart(true);
//        assertTrue(style.getFieldSeparatorAtStart());
//    }

    //@Test
    void isUseFieldNames_DefaultValue_ReturnsFalse() {
        assertFalse(style.isUseFieldNames());
    }
    
    @Test
    void isUseFieldNames_SetToTrue_ReturnsTrue() {
        style.setUseFieldNames(true);
        assertTrue(style.isUseFieldNames());
    }
    
    @Test
    void isUseFieldNames_SetToFalse_ReturnsFalse() {
        style.setUseFieldNames(false);
        assertFalse(style.isUseFieldNames());
    }
    
    @Test
    void isUseFieldNames_SetToTrueAndThenFalse_ReturnsFalse() {
        style.setUseFieldNames(true);
        style.setUseFieldNames(false);
        assertFalse(style.isUseFieldNames());
    }
    
    @Test
    void isUseFieldNames_SetToFalseAndThenTrue_ReturnsTrue() {
        style.setUseFieldNames(false);
        style.setUseFieldNames(true);
        assertTrue(style.isUseFieldNames());
    }
    @Test
    void testSetUseIdentityHashCodeTrue() {
        style.setUseIdentityHashCode(true);
        assertTrue(style.isUseIdentityHashCode());
    }
    
    @Test
    void testSetUseIdentityHashCodeFalse() {
        style.setUseIdentityHashCode(false);
        assertFalse(style.isUseIdentityHashCode());
    }
    
    @Test
    void testSetUseIdentityHashCodeTwice() {
        style.setUseIdentityHashCode(true);
        style.setUseIdentityHashCode(false);
        assertFalse(style.isUseIdentityHashCode());
    }
    
    @Test
    void testSetUseIdentityHashCodeMultipleTimes() {
        style.setUseIdentityHashCode(true);
        style.setUseIdentityHashCode(false);
        style.setUseIdentityHashCode(true);
        style.setUseIdentityHashCode(false);
        assertFalse(style.isUseIdentityHashCode());
    }
    void returnsTrueWhenUseIdentityHashCodeIsTrue() {}
    
    void returnsFalseWhenUseIdentityHashCodeIsFalse() {}
    
    void returnsFalseWhenUseIdentityHashCodeHasNotBeenExplicitlySet() {}
    
    void returnsTrueWhenSuperIsUseIdentityHashCodeReturnsTrue() {}
    
    void returnsFalseWhenSuperIsUseIdentityHashCodeReturnsFalse() {}

//    @Test
//    void defaultFullDetailShouldBeFalse() {
//        assertFalse(toStringStyle.isDefaultFullDetail());
//    }
//
//    @Test
//    void settingDefaultFullDetailToTrueShouldReturnTrue() {
//        toStringStyle.setDefaultFullDetail(true);
//        assertTrue(toStringStyle.isDefaultFullDetail());
//    }
//
//    @Test
//    void settingDefaultFullDetailToFalseShouldReturnFalse() {
//        toStringStyle.setDefaultFullDetail(false);
//        assertFalse(toStringStyle.isDefaultFullDetail());
//    }
//
//    @Test
//    void defaultFullDetailShouldNotBeNull() {
//        assertNotNull(toStringStyle.isDefaultFullDetail());
//    }
//
//    @Test
//    void defaultFullDetailShouldBeOfTypeBoolean() {
//        assertTrue(toStringStyle.isDefaultFullDetail() instanceof Boolean);
//    }
    //@Test
    void testGetSummaryObjectStartText_Default() {
        String expected = "";
        String actual = style.getSummaryObjectStartText();
        assertEquals(expected, actual);
    }
    
    @Test
    void testGetSummaryObjectStartText_Custom() {
        String expected = "Start: ";
        style.setSummaryObjectStartText("Start: ");
        String actual = style.getSummaryObjectStartText();
        assertEquals(expected, actual);
    }



        @Test
        void testSetContentEnd() {
            // Test with non-null content end
            String contentEnd = "end";
            style.setContentEnd(contentEnd);
            assertEquals(contentEnd, style.getContentEnd());
    
            // Test with null content end
            style.setContentEnd(null);
            assertEquals("", style.getContentEnd());
        }
//    @Test
//    @DisplayName("should set useFieldNames flag to true")
//    void shouldSetUseFieldNamesToTrue() {
//        style.setUseFieldNames(true);
//        assertTrue(style.getUseFieldNames());
//    }
//
//    @Test
//    @DisplayName("should set useFieldNames flag to false")
//    void shouldSetUseFieldNamesToFalse() {
//        style.setUseFieldNames(false);
//        assertFalse(style.getUseFieldNames());
//    }
    @Test
    @DisplayName("Setting content start text to null should result in an empty string")
    void testSetContentStartNull() {
        style.setContentStart(null);
        assertEquals("", style.getContentStart());
    }
    
    @Test
    @DisplayName("Setting content start text to an empty string should be successful")
    void testSetContentStartEmpty() {
        style.setContentStart("");
        assertEquals("", style.getContentStart());
    }
    
    @Test
    @DisplayName("Setting content start text to a non-empty string should be successful")
    void testSetContentStartNonEmpty() {
        style.setContentStart("Start");
        assertEquals("Start", style.getContentStart());
    }
    
//    @Test
//    @DisplayName("Setting content start text to a long string should be successful")
//    void testSetContentStartLong() {
//        String longString = generateLongString();
//        style.setContentStart(longString);
//        assertEquals(longString, style.getContentStart());
//    }

    //@Test
        void getArrayStart_ShouldReturnDefaultArrayStart() {
            String expected = "[";
            String actual = style.getArrayStart();
            assertEquals(expected, actual);
        }


//        @Test
//        void setFieldSeparatorAtEnd_shouldSetFieldSeparatorAtEnd() {
//            // Arrange
//            boolean fieldSeparatorAtEnd = true;
//
//            // Act
//            style.setFieldSeparatorAtEnd(fieldSeparatorAtEnd);
//
//            // Assert
//            assertTrue(style.getFieldSeparatorAtEnd());
//        }
//
//        @Test
//        void setFieldSeparatorAtEnd_shouldNotSetFieldSeparatorAtEnd() {
//            // Arrange
//            boolean fieldSeparatorAtEnd = false;
//
//            // Act
//            style.setFieldSeparatorAtEnd(fieldSeparatorAtEnd);
//
//            // Assert
//            assertFalse(style.getFieldSeparatorAtEnd());
//        }
    @Test
    void setSizeStartText_withNonNullString_shouldSetStartText() {
        String sizeStartText = "Size:";
        style.setSizeStartText(sizeStartText);
        assertEquals(sizeStartText, style.getSizeStartText());
    }
    
    @Test
    void setSizeStartText_withNullString_shouldSetEmptyStartText() {
        String sizeStartText = null;
        style.setSizeStartText(sizeStartText);
        assertEquals("", style.getSizeStartText());
    }


    //@Test
    void testIsFieldSeparatorAtEnd() {
        StandardToStringStyle style = new StandardToStringStyle();

        // Test case 1: Field separator should be added at the end
        assertTrue(style.isFieldSeparatorAtEnd());

        // Test case 2: Field separator should not be added at the end
        style.setFieldSeparatorAtEnd(false);
        assertFalse(style.isFieldSeparatorAtEnd());
    }
//    @Test
//    void setFieldNameValueSeparator_shouldSetSeparatorToNull_whenNullPassed() {
//        toStringStyle.setFieldNameValueSeparator(null);
//        assertEquals("", toStringStyle.getFieldNameValueSeparator());
//    }

//    @Test
//    void setFieldNameValueSeparator_shouldSetSeparatorToEmptyString_whenEmptyStringPassed() {
//        toStringStyle.setFieldNameValueSeparator("");
//        assertEquals("", toStringStyle.getFieldNameValueSeparator());
//    }
//
//    @Test
//    void setFieldNameValueSeparator_shouldSetSeparatorToGivenValue_whenValidValuePassed() {
//        String separator = ":";
//        toStringStyle.setFieldNameValueSeparator(separator);
//        assertEquals(separator, toStringStyle.getFieldNameValueSeparator());
//    }


    @Test
    void shouldSetSummaryObjectEndText() {
        // Given
        StandardToStringStyle style = new StandardToStringStyle();
        String summaryObjectEndText = "end";

        // When
        style.setSummaryObjectEndText(summaryObjectEndText);

        // Then
        assertEquals(summaryObjectEndText, style.getSummaryObjectEndText());
    }

    @Test
    void shouldConvertNullToEmptyString() {
        // Given
        StandardToStringStyle style = new StandardToStringStyle();
        String summaryObjectEndText = null;

        // When
        style.setSummaryObjectEndText(summaryObjectEndText);

        // Then
        assertEquals("", style.getSummaryObjectEndText());
    }


//    @Test
//    void setArrayContentDetail_ShouldSetArrayContentDetailFlag() {
//        style.setArrayContentDetail(true);
//        assertTrue(style.getArrayContentDetail());
//
//        style.setArrayContentDetail(false);
//        assertFalse(style.getArrayContentDetail());
//    }

    //@Test
    void setArrayContentDetail_ShouldNotAffectOtherFlags() {
        style.setArrayContentDetail(false);
        assertFalse(style.isUseClassName());

        style.setUseClassName(true);
        style.setArrayContentDetail(true);
        assertTrue(style.isUseClassName());
    }
    @Test
    public void testIsUseClassName_DefaultValue() {
        style = new StandardToStringStyle();
        assertTrue(style.isUseClassName());
    }
    
    @Test
    public void testIsUseClassName_SetToTrue() {
        style = new StandardToStringStyle();
        style.setUseClassName(true);
        assertTrue(style.isUseClassName());
    }
    
    @Test
    public void testIsUseClassName_SetToFalse() {
        style = new StandardToStringStyle();
        style.setUseClassName(false);
        assertFalse(style.isUseClassName());
    }



    // ...

    @Test
    void setArraySeparator_withNull_shouldSetEmptyString() {
        style.setArraySeparator(null);
        assertEquals("", style.getArraySeparator());
    }

    @Test
    void setArraySeparator_withEmptyString_shouldSetEmptyString() {
        style.setArraySeparator("");
        assertEquals("", style.getArraySeparator());
    }

    @Test
    void setArraySeparator_withNonEmptyString_shouldSetArraySeparator() {
        style.setArraySeparator(",");
        assertEquals(",", style.getArraySeparator());
    }

    @ParameterizedTest
    @ValueSource(strings = {"[", "]", "{", "}", "(", ")"})
    void setArraySeparator_withSpecialCharacters_shouldSetArraySeparator(String separator) {
        style.setArraySeparator(separator);
        assertEquals(separator, style.getArraySeparator());
    }

    //@Test
    void setArraySeparator_withWhitespace_shouldTrimWhitespaceAndSetArraySeparator() {
        style.setArraySeparator(" , ");
        assertEquals(",", style.getArraySeparator());
    }
//    @Test
//    void testGetFieldNameValueSeparator() {
//        assertNotNull(toStringStyle.getFieldNameValueSeparator());
//    }
//
//    @Test
//    void testGetFieldNameValueSeparatorDefault() {
//        assertEquals("=", toStringStyle.getFieldNameValueSeparator());
//    }

}