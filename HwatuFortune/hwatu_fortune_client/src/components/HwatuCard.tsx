import type { Card } from "../types/Card";

interface HwatuCardInterface {
    card: Card;
    clickFunction: (cardName: string) => void;
}

export default function HwatuCard({ card, clickFunction }: HwatuCardInterface) {


    return (
        <div
            key={card.name}
            onClick={() => clickFunction(card.name)}
            style={{
                border: card.selected ? "2px solid red" : "none",
                display: "inline-block",
                margin: "5px",
                cursor: "pointer"
            }}
        >
            {card.selected ? (
                <div>
                    <img src={`/images/${card.imgName}`} alt={card.name} />
                </div>
            ) : (
                <div>
                    <img src={`/images/back.jpg`} alt="back" />
                </div>
            )}
        </div>
    );
}