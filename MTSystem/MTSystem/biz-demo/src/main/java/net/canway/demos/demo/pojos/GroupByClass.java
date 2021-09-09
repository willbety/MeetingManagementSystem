package net.canway.demos.demo.pojos;

import com.google.common.collect.ImmutableMultiset;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GroupByClass {
    private  String name;
    private int count;

}
