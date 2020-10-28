package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }


    @Test
    public void negatiivinenTilavuus(){
        varasto = new Varasto(-10);
        assertEquals(0.0, varasto.getTilavuus(), vertailuTarkkuus);
    }


    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void toStringToimii(){
        varasto.lisaaVarastoon(3);

        assertEquals(varasto.toString(),"saldo = " + 3.0 + ", vielä tilaa " + 7.0);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenLisaysToimii() {
        varasto.lisaaVarastoon(-8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void liikaLisaysToimii() {
        varasto.lisaaVarastoon(20);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(10.0, varasto.getSaldo(), vertailuTarkkuus);
    }



    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

     @Test
    public void negatiivinenOttoToimii() {
         varasto.lisaaVarastoon(8);
        double d = varasto.otaVarastosta(-2);
        assertEquals(0.0, d, vertailuTarkkuus);
    }

    @Test
    public void liikaOttoToimii() {
        varasto.lisaaVarastoon(8);
        double d = varasto.otaVarastosta(12);
        assertEquals(8.0, d, vertailuTarkkuus);
    }

    @Test
    public void LisataanliikaaTavaraa(){
        varasto.lisaaVarastoon(20);
        assertEquals(10.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void otetaanLiikaa() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(9);

        assertEquals(8.0,saatuMaara, vertailuTarkkuus );
    }


    @Test
    public void alkusaldoToimiiNormaalisti(){
        varasto = new Varasto(10,5);
        assertEquals(5.0, varasto.getSaldo(), vertailuTarkkuus);

    }

    @Test
    public void alkusaldoToimiiKunSaldoOnliikaa(){
        varasto = new Varasto(10,15);
        assertEquals(10.0, varasto.getSaldo(), vertailuTarkkuus);

    }


    @Test
    public void alkusaldoToimiiKunTilavuusOnNegatiivinen() {
        varasto = new Varasto(-10, 5);
        assertEquals(0.0, varasto.getTilavuus(), vertailuTarkkuus);

    }

    @Test
    public void alkusaldoToimiiKunSaldoOnNegatiivinen() {
        varasto = new Varasto(10, -5);
        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);

    }




}