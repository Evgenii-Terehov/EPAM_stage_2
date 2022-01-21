package com.epam.tat.exceptions;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.constants.GameType;
import com.epam.tat.exceptions.constants.Gender;
import com.epam.tat.exceptions.constants.Material;
import com.epam.tat.exceptions.constants.Size;
import com.epam.tat.exceptions.exception.GetToysByParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetToysByParameterTests extends AbstractBaseTests {

    @Test
    void shouldNotThrowExceptionDueToNoSuchId() {
        Assertions.assertTrue(playroom.getToysByParameter("id", "465").isEmpty());
    }

    @Test
    void shouldThrowExceptionForGetToysByParameterMethodWhenNullValue() {
        Assertions.assertThrows(GetToysByParameterException.class, () -> playroom.getToysByParameter(null, "1"));
    }

    @Test
    void testOneToy() {
        Toy findToy = new Toy(1L, "Doll", GameType.STORY, Gender.FEMALE, 6, Size.MEDIUM, Material.PLASTIC, 150);

        Assertions.assertTrue(playroom.getToysByParameter("id", "1").contains(findToy));
    }
}
