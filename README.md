# Etapas para fazer a migração para o uso do Jetpack Navigation Component
1. Escolher módulos menos complexos para iniciar a implementação, isto é: com menos dependências entre outros módulos.
2. Criar o grafo de navegação interno para tais módulos.
3. Converter o gerenciamento manual de transações entre framentos: substituir as transações de fragmento manuais pelo Jetpack Navigation Component. Isso significa incluir mudança de chamadas FragmentManager para NavController e a atualização de interfaces de retorno de chamada para usar o SafeArgs - quando for necessário.
4. Validar se a navegação no módulo selecionado funciona conforme o esperado após a implementação do Jetpack Navigation Component. 
5. Migrar os módulos restantes, de forma incremental.
6. Integração da navegação entre módulos: após migrar todos os módulos, integrar a navegação entre os módulos usando o Jetpack Navigation Component (isso pode ser realizado no módulo app via global actions ou deeplinks).

# OBS
Seria interessante deixar os módulos independentes após o uso do Navigation Component, de modo que um não conheça o outro. Apenas o módulo app conhece os outros módulos do sistema (isso não se aplica à modulos como core/commons).
