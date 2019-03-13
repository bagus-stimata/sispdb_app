package org.ub.government.sispdb.master.ikan_jenis;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import org.ub.government.sispdb.model_enum.EnumStatusOperasiForm;
import org.ub.government.sispdb.model_table.TableModel_IkanJenis;
import org.ub.government.sispdb.sispdb_gui.master_template.FormTemplate1_IntFrame;


public class IkanJenisView extends FormTemplate1_IntFrame{
	protected IkanJenisController controller;
	protected IkanJenisModel model;
	
	
	/*
	 * #3 Interface Listener: agar Class Controller yang memakai tahu itu Method dari mana
	 * dengan mengunakan @Override
	 */
		interface OnViewListener {
			void aksiBtnReloadFromDb();
			void aksiBtnFilterFromDb();
			
			void aksiBtnNewForm();
			void aksiBtnEditForm();
			void aksiBtnDeleteForm();
			
			void aksiBtnSaveForm();
			void aksiBtnCancelForm();
			void aksiBtnCloseForm();
			
			void aksiPrintForm();
			
			void aksiTable1_ListSelection(ListSelectionEvent event);
			
		}
		
		//######### Jangan Lupa deklarasinya dan DI BAWAH	
		OnViewListener onViewListener; 
		
		public IkanJenisView() {
			super();
			controller = new IkanJenisController(this);
			model = controller.model;
			
			//######### Jangan Lupa deklarasinya dan DARI ATAS
			onViewListener = controller; 

			initComponentView();
			setGrid1Properties();
			
			initListener(); //Belum jalan

			/*
			 * 3. Init Data Provider: ambil data dari point 1 diatas
			 * ListDataProvider di gunakan 
			 */
//			reloadAllProviderOthers(); //Sementara tidak dipakai karena tidak membutuhkan method setFilter
			reloadDataProviderHeader();
			
//			reloadAllComponentComboBox();
			reloadDataGrid1();
//			setReloadComponentGrid2(); // Tidak Perlu di reload dulu
			
		}
		
		public void initComponentView(){
			//Masukkan Form Component
			
			getLabelGroup1().setVisible(false);
//			getLabelGroup2().setVisible(false);
			getCombo_Group1().setVisible(false);
//			getCombo_Group2().setVisible(false);
			
			setFormButtonAndTextState();
			
			getjTable1().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			this.setTitle("JENIS IKAN");
		}
		
		
		public void initListener(){
			getBtnFilter().addActionListener(e -> onViewListener.aksiBtnFilterFromDb());
//			btnHelp.addClickListener(e -> onViewListener.aksiBtnEditForm());
//			btnPrintForm.addClickListener(e -> onViewListener.aksiBtnDeleteForm());

//			btnReloadFromDb.addClickListener(e -> onViewListener.aksiBtnReloadFromDb());
			getBtnNew().addActionListener(e -> onViewListener.aksiBtnNewForm());
			getBtnEdit().addActionListener(e -> onViewListener.aksiBtnEditForm());
			getBtnDelete().addActionListener(e -> onViewListener.aksiBtnDeleteForm());
			
			getBtnSave().addActionListener(e -> onViewListener.aksiBtnSaveForm() );
			getBtnCancel().addActionListener(e -> onViewListener.aksiBtnCancelForm() );
			
			
//			fieldHeaderCell1.addValueChangeListener(e -> onViewListener.aksiFieldHeaderCell1(e));
//			fieldHeaderCell2.addValueChangeListener(e -> onViewListener.aksiFieldHeaderCell2(e));

	        ListSelectionModel table1CellSelectionModel = getjTable1().getSelectionModel();
	        table1CellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        table1CellSelectionModel.addListSelectionListener(e -> onViewListener.aksiTable1_ListSelection(e));
		      
		      //Bisa dideklasikan saat MultiSelectMode saja -> Dipindah ke controller saat penekanan tombol MultiSelectMode: 
//		      grid1.asMultiSelect().addSelectionListener(event -> onViewListener.aksiGrid1MultiSelection(event));
			
			
		}

		public void reloadDataProviderOthers(){
//			beanItemContainerPromo.addAll(model.getListFPromo());
//			beanItemContainerGrup1.addAll(model.getListGrup1());
			
//			getComboSatker().addItem("");
//			getComboSatker().setItemCaption("", "-- Pilih --");
//			for (FSatker satkerBean: model.getListFSatker()) {
//				getComboSatker().addItem(satkerBean.getKode1());
//				getComboSatker().setItemCaption(satkerBean.getKode1(), satkerBean.getKode1() + " " + satkerBean.getName());
//			}
			
			
			
		}
		
