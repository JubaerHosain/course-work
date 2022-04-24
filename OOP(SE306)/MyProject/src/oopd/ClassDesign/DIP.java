package oopd.ClassDesign;

abstract class Reader {
    abstract void read();
}

abstract class Writer {
    abstract void wirte();
}

class FileReader extends Reader {
    @Override
    void read() {

    }
}

class FileWriter extends Writer {

    @Override
    void wirte() {

    }
}

class BufferWriter extends Writer {
    @Override
    void wirte() {

    }
}

public class DIP {
    public void copy(Reader reader, Writer writer) {
        reader.read();
        writer.wirte();
    }

    public void call() {
        copy(new FileReader(), new FileWriter());
        copy(new FileReader(), new BufferWriter());
    }
}




