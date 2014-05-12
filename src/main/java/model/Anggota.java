package model;

// Generated May 2, 2014 10:14:12 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Anggota generated by hbm2java
 */
public class Anggota implements java.io.Serializable {

	private int barcode;
	private String idAnggota;
	private String namaLengkap;
	private Set<TransaksiAnggota> transaksiAnggotas = new HashSet<TransaksiAnggota>(
			0);

	public Anggota() {
	}

	public Anggota(int barcode, String idAnggota) {
		this.barcode = barcode;
		this.idAnggota = idAnggota;
	}

	public Anggota(int barcode, String idAnggota, String namaLengkap,
			Set<TransaksiAnggota> transaksiAnggotas) {
		this.barcode = barcode;
		this.idAnggota = idAnggota;
		this.namaLengkap = namaLengkap;
		this.transaksiAnggotas = transaksiAnggotas;
	}

	public int getBarcode() {
		return this.barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getIdAnggota() {
		return this.idAnggota;
	}

	public void setIdAnggota(String idAnggota) {
		this.idAnggota = idAnggota;
	}

	public String getNamaLengkap() {
		return this.namaLengkap;
	}

	public void setNamaLengkap(String namaLengkap) {
		this.namaLengkap = namaLengkap;
	}

	public Set<TransaksiAnggota> getTransaksiAnggotas() {
		return this.transaksiAnggotas;
	}

	public void setTransaksiAnggotas(Set<TransaksiAnggota> transaksiAnggotas) {
		this.transaksiAnggotas = transaksiAnggotas;
	}

}
