import React from "react";

const gamesMastered = [{name: "Congress"}, {name: "Citadel"}]
const gamesPlayed = [{name: "Expanse"}, {name: "Star wars"}]

export default function Dashboard({token}) {

    const [, updateState] = React.useState();
    const forceUpdate = React.useCallback(() => updateState({}), []);

    function add(e) {
        const form = e.target.form;
        const select = form.elements["to_play"]

        gamesPlayed.push({name: select.value})
        forceUpdate();
    }

    return (
        <div className="App">
            <div className="mastered">
                <p>Мастерит</p>
                {gamesMastered.map(showGame)}
            </div>
            <div className="played">
                <form>
                    <p>Играет</p>
                    {gamesPlayed.map(showGame)}
                    <select name="to_play">
                        {gamesMastered
                            .filter(mastered => !gamesPlayed.find(palyed => palyed.name === mastered.name))
                            .map((game) => (<option name={game.name}>{game.name}</option>))}
                    </select>
                    <button type={"button"} onClick={add}>добавить</button>
                </form>
            </div>
        </div>
    );
}

function showGame(game) {
    return (<p>{game.name}</p>)
}