package quri.teelab.api.teelab.analytics.application.internal.commandservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.analytics.domain.model.aggregates.User;
import quri.teelab.api.teelab.analytics.domain.model.commands.UpdateManufacturerAnalyticsCommand;
import quri.teelab.api.teelab.analytics.domain.model.entities.ManufacturerAnalytics;

@Service
public class ManufacturerAnalyticsCommandServiceImpl {
    public User handle(UpdateManufacturerAnalyticsCommand command) {
        ManufacturerAnalytics manufacturerAnalytics = command.getManufacturerAnalytics();
        // En un caso real, aquí buscarías el agregado User y actualizarías solo la parte de manufacturerAnalytics
        // Por simplicidad, se crea un User con manufacturerAnalytics y customerAnalytics en null
        return new User(null, manufacturerAnalytics);
    }
}
