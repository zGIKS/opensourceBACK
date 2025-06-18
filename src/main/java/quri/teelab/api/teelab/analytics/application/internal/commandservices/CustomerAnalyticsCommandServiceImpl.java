package quri.teelab.api.teelab.analytics.application.internal.commandservices;

import org.springframework.stereotype.Service;
import quri.teelab.api.teelab.analytics.domain.model.aggregates.User;
import quri.teelab.api.teelab.analytics.domain.model.commands.UpdateCustomerAnalyticsCommand;
import quri.teelab.api.teelab.analytics.domain.model.entities.CustomerAnalytics;

@Service
public class CustomerAnalyticsCommandServiceImpl {
    public User handle(UpdateCustomerAnalyticsCommand command) {
        // Aquí va la lógica de actualización del agregado User
        CustomerAnalytics customerAnalytics = command.getCustomerAnalytics();
        // En un caso real, aquí buscarías el agregado User y actualizarías solo la parte de customerAnalytics
        // Por simplicidad, se crea un User con solo customerAnalytics y manufacturerAnalytics en null
        return new User(customerAnalytics, null);
    }
}
