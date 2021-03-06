package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Anggota;
import dao.AnggotaDao;

@ManagedBean(name = "AnggotaController")
@SessionScoped
public class AnggotaController implements java.io.Serializable {
	private Anggota anggota;
	private List<AnggotaController> list;

	public AnggotaController() {
		anggota = new Anggota();
	}

	public Anggota getAnggota() {
		return anggota;
	}

	public void setAnggota(Anggota anggota) {
		this.anggota = anggota;
	}

	public List<AnggotaController> getList() {
		return list;
	}

	public void setList(List<AnggotaController> list) {
		this.list = list;
	}

	public void clearAnggota() {
		anggota.setBarcode("");
		anggota.setIdAnggota("");
		anggota.setNamaLengkap("");
	}

	public void saveAnggota() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (anggota.getNamaLengkap().isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erorr",
								"nama tidak boleh kosong"));
			} else {
				this.anggota.setBarcode(barcodeGen());
				this.anggota.setIdAnggota("ANG" + GenerateId());
				AnggotaDao dao = new AnggotaDao();
				dao.addAnggota(getAnggota());
				clearAnggota();
				context.addMessage(null, new FacesMessage("Sucess"));
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Failed"));
		}

	}

	public void deleteAnggota() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			AnggotaDao dao = new AnggotaDao();
			dao.deleteAnggota(getAnggota());
			context.addMessage(null, new FacesMessage("Sucess"));
			clearAnggota();
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Failed"));
		}
	}

	public void updateAnggota() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			AnggotaDao dao = new AnggotaDao();
			dao.updateAnggota(getAnggota());
			context.addMessage(null, new FacesMessage("Sucess"));
			clearAnggota();
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Failed"));
		}
	}

	public List<Anggota> getRead() {
		try {
			List<Anggota> anggota = new ArrayList<Anggota>();
			AnggotaDao dao = new AnggotaDao();
			anggota = dao.getAllAnggota();
			return anggota;

		} catch (NullPointerException e) {
			System.out.println("Erorr karena : " + e.getMessage());

		}
		return new ArrayList<Anggota>();

	}

	public String barcodeGen() {
		Random ran = new Random();
		String barcode = Integer.toString(ran.nextInt(10));
		while (barcode.length() != 9) {
			barcode += Integer.toString(ran.nextInt(10));
		}

		return barcode;
	}

	public int GenerateId() {
		int randomId = 0;
		Random rand = new Random();
		for (int j = 0; j < 4; j++) {
			randomId = rand.nextInt();
		}
		return randomId;
	}


}
