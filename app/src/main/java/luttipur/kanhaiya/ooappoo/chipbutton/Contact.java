package luttipur.kanhaiya.ooappoo.chipbutton;

public class Contact {
    private String name;
    private int picId;

    public Contact(String name, int picId) {
        this.name = name;
        this.picId = picId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }
}
