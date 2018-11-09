// Compiled by ClojureScript 1.10.439 {}
goog.provide('reagent.debug');
goog.require('cljs.core');
reagent.debug.has_console = (typeof console !== 'undefined');
reagent.debug.tracking = false;
if((typeof reagent !== 'undefined') && (typeof reagent.debug !== 'undefined') && (typeof reagent.debug.warnings !== 'undefined')){
} else {
reagent.debug.warnings = cljs.core.atom.call(null,null);
}
if((typeof reagent !== 'undefined') && (typeof reagent.debug !== 'undefined') && (typeof reagent.debug.track_console !== 'undefined')){
} else {
reagent.debug.track_console = (function (){var o = ({});
o.warn = ((function (o){
return (function() { 
var G__1447__delegate = function (args){
return cljs.core.swap_BANG_.call(null,reagent.debug.warnings,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"warn","warn",-436710552)], null),cljs.core.conj,cljs.core.apply.call(null,cljs.core.str,args));
};
var G__1447 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__1448__i = 0, G__1448__a = new Array(arguments.length -  0);
while (G__1448__i < G__1448__a.length) {G__1448__a[G__1448__i] = arguments[G__1448__i + 0]; ++G__1448__i;}
  args = new cljs.core.IndexedSeq(G__1448__a,0,null);
} 
return G__1447__delegate.call(this,args);};
G__1447.cljs$lang$maxFixedArity = 0;
G__1447.cljs$lang$applyTo = (function (arglist__1449){
var args = cljs.core.seq(arglist__1449);
return G__1447__delegate(args);
});
G__1447.cljs$core$IFn$_invoke$arity$variadic = G__1447__delegate;
return G__1447;
})()
;})(o))
;

o.error = ((function (o){
return (function() { 
var G__1450__delegate = function (args){
return cljs.core.swap_BANG_.call(null,reagent.debug.warnings,cljs.core.update_in,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"error","error",-978969032)], null),cljs.core.conj,cljs.core.apply.call(null,cljs.core.str,args));
};
var G__1450 = function (var_args){
var args = null;
if (arguments.length > 0) {
var G__1451__i = 0, G__1451__a = new Array(arguments.length -  0);
while (G__1451__i < G__1451__a.length) {G__1451__a[G__1451__i] = arguments[G__1451__i + 0]; ++G__1451__i;}
  args = new cljs.core.IndexedSeq(G__1451__a,0,null);
} 
return G__1450__delegate.call(this,args);};
G__1450.cljs$lang$maxFixedArity = 0;
G__1450.cljs$lang$applyTo = (function (arglist__1452){
var args = cljs.core.seq(arglist__1452);
return G__1450__delegate(args);
});
G__1450.cljs$core$IFn$_invoke$arity$variadic = G__1450__delegate;
return G__1450;
})()
;})(o))
;

return o;
})();
}
reagent.debug.track_warnings = (function reagent$debug$track_warnings(f){
reagent.debug.tracking = true;

cljs.core.reset_BANG_.call(null,reagent.debug.warnings,null);

f.call(null);

var warns = cljs.core.deref.call(null,reagent.debug.warnings);
cljs.core.reset_BANG_.call(null,reagent.debug.warnings,null);

reagent.debug.tracking = false;

return warns;
});

//# sourceMappingURL=debug.js.map
