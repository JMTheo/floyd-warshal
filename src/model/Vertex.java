package model;

public class Vertex {
    private String label;

    private void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public Vertex(String label) {
        setLabel(label);
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        Vertex other = (Vertex) obj;
        if (this.getLabel() == null) {
            return other.getLabel() == null;
        } else
            return getLabel().equals(other.getLabel());
    }
}
