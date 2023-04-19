package com.example.new_project_challenge_15.entity.rels;

import com.example.new_project_challenge_15.entity.Address;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class REG_ADDRESS_CUR {
    @Id
    @GeneratedValue
    public Long id;
    public String Label;
    public String Source;
    @Property("Вид связи")
    public String Vid_svyaziey;
    @Property("Дата начала прописки")
    public String  Data_nachali_propiski;

    @TargetNode
    private Address address;

    @Override
    public String toString() {
        return "REG_ADDRESS_CUR{" +
                "id=" + id +
                ", Label='" + Label + '\'' +
                ", Source='" + Source + '\'' +
                ", Vid_svyaziey='" + Vid_svyaziey + '\'' +
                ", Data_nachali_propiski='" + Data_nachali_propiski + '\'' +
                ", address=" + address +
                '}';
    }

    public String getData_nachali_propiski() {
        return Data_nachali_propiski;
    }

    public void setData_nachali_propiski(String data_nachali_propiski) {
        Data_nachali_propiski = data_nachali_propiski;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
