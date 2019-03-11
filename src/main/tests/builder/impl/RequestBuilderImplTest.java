package builder.impl;

import builder.Builder;
import builder.exception.BuilderException;
import entity.PersonSex;
import entity.PersonType;
import entity.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestBuilderImplTest {
    private static final int REQUEST_ID = 1;
    private static final PersonSex SEX = PersonSex.MALE;
    private static final PersonType TYPE = PersonType.MISSING;
    private static final Date BIRTH_DATE = Date.valueOf("1990-01-01");
    private static final String FULL_NAME = "fullName";
    private static final String NATIONALITY = "nationality";
    private static final String FILE_LINK = "fileLink";
    private static final Builder REQUEST_BUILDER = RequestBuilderImpl.getInstance();

    private static final Request EXPECTED = new Request(REQUEST_ID, SEX, TYPE,
            FULL_NAME, NATIONALITY, BIRTH_DATE, FILE_LINK);

    @Test
    public void testBuild() throws SQLException, BuilderException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt(RequestBuilderImpl.REQUEST_ID)).thenReturn(REQUEST_ID);
        when(resultSet.getInt(RequestBuilderImpl.SEX_ID)).thenReturn(SEX.getId());
        when(resultSet.getInt(RequestBuilderImpl.TYPE_ID)).thenReturn(TYPE.getId());
        when(resultSet.getDate(RequestBuilderImpl.BIRTH_DATE)).thenReturn(BIRTH_DATE);
        when(resultSet.getString(RequestBuilderImpl.FULL_NAME)).thenReturn(FULL_NAME);
        when(resultSet.getString(RequestBuilderImpl.NATIONALITY)).thenReturn(NATIONALITY);
        when(resultSet.getString(RequestBuilderImpl.FILE_LINK)).thenReturn(FILE_LINK);
        Request actual = (Request) REQUEST_BUILDER.build(resultSet);
        Assert.assertEquals(actual, EXPECTED);
    }
}