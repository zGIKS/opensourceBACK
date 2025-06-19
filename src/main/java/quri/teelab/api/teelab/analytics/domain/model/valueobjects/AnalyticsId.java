package quri.teelab.api.teelab.analytics.domain.model.valueobjects;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AnalyticsId implements Serializable {
    @Column(name = "id")
    private String value;

    // Constructor sin argumentos requerido por JPA
    protected AnalyticsId() {
    }

    public AnalyticsId(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("AnalyticsId cannot be null or blank");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalyticsId that = (AnalyticsId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
