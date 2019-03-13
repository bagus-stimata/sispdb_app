package org.ub.government.sispdb.master.ikan_jenis;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import org.ub.government.sispdb.master.ikan_jenis.IkanJenisView.OnViewListener;
import org.ub.government.sispdb.model.IkanJenis;
import org.ub.government.sispdb.model_enum.EnumStatusOperasiForm;

public class IkanJenisController implements OnViewListener{
	protected IkanJenisModel model;
	protected IkanJenisView view;

	public IkanJenisController(IkanJenisView view) {
		model = new IkanJenisModel();
		this.view = view;
	}

	@Override
	public void aksiBtnReloadFromDb() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void aksiBtnFilterFromDb() {
		
//		view.filter_Data()
	}

	@Override
	public void aksiBtnNewForm() {
		model.resetNewObject_Header();
		model.itemHeader.setStatusActive(true);
		
		view.readBinderHeader();
		view.getTf_ID().requestFocus();
		
		model.statusOperasiForm = EnumStatusOperasiForm.ADD_NEW;
		view.setFormButtonAndTextState();
		
	}

	@Override
	public void aksiBtnEditForm() {
		view.readBinderHeader();
		
		view.getTf_Description().requestFocus();
		
		model.statusOperasiForm = EnumStatusOperasiForm.EDIT_FORM;
		view.setFormButtonAndTextState();		
	}

	@Override
	public void aksiBtnDeleteForm() {
		if (model.statusOperasiForm.equals(EnumStatusOperasiForm.OPEN)) {
			boolean isValidDelete = true;
			/*
			 * CEK APAKAH SUDAH DIPAKAI MELAKUKAN TRANSAKSI
			 */
			if (model.itemHeader.getTangkapItemsSet().size() >0) isValidDelete = false;
			if (JOptionPane.showConfirmDialog(view, "Yakin hapus data", "Konfirm Hapus", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) isValidDelete = false;
			
			if (isValidDelete) {
				model.statusOperasiForm = EnumStatusOperasiForm.DEL_STAT;
				
				model.deleteFromDatabase(null);
				view.updateDataGrid1();
				
				model.resetNewObject_Header();
				view.readBinderHeader();
				
				model.statusOperasiForm = EnumStatusOperasiForm.OPEN;
			}
		}
		
	}

	@Override
	public void aksiBtnSaveForm() {
		view.writeBinderHeader();
		if (model.isKodeSudahAdaPerCompany(model.itemHeader.getKode1(), null) ==null) {
			
			model.saveToDatabase();
	
			//Update View
			view.updateDataGrid1();
			
			model.statusOperasiForm = EnumStatusOperasiForm.OPEN;
			view.setFormButtonAndTextState();
		}else {
			JOptionPane.showMessageDialog(view, "Kode Sudah Ada", "Confilct Code", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void aksiBtnCancelForm() {
		
		model.statusOperasiForm = EnumStatusOperasiForm.OPEN;
		view.setFormButtonAndTextState();
		
	}

	@Override
	public void aksiBtnCloseForm() {
		view.dispose();
	}

	@Override
	public void aksiPrintForm() {
		
	}

	@Override
	public void aksiTable1_ListSelection(ListSelectionEvent event) {
		try {
			if (event !=null) {
		        try{
                    int selectedRow = view.getjTable1().getSelectedRow();
                    IkanJenis domainBean = new IkanJenis();
                    domainBean = (IkanJenis) model.tableModelHeader.get(selectedRow);
                    model.itemHeader = domainBean;
                    
                    view.readBinderHeader();
                    
		        }catch(Exception ex){}
			} //end if
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}