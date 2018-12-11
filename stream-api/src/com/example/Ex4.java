package com.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.model.Txn;
import com.example.model.TxnType;

public class Ex4 {

	private static List<Txn> txns = Arrays.asList(new Txn(1212, 1000.00, TxnType.CREDIT, LocalDate.of(2017, 4, 13)),
			new Txn(1213, 2000.00, TxnType.CREDIT, LocalDate.of(2017, 4, 13)),
			new Txn(1214, 2000.00, TxnType.DEBIT, LocalDate.of(2018, 4, 23)),
			new Txn(1215, 1000.00, TxnType.CREDIT, LocalDate.of(2018, 5, 13)),
			new Txn(1216, 4000.00, TxnType.CREDIT, LocalDate.of(2018, 6, 13)),
			new Txn(1217, 6000.00, TxnType.DEBIT, LocalDate.of(2018, 7, 13)),
			new Txn(1218, 7000.00, TxnType.DEBIT, LocalDate.of(2018, 8, 14)),
//			new Txn(1218, 7000.00, TxnType.DEBIT, LocalDate.of(2018, 8, 14)),
			new Txn(1219, 1000.00, TxnType.CREDIT, LocalDate.of(2018, 9, 13)),
			new Txn(1220, 8000.00, TxnType.DEBIT, LocalDate.of(2018, 10, 13)));

	public static void main(String[] args) {

		System.out.println(

		txns.stream()
		     .filter(txn->txn.getType()==TxnType.CREDIT)
//		     .limit(5)
//			 .distinct()
		     //.map(Txn::getAmount)
		     //.sorted(Comparator.comparingDouble(Txn::getAmount).reversed())
			 //.forEach(System.out::println);
		     //.findFirst()
		     //.findAny()
		     //.allMatch(txn->txn.getAmount()>3000.00)
			 //.anyMatch(txn->txn.getAmount()>3000.00)	
		     //.noneMatch(txn->txn.getAmount()<100)
			 //.count()	
		     //.toArray(Txn[]::new);
			 //.collect(Collectors.toList())
		     //.collect(Collectors.toSet())
		     //.collect(Collectors.toMap(Txn::getId, Txn::getAmount))
		     //.collect(Collectors.groupingBy(Txn::getType))
		     //.collect(Collectors.partitioningBy(txn->txn.getAmount()<3000))
			 //.map(txn->String.valueOf(txn.getAmount()))
		     //.collect(Collectors.joining(",", "[", "]"))
			   .mapToDouble(Txn::getAmount)	
//			   .reduce(0, (acc,next)->{
//				   System.out.println(acc);
//				   System.out.println(next);
//				   return acc+next;
//			   })
			   //.sum()
			   //.min()
			   .max()
		     
		);
			
		
		
		

	}

}

