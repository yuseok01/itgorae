import type { BookData } from "@/types";
import Link from "next/link";
import styles from './book-item.module.css';

export default function BookItem({  
    id,
    title,
    subTitle,
    description,
    author,
    publisher,
    coverImgUrl // 변수명 수정
}: BookData) {
    return (
        <Link href={`/book/${id}`}>
            <a className={styles.container}> {/* `a` 태그에 `className` 적용 */}
                <img src={coverImgUrl} alt={title} /> {/* alt 속성 추가 */}
                <div>
                    <div className={styles.title}>{title}</div>
                    <div className={styles.subTitle}>{subTitle}</div>
                    <br />
                    <div className={styles.author}>
                        {author} | {publisher}
                    </div>
                </div>
            </a>
        </Link>
    );
}