		public void reloadDataProviderHeader(){
			//Buat Fresh
//			dataProvider = new ListDataProvider<FArea>(model.getListHeader());
//			dataProvider.refreshAll();
			model.tableModelHeader = new TableModel_IkanJenis(new ArrayList<>(model.listHeader.values()));
			
		}	
		
		//### Not Override
		public void reloadComponentComboBox(){
			
//			getComboTipeopname().setFilteringMode(FilteringMode.CONTAINS);
//			getComboTipeopname().setNullSelectionAllowed(false);

//			getComboTipeopname().addItem(0);
//			getComboTipeopname().setItemCaption(0, "-- Pilih --");
//			getComboTipeopname().addItem(1);
//			getComboTipeopname().setItemCaption(1, "Semua Item");
//			getComboTipeopname().addItem(2);		
//			getComboTipeopname().setItemCaption(2, "Parsial");		
//			getComboTipeopname().select(2);
			
//			getComboGrup1().setFilteringMode(FilteringMode.CONTAINS);
//			getComboGrup1().setContainerDataSource(beanItemContainerGrup1);
//			getComboGrup1().setItemCaptionMode(ItemCaptionMode.EXPLICIT_DEFAULTS_ID);
//			getComboGrup1().setFilteringMode(FilteringMode.CONTAINS);
//			getComboGrup1().setNullSelectionAllowed(true);

//			getComboSearch1().setFilteringMode(FilteringMode.CONTAINS);
//			getComboSearch1().setContainerDataSource(getBeanItemContainerPromo());
//			getComboSearch1().setItemCaptionMode(ItemCaptionMode.EXPLICIT_DEFAULTS_ID);
//			getComboSearch1().setFilteringMode(FilteringMode.CONTAINS);
//			getComboSearch1().setNullSelectionAllowed(true);
	//
//			getComboFPromo().setFilteringMode(FilteringMode.CONTAINS);
//			getComboFPromo().setContainerDataSource(getBeanItemContainerPromo());
//			getComboFPromo().setItemCaptionMode(ItemCaptionMode.EXPLICIT_DEFAULTS_ID);
//			getComboFPromo().setFilteringMode(FilteringMode.CONTAINS);
//			getComboFPromo().setNullSelectionAllowed(true);
			
			
		}

		public void reloadDataGrid1(){
			
//			grid1.setDataProvider(dataProvider);
			getjTable1().setModel(model.tableModelHeader);
			
			/*
			 * Vaadin 8 Cukup dipanggil 1 kali
			 * Namun akan dipanggil Ulang jika bener-bener diperlukan 
			 * 
			 */
			setGrid1Properties(); 

			//Tidak bisa otomatis saat: Jadi harus dipangil secara Manual
			setGrid1Footer();	
			
		}
		
		public void updateDataGrid1() {
			if (model.statusOperasiForm.equals(EnumStatusOperasiForm.ADD_NEW)) {
				model.tableModelHeader.insert(model.itemHeader);
			}else if (model.statusOperasiForm.equals(EnumStatusOperasiForm.EDIT_FORM)){
		        int selectedRow = getjTable1().getSelectedRow();
				model.tableModelHeader.update(model.itemHeader, selectedRow);
			}else if (model.statusOperasiForm.equals(EnumStatusOperasiForm.DEL_STAT)) {
		        int selectedRow = getjTable1().getSelectedRow();
				model.tableModelHeader.delete( selectedRow);
			}
		}
		
		public void reloadDataGrid2(){
			/*
			 * Kemungkinan detil tidak mengguakan data Provider: Cukup menggunakan List Saja dan Perulangan
			 */
//			grid2.setDataProvider(dataProviderDetil);
//			setGrid2Properties();
			
			setGrid2Footer();		
			
		}
		
