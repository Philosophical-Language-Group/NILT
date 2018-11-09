// Compiled by ClojureScript 1.10.439 {}
goog.provide('nilt.ui.main');
goog.require('cljs.core');
goog.require('reagent.core');
cljs.core.enable_console_print_BANG_.call(null);
nilt.ui.main.main_ui = (function nilt$ui$main$main_ui(){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"center","center",-748944368),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword(null,"h1","h1",-1896887462),"Hello, world!"], null)], null);
});
if((typeof nilt !== 'undefined') && (typeof nilt.ui !== 'undefined') && (typeof nilt.ui.main !== 'undefined') && (typeof nilt.ui.main.app_state !== 'undefined')){
} else {
nilt.ui.main.app_state = reagent.core.atom.call(null,cljs.core.PersistentArrayMap.EMPTY);
}
nilt.ui.main.init_BANG_ = (function nilt$ui$main$init_BANG_(){
return reagent.core.render_component.call(null,(function (){
return new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [nilt.ui.main.main_ui], null);
}),document.getElementById("app"));
});
nilt.ui.main.init_BANG_.call(null);

//# sourceMappingURL=main.js.map
