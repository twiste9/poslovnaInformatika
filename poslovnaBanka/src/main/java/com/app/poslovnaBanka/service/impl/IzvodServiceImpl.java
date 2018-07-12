package com.app.poslovnaBanka.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.poslovnaBanka.modeli.AnalitikaIzvoda;
import com.app.poslovnaBanka.repository.IzvodRepository;
import com.app.poslovnaBanka.service.IzvodService;

@Service
public class IzvodServiceImpl implements IzvodService {

	@Autowired
	IzvodRepository izvodRepository;

	@Override
	public List<AnalitikaIzvoda> pretraziPoDatumuIRacunu(Date datum, String racun) {
		List<AnalitikaIzvoda> lista = izvodRepository
				.findByDatumNalogaAndRacunPoveriocaOrDatumNalogaAndRacunDuznika(datum, racun, datum, racun);
		Element izvod = new Element("izvod");
		Element zaglavlje = new Element("zaglavlje");
		Element stavke = new Element("stavke");

		Element brojRacuna = new Element("broj_racuna");
		brojRacuna.setText(racun);
		Element datumNaloga = new Element("datum_naloga");
		datumNaloga.setText(datum.toString());
		Element prethodnoStanje = new Element("prethodno_stanje");
		prethodnoStanje.setText(Double.toString(lista.get(0).getStanjeRacuna().getPrethodnoStanje()));

		Element brojPromenaUKorist = new Element("broj_promena_u_korist");
		Element brojPromenaNaTeret = new Element("broj_promena_na_teret");
		Element ukupnoNaTeretElem = new Element("ukupno_na_teret");
		Element ukupnoUKoristElem = new Element("ukupno_u_korist");
		Element novoStanje = new Element("novo_stanje");
		novoStanje.setText(Double.toString(lista.get(0).getStanjeRacuna().getNovoStanje()));
		
		int promeneUKorist = 0;
		int promeneNaTeret = 0;
		double ukupnoUKorist = 0;
		double ukupnoNaTeret = 0;
		for (AnalitikaIzvoda a : lista) {
			if (a.getRacunDuznika().equals(racun)) {
				promeneNaTeret++;
				ukupnoNaTeret += a.getIznos();
			} else {
				promeneUKorist++;
				ukupnoUKorist += a.getIznos();
			}
			Element duznikNalogodavac = new Element("duznik_nalogodavac");
			duznikNalogodavac.setText(a.getDuznikNalogodavac());
			
			Element svrhaPlacanja = new Element("svrha_placanja");
			svrhaPlacanja.setText(a.getSvrhaPlacanja());
			
			Element primalacPoverilac = new Element("primalac_poverilac");
			primalacPoverilac.setText(a.getPrimalacPoverilac());
			
			Element datumN = new Element("datum_naloga");
			datumN.setText(a.getDatumNaloga().toString());
			
			Element racunDuznika = new Element("racun_duznika");
			racunDuznika.setText(a.getRacunDuznika());
			
			Element modelZaduzenja = new Element("model_zaduzenja");
			modelZaduzenja.setText(Integer.toString(a.getModelZaduzenja()));
			
			Element pozivNaBrojZaduzenja = new Element("poziv_na_broj_zaduzenja");
			pozivNaBrojZaduzenja.setText(a.getPozivNaBrojZaduzenja());
			
			Element racunPoverioca = new Element("racun_poverioca");
			racunPoverioca.setText(a.getRacunPoverioca());
			
			Element modelOdobrenja = new Element("model_odobrenja");
			modelOdobrenja.setText(Integer.toString(a.getModelOdobrenja()));
			
			Element pozivNaBrojOdobrenja = new Element("poziv_na_broj_odobrenja");
			pozivNaBrojOdobrenja.setText(a.getPozivNaBrojOdobrenja());
			
			Element iznos = new Element("iznos");
			iznos.setText(Double.toString(a.getIznos()));
			
			Element smer = new Element("smer");
			smer.setText(Character.toString(a.getStatus()));
			
			Element stavka = new Element("stavka");
			stavka.addContent(duznikNalogodavac);
			stavka.addContent(svrhaPlacanja);
			stavka.addContent(primalacPoverilac);
			stavka.addContent(datumN);
			stavka.addContent(racunDuznika);
			stavka.addContent(modelZaduzenja);
			stavka.addContent(pozivNaBrojZaduzenja);
			stavka.addContent(racunPoverioca);
			stavka.addContent(modelOdobrenja);
			stavka.addContent(pozivNaBrojOdobrenja);
			stavka.addContent(iznos);
			stavka.addContent(smer);
			
			stavke.addContent(stavka);
		}
		brojPromenaUKorist.setText(Integer.toString(promeneUKorist));
		brojPromenaNaTeret.setText(Integer.toString(promeneNaTeret));
		ukupnoNaTeretElem.setText(Double.toString(ukupnoNaTeret));
		ukupnoUKoristElem.setText(Double.toString(ukupnoUKorist));
		
		zaglavlje.addContent(brojRacuna);
		zaglavlje.addContent(datumNaloga);
		zaglavlje.addContent(prethodnoStanje);
		zaglavlje.addContent(brojPromenaUKorist);
		zaglavlje.addContent(ukupnoUKoristElem);
		zaglavlje.addContent(brojPromenaNaTeret);
		zaglavlje.addContent(ukupnoNaTeretElem);
		zaglavlje.addContent(novoStanje);
		
		izvod.addContent(zaglavlje);
		izvod.addContent(stavke);
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		Document doc = new Document(izvod);
		
		try {
			PrintWriter out = new PrintWriter("src/main/resources/static/xml/Izvod.xml");
			xmlOutput.output(doc, out);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return izvodRepository.findByDatumNalogaAndRacunPoveriocaOrDatumNalogaAndRacunDuznika(datum, racun, datum,
				racun);
	}

}
