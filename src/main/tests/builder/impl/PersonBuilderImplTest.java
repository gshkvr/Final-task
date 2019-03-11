package builder.impl;

import builder.Builder;
import builder.exception.BuilderException;
import entity.Person;
import entity.PersonSex;
import entity.PersonType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonBuilderImplTest {
    private static final int PERSON_ID = 1;
    private static final PersonSex SEX = PersonSex.MALE;
    private static final PersonType TYPE = PersonType.MISSING;
    private static final Date BIRTH_DATE = Date.valueOf("1990-01-01");
    private static final String FULL_NAME = "fullName";
    private static final String NATIONALITY = "nationality";
    private static final String FILE_LINK = "fileLink";
    private static final Builder PERSON_BUILDER = PersonBuilderImpl.getInstance();

    private static final Person EXPECTED = new Person(PERSON_ID, SEX, TYPE,
            FULL_NAME, NATIONALITY, BIRTH_DATE, FILE_LINK);

    @Test
    public void testBuild() throws SQLException, BuilderException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(PersonBuilderImpl.PERSON_ID)).thenReturn(PERSON_ID);
        when(resultSet.getInt(PersonBuilderImpl.SEX_ID)).thenReturn(SEX.getId());
        when(resultSet.getInt(PersonBuilderImpl.TYPE_ID)).thenReturn(TYPE.getId());
        when(resultSet.getDate(PersonBuilderImpl.BIRTH_DATE)).thenReturn(BIRTH_DATE);
        when(resultSet.getString(PersonBuilderImpl.FULL_NAME)).thenReturn(FULL_NAME);
        when(resultSet.getString(PersonBuilderImpl.NATIONALITY)).thenReturn(NATIONALITY);
        when(resultSet.getString(PersonBuilderImpl.FILE_LINK)).thenReturn(FILE_LINK);
        Person actual = (Person) PERSON_BUILDER.build(resultSet);
        Assert.assertEquals(actual, EXPECTED);
    }
}