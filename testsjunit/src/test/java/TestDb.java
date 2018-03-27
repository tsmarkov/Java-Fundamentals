import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Constructor;

public class TestDb {
    private static final int DATABASE_INITIAL_CAPACITY = 16;
    private static final int DATABASE_WRONG_INITIAL_CAPACITY = 10;
    private static final int NUMBER_ELEMENT_INITIAL_VALUE = 13;
    private static final int ONE_ELEMENT_LENGTH_DATABASE = 1;

    private Database database;
    private Integer element;

    @Before
    public void objectsInitialization() throws OperationNotSupportedException {
        database = new Database(DATABASE_INITIAL_CAPACITY);
        element = NUMBER_ELEMENT_INITIAL_VALUE;
    }

    @Test
    public void initializeDatabaseWith16Cells() {
        //Assert
        Assert.assertEquals("Database initialized.", DATABASE_INITIAL_CAPACITY, database.getData().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseInitializationShouldThrowException() throws OperationNotSupportedException {
        //Arrange & Act
        database = new Database(DATABASE_WRONG_INITIAL_CAPACITY);
    }

    @Test
    public void addElement() throws OperationNotSupportedException {
        //Act
        database.add(element);

        //Assert
        Assert.assertEquals("Database should add elements.", ONE_ELEMENT_LENGTH_DATABASE, database.length());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void nullElementAddException() throws OperationNotSupportedException {
        //Arrange
        element = null;

        //Act
        database.add(element);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addInFullDatabaseException() throws OperationNotSupportedException {
        //Act
        for (int i = 0; i <= 16; i++) {
            database.add(element);
        }
    }

    @Test
    public void removeFromDatabase() throws OperationNotSupportedException {
        //Act
        for (int i = 0; i < 2; i++) {
            database.add(element);
        }

        database.remove();

        //Assert
        Assert.assertEquals("Database should remove last element.", ONE_ELEMENT_LENGTH_DATABASE, database.length());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyDatabase() throws OperationNotSupportedException {
        //Act
        database.remove();
    }

    @Test
    public void constructorArgumentType() throws NoSuchMethodException {
        Constructor databaseConstructor = Database.class.getConstructor();
        Class[] parameterTypes = databaseConstructor.getParameterTypes();
        Class cl = parameterTypes[0].getClass();

        Assert.assertEquals(int.class, cl);
    }
}
