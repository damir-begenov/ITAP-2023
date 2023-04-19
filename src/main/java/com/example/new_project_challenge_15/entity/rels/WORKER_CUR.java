package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Persons;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class WORKER_CUR {
    @Id
    @GeneratedValue
    public Long id;
    public String Label;
    public String Source;
    @Property("Вид связи")
    public String Vid_svyaziey;
    @Property("БИН/ИИН работадателя")
    public String IINBIN_rabotadatelya;
    @Property("ИИН")
    public String IIN;
    @Property("Дата начала отчисления ОПВ/СО")
    public String data_nachalo;
    @Property("Дата окончания отчисления ОПВ/СО")
    public String data_oconchanya;
    @Property("Количество месяцев пенсионных отчислений")
    public String mesyac_pensionnih;
    @Property("Пенсионные отчисления")
    public String pensionnoe_otchislenie;
    @Property("Социальные отчисления")
    public String soc_ochislenya;
    @Property("Средняя заработная плата")
    public String average_zp;
    @TargetNode
    private Persons person;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getVid_svyaziey() {
        return Vid_svyaziey;
    }

    public void setVid_svyaziey(String vid_svyaziey) {
        Vid_svyaziey = vid_svyaziey;
    }

    public String getIINBIN_rabotadatelya() {
        return IINBIN_rabotadatelya;
    }

    public void setIINBIN_rabotadatelya(String IINBIN_rabotadatelya) {
        this.IINBIN_rabotadatelya = IINBIN_rabotadatelya;
    }

    public String getIIN() {
        return IIN;
    }

    public void setIIN(String IIN) {
        this.IIN = IIN;
    }

    public String getData_nachalo() {
        return data_nachalo;
    }

    public void setData_nachalo(String data_nachalo) {
        this.data_nachalo = data_nachalo;
    }

    public String getData_oconchanya() {
        return data_oconchanya;
    }

    public void setData_oconchanya(String data_oconchanya) {
        this.data_oconchanya = data_oconchanya;
    }

    public String getMesyac_pensionnih() {
        return mesyac_pensionnih;
    }

    public void setMesyac_pensionnih(String mesyac_pensionnih) {
        this.mesyac_pensionnih = mesyac_pensionnih;
    }

    public String getPensionnoe_otchislenie() {
        return pensionnoe_otchislenie;
    }

    public void setPensionnoe_otchislenie(String pensionnoe_otchislenie) {
        this.pensionnoe_otchislenie = pensionnoe_otchislenie;
    }

    public String getSoc_ochislenya() {
        return soc_ochislenya;
    }

    public void setSoc_ochislenya(String soc_ochislenya) {
        this.soc_ochislenya = soc_ochislenya;
    }

    public String getAverage_zp() {
        return average_zp;
    }

    public void setAverage_zp(String average_zp) {
        this.average_zp = average_zp;
    }

    public Persons getPerson() {
        return person;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }
}
