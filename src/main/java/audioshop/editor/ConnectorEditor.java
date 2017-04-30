package audioshop.editor;

import audioshop.entity.Connection;
import audioshop.service.ConnectionService;

import java.beans.PropertyEditorSupport;

/**
 * Created by vasya on 022 22 02 2017.
 */
public class ConnectorEditor extends PropertyEditorSupport {

    private final ConnectionService connectionService;

    public ConnectorEditor(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Connection connection = connectionService.findOne(Integer.valueOf(text));
        setValue(connection);
    }
}
