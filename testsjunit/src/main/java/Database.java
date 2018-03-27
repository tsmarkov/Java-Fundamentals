import javax.naming.OperationNotSupportedException;

public class Database {
    private int index;
    private int[] data;

    public Database(int capacity) throws OperationNotSupportedException {
        this.index = 0;
        this.setData(capacity);
    }

    public int[] getData() {
        return data;
    }

    private void setData(int capacity) throws OperationNotSupportedException {
        if (capacity != 16) {
            throw new OperationNotSupportedException("Invalid capacity!");
        }

        this.data = new int[capacity];
    }

    public void add(Integer num) throws OperationNotSupportedException {
        if (num == null) {
            throw new OperationNotSupportedException("Received number is null.");
        }

        if (index > 15) {
            throw new OperationNotSupportedException("Database is full.");
        }

        this.data[index++] = num;
    }

    public void remove() throws OperationNotSupportedException {
        if (this.index == 0) {
            throw new OperationNotSupportedException();
        }

        this.data[--this.index] = 0;
    }

    public int length() {
        return this.index;
    }
}