		public void setGrid1Properties(){					
			
	        getjTable1().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        getjTable1().setAutoCreateRowSorter(true);
	        getjTable1().setRowSelectionAllowed(true);
	        getjTable1().setRowHeight(27);
	        getjTable1().setGridColor(Color.gray);
//	         getjTable1().setFont(new Font("Arial", Font.BOLD, 12));  
	         getjTable1().setFont(new Font("Arial", Font.PLAIN, 14));  
	        
	        getjTable1().setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 


	        //WIDTH REZISE
	        getjTable1().getColumnModel().getColumn(0).setPreferredWidth(120);
	        getjTable1().getColumnModel().getColumn(1).setPreferredWidth(300);
	        
//	        getjTable1().getColumnModel().getColumn(3).setPreferredWidth(70);
//	        getjTable1().getColumnModel().getColumn(4).setPreferredWidth(80);

	        //RENDER DATE :: SEDANG TIDAK DIPAKAI
	        final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
	        final NumberFormat nf = NumberFormat.getInstance();
	        nf.setMaximumFractionDigits(0);
	        DefaultTableCellRenderer tableCellRendererDate = new DefaultTableCellRenderer() {
	            public Component getTableCellRendererComponent(JTable table,
	                    Object value, boolean isSelected, boolean hasFocus,
	                    int row, int column) {
	                if(value instanceof Date) {
	                    value = sdf.format(value);
	                } 
	                return super.getTableCellRendererComponent(table, value, isSelected,
	                        hasFocus, row, column);
	            }
	        };
	        tableCellRendererDate.setHorizontalAlignment(JLabel.CENTER);
	       
	        //RENDER NUMBER
	        DefaultTableCellRenderer tableCellRendererNumber = new DefaultTableCellRenderer() {
	            public Component getTableCellRendererComponent(JTable table,
	                    Object value, boolean isSelected, boolean hasFocus,
	                    int row, int column) {
	                if(value instanceof Number) {
	                    value = nf.format(value);
	                } 
	                return super.getTableCellRendererComponent(table, value, isSelected,
	                        hasFocus, row, column);
	            }
	        };
//	        tableCellRendererNumber.setForeground(Color.BLUE);
	        tableCellRendererNumber.setHorizontalAlignment(JLabel.RIGHT);
//	        JTextField tfRight = new JTextField(); //Untuk Editornya biar Right
//	        tfRight.setHorizontalAlignment(JTextField.RIGHT);
//	        getjTable1().getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(tfRight));
	        
	        DefaultTableCellRenderer tableCellRendererSpriceAltRetailPcs = new DefaultTableCellRenderer() {
	            public Component getTableCellRendererComponent(JTable table,
	                    Object value, boolean isSelected, boolean hasFocus,
	                    int row, int column) {
	                if(value instanceof Number) {
	                    value = nf.format(value);
	                } 
	                return super.getTableCellRendererComponent(table, value, isSelected,
	                        hasFocus, row, column);
	            }
	        };
	        tableCellRendererSpriceAltRetailPcs.setForeground(Color.BLUE);
	        tableCellRendererSpriceAltRetailPcs.setHorizontalAlignment(JLabel.RIGHT);

	        DefaultTableCellRenderer tableCellRendererStok = new DefaultTableCellRenderer(); 
	        tableCellRendererStok.setForeground(Color.BLUE);
	        tableCellRendererStok.setHorizontalAlignment(JLabel.CENTER);
	                
//	        getjTable1().getColumnModel().getColumn(2).setCellRenderer(tableCellRendererSpriceAltRetailPcs);        
//	        getjTable1().getColumnModel().getColumn(3).setCellRenderer(tableCellRendererNumber);        
//	        getjTable1().getColumnModel().getColumn(6).setCellRenderer(tableCellRendererStok);
			
		}
		
		public void setGrid1Footer(){
//			NumberFormat nf = NumberFormat.getInstance();
//			Collection<FArea> items =  dataProvider.getItems();
//
//			//1. Hitung Semua
//			int jumlahRec = 0;
//			for (FArea item: items){
//				jumlahRec++;
//			}
//			
//			footerRowGrid1.getCell("kode1").setText("*Rec " + nf.format(model.getListHeader().size()) + ",  Selected " + grid1.getSelectedItems().size());

		}
		
		public void setGrid2Properties(){
			
//			for (Column c : getGrid2().getColumns()) {
//	        	c.setHidable(true);
//	        	c.setHidden(true);
//	        }
//			
//			getGrid2().getColumn("nourut").setHidden(false);
//			getGrid2().getColumn("tipePembayaranDcv").setHidden(false);
////			getGrid2().getColumn("fvendorBean.vcode").setHidden(false);
//			
//			//Formatting
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
//			grid1.getColumn("paymentDate").setRenderer(new DateRenderer(sdf));
	//
//			//Aligment: Defautnya Left Aligment
//			getGrid2().setCellStyleGenerator(new Grid.CellStyleGenerator() {
//	            @Override
//	            public String getStyle(Grid.CellReference cellReference) {
//	                if ("amountafterdiscafterppn".equals(cellReference.getPropertyId())) {
//	                    // when the current cell is number such as age, align text to right
//	                    return "rightAligned";
//	                } else if ("amount".equals(cellReference.getPropertyId())){                	
//	                	return "rightAligned";
//	                	
//	                } else if ("tipePembayaranDcv".equals(cellReference.getPropertyId())){                	
//	                	return "centerAligned";
//	                } else if ("paymentDate".equals(cellReference.getPropertyId())){
//	                	return "centerAligned";
//	                } else {
//	                    // otherwise, align text to left
//	                    return "leftAligned";
//	                }
//	            }
//	        });			

		}
		
