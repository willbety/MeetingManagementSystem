package net.canway.demos.demo.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GroupByUser {
    private int Count;
    private double age;


}