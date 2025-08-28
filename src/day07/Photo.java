package day07;

public class Photo implements Drawable, Resizable {
    private String filename;
    private int width, height;

    public Photo(String filename, int width, int height) {
        this.filename = filename;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {

    }

    @Override
    public void erase() {

    }

    @Override
    public void resize(double factor) {

    }
}
