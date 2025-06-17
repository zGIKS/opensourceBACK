package quri.teelab.api.teelab.analytics.domain.model.valueobjects;

import java.util.Objects;

public class AnalyticsId {
    private final String value;

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

