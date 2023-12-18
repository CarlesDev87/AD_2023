package controlador;

public class ControladorArticulo {


        if (e.getSource() == this.vista.btnSeleccionar) {

            int filaEditar = vista.jtArticulos.getSelectedRow();
            int numFS = vista.jtArticulos.getSelectedRowCount();

            if (filaEditar >= 0 && numFS == 1) {
                vista.txtId.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 0)));
                vista.txtNombre.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 1)));
                vista.txtPrecio.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 2)));
                vista.txtStock.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 3)));
                vista.txtImagen.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 4)));
                vista.txtDescripcion.setText(String.valueOf(vista.jtArticulos.getValueAt(filaEditar, 5)));

            } else {
                JOptionPane.showMessageDialog(null, "Error: debes seleccionar una fila.");
            }

        }

}
