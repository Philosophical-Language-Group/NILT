// Compiled by ClojureScript 1.10.439 {}
goog.provide('cljs.repl');
goog.require('cljs.core');
goog.require('cljs.spec.alpha');
cljs.repl.print_doc = (function cljs$repl$print_doc(p__2609){
var map__2610 = p__2609;
var map__2610__$1 = (((((!((map__2610 == null))))?(((((map__2610.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__2610.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__2610):map__2610);
var m = map__2610__$1;
var n = cljs.core.get.call(null,map__2610__$1,new cljs.core.Keyword(null,"ns","ns",441598760));
var nm = cljs.core.get.call(null,map__2610__$1,new cljs.core.Keyword(null,"name","name",1843675177));
cljs.core.println.call(null,"-------------------------");

cljs.core.println.call(null,(function (){var or__4047__auto__ = new cljs.core.Keyword(null,"spec","spec",347520401).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__4047__auto__)){
return or__4047__auto__;
} else {
return [cljs.core.str.cljs$core$IFn$_invoke$arity$1((function (){var temp__5457__auto__ = new cljs.core.Keyword(null,"ns","ns",441598760).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(temp__5457__auto__)){
var ns = temp__5457__auto__;
return [cljs.core.str.cljs$core$IFn$_invoke$arity$1(ns),"/"].join('');
} else {
return null;
}
})()),cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join('');
}
})());

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Protocol");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m))){
var seq__2612_2634 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"forms","forms",2045992350).cljs$core$IFn$_invoke$arity$1(m));
var chunk__2613_2635 = null;
var count__2614_2636 = (0);
var i__2615_2637 = (0);
while(true){
if((i__2615_2637 < count__2614_2636)){
var f_2638 = cljs.core._nth.call(null,chunk__2613_2635,i__2615_2637);
cljs.core.println.call(null,"  ",f_2638);


var G__2639 = seq__2612_2634;
var G__2640 = chunk__2613_2635;
var G__2641 = count__2614_2636;
var G__2642 = (i__2615_2637 + (1));
seq__2612_2634 = G__2639;
chunk__2613_2635 = G__2640;
count__2614_2636 = G__2641;
i__2615_2637 = G__2642;
continue;
} else {
var temp__5457__auto___2643 = cljs.core.seq.call(null,seq__2612_2634);
if(temp__5457__auto___2643){
var seq__2612_2644__$1 = temp__5457__auto___2643;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__2612_2644__$1)){
var c__4461__auto___2645 = cljs.core.chunk_first.call(null,seq__2612_2644__$1);
var G__2646 = cljs.core.chunk_rest.call(null,seq__2612_2644__$1);
var G__2647 = c__4461__auto___2645;
var G__2648 = cljs.core.count.call(null,c__4461__auto___2645);
var G__2649 = (0);
seq__2612_2634 = G__2646;
chunk__2613_2635 = G__2647;
count__2614_2636 = G__2648;
i__2615_2637 = G__2649;
continue;
} else {
var f_2650 = cljs.core.first.call(null,seq__2612_2644__$1);
cljs.core.println.call(null,"  ",f_2650);


var G__2651 = cljs.core.next.call(null,seq__2612_2644__$1);
var G__2652 = null;
var G__2653 = (0);
var G__2654 = (0);
seq__2612_2634 = G__2651;
chunk__2613_2635 = G__2652;
count__2614_2636 = G__2653;
i__2615_2637 = G__2654;
continue;
}
} else {
}
}
break;
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m))){
var arglists_2655 = new cljs.core.Keyword(null,"arglists","arglists",1661989754).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_((function (){var or__4047__auto__ = new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m);
if(cljs.core.truth_(or__4047__auto__)){
return or__4047__auto__;
} else {
return new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m);
}
})())){
cljs.core.prn.call(null,arglists_2655);
} else {
cljs.core.prn.call(null,((cljs.core._EQ_.call(null,new cljs.core.Symbol(null,"quote","quote",1377916282,null),cljs.core.first.call(null,arglists_2655)))?cljs.core.second.call(null,arglists_2655):arglists_2655));
}
} else {
}
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"special-form","special-form",-1326536374).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Special Form");

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.contains_QMARK_.call(null,m,new cljs.core.Keyword(null,"url","url",276297046))){
if(cljs.core.truth_(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))){
return cljs.core.println.call(null,["\n  Please see http://clojure.org/",cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"url","url",276297046).cljs$core$IFn$_invoke$arity$1(m))].join(''));
} else {
return null;
}
} else {
return cljs.core.println.call(null,["\n  Please see http://clojure.org/special_forms#",cljs.core.str.cljs$core$IFn$_invoke$arity$1(new cljs.core.Keyword(null,"name","name",1843675177).cljs$core$IFn$_invoke$arity$1(m))].join(''));
}
} else {
if(cljs.core.truth_(new cljs.core.Keyword(null,"macro","macro",-867863404).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Macro");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"spec","spec",347520401).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"Spec");
} else {
}

if(cljs.core.truth_(new cljs.core.Keyword(null,"repl-special-function","repl-special-function",1262603725).cljs$core$IFn$_invoke$arity$1(m))){
cljs.core.println.call(null,"REPL Special Function");
} else {
}

cljs.core.println.call(null," ",new cljs.core.Keyword(null,"doc","doc",1913296891).cljs$core$IFn$_invoke$arity$1(m));

if(cljs.core.truth_(new cljs.core.Keyword(null,"protocol","protocol",652470118).cljs$core$IFn$_invoke$arity$1(m))){
var seq__2616_2656 = cljs.core.seq.call(null,new cljs.core.Keyword(null,"methods","methods",453930866).cljs$core$IFn$_invoke$arity$1(m));
var chunk__2617_2657 = null;
var count__2618_2658 = (0);
var i__2619_2659 = (0);
while(true){
if((i__2619_2659 < count__2618_2658)){
var vec__2620_2660 = cljs.core._nth.call(null,chunk__2617_2657,i__2619_2659);
var name_2661 = cljs.core.nth.call(null,vec__2620_2660,(0),null);
var map__2623_2662 = cljs.core.nth.call(null,vec__2620_2660,(1),null);
var map__2623_2663__$1 = (((((!((map__2623_2662 == null))))?(((((map__2623_2662.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__2623_2662.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__2623_2662):map__2623_2662);
var doc_2664 = cljs.core.get.call(null,map__2623_2663__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists_2665 = cljs.core.get.call(null,map__2623_2663__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name_2661);

cljs.core.println.call(null," ",arglists_2665);

if(cljs.core.truth_(doc_2664)){
cljs.core.println.call(null," ",doc_2664);
} else {
}


var G__2666 = seq__2616_2656;
var G__2667 = chunk__2617_2657;
var G__2668 = count__2618_2658;
var G__2669 = (i__2619_2659 + (1));
seq__2616_2656 = G__2666;
chunk__2617_2657 = G__2667;
count__2618_2658 = G__2668;
i__2619_2659 = G__2669;
continue;
} else {
var temp__5457__auto___2670 = cljs.core.seq.call(null,seq__2616_2656);
if(temp__5457__auto___2670){
var seq__2616_2671__$1 = temp__5457__auto___2670;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__2616_2671__$1)){
var c__4461__auto___2672 = cljs.core.chunk_first.call(null,seq__2616_2671__$1);
var G__2673 = cljs.core.chunk_rest.call(null,seq__2616_2671__$1);
var G__2674 = c__4461__auto___2672;
var G__2675 = cljs.core.count.call(null,c__4461__auto___2672);
var G__2676 = (0);
seq__2616_2656 = G__2673;
chunk__2617_2657 = G__2674;
count__2618_2658 = G__2675;
i__2619_2659 = G__2676;
continue;
} else {
var vec__2625_2677 = cljs.core.first.call(null,seq__2616_2671__$1);
var name_2678 = cljs.core.nth.call(null,vec__2625_2677,(0),null);
var map__2628_2679 = cljs.core.nth.call(null,vec__2625_2677,(1),null);
var map__2628_2680__$1 = (((((!((map__2628_2679 == null))))?(((((map__2628_2679.cljs$lang$protocol_mask$partition0$ & (64))) || ((cljs.core.PROTOCOL_SENTINEL === map__2628_2679.cljs$core$ISeq$))))?true:false):false))?cljs.core.apply.call(null,cljs.core.hash_map,map__2628_2679):map__2628_2679);
var doc_2681 = cljs.core.get.call(null,map__2628_2680__$1,new cljs.core.Keyword(null,"doc","doc",1913296891));
var arglists_2682 = cljs.core.get.call(null,map__2628_2680__$1,new cljs.core.Keyword(null,"arglists","arglists",1661989754));
cljs.core.println.call(null);

cljs.core.println.call(null," ",name_2678);

cljs.core.println.call(null," ",arglists_2682);

if(cljs.core.truth_(doc_2681)){
cljs.core.println.call(null," ",doc_2681);
} else {
}


var G__2683 = cljs.core.next.call(null,seq__2616_2671__$1);
var G__2684 = null;
var G__2685 = (0);
var G__2686 = (0);
seq__2616_2656 = G__2683;
chunk__2617_2657 = G__2684;
count__2618_2658 = G__2685;
i__2619_2659 = G__2686;
continue;
}
} else {
}
}
break;
}
} else {
}

if(cljs.core.truth_(n)){
var temp__5457__auto__ = cljs.spec.alpha.get_spec.call(null,cljs.core.symbol.call(null,cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.ns_name.call(null,n)),cljs.core.name.call(null,nm)));
if(cljs.core.truth_(temp__5457__auto__)){
var fnspec = temp__5457__auto__;
cljs.core.print.call(null,"Spec");

var seq__2630 = cljs.core.seq.call(null,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"args","args",1315556576),new cljs.core.Keyword(null,"ret","ret",-468222814),new cljs.core.Keyword(null,"fn","fn",-1175266204)], null));
var chunk__2631 = null;
var count__2632 = (0);
var i__2633 = (0);
while(true){
if((i__2633 < count__2632)){
var role = cljs.core._nth.call(null,chunk__2631,i__2633);
var temp__5457__auto___2687__$1 = cljs.core.get.call(null,fnspec,role);
if(cljs.core.truth_(temp__5457__auto___2687__$1)){
var spec_2688 = temp__5457__auto___2687__$1;
cljs.core.print.call(null,["\n ",cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.name.call(null,role)),":"].join(''),cljs.spec.alpha.describe.call(null,spec_2688));
} else {
}


var G__2689 = seq__2630;
var G__2690 = chunk__2631;
var G__2691 = count__2632;
var G__2692 = (i__2633 + (1));
seq__2630 = G__2689;
chunk__2631 = G__2690;
count__2632 = G__2691;
i__2633 = G__2692;
continue;
} else {
var temp__5457__auto____$1 = cljs.core.seq.call(null,seq__2630);
if(temp__5457__auto____$1){
var seq__2630__$1 = temp__5457__auto____$1;
if(cljs.core.chunked_seq_QMARK_.call(null,seq__2630__$1)){
var c__4461__auto__ = cljs.core.chunk_first.call(null,seq__2630__$1);
var G__2693 = cljs.core.chunk_rest.call(null,seq__2630__$1);
var G__2694 = c__4461__auto__;
var G__2695 = cljs.core.count.call(null,c__4461__auto__);
var G__2696 = (0);
seq__2630 = G__2693;
chunk__2631 = G__2694;
count__2632 = G__2695;
i__2633 = G__2696;
continue;
} else {
var role = cljs.core.first.call(null,seq__2630__$1);
var temp__5457__auto___2697__$2 = cljs.core.get.call(null,fnspec,role);
if(cljs.core.truth_(temp__5457__auto___2697__$2)){
var spec_2698 = temp__5457__auto___2697__$2;
cljs.core.print.call(null,["\n ",cljs.core.str.cljs$core$IFn$_invoke$arity$1(cljs.core.name.call(null,role)),":"].join(''),cljs.spec.alpha.describe.call(null,spec_2698));
} else {
}


var G__2699 = cljs.core.next.call(null,seq__2630__$1);
var G__2700 = null;
var G__2701 = (0);
var G__2702 = (0);
seq__2630 = G__2699;
chunk__2631 = G__2700;
count__2632 = G__2701;
i__2633 = G__2702;
continue;
}
} else {
return null;
}
}
break;
}
} else {
return null;
}
} else {
return null;
}
}
});

//# sourceMappingURL=repl.js.map