		public void setGrid2Footer(){
			NumberFormat nf = NumberFormat.getInstance();
//			Collection<FArea> items =  dataProviderDetil.getItems();
//			//1. Hitung Semua
//			int jumlahRec = 0;
//			for (FArea item: items){
//				jumlahRec++;
//			}
//			footerRowGrid2.getCell("kode1").setText("*Rec " + nf.format(model.getListHeader().size()) + ",  Selected " + grid1.getSelectedItems().size());
			
		}
		
		
		public void setGrid1MultiSelectMode(boolean isMultiSelect) {
			if (isMultiSelect) {
//				btnNewForm.setEnabled(false);
//				btnEditForm.setEnabled(false);
//				formHeader.btnSave.setEnabled(false);
//				formHeader.btnDelete.setEnabled(false);
			}else {
//				btnNewForm.setEnabled(true);
//				btnEditForm.setEnabled(true);
//				formHeader.btnSave.setEnabled(true);
//				formHeader.btnDelete.setEnabled(true);
				
			}
		}
		
		public void setFormButtonAndTextState(){
			/*
			 * KEMUNGKINAN TIDAK DIPAKAI LAGI
			 */
			//KODE REFNO SELALU READ ONLY KARENA OTOMATIS
			
			if (model.statusOperasiForm.equals(EnumStatusOperasiForm.OPEN )){
				getTf_ID().setEditable(false);
				getTf_Description().setEditable(false);
				getTa_Notes().setEditable(false);
				
				getjTable1().setCellSelectionEnabled(true);

				getBtnNew().setEnabled(true);
				getBtnEdit().setEnabled(true);
				getBtnDelete().setEnabled(true);
				getBtnSave().setEnabled(false);
				getBtnCancel().setEnabled(false);

				getjTable1().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
			} else if (model.statusOperasiForm.equals(EnumStatusOperasiForm.ADD_NEW )){
				getTf_ID().setEditable(true);
				getTf_Description().setEditable(true);
				getTa_Notes().setEditable(true);
				
				getjTable1().setCellSelectionEnabled(false);

				getBtnNew().setEnabled(false);
				getBtnEdit().setEnabled(false);
				getBtnDelete().setEnabled(false);
				getBtnSave().setEnabled(true);
				getBtnCancel().setEnabled(true);
				
			}else if (model.statusOperasiForm.equals(EnumStatusOperasiForm.EDIT_FORM  )){
				getTf_ID().setEditable(false); //Kode tidak boleh di rubah saat edit
				getTf_Description().setEditable(true);
				getTa_Notes().setEditable(true);
				
				getjTable1().setCellSelectionEnabled(false);

				getBtnNew().setEnabled(false);
				getBtnEdit().setEnabled(false);
				getBtnDelete().setEnabled(false);
				getBtnSave().setEnabled(true);
				getBtnCancel().setEnabled(true);
			}		
			
		}
		

	    public void readBinderHeader() {
            getTf_ID().setText(model.itemHeader.getKode1());
            getTf_Description().setText(model.itemHeader.getDescription());
            getTa_Notes().setText(model.itemHeader.getNotes());
            getjCheckBox1().setSelected(model.itemHeader.isStatusActive());
	    }
		public void writeBinderHeader() {
			model.itemHeader.setKode1(getTf_ID().getText().trim());
			model.itemHeader.setDescription(getTf_Description().getText().trim());
			model.itemHeader.setNotes(getTa_Notes().getText().trim());
			model.itemHeader.setStatusActive(getjCheckBox1().isSelected());
		}

//		@Override
//		public void itemClick(ItemClickEvent event) {
//			// TODO Auto-generated method stub
//			
//		}

//		@Override
//		public void textChange(TextChangeEvent event) {
////			controller.aksiBtnSearchForm();
////			System.out.println(getFieldHeaderCell1().getValue());
//		   String newValue = (String) event.getText();
//			if (event.getComponent()==getFieldHeaderCell1()) {
//				   getBeanItemContainerHeader().removeContainerFilters("kode1");
//				   if (null != newValue && !newValue.isEmpty()) {
//					   getBeanItemContainerHeader().addContainerFilter(new SimpleStringFilter(
//							   "kode1", newValue, true, false));
//					   setDisplayGrid1Footer();
//				   }
//				   getGrid1().recalculateColumnWidths();
//				
//			}else if (event.getComponent()==getFieldHeaderCell2()) {
//				   getBeanItemContainerHeader().removeContainerFilters("description");
//				   if (null != newValue && !newValue.isEmpty()) {
//					   getBeanItemContainerHeader().addContainerFilter(new SimpleStringFilter(
//							   "description", newValue, true, false));
//					   setDisplayGrid1Footer();
//				   }
//				   getGrid1().recalculateColumnWidths();
//			}
//			
//		}



}